package com.xworkz.toy.dto;

import java.time.LocalDateTime;

public class ToyDto {
	
private String toyName;
	
	private String toyType;
	
	private int price;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String updatedBy;
	
	private LocalDateTime updateOn;

	public ToyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToyDto(String toyName, String toyType, int price, String createdBy, LocalDateTime createdDate,
			String updatedBy, LocalDateTime updateOn) {
		super();
		this.toyName = toyName;
		this.toyType = toyType;
		this.price = price;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updateOn = updateOn;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public String getToyType() {
		return toyType;
	}

	public void setToyType(String toyType) {
		this.toyType = toyType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(LocalDateTime updateOn) {
		this.updateOn = updateOn;
	}

	@Override
	public String toString() {
		return "ToyDto [toyName=" + toyName + ", toyType=" + toyType + ", price=" + price + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updateOn=" + updateOn + "]";
	}
	
	

}
