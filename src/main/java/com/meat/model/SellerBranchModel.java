/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */

@Component("sellerBranchModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchModel extends AbstractModel {

    private String sellerId;
    private String branchName;
    private String sellerEmailId;
    private String sellerPhoneNo;
    private String landlineNo;
    private String branchStatus;
    private String minimumOrderTime;
    private String minimumPickupTime;
    private String minimumOrderAmount;
    private String minimunOrderDeliveryAmount;
    private String deliveryCharges;
    private String deliveryCutoffDays;
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);
    // private List<AddressModel> addressesModels = new ArrayList<AddressModel>(0);
    private List<SellerBranchAddressModel> sellerBranchAddressModels = new ArrayList<SellerBranchAddressModel>(0);
    private List<SellerBranchZoneModel> sellerBranchZoneModels = new ArrayList<SellerBranchZoneModel>(0);
    private List<SellerBranchImagesModel> sellerBranchImagesModels = new ArrayList<SellerBranchImagesModel>(0);
    private List<SellerBranchTimingsModel> sellerBranchTimingsModels = new ArrayList<SellerBranchTimingsModel>(0);
    private List<SellerItemModel> sellerItemModels = new ArrayList<SellerItemModel>(0);
    private List<SellerUserModel> sellerUserModel = new ArrayList<SellerUserModel>(0);
    private List<SellerBranchTaxModel> sellerBranchTaxModels = new ArrayList<SellerBranchTaxModel>(0);
    private List<SubOrderModel> subOrderModels = new ArrayList<SubOrderModel>(0);
    private List<AccountModel> accountModels = new ArrayList<AccountModel>(0);
    private List<SellerBankAccountModel> sellerBankAccountModels = new ArrayList<SellerBankAccountModel>(0);
    private List<SellerBranchChargesModel> sellerBranchChargesModels = new ArrayList<SellerBranchChargesModel>(0);

    public List<AccountModel> getAccountModels() {
        return accountModels;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchStatus() {
        return branchStatus;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public String getDeliveryCutoffDays() {
        return deliveryCutoffDays;
    }

    public String getLandlineNo() {
        return landlineNo;
    }

    public String getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    public String getMinimumOrderTime() {
        return minimumOrderTime;
    }

    public String getMinimumPickupTime() {
        return minimumPickupTime;
    }

    public String getMinimunOrderDeliveryAmount() {
        return minimunOrderDeliveryAmount;
    }

    public List<OfferConfigModel> getOfferConfigModels() {
        return offerConfigModels;
    }

    public List<OfferExcludeConfigModel> getOfferExcludeConfigModels() {
        return offerExcludeConfigModels;
    }

    public List<SellerBankAccountModel> getSellerBankAccountModels() {
        return sellerBankAccountModels;
    }

    public List<SellerBranchAddressModel> getSellerBranchAddressModels() {
        return sellerBranchAddressModels;
    }

    public List<SellerBranchChargesModel> getSellerBranchChargesModels() {
        return sellerBranchChargesModels;
    }

    public List<SellerBranchImagesModel> getSellerBranchImagesModels() {
        return sellerBranchImagesModels;
    }

    public List<SellerBranchTaxModel> getSellerBranchTaxModels() {
        return sellerBranchTaxModels;
    }

    public List<SellerBranchTimingsModel> getSellerBranchTimingsModels() {
        return sellerBranchTimingsModels;
    }

    public List<SellerBranchZoneModel> getSellerBranchZoneModels() {
        return sellerBranchZoneModels;
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public List<SellerItemModel> getSellerItemModels() {
        return sellerItemModels;
    }

    public String getSellerPhoneNo() {
        return sellerPhoneNo;
    }

    public List<SellerUserModel> getSellerUserModel() {
        return sellerUserModel;
    }

    public List<SubOrderModel> getSubOrderModels() {
        return subOrderModels;
    }

    public void setAccountModels(final List<AccountModel> accountModels) {
        this.accountModels = accountModels;
    }

    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    public void setBranchStatus(final String branchStatus) {
        this.branchStatus = branchStatus;
    }

    public void setDeliveryCharges(final String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public void setDeliveryCutoffDays(final String deliveryCutoffDays) {
        this.deliveryCutoffDays = deliveryCutoffDays;
    }

    public void setLandlineNo(final String landlineNo) {
        this.landlineNo = landlineNo;
    }

    public void setMinimumOrderAmount(final String minimumOrderAmount) {
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public void setMinimumOrderTime(final String minimumOrderTime) {
        this.minimumOrderTime = minimumOrderTime;
    }

    public void setMinimumPickupTime(final String minimumPickupTime) {
        this.minimumPickupTime = minimumPickupTime;
    }

    public void setMinimunOrderDeliveryAmount(final String minimunOrderDeliveryAmount) {
        this.minimunOrderDeliveryAmount = minimunOrderDeliveryAmount;
    }

    public void setOfferConfigModels(final List<OfferConfigModel> offerConfigModels) {
        this.offerConfigModels = offerConfigModels;
    }

    public void setOfferExcludeConfigModels(final List<OfferExcludeConfigModel> offerExcludeConfigModels) {
        this.offerExcludeConfigModels = offerExcludeConfigModels;
    }

    public void setSellerBankAccountModels(final List<SellerBankAccountModel> sellerBankAccountModels) {
        this.sellerBankAccountModels = sellerBankAccountModels;
    }

    public void setSellerBranchAddressModels(final List<SellerBranchAddressModel> sellerBranchAddressModels) {
        this.sellerBranchAddressModels = sellerBranchAddressModels;
    }

    public void setSellerBranchChargesModels(final List<SellerBranchChargesModel> sellerBranchChargesModels) {
        this.sellerBranchChargesModels = sellerBranchChargesModels;
    }

    public void setSellerBranchImagesModels(final List<SellerBranchImagesModel> sellerBranchImagesModels) {
        this.sellerBranchImagesModels = sellerBranchImagesModels;
    }

    public void setSellerBranchTaxModels(final List<SellerBranchTaxModel> sellerBranchTaxModels) {
        this.sellerBranchTaxModels = sellerBranchTaxModels;
    }

    public void setSellerBranchTimingsModels(final List<SellerBranchTimingsModel> sellerBranchTimingsModels) {
        this.sellerBranchTimingsModels = sellerBranchTimingsModels;
    }

    public void setSellerBranchZoneModels(final List<SellerBranchZoneModel> sellerBranchZoneModels) {
        this.sellerBranchZoneModels = sellerBranchZoneModels;
    }

    public void setSellerEmailId(final String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerItemModels(final List<SellerItemModel> sellerItemModels) {
        this.sellerItemModels = sellerItemModels;
    }

    public void setSellerPhoneNo(final String sellerPhoneNo) {
        this.sellerPhoneNo = sellerPhoneNo;
    }

    public void setSellerUserModel(final List<SellerUserModel> sellerUserModel) {
        this.sellerUserModel = sellerUserModel;
    }

    public void setSubOrderModels(final List<SubOrderModel> subOrderModels) {
        this.subOrderModels = subOrderModels;
    }

}
