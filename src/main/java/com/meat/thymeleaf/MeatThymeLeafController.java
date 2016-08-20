package com.meat.thymeleaf;

import com.meat.dao.RolesRepository;
import com.meat.dao.UsersRepository;
import com.meat.dao.ZoneAreaRepository;
import com.meat.domain.*;
import com.meat.mail.Mail;
import com.meat.security.CustomUserDetails;
import com.meat.service.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ImportResource("classpath:spring-thymeleaf.xml")
@Controller
@RequestMapping
@PropertySource("classpath:application.properties")
@PropertySource("classpath:mail.properties")
public class MeatThymeLeafController {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private IUsersService userService;
    @Autowired
    private ISellerService sellerService;
    @Autowired
    private IAttributesService attributesService;
    @Autowired
    private IZoneCityService zoneCityService;
    @Autowired
    private ITagsService tagsService;
    @Autowired
    private ITagTypeService tagTypeService;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private ISubCategoryService subCategoryService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ISellerBranchService sellerBranchService;
    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IMailService mailService;
    @Autowired
    private IMailConfigService mailConfigService;
    @Autowired
    private IItemAttributesService itemAttributesService;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;
    @Autowired
    private ZoneAreaRepository zoneAreaRepository;
    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
    @Autowired
    private ISellerInvoiceService sellerInvoiceService;
    @Autowired
    private IOfferService offerService;
    @Autowired
    private IOrdersService orderService;

    @Value("${url}")
    private String url;
    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;

