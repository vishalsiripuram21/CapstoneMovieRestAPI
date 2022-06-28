package com.restservice.DTO;

public class ProductDTO {
	
	private Integer productId;
	private String productName;
	private Integer productQty;
	public ProductDTO() {
		
	}
	public ProductDTO(Integer productId, String productName, Integer productQty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQty() {
		return productQty;
	}
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}
	

}
