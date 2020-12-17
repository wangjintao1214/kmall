package com.kgc.kmall.bean;

import java.io.Serializable;

public class PmsProductSaleAttr implements Serializable{
    private Long id;

    private Long productId;

    private Long saleAttrId;

    private String saleAttrName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    @Override
    public String toString() {
        return "PmsProductSaleAttr{" +
                "id=" + id +
                ", productId=" + productId +
                ", saleAttrId=" + saleAttrId +
                ", saleAttrName='" + saleAttrName + '\'' +
                '}';
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName == null ? null : saleAttrName.trim();

    }
}