    String supplier = "ROLE_RESTAURANT";
    String restaurant = "ROLE_RESTAURANT";
    @Autowired
    private RolesRepository roleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/404", consumes = { MediaType.ALL_VALUE })
    public String get404() {

        return "404Page";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/s/about-us", consumes = { MediaType.ALL_VALUE })
    public String getAboutPage() {

        return "AboutUsPage";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/appHome", consumes = { MediaType.ALL_VALUE })
    public String getAppHomePage() {

        return "mobile/MainPageFragment";

    }

    @RequestMapping(value = "/meatitem/{itemName}", method = RequestMethod.GET)
    public String getByProduct(final Item item, final BindingResult result, final Model model, final HttpSession session,
            final HttpServletRequest req, @PathVariable(value = "itemName") final String itemName,
            @RequestParam(value = "id") final String itemId, @RequestParam(value = "med", defaultValue = "desk") final String media) {

        String zoneId = getCookieZoneId(req);
        Item items = itemService.getItemByThymeleafWithSellerItem(itemId);
        model.addAttribute("item", items);
        if (zoneId != null) {
            Map<SellerItem, List<Offer>> sellerItemsWithOffers = new HashMap<SellerItem, List<Offer>>(0);
            List<SellerItem> sellerItems = sellerItemService.getSellerItemByThymeleafItemZone(itemId, zoneId);
            model.addAttribute("zoneAvailability", true);
            if (sellerItems.size() == 0) {
                sellerItems.addAll(sellerItemService.getSellerItemByThymeleafItem(itemId));
                model.addAttribute("zoneAvailability", false);
            }

            int i = 0;
            SellerItem si = new SellerItem();
            List<Offer> selectedOffers = new ArrayList<Offer>();
            for (SellerItem sellerItem : sellerItems) {
                List<Offer> sellerItemOffers = offerService.getOffersBySellerItemAlongWithItsParents(sellerItem.getId());
                float totalRating = 0;
                for (UserSellerItemRating usir : sellerItem.getUserSellerItemRatings()) {
                    totalRating = totalRating + usir.getRating();
                }
                int averageRating = (int) (totalRating / sellerItem.getUserSellerItemRatings().size());

                sellerItem.setCountFlag(averageRating);
                sellerItemsWithOffers.put(sellerItem, sellerItemOffers);

                if (i == 0) {
                    si = sellerItem;
                    selectedOffers.addAll(sellerItemOffers);
                }
                i++;
            }

            model.addAttribute("sellerItemsWithOffers", sellerItemsWithOffers);
            model.addAttribute("lowestSellingPriceSellerItem", si);
            model.addAttribute("lowestSellingPriceSellerItemOffers", selectedOffers);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (!authentication.getPrincipal().equals("anonymousUser")) {
                Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                List<PreOrderCartItems> pocs = preOrderCartItemsService.getPreOrderCartItemsBySellerItemUser(users.getId(), si.getId());
                model.addAttribute("pocs", pocs);
            }

        }
        else {
            Map<SellerItem, List<Offer>> sellerItemsWithOffers = new HashMap<SellerItem, List<Offer>>(0);
            List<SellerItem> sellerItems = sellerItemService.getSellerItemByThymeleafItem(itemId);
            int i = 0;
            SellerItem si = new SellerItem();
            List<Offer> selectedOffers = new ArrayList<Offer>();
            for (SellerItem sellerItem : sellerItems) {
                List<Offer> sellerItemOffers = offerService.getOffersBySellerItemAlongWithItsParents(sellerItem.getId());
                float totalRating = 0;
                for (UserSellerItemRating usir : sellerItem.getUserSellerItemRatings()) {
                    totalRating = totalRating + usir.getRating();
                }

                int averageRating = (int) (totalRating / sellerItem.getUserSellerItemRatings().size());

                sellerItem.setCountFlag(averageRating);
                sellerItemsWithOffers.put(sellerItem, sellerItemOffers);

                if (i == 0) {
                    si = sellerItem;
                    selectedOffers.addAll(sellerItemOffers);
                }
                i++;
            }
            model.addAttribute("sellerItemsWithOffers", sellerItemsWithOffers);
            model.addAttribute("lowestSellingPriceSellerItem", si);
            model.addAttribute("lowestSellingPriceSellerItemOffers", selectedOffers);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (!authentication.getPrincipal().equals("anonymousUser")) {
                Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                List<PreOrderCartItems> pocs = preOrderCartItemsService.getPreOrderCartItemsBySellerItemUser(users.getId(), si.getId());
                model.addAttribute("pocs", pocs);
            }
        }

        int p = 1;
        int pz = 6;
        List<Item> relativeItems = itemService.getSubCatRelativeRelativeItemsPage(items.getSubCategory().getId(), zoneId, p, pz);
        model.addAttribute("relativeItems", relativeItems);
        ArrayList<String> array = new ArrayList<String>();
        model.addAttribute("array", array);

        if (media.equals("desk")) {
            return "SingleItemPage";
        }
        else {
            return "mobile/SingleItemDetailsFragment";
        }
    }

    @RequestMapping(value = "/useractivation/{usersId}", method = RequestMethod.GET)
    public String getByUserActivation(final Users users, final BindingResult result, final Model model, final HttpSession session,
            @PathVariable(value = "usersId") final String usersId) {
        Users user = userRepository.findByUserId(usersId);
        if (user.getStatus() != null) {
            if (user.getStatus().equals("ACTIVE")) {
                model.addAttribute("message", "ALREADYACTIVATED");
            }
            else {
                Users urs = user;
                urs.setStatus("ACTIVE");
                urs = userService.updateUsers(urs);
                model.addAttribute("message", "ACTIVATEDSUCCESSFULLY");
                if (urs != null) {
                    MailConfig mcfgs = mailConfigService.getUserAcitvationMailConfig();
                    if (mcfgs != null) {
                        Mail mail = new Mail();
                        mail.setMailFrom(mailFrom);
                        mail.setMailTo(users.getEmailId());
                        mail.setMailSubject("Account Activation Request");
                        mailService.sendUserActivationMail(mail, users);
                    }
                }
            }
        }
        return "redirect:" + url + "/login";
    }

    @RequestMapping(value = "/forgotPassword/{emailId}", method = RequestMethod.GET)
    public String getByUserForgotPassword(final Users users, final BindingResult result, final Model model, final HttpSession session,
            @PathVariable(value = "emailId") final String emailId) {
        Users user = userRepository.findByEmailId(emailId);
        if (user.getStatus() != null) {
            if (user.getStatus().equals("ACTIVE")) {

            }
            else {
                Users urs = user;
                urs.setStatus("ACTIVE");
                urs = userService.updateUsers(urs);
                model.addAttribute("message", "ACTIVATEDSUCCESSFULLY");
                if (urs != null) {
                    MailConfig mcfgs = mailConfigService.getUserAcitvationMailConfig();
                    if (mcfgs != null) {
                        Mail mail = new Mail();
                        mail.setMailFrom(mailFrom);
                        mail.setMailTo(users.getEmailId());
                        mail.setMailSubject("Account Activation Request");
                        mailService.sendUserActivationMail(mail, users);
                    }
                }
            }
        }
        return "redirect:" + url + "/login";
    }

    /* sankar edited for mobile cart page end */
    @RequestMapping(method = RequestMethod.GET, value = "/s/contact-us", consumes = { MediaType.ALL_VALUE })
    public String getContactUsPage() {

        return "ContactUsPage";

    }

    public String getCookieZoneId(final HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        String zoneId = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("zid")) {
                    zoneId = c.getValue();
                }
            }
        }
        return zoneId;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/s/delivery-and-cancel", consumes = { MediaType.ALL_VALUE })
    public String getDeliveryAndCancel() {

        return "DeliveryAndCancelPage";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/productSearch/distinct/{searchTerm}/items", consumes = { MediaType.ALL_VALUE })
    public String getDistinctProductsBySearchn(final Item item, final Zone zone, final BindingResult result, final Model model,
            final HttpServletRequest req, final HttpSession session, @RequestParam(value = "med", defaultValue = "desk") final String media,

            @PathVariable(value = "searchTerm") final String searchTerm) {
        // String s = (String) session.getAttribute("userId");
        String zoneId = getCookieZoneId(req);
        int itemsCount = 0;
        if (media.equals("desk")) {
            itemsCount = 6;
        }
        else {
            itemsCount = 20;
        }

        if (zoneId != null) {
            List<Item> items = itemService.getSearchItemsByZoneOnly(zoneId, searchTerm, itemsCount);
            model.addAttribute("items", items);

            List<SubCategory> subCategories = subCategoryService.getSearchItemSubCategoryByZoneOnly(zoneId, searchTerm);
            model.addAttribute("subCategories", subCategories);

            /* List<Category> categories = categoryService.getSearchItemCategoryByZoneOnly(zoneId, searchTerm);
            model.addAttribute("categories", categories);*/
        }
        else {
            List<Item> items = itemService.getSearchItemsOnly(searchTerm, itemsCount);
            model.addAttribute("items", items);

            List<SubCategory> subCategories = subCategoryService.getSearchItemSubCategoryOnly(searchTerm);
            model.addAttribute("subCategories", subCategories);
            /*
            List<Category> categories = categoryService.getSearchItemCategoryOnly(searchTerm);
            model.addAttribute("categories", categories);*/
        }
        if (media.equals("desk")) {
            return "fragments/SearchResultsFragment::ResultsFragment";
        }
        else {
            return "mobile/SearchResultsFragment";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/distinct/withOutSelect/{searchTerm}/items", consumes = { MediaType.ALL_VALUE })
    public String getDistinctProductsBySearchnByEnter(final Item item, final BindingResult result, final Model model,
            @PathVariable(value = "searchTerm") final String searchTerm, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        List<Item> items1 = itemService.getSearchItemsOnly(searchTerm);
        model.addAttribute("items", items1);
        /*
         * List<Restaurant> restaurants = restaurantService
         * .getSearchItemsOnly(searchTerm); model.addAttribute("restaurants",
         * restaurants);
         */
        /*    List<Category> categories = categoryService.getSearchItemsOnlyWithOutSelect(searchTerm);
        model.addAttribute("categories", categories);*/
        /*
         * List<SubCategory> subCategories = subCategoryService
         * .getSearchItemsOnly(searchTerm); model.addAttribute("subCategories",
         * subCategories);
         */

        return "fragments/ResultsFragment";
    }

    @RequestMapping(value = "/items/category/{categoryName}/a", method = RequestMethod.GET)
    public String getItemListByAttributesAndCategoryThyme(final Zone zone, final BindingResult result, final Model model,
            final HttpServletRequest req, @PathVariable(value = "categoryName") final String categoryName,
            @RequestParam(value = "id") final String categoryId, final Item item,

            @RequestParam(defaultValue = "N/A", value = "tid") final String[] tagId,
            @RequestParam(defaultValue = "N/A", value = "scid") final String[] subCategoryId,
            @RequestParam(defaultValue = "N/A", value = "atid") final String[] attributesId,
            @RequestParam(defaultValue = "N/A", value = "atval") final String[] attributeValue,
            @RequestParam(defaultValue = "N/A", value = "sp") final String sp,
            @RequestParam(defaultValue = "N/A", value = "ep") final String ep,
            @RequestParam(defaultValue = "1", value = "page", required = false) final int page,
            @RequestParam(defaultValue = "16", value = "pageSize", required = false) final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {
        String zoneId = getCookieZoneId(req);
        Category c = categoryService.getCategory(categoryId);
        model.addAttribute("seo", c.getSeo());
        model.addAttribute("category", c);
        ArrayList<String> array = new ArrayList<String>();
        model.addAttribute("array", array);
        if (!zoneId.equals("N/A")) {
            String[] cat = { categoryId };
            List<Item> items = itemService.getCategoryItemPriceFilterThymeleafPageAll(cat, zoneId, subCategoryId, tagId, attributesId,
                    attributeValue, sp, ep, page, pageSize, sort, type);
            model.addAttribute("items", items);

        }
        else {
            String[] cat = { categoryId };
            List<Item> items = itemService.getItemsByThymeleafPageAllCategory(cat, subCategoryId, tagId, attributesId, attributeValue, sp,
                    ep, page, pageSize, sort, type);
            model.addAttribute("items", items);
        }
        if (zoneId != null) {
            List<Attributes> attributes = attributesService.getItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("attributes", attributes);
        }

        if (zoneId != null) {
            List<ItemAttributes> itemAttributes = itemAttributesService.getItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("itemAttributes", itemAttributes);
        }
        else {

            List<ItemAttributes> itemAttributes = itemAttributesService.getItemAttributesByThymeleafCategory(categoryId);
            model.addAttribute("itemAttributes", itemAttributes);
        }
        if (zoneId != null) {
            List<SellerItem> sellerItems = sellerItemService.getItemSellerItemByThymeleafCategoryZone(categoryId, zoneId, page, pageSize,
                    sort, type);
            model.addAttribute("sellerItems", sellerItems);
        }
        else {
            List<SellerItem> sellerItems = sellerItemService.getItemSellerItemByThymeleafCategory(categoryId, page, pageSize, sort, type);
            model.addAttribute("sellerItems", sellerItems);
        }
        if (zoneId != null) {
            BigDecimal minPrice = sellerItemService.getMinSellerItemPagesByThemeleafCategoryZone(zoneId, categoryId);
            model.addAttribute("minPrice", minPrice);
        }
        else {
            BigDecimal minPrice = sellerItemService.getMinSellerItemPagesByThemeleafCategory(categoryId);
            model.addAttribute("minPrice", minPrice);

        }
        if (zoneId != null) {
            BigDecimal maxPrice = sellerItemService.getMaxSellerItemPagesByThemeleafCategoryZone(zoneId, categoryId);
            model.addAttribute("maxPrice", maxPrice);
        }
        else {
            BigDecimal maxPrice = sellerItemService.getMaxSellerItemPagesByThemeleafCategory(categoryId);
            model.addAttribute("maxPrice", maxPrice);
        }
        if (zoneId != null) {

            List<SubCategory> subCategories = subCategoryService.getItemSubCategoriesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("subCategories", subCategories);
        }
        else {

            List<SubCategory> subCategories = subCategoryService.getItemSubCategoriesByThymeleafCategory(categoryId);
            model.addAttribute("subCategories", subCategories);
        }
        if (zoneId != null) {
            List<TagType> tagType = tagTypeService.getItemTagTypesByThemeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("tagTypes", tagType);
        }
        else {
            List<TagType> tagType = tagTypeService.getItemTagTypesByThemeleafCategory(categoryId);
            model.addAttribute("tagTypes", tagType);
        }
        List<SellerBranch> sellerBranchs = sellerBranchService.getSellerBranchesByThemeleafCategoryZone(categoryId, zoneId);
        model.addAttribute("sellerBranchs", sellerBranchs);

        return "ItemsPage";

    }

    @RequestMapping(value = { "/items/category/{categoryName}/page/{page}/pageSize/{pageSize}",
            "/items/category/{categoryName}/a/page/{page}/pageSize/{pageSize}" }, method = RequestMethod.GET)
    public String getItemListByCategoryByPage(final Item item, final BindingResult result, final Model model, final HttpSession session,
            final HttpServletRequest req, @PathVariable(value = "categoryName") final String categoryName,
            @RequestParam(value = "id") final String categoryId,

            @RequestParam(defaultValue = "N/A", value = "tid") final String[] tagId,
            @RequestParam(defaultValue = "N/A", value = "scid") final String[] subCategoryId,
            @RequestParam(defaultValue = "N/A", value = "atid") final String[] attributesId,
            @RequestParam(defaultValue = "N/A", value = "atval") final String[] attributeValue,
            @RequestParam(defaultValue = "N/A", value = "sp") final String sp,
            @RequestParam(defaultValue = "N/A", value = "ep") final String ep, @PathVariable(value = "page") final int page,
            @PathVariable(value = "pageSize") final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {
        String zoneId = getCookieZoneId(req);
        if (zoneId != null) {
            /* List<Item> items = itemService.getItemsByThymeleafCategoryZone(categoryId, zoneId, page, pageSize, sort, type);
            model.addAttribute("items", items);*/
            String[] cat = { categoryId };
            List<Item> items1 = itemService.getCategoryItemPriceFilterThymeleafPageAll(cat, zoneId, subCategoryId, tagId, attributesId,
                    attributeValue, sp, ep, page, pageSize, sort, type);
            model.addAttribute("items", items1);
        }
        else {
            List<Item> items = itemService.getItemsByThymeleafCategory(categoryId, page, pageSize, sort, type);
            model.addAttribute("items", items);
        }

        return "fragments/ItemsListFragment";
    }

    @RequestMapping(value = "/items/category/{categoryName}", method = RequestMethod.GET)
    public String getItemListByCategoryThyme(final Zone zone, final BindingResult result, final Model model, final HttpServletRequest req,
            @PathVariable(value = "categoryName") final String categoryName, @RequestParam(value = "id") final String categoryId,
            final Item item,

            @RequestParam(defaultValue = "desk", value = "med", required = false) final String media,
            @RequestParam(defaultValue = "1", value = "page", required = false) final int page,
            @RequestParam(defaultValue = "16", value = "pageSize", required = false) final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {
        String zoneId = getCookieZoneId(req);
        Category c = categoryService.getCategory(categoryId);
        if (c.getSeo() != null) {
            model.addAttribute("seo", c.getSeo());
        }
        model.addAttribute("category", c);

        ArrayList<String> array = new ArrayList<String>();
        model.addAttribute("array", array);
        if (zoneId != null) {
            List<Item> items = itemService.getItemsByThymeleafCategoryZone(categoryId, zoneId, page, pageSize, sort, type);
            model.addAttribute("items", items);
        }
        else {
            List<Item> items = itemService.getItemsByThymeleafCategory(categoryId, page, pageSize, sort, type);
            model.addAttribute("items", items);
        }
        if (zoneId != null) {
            List<Attributes> attributes = attributesService.getItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("attributes", attributes);
        }

        if (zoneId != null) {
            List<ItemAttributes> itemAttributes = itemAttributesService.getItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("itemAttributes", itemAttributes);
        }
        else {

            List<ItemAttributes> itemAttributes = itemAttributesService.getItemAttributesByThymeleafCategory(categoryId);
            model.addAttribute("itemAttributes", itemAttributes);
        }
        if (zoneId != null) {
            List<SellerItem> sellerItems = sellerItemService.getItemSellerItemByThymeleafCategoryZone(categoryId, zoneId, page, pageSize,
                    sort, type);
            model.addAttribute("sellerItems", sellerItems);
        }
        else {
            List<SellerItem> sellerItems = sellerItemService.getItemSellerItemByThymeleafCategory(categoryId, page, pageSize, sort, type);
            model.addAttribute("sellerItems", sellerItems);
        }
        if (zoneId != null) {
            BigDecimal minPrice = sellerItemService.getMinSellerItemPagesByThemeleafCategoryZone(zoneId, categoryId);
            model.addAttribute("minPrice", minPrice);
        }
        else {
            BigDecimal minPrice = sellerItemService.getMinSellerItemPagesByThemeleafCategory(categoryId);
            model.addAttribute("minPrice", minPrice);
        }
        if (zoneId != null) {
            BigDecimal maxPrice = sellerItemService.getMaxSellerItemPagesByThemeleafCategoryZone(zoneId, categoryId);
            model.addAttribute("maxPrice", maxPrice);
        }
        else {
            BigDecimal maxPrice = sellerItemService.getMaxSellerItemPagesByThemeleafCategory(categoryId);
            model.addAttribute("maxPrice", maxPrice);
        }
        if (zoneId != null) {

            List<SubCategory> subCategories = subCategoryService.getItemSubCategoriesByThymeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("subCategories", subCategories);
        }
        else {

            List<SubCategory> subCategories = subCategoryService.getItemSubCategoriesByThymeleafCategory(categoryId);
            model.addAttribute("subCategories", subCategories);
        }
        if (zoneId != null) {
            List<TagType> tagType = tagTypeService.getItemTagTypesByThemeleafCategoryZone(categoryId, zoneId);
            model.addAttribute("tagTypes", tagType);
        }
        else {
            List<TagType> tagType = tagTypeService.getItemTagTypesByThemeleafCategory(categoryId);
            model.addAttribute("tagTypes", tagType);
        }
        List<SellerBranch> sellerBranchs = sellerBranchService.getSellerBranchesByThemeleafCategoryZone(categoryId, zoneId);
        model.addAttribute("sellerBranchs", sellerBranchs);

        return "ItemsPage";

    }

    @RequestMapping(value = "/items/seller/{sellerName}", method = RequestMethod.GET)
    public String getItemListBySellerThyme(final Zone zone, final BindingResult result, final Model model, final HttpServletRequest req,
            @PathVariable(value = "sellerName") final String sellerName, @RequestParam(value = "id") final String sellerId,

            @RequestParam(defaultValue = "desk", value = "med", required = false) final String media,
            @RequestParam(defaultValue = "1", value = "page", required = false) final int page,
            @RequestParam(defaultValue = "16", value = "pageSize", required = false) final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {
        String zoneId = getCookieZoneId(req);
        Seller s = sellerService.getSeller(sellerId);
        model.addAttribute("seo", s.getSeo());
        model.addAttribute("seller", s);

        List<SellerItem> sellerItems = sellerItemService.getItemSellerItemByThymeleafSellerZone(sellerId, zoneId, page, pageSize, sort,
                type);
        model.addAttribute("sellerItems", sellerItems);

        return "ItemsPage";

    }

    /*  @RequestMapping(method = RequestMethod.GET, value = "/filter/root/items/page/{page}/pageSize/{pageSize}", consumes = {
            MediaType.ALL_VALUE })
    public String getItemsByCategoryPage1(final Item item, final BindingResult result, final Model model,
            @RequestParam(defaultValue = "N/A", value = "cid") final String[] categoryId,
            @RequestParam(defaultValue = "N/A", value = "zid") final String zoneId,
            @RequestParam(defaultValue = "N/A", value = "tid") final String[] tagId,
            @RequestParam(defaultValue = "N/A", value = "scid") final String[] subCategoryId,
            @RequestParam(defaultValue = "N/A", value = "atid") final String[] attributesId,
            @RequestParam(defaultValue = "N/A", value = "atval") final String[] attributeValue,
            @RequestParam(defaultValue = "N/A", value = "sp") final String sp,
            @RequestParam(defaultValue = "N/A", value = "ep") final String ep,
            @RequestParam(defaultValue = "1", value = "page", required = false) final int page,
            @RequestParam(defaultValue = "16", value = "pageSize", required = false) final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {

        List<Item> items1 = itemService.getCategoryItemPriceFilterThymeleafPagination(categoryId, tagId, page, pageSize, sort, type);
        model.addAttribute("items", items1);
        return "fragments/ItemsListFragment";
    }
    */
    @RequestMapping(method = RequestMethod.GET, value = "/filter/root/items", consumes = { MediaType.ALL_VALUE })
    public String getItemsByCategoryPage1Filter(final Item item, final BindingResult result, final Model model, final HttpSession session,
            final HttpServletRequest req, @RequestParam(defaultValue = "N/A", value = "cid") final String[] categoryId,

            @RequestParam(defaultValue = "N/A", value = "tid") final String[] tagId,
            @RequestParam(defaultValue = "N/A", value = "scid") final String[] subCategoryId,
            @RequestParam(defaultValue = "N/A", value = "atid") final String[] attributesId,
            @RequestParam(defaultValue = "N/A", value = "atval") final String[] attributeValue,
            @RequestParam(defaultValue = "N/A", value = "sp") final String sp,
            @RequestParam(defaultValue = "N/A", value = "ep") final String ep,
            @RequestParam(defaultValue = "1", value = "page", required = false) final int page,
            @RequestParam(defaultValue = "16", value = "pageSize", required = false) final int pageSize,
            @RequestParam(defaultValue = "item", value = "sort", required = false) final String sort,
            @RequestParam(defaultValue = "asc", value = "type", required = false) final String type) {
        String zoneId = getCookieZoneId(req);
        List<Item> items1 = itemService.getCategoryItemPriceFilterThymeleafPageAll(categoryId, zoneId, subCategoryId, tagId, attributesId,
                attributeValue, sp, ep, page, pageSize, sort, type);

        model.addAttribute("items", items1);
        return "fragments/ItemsListFragment";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login", consumes = { MediaType.ALL_VALUE })
    public String getLoginPageByThymeleaf(final Model model, final HttpSession session, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal().equals("anonymousUser")) {
            return "LoginOrRegistrationPage";
        }
        else {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            return "redirect:" + url + "/myaccount/profile";
        }
    }

    @RequestMapping(value = "/myaccount/logout", method = RequestMethod.GET)
    public String getLogout(final Users user, final BindingResult result, final ModelMap model, final HttpSession session) {
        String message = "Logout Successfully!";
        session.invalidate();
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");
        return "index";
    }

    @RequestMapping(value = "/myaccount/profile", method = RequestMethod.GET)
    public String getMyAccountProfile(final Model model, final HttpSession httpSession, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (!userDetails.getUserName().equals("anonymousUser")) {
            Users user1 = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user1.getUserName(); // get logged in username
            String id = user1.getId();
            String status = "CARTADDED";
            List<PreOrderCartItems> preOrderCartItems = preOrderCartItemsService.getPreOrderCartItemsByUserAndStatus(id, status);
            model.addAttribute("preOrderCartItems", preOrderCartItems);
            Users user = userService.findByUser(id);
            model.addAttribute("user", user);
            return "MyAccount";
        }
        else {
            httpSession.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");
            return "redirect:" + url + "/login";
        }

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getMyCart(final ModelMap model, final HttpSession httpSession, final HttpServletRequest req) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String status = "CARTADDED";
        String userId = userDetails.getId();
        List<PreOrderCartItems> cartItems = preOrderCartItemsService.getPreOrderCartItemsByUserAndStatus(userId, status);
        List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();
        BigDecimal totalCartPrice = new BigDecimal(0.0);
        Map<PreOrderCartItems, List<Offer>> preOrderCartItemsWithOffers = new HashMap<PreOrderCartItems, List<Offer>>();
        for (PreOrderCartItems poc : cartItems) {

            PreOrderCartItems poci = new PreOrderCartItems();
            SellerItem sellerItem = poc.getSellerItem();
            List<PreOrderCartItems> pres = preOrderCartItemsService.getPreOrderCartItemsWithCommonSellerItem(sellerItem.getId(), userId);
            if (pres.size() > 1) {

                preOrderCartItemsService.deleteSinglePreOrderCartItems(pres.get(1));

                continue;
            }
            Map<SellerItem, List<Offer>> sellerItemWithOffersShortInfo = sellerItemService
                    .getSellerItemWithOffersShortInfo(sellerItem.getId());

            SellerItem si = (SellerItem) sellerItemWithOffersShortInfo.keySet().toArray()[0];

            /*  Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(si.getId(), "PERCENT");
            poc.setItemTax(itemTotalTax);*/

            poc.setPrice(si.getSellingPrice().multiply(new BigDecimal(poc.getUnits())));
            poci = poc;
            poci.setSellerItem(si);
            /*  BigDecimal itemTotalPrice = (poc.getPrice().multiply(new BigDecimal(itemTotalTax))).divide(new BigDecimal(100.00))
                    .add(poc.getPrice());*/
            poci.setCartPrice(poc.getPrice());

            totalCartPrice = totalCartPrice.add(poc.getCartPrice());
            preOrderCartItemsWithOffers.put(poci, sellerItemWithOffersShortInfo.get(si));
            preOrderCartItems.add(poci);

        }
        model.addAttribute("preOrderCartItemsWithOffers", preOrderCartItemsWithOffers);
        model.addAttribute("preOrderCartItems", preOrderCartItems);
        model.addAttribute("cartTotalPrice", totalCartPrice);

        return "CartPage";
    }

    @RequestMapping(value = "/myaccount/changepassword", method = RequestMethod.GET)
    public String getMyChangePassword(final Users user, final BindingResult result, final ModelMap model, final HttpSession session,
            final HttpServletRequest req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String zoneId = getCookieZoneId(req);
        if (!authentication.getName().equals("anonymousUser")) {
            Users user1 = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user1.getUserName(); // get logged in username
            String id = user1.getId();
            String status = "CartAdded";
            /*   List<PreOrderCartItems> preOrderCartItems = preOrderCartItemsService.getCartItemsOnly(id, status);*/
            /*model.addAttribute("preOrderCartItems", preOrderCartItems);*/
            Users u = userService.findByUser(id);
            model.addAttribute("user", u);

            return "MyAccount";
        }
        else {
            session.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");

            return "redirect:" + url + "/login";
        }
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String getMyCheckOut(final Model model, final HttpSession httpSession, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            String status = "CARTADDED";
            List<PreOrderCartItems> poci = preOrderCartItemsService.getPreOrderCartItemsByUserAndStatus(userDetails.getId(), status);
            model.addAttribute("preOrderCartItems", poci);

            HashMap<String, List<PreOrderCartItems>> hashMap = new HashMap<String, List<PreOrderCartItems>>();

            for (PreOrderCartItems poc : poci) {
                PreOrderCartItems po = new PreOrderCartItems();

                SellerItem sellerItem = poc.getSellerItem();
                Map<SellerItem, List<Offer>> sellerItemWithOffersShortInfo = sellerItemService
                        .getSellerItemWithOffersShortInfo(sellerItem.getId());

                SellerItem si = (SellerItem) sellerItemWithOffersShortInfo.keySet().toArray()[0];
                poc.setSellerItem(si);

                Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(poc.getSellerItem().getId(), "PERCENT");
                poc.setItemTax(itemTotalTax);
                po = poc;
                String sellerBranchId = poc.getSellerItem().getSellerBranch().getId();
                // BigDecimal itemTotalPrice = (poc.getPrice().multiply(new BigDecimal(itemTotalTax))).divide(new BigDecimal(100.00));
                /*  po.setCartPrice(itemTotalPrice.add(poc.getCartPrice()));*/

                if (!hashMap.containsKey(sellerBranchId)) {
                    List<PreOrderCartItems> list = new ArrayList<PreOrderCartItems>();
                    list.add(po);

                    hashMap.put(sellerBranchId, list);
                }
                else {
                    hashMap.get(sellerBranchId).add(po);
                }
            }
            if (zoneId != null) {
                List<ZoneArea> zoneAreas = zoneAreaRepository.findZoneAreasByZoneId(zoneId);
                model.addAttribute("zoneAreas", zoneAreas);
            }
            List<Address> userAddress = addressService.getAllAddressByUser(userDetails.getId());
            model.addAttribute("preOrderCartItemsHash", hashMap);
            model.addAttribute("userAddress", userAddress);

        }

        return "CheckOutPage";
    }

    @RequestMapping(value = "/myaccount/order/{orderId}/orderItems", method = RequestMethod.GET)
    public String getMyOrderItemsByOrder(final Users user, final BindingResult result, final ModelMap model, final HttpSession session,
            final HttpServletRequest req, @PathVariable(value = "orderId") final String orderId) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals("anonymousUser")) {
            Users user1 = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user1.getUserName(); // get logged in username
            String id = user1.getId();
            String status = "CartAdded";
            return "MyAccount";
        }
        else {
            session.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");

            return "redirect:" + url + "/login";
        }
    }

    @RequestMapping(value = "/quickcheckout", method = RequestMethod.GET)
    public String getMyQuickCheckOut(final Model model, final HttpSession httpSession, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            String statusFlag = "QC";
            List<PreOrderCartItems> poci = preOrderCartItemsService.getPreOrderCartItemsByUserAndStatusFlag(userDetails.getId(),
                    statusFlag);
            model.addAttribute("preOrderCartItems", poci);

            HashMap<String, List<PreOrderCartItems>> hashMap = new HashMap<String, List<PreOrderCartItems>>();
            for (PreOrderCartItems poc : poci) {
                PreOrderCartItems po = new PreOrderCartItems();

                Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(poc.getSellerItem().getId(), "PERCENT");
                poc.setItemTax(itemTotalTax);
                po = poc;
                String sellerBranchId = poc.getSellerItem().getSellerBranch().getId();
                BigDecimal itemTotalPrice = (poc.getCartPrice().multiply(new BigDecimal(itemTotalTax))).divide(new BigDecimal(100.00));
                po.setCartPrice(itemTotalPrice.add(poc.getCartPrice()));

                if (!hashMap.containsKey(sellerBranchId)) {
                    List<PreOrderCartItems> list = new ArrayList<PreOrderCartItems>();
                    list.add(po);

                    hashMap.put(sellerBranchId, list);
                }
                else {
                    hashMap.get(sellerBranchId).add(po);
                }

            }
            if (zoneId != null) {
                List<ZoneArea> zoneAreas = zoneAreaRepository.findZoneAreasByZoneId(zoneId);
                model.addAttribute("zoneAreas", zoneAreas);
            }
            List<Address> userAddress = addressService.getAllAddressByUser(userDetails.getId());
            model.addAttribute("preOrderCartItemsHash", hashMap);
            model.addAttribute("userAddress", userAddress);

        }

        return "CheckOutPage";
    }

    @RequestMapping(value = "/s/orders-and-pricing", method = RequestMethod.GET)
    public String getOrdersAndPricingPage() {
        return "OrdersAndPricingPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/s/privacypolicy", consumes = { MediaType.ALL_VALUE })
    public String getPrivacyPolicyPage() {

        return "PrivacyPolicyPage";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/register", consumes = { MediaType.ALL_VALUE })
    public String getRegistrationOrLoginPage(final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        return "LoginOrRegistrationPage";
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
    public String getResetPasswordPage(@RequestParam(value = "id") final String usersId) {

        return "ResetPasswordPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/redirect", consumes = { MediaType.ALL_VALUE })
    public String getSamplePage(final HttpServletRequest req, final HttpServletResponse res, final RedirectAttributes redirectAttributes) {
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

        try {
            redirectStrategy.sendRedirect(req, res, "/redirect1");

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "AboutUsPage";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/redirect1")
    public String getSamplePage1(final HttpServletRequest req, final HttpServletResponse res) {
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        try {
            redirectStrategy.sendRedirect(req, res, "http://www.flipkart.com");

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "AboutUsPage";

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchFullPage(@RequestParam(value = "query") final String searchString,
            @RequestParam(value = "s") final String pageSize, final HttpServletRequest req, final Model model) {
        String zoneId = getCookieZoneId(req);

        if (zoneId != null) {
            List<Item> items = itemService.getSearchItemsByZoneOnly(zoneId, searchString, Integer.parseInt(pageSize));
            model.addAttribute("items", items);
            List<SubCategory> subCategories = subCategoryService.getSearchItemSubCategoryByZoneOnly(zoneId, searchString);
            model.addAttribute("subCategories", subCategories);
        }
        else {
            List<Item> items = itemService.getSearchItemsOnly(searchString, Integer.parseInt(pageSize));
            model.addAttribute("items", items);
        }
        model.addAttribute("searchString", searchString);
        return "FullSearchPage";
    }

    // Commented on 30/6/2016 by varma
    /*   start
     *
     *   @RequestMapping(value = "/resetsupassword", method = RequestMethod.GET)
    public String getResetSellerUserPasswordPage(@RequestParam(value = "id") final String sellerUserId, final Model model,
            @RequestParam(value = "newPassword") final String newPassword,
            @RequestParam(value = "confirmPassword") final String confirmPassword) {
        SellerUser sellerUser = sellerUserRepository.findOne(sellerUserId);
        SellerUser user = sellerUser;
        if (newPassword.equals(confirmPassword)) {
            user.setPassword(newPassword);
            user = sellerUserService.getUserResetPassword(user);
            if (user != null) {
                model.addAttribute("SUCCESS", "Successfully Recovered Password");
            }
        }
        else {
            model.addAttribute("FAILURE", "Passwords Doesn't Match");
        }
        return "ResetPasswordPage";
    }

    End
    */

    /*  @RequestMapping(method = RequestMethod.GET, value = "/resetpassword", consumes = { MediaType.ALL_VALUE })
    public String getResetPasswordPage(@RequestParam(value = "token") final String id, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Users user = userRepository.findOne(id);
        if (user != null) {
            return "ResetPasswordPage";
        }
        else {
            return "redirect:" + url;
        }
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/seller/accountpage/{usersId}", consumes = { MediaType.ALL_VALUE })
    public String getSellerAccount(@PathVariable(value = "usersId") final String usersId, final Model model) {
        Users users = userService.getUsers(usersId);
        // SellerBranch sellerBranch = sellerBranchService.getSellerBranch(sellerBranchId);
        model.addAttribute("users", users);

        return "mobile/seller/SellerAccount";

    }

    /* Welcome Page for Seller Admin App */
    @RequestMapping(method = RequestMethod.GET, value = "/seller/welcomepage", consumes = { MediaType.ALL_VALUE })
    public String getSellerAppHomePage() {
        return "mobile/seller/SellerWelcome";
    }

    /* Login Page for Seller Admin App */
    @RequestMapping(method = RequestMethod.GET, value = "/seller/loginpage", consumes = { MediaType.ALL_VALUE })

    public String getSellerAppLoginPage() {
        return "mobile/seller/SellerLogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/mainmenupage", consumes = { MediaType.ALL_VALUE })
    public String getSellerAppMenuPage() {

        return "mobile/seller/SellerMainMenu";
    }

    @RequestMapping(value = "/seller/selleritems/branch/{branchId}", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })

    public String getSellerBranchItemsByBranchId(final Model model, @PathVariable(value = "branchId") final String branchId) {
        List<SellerItem> sellerItems = sellerItemService.getSellerItemsBySellerBranch(branchId);
        model.addAttribute("sellerItems", sellerItems);
        return "mobile/seller/SellerSubOrders";
    }

    @RequestMapping(value = "/seller/sellerorders/branch/{branchId}/date/{deliveryDate}/confirmedstatus/{status}", method = RequestMethod.GET, consumes = {
            MediaType.ALL_VALUE })
    public String getSellerBranchSubOrdersByBranchDeliveryDateConfirmedStatus(final Model model,
            @PathVariable(value = "branchId") final String branchId, @PathVariable(value = "deliveryDate") final String date,
            @PathVariable(value = "status") final String status) {

        List<SubOrder> subOrders = subOrderService.getSubOrderByBranchStatusDate(branchId, date, status);

        model.addAttribute("subOrders", subOrders);
        return "mobile/seller/SellerConfirmedOrders";
    }

    @RequestMapping(value = "/seller/sellerorders/branch/{branchId}/date/{deliveryDate}/deliveredstatus/{status}", method = RequestMethod.GET, consumes = {
            MediaType.ALL_VALUE })
    public String getSellerBranchSubOrdersByBranchDeliveryDateDeliveredStatus(final Model model,
            @PathVariable(value = "branchId") final String branchId, @PathVariable(value = "deliveryDate") final String date,
            @PathVariable(value = "status") final String status) {

        List<SubOrder> subOrders = subOrderService.getSubOrderByBranchStatusDate(branchId, date, status);

        model.addAttribute("subOrders", subOrders);
        return "mobile/seller/SellerDeliveredOrders";
    }

    @RequestMapping(value = "/seller/sellerorders/branch/{branchId}/date/{deliveryDate}/placedstatus/{status}", method = RequestMethod.GET, consumes = {
            MediaType.ALL_VALUE })
    public String getSellerBranchSubOrdersByBranchDeliveryDatePlacedStatus(final Model model,
            @PathVariable(value = "branchId") final String branchId, @PathVariable(value = "deliveryDate") final String date,
            @PathVariable(value = "status") final String status) {

        List<SubOrder> subOrders = subOrderService.getSubOrderByBranchStatusDate(branchId, date, status);

        model.addAttribute("subOrders", subOrders);
        return "mobile/seller/SellerPlacedOrders";
    }

    @RequestMapping(value = "/seller/sellerorders/branch/{branchId}/date/{deliveryDate}/shippedstatus/{status}", method = RequestMethod.GET, consumes = {
            MediaType.ALL_VALUE })
    public String getSellerBranchSubOrdersByBranchDeliveryDateShippedStatus(final Model model,
            @PathVariable(value = "branchId") final String branchId, @PathVariable(value = "deliveryDate") final String date,
            @PathVariable(value = "status") final String status) {

        List<SubOrder> subOrders = subOrderService.getSubOrderByBranchStatusDate(branchId, date, status);

        model.addAttribute("subOrders", subOrders);
        return "mobile/seller/SellerShippedOrders";
    }

    @RequestMapping(value = "/seller/sellerorders/branch/{branchId}/date/{deliveryDate}/status/{status}", method = RequestMethod.GET, consumes = {
            MediaType.ALL_VALUE })
    public String getSellerBranchSubOrdersByBranchDeliveryDateStatus() {
        return "mobile/seller/SellerSubOrders";
    }

    @RequestMapping(value = "/seller/sellerBranch/{branchId}/sellerDashboard", method = RequestMethod.GET)
    public String getSellerDashboardDate(final Model model, @PathVariable(value = "branchId") final String branchId) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(date);
        String currentDateDeliverableConfirmedSubOrdersCount = subOrderService.getSubOrdersCountByBranchStatusDate(branchId, "CONFIRMED",
                date1);
        String currentDateDeliverablePlacedSubOrdersCount = subOrderService.getSubOrdersCountByBranchStatusDate(branchId, "PLACED", date1);

        String allPlacedSubOrdersCount = subOrderService.getSubOrdersCountByBranchStatusDate(branchId, "PLACED", "ALL");
        String allConfirmedSubOrdersCount = subOrderService.getSubOrdersCountByBranchStatusDate(branchId, "CONFIRMED", "ALL");

        String minsBeforeUnConfirmedPlacedOrdersCount = subOrderService.getSubOrdersCountBranchByMinsBeforeStatus(branchId, "PlACED");//still not working as INTERVAL not working in JPA

        String unBilledDeliveredSubOrdersAmount = subOrderService.getSubOrderUnBilledAmountByBranchBilledStatus(branchId, "DELIVERED",
                "UNBILLED");
        String unBilledPlacedOrConfirmedOrShippedSubOrdersAmount = subOrderService.getSubOrderUnBilledAmountByBranchBilledStatus(branchId,
                "PLACEDORSHIPPEDORCONFIRMED", "UNBILLED");
        String lastBilledSellerInvoiceAmount = sellerInvoiceService.getLastSellerInvoiceAmountByBranch(branchId);
        String activeSellerItems = sellerItemService.getSellerItemsCountBySellerBranchStatus(branchId, "ACTIVE");
        String inActiveSellerItems = sellerItemService.getSellerItemsCountBySellerBranchStatus(branchId, "INACTIVE");

        model.addAttribute("currentDateDeliverableConfirmedSubOrdersCount", currentDateDeliverableConfirmedSubOrdersCount);
        model.addAttribute("currentDateDeliverablePlacedSubOrdersCount", currentDateDeliverablePlacedSubOrdersCount);
        model.addAttribute("allPlacedSubOrdersCount", allPlacedSubOrdersCount);
        model.addAttribute("allConfirmedSubOrdersCount", allConfirmedSubOrdersCount);
        model.addAttribute("unBilledDeliveredSubOrdersAmount", unBilledDeliveredSubOrdersAmount);
        model.addAttribute("unBilledPlacedOrConfirmedOrShippedSubOrdersAmount", unBilledPlacedOrConfirmedOrShippedSubOrdersAmount);
        model.addAttribute("minsBeforeUnConfirmedPlacedOrdersCount", minsBeforeUnConfirmedPlacedOrdersCount);
        model.addAttribute("activeSellerItems", activeSellerItems);
        model.addAttribute("inActiveSellerItems", inActiveSellerItems);
        model.addAttribute("lastBilledSellerInvoiceAmount", lastBilledSellerInvoiceAmount);
        Map<String, String> last30DaysAllSubOrdersPayment = subOrderService
                .getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(branchId, 30, "DAY", "ALL");
        model.addAttribute("lastBilledSellerInvoiceAmount", lastBilledSellerInvoiceAmount);
        String last30DaysSubOrdersCount = "0";
        String last30DaysSubOrdersAmount = "0.0";
        for (Entry<String, String> entry : last30DaysAllSubOrdersPayment.entrySet()) {
            last30DaysSubOrdersCount = entry.getKey();
            last30DaysSubOrdersAmount = entry.getValue();

        }
        model.addAttribute("last30DaysSubOrdersCount", last30DaysSubOrdersCount);
        model.addAttribute("last30DaysSubOrdersAmount", last30DaysSubOrdersAmount);
        /*  String last7DaysSubOrdersCount = "0";
        String last7DaysSubOrdersAmount = "0.0";
        String last30DaysSubOrdersCount = "0";
        String last30DaysSubOrdersAmount = "0.0";
        for (Entry<String, String> entry : last7DaysSubOrdersCountAmount.entrySet()) {
            last7DaysSubOrdersCount = entry.getKey();
            last7DaysSubOrdersAmount = entry.getValue();
        
        }
        for (Entry<String, String> entry : last30DaysSubOrdersCountAmount.entrySet()) {
            last30DaysSubOrdersCount = entry.getKey();
            last30DaysSubOrdersAmount = entry.getValue();
        
        }
        model.addAttribute("last7DaysSubOrdersCount", last7DaysSubOrdersCount);
        model.addAttribute("last30DaysSubOrdersCount", last30DaysSubOrdersCount);
        model.addAttribute("last7DaysSubOrdersAmount", last7DaysSubOrdersAmount);
        model.addAttribute("last30DaysSubOrdersAmount", last30DaysSubOrdersAmount);
        */
        return "/mobile/seller/SellerDashboard";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/selleritemslistpage/{sellerBranchId}", consumes = { MediaType.ALL_VALUE })
    public String getSellerItemsListPage(@PathVariable("sellerBranchId") final String sellerBranchId, final Model model) {
        List<SellerItem> sellerItems = sellerItemService.getSellerBranchItemOnly(sellerBranchId);

        model.addAttribute("sellerItems", sellerItems);
        return "mobile/seller/SellerItemsList";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/selleritemspage", consumes = { MediaType.ALL_VALUE })
    public String getSellerItemsPage() {
        return "mobile/seller/SellerItems";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/sellerpayments/{branchId}", consumes = { MediaType.ALL_VALUE })
    public String getSellerPaymentsPage(@PathVariable(value = "branchId") final String branchId, final Model model) {

        /*    Map<String, String> last7DaysCODSubOrdersPayment = subOrderService
                .getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(branchId, 7, "DAY", "COD");
        Map<String, String> last7DaysPaymentGatewaySubOrdersPayment = subOrderService
                .getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(branchId, 7, "DAY", "PAYMENTGATEWAY");
        Map<String, String> last30DaysCODSubOrdersPayment = subOrderService
                .getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(branchId, 30, "DAY", "COD");
        Map<String, String> last30DaysPaymentGatewaySubOrdersPayment = subOrderService
                .getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(branchId, 30, "DAY", "PAYMENTGATEWAY");*/
        Map<String, String> unBilledDeliveredCODSubOrders = subOrderService.getSubOrdersByStatusBillingPaymentMode(branchId, "DELIVERED",
                "UNBILLED", "COD");
        Map<String, String> unBilledDeliveredPaymentGatewaySubOrders = subOrderService.getSubOrdersByStatusBillingPaymentMode(branchId,
                "DELIVERED", "UNBILLED", "PAYMENTGATEWAY");

        /*        String last7DaysCODSubOrdersCount = "0";
        String last7DaysCODSubOrdersAmount = "0.0";
        String last7DaysPaymentGatewaySubOrdersCount = "0";
        String last7DaysPaymentGatewaySubOrdersAmount = "0.0";
        String last30DaysCODSubOrdersCount = "0";
        String last30DaysCODSubOrdersAmount = "0.0";
        String last30DaysPaymentGatewaySubOrdersCount = "0";
        String last30DaysPaymentGatewaySubOrdersAmount = "0.0";*/
        String unBilledDeliveredCODSubOrdersCount = "0";
        String unBilledDeliveredCODSubOrdersAmount = "0.0";
        String unBilledDeliveredPaymentGatewaySubOrdersCount = "0";
        String unBilledDeliveredPaymentGatewaySubOrdersAmount = "0.0";
        for (Entry<String, String> entry : unBilledDeliveredCODSubOrders.entrySet()) {
            unBilledDeliveredCODSubOrdersCount = entry.getKey();
            unBilledDeliveredCODSubOrdersAmount = entry.getValue();

        }
        for (Entry<String, String> entry : unBilledDeliveredPaymentGatewaySubOrders.entrySet()) {
            unBilledDeliveredPaymentGatewaySubOrdersCount = entry.getKey();
            unBilledDeliveredPaymentGatewaySubOrdersAmount = entry.getValue();

        }

        model.addAttribute("unBilledDeliveredCODSubOrdersCount", unBilledDeliveredCODSubOrdersCount);
        model.addAttribute("unBilledDeliveredCODSubOrdersAmount", unBilledDeliveredCODSubOrdersAmount);
        model.addAttribute("unBilledDeliveredPaymentGatewaySubOrdersCount", unBilledDeliveredPaymentGatewaySubOrdersCount);
        model.addAttribute("unBilledDeliveredPaymentGatewaySubOrdersAmount", unBilledDeliveredPaymentGatewaySubOrdersAmount);

        return "mobile/seller/SellerPayments";

    }

    /* sankar edited for mobile cart page start */
    /* @RequestMapping(value = "/cart/user/{userId}", method = RequestMethod.GET)
    public String getMobileCartPage(final Item item, final BindingResult result, final ModelMap model,
            @PathVariable(value = "userId") final String userId

             * , @RequestParam(defaultValue="N/A",value = "userId") final String userId
             ) {
        String s = userId;
        if (s != null) {
            Orders orders = orderService.getSingleCartItems(s);
            model.addAttribute("order", orders);

            User u = userService.findByUser(s);
            if (u.getCompanyBranch() != null) {
                Address a = addressService.getAddressByUserCompanyDeliveryAddress(u.getCompanyBranch().getId());

                model.addAttribute("deliveryAddress", a);
                model.addAttribute("extensionNo", u.getExtensionNo());
                model.addAttribute("deskNo", u.getDeskNo());
            }

        }
        model.addAttribute("messageType", "Failure");
        return "mobile/CartDetailsFragment";
    }*/

    @RequestMapping(value = "/seller/subOrder/{subOrderId}", method = RequestMethod.GET)
    public String getSingleSubOrderInformation(@PathVariable(value = "subOrderId") final String subOrderId, final Model model,
            final HttpSession session) {

        SubOrder subOrder = subOrderService.getSubOrder(subOrderId);
        model.addAttribute("subOrder", subOrder);

        return "mobile/seller/SellerSingleSubOrder";
    }

    @RequestMapping(value = "/tags/category/{categoryId}", method = RequestMethod.GET)
    public String getTagListByCategory(final Item item, final BindingResult result, final Model model, final HttpServletRequest req,
            @PathVariable(value = "categoryId") final String categoryId) {
        String zoneId = getCookieZoneId(req);
        List<Tags> tags = tagsService.getThymeleafCategoryTags(categoryId);
        model.addAttribute("tagList", tags);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/s/terms-and-conditions", consumes = { MediaType.ALL_VALUE })
    public String getTermsAndConditionsPage() {
        return "TermsAndConditionsPage";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/failure/transaction", consumes = { MediaType.ALL_VALUE })
    public String getTransactionFailurePage() {

        return "FailureTransactionPage";

    }

    @RequestMapping(value = "/useraddress/address", method = RequestMethod.GET)
    public String getUserAddresses(final Model model, final HttpSession httpSession, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (!userDetails.getUserName().equals("anonymousUser")) {
            Users user1 = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // String name = user1.getUserName(); // get logged in username
            String id = user1.getId();
            List<Address> addresses = addressService.getAllAddressByUser(id);
            model.addAttribute("userAddress", addresses);
            return "fragments/CheckOutMainFragment::UserAddressFragment";
        }
        else {
            httpSession.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            // return "LoginOrRegistrationPage";
            model.addAttribute("messageType", "Failure");
            return "redirect:" + url + "/login";
        }

    }

    @RequestMapping(value = "/myaccount/orders", method = RequestMethod.GET)
    public String getUserOrders(final Model model, final HttpSession session, final HttpServletRequest req) {
        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (userDetails.getId() != null) {
            String userId = userDetails.getId();
            //  String status = "CARTADDED";
            /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            if (!userDetails.getUserName().equals("anonymousUser")) {*/
            Users user1 = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user1.getUserName(); // get logged in username
            String id = user1.getId();
            List<Orders> orders = ordersService.getOrdersByThymeleafUser(userId);
            model.addAttribute("orders", orders);
            Users user = userService.findByUser(id);
            model.addAttribute("user", user);
            /* List<PreOrderCartItems> preOrderCartItems = preOrderCartItemsService.getCartItemsOnly(userId, status);
            model.addAttribute("preOrderCartItems", preOrderCartItems);*/
            return "MyAccount";
        }
        else {
            session.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");

            return "redirect:" + url + "/login";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/zonecity", consumes = { MediaType.ALL_VALUE })
    public String getZoneCityWithZonesByThymeleaf(final Model model, final HttpSession session) {

        List<ZoneCity> zoneCities = zoneCityService.getZoneCityWithZoneByThymeleaf();

        model.addAttribute("zoneCities", zoneCities);

        return "ZoneCity";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/payment", consumes = { MediaType.ALL_VALUE })
    // @ResponseBody
    public String Payment(final Orders orders, final BindingResult result, final Model model, @RequestParam("o") final String orderId) {

        /*
         * System.out.println("order status"+orderModel.getId()+orderModel.getStatus
         * ());
         * order.setStatus(orderModel.getStatus());
         * //orderItemService.create(order); orderService.save(order);
         *
         * model.addAttribute("orderId", order.getId());
         * model.addAttribute("amount", order.getAmount());
         *
         * if(order.getStatus().equals("OrderPlaced")){
         * model.addAttribute("status", "Success"); }else{
         * model.addAttribute("status", "Failure"); }
         */
        Orders order = orderService.getOrders(orderId);
        model.addAttribute("order", order);
        model.addAttribute("status", "Success");

        return "TransactionStatusPage";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {

        model.addAttribute("title", "Hello world!");
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome2(final ModelMap model, final HttpServletRequest req, final HttpServletResponse res,
            final HttpSession session) {

        String zoneId = getCookieZoneId(req);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if (!(authentication instanceof AnonymousAuthenticationToken)) {
        //  String s = (String) session.getAttribute("userId");
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (!authentication.getName().equals("anonymousUser")) {
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                if (userDetails != null) {
                    model.addAttribute("user", userDetails);
                }
                /*List<ZoneCity> zoneCities = zoneCityService.getAll();
                model.addAttribute("zoneCities", zoneCities);*/
                List<ZoneCity> zoneCities1 = zoneCityService.getZoneCityWithZoneByThymeleaf();
                model.addAttribute("zoneCities", zoneCities1);
                //String message = "User Successfully Logged IN!";
                /*    model.addAttribute("message", message);
                model.addAttribute("messageType", "Success");
                String status = "CartAdded";*/
                /*  List<PreOrderCartItems> preOrderCartItems = preOrderCartItemsService.getCartItemsOnly(s, status);
                  model.addAttribute("preOrderCartItems", preOrderCartItems);*/
                return "index";
            }
            else {
                return "index";
            }
        }
        else {
            /*   session.invalidate();
            String message = "User Successfully Logged out!";
            // session.invalidate();
            
            >>>>>>> refs/remotes/origin/master
            model.addAttribute("message", message);
            model.addAttribute("messageType", "Failure");*/

            return "index";
        }

    }

    @RequestMapping(value = "/Restaurants/Dashboard/index.html#/dashboards/orders")
    public String restaurantDashboard(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final HttpSession session, final BindingResult result, final ModelMap model) throws IOException {
        // String message = "";//"Restaurant Login Page!";
        // session.invalidate();
        // model.addAttribute("message", message);
        /*   Users u = userService.findByUser("USR9");*/

        String s = (String) session.getAttribute("userId");
        if (s != null) {
            return "/../../Restaurants/Dashboard/index";
        }
        return "../../Restaurants/login";
    }

    @RequestMapping(value = "/restaurant/auth", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
    public String restaurantLoginUser(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final Item item, final BindingResult result, final ModelMap model) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = request.getParameter(authentication.getName());
        session.setAttribute("username", username);
        // session.setAttribute("password", password);
        String username1 = null;
        String userId = null;
        if (!authentication.getName().equals("anonymousUser")) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof Users) {
                username1 = ((Users) principal).getUserName();
                userId = ((Users) principal).getId();
            }
            else {
                username1 = principal.toString();
            }

            Users u = userService.getUsers(userId);
            session.setAttribute("userName", username1);
            session.setAttribute("userId", userId);
            // setting session to expiry in 30 mins

            model.addAttribute("user", u);

            model.addAttribute("auth", authentication);
            model.addAttribute("session1", session);
            model.addAttribute("message", "Restaurant User SuccessFully LoggedIN!");

            // http://192.168.0.137:8085/Restaurants/Dashboard/index.html#/dashboards/orders
            // return "/restaurant/index";
            return "../../Restaurants/Dashboard/index";
        }
        else {
            session.invalidate();
            model.addAttribute("message", "Session Expired! Please Login");
            return "../../Restaurants/login";
        }
    }

    @RequestMapping(value = "/restaurant/index", method = RequestMethod.GET)
    public String restaurantPage(final ModelMap model) {
        model.addAttribute("title", "Hello world!");
        return "restaurant/index";
    }

    @RequestMapping(value = "/restaurants/login")
    public String restaurantsLogin(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final HttpSession session, final BindingResult result, final ModelMap model) throws IOException {
        String message = "HI";// "Restaurant Login Page!";
        // session.invalidate();
        /*
         * User u=userService.findByUser("USR9"); model.addAttribute("message",
         * u);
         */
        model.addAttribute("message", message);
        return "../../Restaurants/Dashboard/index";
        // return "../../Restaurants/Dashboard/index";
    }

    @InitBinder
    public void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
