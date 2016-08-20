/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBranchModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author venu
 *
 */
@Component("sellerBranchRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranch", uri = "/sellerBranches/{id}")
@Representation(SellerBranchModel.class)
public class SellerBranchRepresentation extends BaseResource {
    private String id;
    private String sellerId;
    private String branchName;
    private String sellerEmailId;
    private String sellerPhoneNo;
    private String landlineNo;
    private String branchStatus;
    private String minimumOrderTime;
    private String minimumOrderAmount;
    private String minimunOrderDeliveryAmount;
    private String minimumPickupTime;
    private String deliveryCutoffDays;
    private String deliveryCharges;
    @Siren4JSubEntity
    private List<SellerBranchAddressRepresentation> sellerBranchAddressRep = new ArrayList<SellerBranchAddressRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchZoneRepresentation> sellerBranchZoneRep = new ArrayList<SellerBranchZoneRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchImagesRepresentation> sellerBranchImagesRep = new ArrayList<SellerBranchImagesRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchTimingsRepresentation> sellerBranchTimingsRep = new ArrayList<SellerBranchTimingsRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemRepresentation> sellerItemRep = new ArrayList<SellerItemRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchTaxRepresentation> sellerBranchTaxRep = new ArrayList<SellerBranchTaxRepresentation>(0);
    @Siren4JSubEntity
    private List<SubOrderRepresentation> subOrderRep = new ArrayList<SubOrderRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferConfigRepresentation> offerConfigRep = new ArrayList<OfferConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferExcludeConfigRepresentation> offerExcludeConfigRep = new ArrayList<OfferExcludeConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerUserRepresentation> sellerUserRep = new ArrayList<SellerUserRepresentation>(0);
    @Siren4JSubEntity
    private List<AccountRepresentation> accountRep = new ArrayList<AccountRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBankAccountRepresentation> sellerBankAccountRep = new ArrayList<SellerBankAccountRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchChargesRepresentation> sellerBranchChargesRep = new ArrayList<SellerBranchChargesRepresentation>(0);

    public List<AccountRepresentation> getAccountRep() {
        return accountRep;
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

    public String getId() {
        return id;
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

    public List<OfferConfigRepresentation> getOfferConfigRep() {
        return offerConfigRep;
    }

    public List<OfferExcludeConfigRepresentation> getOfferExcludeConfigRep() {
        return offerExcludeConfigRep;
    }

    public List<SellerBankAccountRepresentation> getSellerBankAccountRep() {
        return sellerBankAccountRep;
    }

    public List<SellerBranchAddressRepresentation> getSellerBranchAddressRep() {
        return sellerBranchAddressRep;
    }

    public List<SellerBranchChargesRepresentation> getSellerBranchChargesRep() {
        return sellerBranchChargesRep;
    }

    public List<SellerBranchImagesRepresentation> getSellerBranchImagesRep() {
        return sellerBranchImagesRep;
    }

    public List<SellerBranchTaxRepresentation> getSellerBranchTaxRep() {
        return sellerBranchTaxRep;
    }

    public List<SellerBranchTimingsRepresentation> getSellerBranchTimingsRep() {
        return sellerBranchTimingsRep;
    }

    public List<SellerBranchZoneRepresentation> getSellerBranchZoneRep() {
        return sellerBranchZoneRep;
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public List<SellerItemRepresentation> getSellerItemRep() {
        return sellerItemRep;
    }

    public String getSellerPhoneNo() {
        return sellerPhoneNo;
    }

    public List<SellerUserRepresentation> getSellerUserRep() {
        return sellerUserRep;
    }

    public List<SubOrderRepresentation> getSubOrderRep() {
        return subOrderRep;
    }

    public void setAccountRep(final List<AccountRepresentation> accountRep) {
        this.accountRep = accountRep;
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

    public void setId(final String id) {
        this.id = id;
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

    public void setOfferConfigRep(final List<OfferConfigRepresentation> offerConfigRep) {
        this.offerConfigRep = offerConfigRep;
    }

    public void setOfferExcludeConfigRep(final List<OfferExcludeConfigRepresentation> offerExcludeConfigRep) {
        this.offerExcludeConfigRep = offerExcludeConfigRep;
    }

    public void setSellerBankAccountRep(final List<SellerBankAccountRepresentation> sellerBankAccountRep) {
        this.sellerBankAccountRep = sellerBankAccountRep;
    }

    public void setSellerBranchAddressRep(final List<SellerBranchAddressRepresentation> sellerBranchAddressRep) {
        this.sellerBranchAddressRep = sellerBranchAddressRep;
    }

    public void setSellerBranchChargesRep(final List<SellerBranchChargesRepresentation> sellerBranchChargesRep) {
        this.sellerBranchChargesRep = sellerBranchChargesRep;
    }

    public void setSellerBranchImagesRep(final List<SellerBranchImagesRepresentation> sellerBranchImagesRep) {
        this.sellerBranchImagesRep = sellerBranchImagesRep;
    }

    public void setSellerBranchTaxRep(final List<SellerBranchTaxRepresentation> sellerBranchTaxRep) {
        this.sellerBranchTaxRep = sellerBranchTaxRep;
    }

    public void setSellerBranchTimingsRep(final List<SellerBranchTimingsRepresentation> sellerBranchTimingsRep) {
        this.sellerBranchTimingsRep = sellerBranchTimingsRep;
    }

    public void setSellerBranchZoneRep(final List<SellerBranchZoneRepresentation> sellerBranchZoneRep) {
        this.sellerBranchZoneRep = sellerBranchZoneRep;
    }

    public void setSellerEmailId(final String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerItemRep(final List<SellerItemRepresentation> sellerItemRep) {
        this.sellerItemRep = sellerItemRep;
    }

    public void setSellerPhoneNo(final String sellerPhoneNo) {
        this.sellerPhoneNo = sellerPhoneNo;
    }

    public void setSellerUserRep(final List<SellerUserRepresentation> sellerUserRep) {
        this.sellerUserRep = sellerUserRep;
    }

    public void setSubOrderRep(final List<SubOrderRepresentation> subOrderRep) {
        this.subOrderRep = subOrderRep;
    }

}
