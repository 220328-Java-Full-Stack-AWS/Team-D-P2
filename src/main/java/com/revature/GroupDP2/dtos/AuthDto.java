package com.revature.GroupDP2.dtos;

public class AuthDto {
    private Integer productId;
    private String productName;

    public AuthDto() {
    }

    public AuthDto(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
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
}

