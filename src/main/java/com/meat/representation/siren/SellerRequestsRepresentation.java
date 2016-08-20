/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerRequestsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerRequestsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerRequest", uri = "/sellerRequest/{id}")
@Representation(SellerRequestsModel.class)
public class SellerRequestsRepresentation extends BaseResource {
    private String id;
    private String requestName;
    private String requestType;
    private String requestStatus;
    private String description;
    private String requestDate;
    private String userCreated;
    private String dateCreated;
    private String userModified;
    private String dateModified;
    private String sellerBranchId;

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getRequestName() {
        return requestName;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public String getUserModified() {
        return userModified;
    }

    public void setDateCreated(final String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateModified(final String dateModified) {
        this.dateModified = dateModified;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setRequestDate(final String requestDate) {
        this.requestDate = requestDate;
    }

    public void setRequestName(final String requestName) {
        this.requestName = requestName;
    }

    public void setRequestStatus(final String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setRequestType(final String requestType) {
        this.requestType = requestType;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setUserCreated(final String userCreated) {
        this.userCreated = userCreated;
    }

    public void setUserModified(final String userModified) {
        this.userModified = userModified;
    }

}
