package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component("pieceTypeContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PieceTypeContext implements IBusinessDelegateContext{
	
	private String all;
	private String id;
	private String pieceTypeId;
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPieceTypeId() {
		return pieceTypeId;
	}
	public void setPieceTypeId(String pieceTypeId) {
		this.pieceTypeId = pieceTypeId;
	}
	

}
