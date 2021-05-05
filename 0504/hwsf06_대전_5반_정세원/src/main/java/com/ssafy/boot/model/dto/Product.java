package com.ssafy.boot.model.dto;

public class Product {
	private String code;
	private String name;
	private Integer quantity;

	public Product() {
	}

	public Product(String name, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product(String code, String name, Integer quantity) {
		this(name, quantity);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", quantity=" + quantity + "]";
	}

}
