package com.xworkz.toy.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToyEntity {


	//createdBy,createdDate,updatedBy,updateOn
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int toyId;
	
	private String toyName;
	
	private String toyType;
	
	private int price;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String updatedBy;
	
	private LocalDateTime updateOn;

	public ToyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToyEntity(int toyId, String toyName, String toyType, int price, String createdBy, LocalDateTime createdDate,
			String updatedBy, LocalDateTime updateOn) {
		super();
		this.toyId = toyId;
		this.toyName = toyName;
		this.toyType = toyType;
		this.price = price;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updateOn = updateOn;
	}

	public int getToyId() {
		return toyId;
	}

	public void setToyId(int toyId) {
		this.toyId = toyId;
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
		return "ToyEntity [toyId=" + toyId + ", toyName=" + toyName + ", toyType=" + toyType + ", price=" + price
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updateOn=" + updateOn + "]";
	}

	

}
