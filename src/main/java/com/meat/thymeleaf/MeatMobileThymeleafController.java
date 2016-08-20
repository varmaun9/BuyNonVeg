package com.meat.thymeleaf;

import com.meat.domain.Item;
import com.meat.domain.PreOrderCartItems;
import com.meat.domain.SubCategory;
import com.meat.security.CustomUserDetails;
import com.meat.service.IItemService;
import com.meat.service.IPreOrderCartItemsService;
import com.meat.service.ISellerBranchTaxService;
import com.meat.service.ISubCategoryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@ImportResource("classpath:spring-thymeleaf.xml")
@Controller
@RequestMapping
@PropertySource("classpath:application.properties")
public class MeatMobileThymeleafController {

    @Autowired
    ISubCategoryService subCategoryService;
    @Value("${url}")
    private String url;

    String supplier = "ROLE_RESTAURANT";
    String restaurant = "ROLE_RESTAURANT";

    @Autowired
    private IItemService itemsService;
    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;

    @RequestMapping(value = "/mobile/items/category/{categoryId}", method = RequestMethod.GET)
    public String getItemsByCategoryMobile(@PathVariable(value = "categoryId") final String categoryId, final Model model) {
        List<SubCategory> subCategories = subCategoryService.getItemSubCategoriesByThymeleafCategory(categoryId);
        model.addAttribute("subCategories", subCategories);

        List<Item> items = itemsService.getItemByCategoryId(categoryId);

        for (SubCategory subC : subCategories) {
            System.out.println(subC.getSubCategoryImageses());
        }
        model.addAttribute("items", items);

        return "/mobile/home/MobileItemsList";
    }

    @RequestMapping(value = "/mobile/item/subCategory/{subCategoryId}", method = RequestMethod.GET)
    public String getItemsBySubCategoryMobile(@PathVariable(value = "subCategoryId") final String subCategoryId,
            @RequestParam(value = "med", defaultValue = "mobile") final String media, final Model model) {
        int itemsCount = 0;
        if (media.equals("mobile")) {
            itemsCount = 1;
        }

        List<Item> items = itemsService.getItemBySubCategoryId(subCategoryId);
        model.addAttribute("items", items);
        return "mobile/home/MobileItemsList";

    }

    @RequestMapping(value = "/mobile/cart", method = RequestMethod.GET)
    public String getMyCart(final Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String status = "CARTADDED";
        String userId = userDetails.getId();
        List<PreOrderCartItems> cartItems = preOrderCartItemsService.getPreOrderCartItemsByUserAndStatus(userId, status);
        List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();
        BigDecimal totalCartPrice = new BigDecimal(0.0);
        for (PreOrderCartItems poc : cartItems) {
            PreOrderCartItems poci = new PreOrderCartItems();
            Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(poc.getSellerItem().getId(), "PERCENT");
            poc.setItemTax(itemTotalTax);
            poci = poc;
            BigDecimal itemTotalPrice = (poc.getCartPrice().multiply(new BigDecimal(itemTotalTax))).divide(new BigDecimal(100.00));
            totalCartPrice = totalCartPrice.add(poc.getCartPrice().add(itemTotalPrice));

            preOrderCartItems.add(poci);

        }
        model.addAttribute("preOrderCartItems", preOrderCartItems);
        model.addAttribute("cartTotalPrice", totalCartPrice);
        return "";
    }

    @RequestMapping(value = "/mobile/singleItem/{itemId}", method = RequestMethod.GET)
    public String getSingleItem(@PathVariable(value = "itemId") final String itemId, final Model model) {
        Item item = itemsService.getItem(itemId);
        model.addAttribute("item", item);

        return "mobile/home/MobileSingleItem";
    }

    @RequestMapping(value = "/mobile/subCategory/category/{categoryId}", method = RequestMethod.GET)
    public String getSubCategoryByCategoryMobile(@PathVariable(value = "categoryId") final String categoryId, final Model model) {
        List<SubCategory> subCategories = subCategoryService.getSubCategoryByCategory(categoryId);
        model.addAttribute("subCategories", subCategories);
        return "mobile/home/MobileSubCategoryList";
    }

}
