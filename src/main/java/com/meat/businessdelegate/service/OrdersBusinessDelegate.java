/**

 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.dao.PreOrderCartItemsRepository;
import com.meat.domain.*;
import com.meat.mail.Mail;
import com.meat.model.CategoryModel;
import com.meat.model.OrderItemModel;
import com.meat.model.OrdersModel;
import com.meat.model.SubOrderModel;
import com.meat.security.CustomUserDetails;
import com.meat.service.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
@ImportResource("classpath:spring-thymeleaf.xml")
@PropertySource("classpath:mail.properties")
@PropertySource("classpath:application.properties")
public class OrdersBusinessDelegate implements IBusinessDelegate<OrdersModel, OrdersContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IOrderDeliveryOptionsService orderDeliveryOptionsService;
    @Autowired
    private ISellerBranchService sellerBranchService;
    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private IUsersService userService;
    @Autowired
    private IMailService mailService;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
    @Autowired
    private ISubOrderStatusCodeService subOrderStatusCodeService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ITimingsService timingsService;
    @Autowired
    private PreOrderCartItemsRepository preOrderCartItemsRepository;
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;
    @Autowired
    private IMailConfigService mailConfigService;
    @Autowired
    private ISubOrderTaxesService subOrderTaxesService;
    @Autowired
    private IOfferService offerService;
    @Autowired
    private ISellerBranchChargesService sellerBranchChargesService;

    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;
    @Value("${url}")
    private String url;
    @Value("${websocketURL}")
    private String websocketURL;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OrdersModel create(final OrdersModel model) {

        Orders orders = new Orders();
        // orders.setId(model.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Users users = userService.getUsers(userDetails.getId());
        orders.setUsers(users);
        orders.setName((new Date()).toString());
        orders.setStatus("PLACED");//setting default status
        orders.setTransactionId(model.getTransactionId());//have to change this after payment gateway integration
        BigDecimal orderTotalAmount = new BigDecimal(0.0);

        String value = model.getAmount();
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.replaceAll(",", ""));
            orders.setAmount(bigDecimal);
        }
        String value1 = model.getDiscount();
        if (value1 != null) {
            BigDecimal bigDecimal = new BigDecimal(value1.replaceAll(",", ""));
            orders.setDiscount(bigDecimal);
        }
        String value2 = model.getShippingCharges();
        if (value2 != null) {
            BigDecimal bigDecimal = new BigDecimal(value2.replaceAll(",", ""));
            orders.setShippingCharges(bigDecimal);
        }
        orders.setOrderCreatedTime(model.getOrderCreatedTime());
        Integer i = ordersService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            orders.setOrderCount(bi);
        }
        else {
            long bi = i + 1;
            orders.setOrderCount(bi);
        }
        Integer ca = i + 1;
        String m = DBSequences.ORDER.getSequenceName();
        String mc = m.concat(ca.toString());
        orders.setOrderCode(mc);
        orders.setOrderCreatedDate(new Date());
        if (model.getOrderDetails() != null) {
            orders.setOrderDetails(model.getOrderDetails());
        }
        //orders = ordersService.create(orders);

        if (model.getOrderItemsModels() != null) {
            HashMap<String, List<OrderItemModel>> subOrderGroups = new HashMap<String, List<OrderItemModel>>();
            for (OrderItemModel cartItem : model.getOrderItemsModels()) {//grouping all order items to groups
                String sId = "";//seller Branch Id
                if (cartItem.getSellerItemId() != null) {
                    SellerBranch sb = sellerBranchService.getBranchBySellerItem(cartItem.getSellerItemId());
                    sId = sb.getId();
                }
                String timingsId = null;
                if (cartItem.getTimingsId() != null) {
                    timingsId = cartItem.getTimingsId();
                }
                String deliveryTime = null;
                if (cartItem.getDeliveryTime() != null) {
                    deliveryTime = cartItem.getDeliveryTime();
                }
                String deliveryDate = cartItem.getDeliveryDate();
                String deliveryType = cartItem.getDeliveryType();
                String groupingParameter = sId + "$$$" + timingsId + "$$$" + deliveryTime + "$$$" + deliveryDate + "$$$" + deliveryType;

                if (!subOrderGroups.containsKey(groupingParameter)) {
                    List<OrderItemModel> list = new ArrayList<OrderItemModel>();
                    list.add(cartItem);
                    subOrderGroups.put(groupingParameter, list);
                }
                else {
                    subOrderGroups.get(groupingParameter).add(cartItem);
                }
            }

            List<OrderItem> overAllOrderItems = new ArrayList<OrderItem>();
            Set<SubOrder> subOrders = new HashSet<SubOrder>();
            for (Entry<String, List<OrderItemModel>> entry : subOrderGroups.entrySet()) {//converting created groups to subOrders
                String key = entry.getKey();
                SubOrder sOrder = new SubOrder();
                String sellerBranchId = key.split("\\$\\$\\$")[0];//seller branch Id
                String timingsId = key.split("\\$\\$\\$")[1];//timingsId
                String deliveryTime = key.split("\\$\\$\\$")[2];//delivery Time
                String sOrderedDate = key.split("\\$\\$\\$")[3];//order created date
                String deliveryType = key.split("\\$\\$\\$")[4];//order delivery type

                SellerBranch sBranch = new SellerBranch();
                sBranch.setId(sellerBranchId);
                sOrder.setSellerBranch(sBranch);
                Timings timings = timingsService.getTimings(timingsId);
                if (!timingsId.equals("null")) {
                    sOrder.setTimings(timings);
                    sOrder.setSubOrderDeliveryTime(timings.getEndTime());
                }
                /* Users usrs = new Users();
                usrs.setId(model.getUsersId());*/
                sOrder.setUsers(users);
                if (!deliveryTime.equals("null")) {
                    DateTime endTime = DateTime.now().plusMinutes(Integer.parseInt(deliveryTime));
                    DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm a");
                    sOrder.setSubOrderDeliveryTime(fmt.print(endTime));
                }
                // sOrder.setSubOrderDeliveryDate(sOrderedDate);
                sOrder.setDeliveryType(deliveryType);
                SimpleDateFormat MYDate = new SimpleDateFormat("dd/MM/yyyy");
                Date today;
                try {

                    today = MYDate.parse(sOrderedDate);
                    sOrder.setSubOrderDeliveryDate(today);
                }
                catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Integer subo = subOrderService.getMaxCode();
                if (subo == null || subo == 0) {
                    subo = 9999;
                    long bi2 = (subo + 1);
                    sOrder.setSubOrderCount(bi2);
                }
                Integer code = subo + 1;

                String m1 = DBSequences.SUBORDER.getSequenceName();
                String mc1 = m1.concat(code.toString());
                sOrder.setSubOrderCode(mc1);
                sOrder.setSubOrderStatus("PLACED");//setting default subOrder status

                BigDecimal subOrderTotalPrice = new BigDecimal(0.0);// price after all charges and taxes
                BigDecimal subOrderSubTotalPrice = new BigDecimal(0.0);//price before all charges and taxes

                BigDecimal subOrderTotalDiscount = new BigDecimal(0.0);
                float subOrderTotalCharges = 0;
                Set<OrderItem> orderItems = new HashSet<OrderItem>();
                for (OrderItemModel oim : entry.getValue()) {
                    OrderItem oi = new OrderItem();
                    if (!timingsId.equals("null")) {
                        oi.setTimings(timings);
                    }
                    oi.setOrders(orders);
                    oi.setOrderItemStatus("PLACED");//default order item status
                    oi.setUnits(Float.parseFloat(oim.getUnits()));
                    oi.setCutType(oim.getCutType());
                    SellerItem si = sellerItemService.getSellerItemAfterOfferApplied(oim.getSellerItemId());
                    /*  si.setId(oim.getSellerItemId());*/
                    oi.setFinalUnitPrice(si.getSellingPrice());
                    oi.setSellerPrice(si.getSellerPrice());
                    oi.setMarketPrice(si.getMarketPrice());
                    oi.setOtherDiscounts(new BigDecimal(si.getDescription()));// here description using as other discounts total from service
                    BigDecimal sellerDiscount = si.getMarketPrice().subtract(si.getSellerPrice());
                    oi.setSellerDiscounts(sellerDiscount);//discounts as amounts
                    List<String> offerIds = offerService.getOfferIdsBySellerItemAlongWithItsParents(si.getId());
                    oi.setOtherOffers(String.join(",", offerIds));
                    oi.setSellerItem(si);
                    oi.setCreatedDate(new Date());
                    oi.setAvailableTime(oim.getAvailableTime());
                    DateTime dt = new DateTime();

                    oi.setDeliveryTime(dt.plusMinutes(Integer.parseInt(oim.getDeliveryTime())).toString());
                    oi.setCutType(oim.getCutType());

                    BigDecimal orderItemPrice = si.getSellingPrice();//price with offer after applying offers related to seller item
                    BigDecimal orderItemUnits = new BigDecimal(oim.getUnits());
                    BigDecimal orderItemTotalPrice = orderItemPrice.multiply(orderItemUnits);
                    oi.setOrderItemTotalPrice(orderItemTotalPrice.setScale(2, BigDecimal.ROUND_CEILING));
                    subOrderSubTotalPrice = subOrderSubTotalPrice.add(orderItemTotalPrice.setScale(2, BigDecimal.ROUND_CEILING));
                    subOrderTotalDiscount = subOrderTotalDiscount.add(oi.getSellerDiscounts()).add(oi.getOtherDiscounts());// as amounts
                    /*float discount1 = (Float.parseFloat(oim.getDiscount())) / 100;*/
                    //  float tax1 = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(si.getId(), "PERCENT") / 100;
                    /*   BigDecimal orderItemTotalPriceAfterDiscount = orderItemTotalPrice
                            .subtract(orderItemTotalPrice.multiply(new BigDecimal(discount1)));*/
                    /*BigDecimal orderItemTotalPriceAfterTaxAndDiscount = orderItemTotalPriceAfterDiscount
                            .add(orderItemTotalPriceAfterDiscount.multiply(new BigDecimal(tax1)));*/
                    /*   subOrderTotalPrice = subOrderTotalPrice.add(orderItemTotalPriceAfterTaxAndDiscount);*/

                    /*subOrderTotalTax = subOrderTotalTax + tax1;*/
                    /*  subOrderTotalDiscount = subOrderTotalDiscount + Float.parseFloat(oim.getDiscount());*/
                    /*    oi.setPrice(orderItemTotalPrice);*/

                    /* oi.setDiscount(Float.parseFloat(oim.getDiscount()));
                    oi.setTaxValue(tax1 * 100);*/
                    SimpleDateFormat oiDate = new SimpleDateFormat("dd/MM/yyyy");
                    Date tday;
                    try {
                        tday = oiDate.parse(sOrderedDate);
                        oi.setDeliveryDate(tday);
                    }
                    catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Integer oic = orderItemService.getMaxCode();
                    if (oic == null || oic == 0) {
                        oic = 9999;
                        long b1i = (oic + 1);
                        oi.setOrderItemCount(b1i);
                    }
                    Integer oia = i + 1;

                    String m2 = DBSequences.ORDERITEM.getSequenceName();
                    String mc2 = m2.concat(oia.toString());
                    oi.setOrderItemCode(mc2);
                    orderItems.add(oi);
                    overAllOrderItems.add(oi);
                    oi.setSubOrder(sOrder);
                    oim.setSellerItemName(oi.getSellerItem().getSellerItemName());
                }
                sOrder.setOrderItems(orderItems);
                sOrder.setSubOrderSubTotalPrice(subOrderSubTotalPrice);
                sOrder.setSubOrderTotalCharges(new BigDecimal(0.0));
                SellerBranch sellerBranch = sellerBranchService.getSellerBranch(sellerBranchId);
                BigDecimal sellerMinimumOrderDeliveryAmount = sellerBranch.getMinimumOrderDeliveryAmount();

                if (subOrderSubTotalPrice.compareTo(sellerMinimumOrderDeliveryAmount) < 0) {
                    BigDecimal sellerCharges = sellerBranchChargesService.getSumOfSellerChargesBySellerBranch(sellerBranchId);
                    subOrderSubTotalPrice = subOrderSubTotalPrice.add(sellerCharges);
                    sOrder.setSubOrderTotalCharges(sellerCharges);

                }
                Float subOrderTotalTax = sellerBranchTaxService.getSumOfApplicableTaxesBySellerBranch(sellerBranch.getId(), "PERCENT")
                        / 100;

                subOrderTotalPrice = subOrderSubTotalPrice.add(subOrderSubTotalPrice.multiply(new BigDecimal(subOrderTotalTax)));
                sOrder.setSubOrderTotalPrice(subOrderTotalPrice.setScale(2, BigDecimal.ROUND_CEILING));
                orderTotalAmount = orderTotalAmount.add(subOrderTotalPrice.setScale(2, BigDecimal.ROUND_CEILING));
                sOrder.setDiscount(subOrderTotalDiscount);//always % value
                sOrder.setTaxValue(Math.round(subOrderTotalTax * 100));//always % value
                sOrder.setRefundAmount(new BigDecimal(0.0));
                sOrder.setRefundDeductedAmount(new BigDecimal(0.0));
                sOrder.setRefundPayableAmount(new BigDecimal(0.0));
                sOrder.setRefundStatus("INACTIVE");
                sOrder.setCreatedDate(new Date());
                sOrder.setBilledStatus("UNBILLED");
                sOrder.setOrders(orders);
                sOrder.setUsers(users);
                List<SellerBranchTax> sellerBranchTaxes = sellerBranchTaxService.getApplicableTaxesBySellerBranch(sellerBranchId,
                        "PERCENT");
                List<SubOrderTaxes> subOrderTaxes = new ArrayList<SubOrderTaxes>(0);
                for (SellerBranchTax sbt : sellerBranchTaxes) {
                    SubOrderTaxes sot = new SubOrderTaxes();
                    sot.setSubOrder(sOrder);
                    sot.setTaxName(sbt.getTax().getTaxName());
                    sot.setTaxValue(sbt.getTaxValue().toString());
                    sot.setDescription(sbt.getAmountType().getAmountDescription());

                    subOrderTaxes.add(sot);
                }
                sOrder.setSubOrderTaxes(new HashSet<SubOrderTaxes>(subOrderTaxes));
                subOrders.add(sOrder);
            }
            orders.setOrderItems(new HashSet<OrderItem>(overAllOrderItems));
            orders.setAmount(orderTotalAmount.setScale(2, BigDecimal.ROUND_CEILING));
            orders.setSubOrders(subOrders);

        }
        orders = ordersService.create(orders);
        if (orders.getId() != null) {
            List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();
            for (OrderItemModel oi : model.getOrderItemsModels()) {

                PreOrderCartItems po = preOrderCartItemsService.getPreOrderCartItemsByStatusSellerItemUser(oi.getSellerItemId(),
                        oi.getCartStatusFlag(), users.getId());
                if (po != null) {
                    preOrderCartItems.add(po);
                }
                if (preOrderCartItems.size() > 0) {
                    preOrderCartItemsRepository.delete(preOrderCartItems);
                }
            }
        }

        if (orders.getId() != null) {
            for (SubOrder so : orders.getSubOrders()) {
                SubOrderModel subOrderModel = conversionService.convert(so, SubOrderModel.class);
                template.convertAndSend("/orders/subOrders/" + so.getSellerBranch().getId(), subOrderModel);
            }
        }
        OrderDeliveryOptions shippingAddress = new OrderDeliveryOptions();
        if (orders.getId() != null && model.getAddressId() != null) {
            OrderDeliveryOptions orderDeliveryAddress = new OrderDeliveryOptions();
            Address address = new Address();
            for (Address add : orders.getUsers().getAddresses()) {
                if (add.getType().equals("PERMANENT")) {
                    address.setId(add.getId());
                }
            }

            orderDeliveryAddress.setAddress(address);

            Address shipAddress = addressService.getAddress(model.getAddressId());
            shipAddress.setId(model.getAddressId());
            orderDeliveryAddress.setAddress(shipAddress);
            //orderDeliveryAddress.setShippingCost(new BigDecimal(model.getShippingCharges()));
            orderDeliveryAddress.setOrders(orders);
            orderDeliveryAddress = orderDeliveryOptionsService.create(orderDeliveryAddress);

            List<OrderDeliveryOptions> oDeliveryOptions = new ArrayList<OrderDeliveryOptions>();
            oDeliveryOptions.add(orderDeliveryAddress);
            Set<OrderDeliveryOptions> oDeliveryOptionsSet = new HashSet(oDeliveryOptions);
            orders.setOrderDeliveryOptionses(oDeliveryOptionsSet);
            shippingAddress = orderDeliveryAddress;
            model.setId(orders.getId());
        }
        if (orders.getId() != null) {
            MailConfig mcfgs = mailConfigService.getOrderPlacedMailConfig();
            MailConfig mailConfig = mcfgs;
            if (mailConfig != null) {
                Mail mail = new Mail();
                mail.setMailFrom(mailFrom);
                mail.setMailTo(users.getEmailId());
                mail.setMailSubject("Order Confirmation/Placed Request");
                mailService.sendOrderPlacedMail(mail, users, orders, shippingAddress);

            }
        }
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OrdersContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OrdersModel edit(final IKeyBuilder<String> keyBuilder, final OrdersModel model) {
        Orders orders = ordersService.getOrder(model.getId());

        if (model.getUsersId() != null) {
            Users users = new Users();
            users.setId(model.getUsersId());

            orders.setUsers(users);
        }

        if (model.getStatus() != null) {

            orders.setStatus(model.getStatus());
        }
        if (model.getRating() != null) {
            orders.setRating(Integer.parseInt(model.getRating()));
        }
        if (model.getComments() != null) {
            orders.setComments(model.getComments());
        }

        orders = ordersService.updateOrders(orders);
        model.setId(orders.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OrdersModel getByKey(final IKeyBuilder<String> keyBuilder, final OrdersContext context) {
        Orders orders = ordersService.getOrders(keyBuilder.build().toString());
        OrdersModel ordersModel = conversionService.convert(orders, OrdersModel.class);
        return ordersModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OrdersModel> getCollection(final OrdersContext context) {
        List<Orders> orders = new ArrayList<Orders>();

        if (context.getAll() != null) {
            orders = ordersService.getAll();
        }

        List<OrdersModel> ordersModels = (List<OrdersModel>) conversionService.convert(orders, TypeDescriptor.forObject(orders),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryModel.class)));

        return ordersModels;
    }

}
