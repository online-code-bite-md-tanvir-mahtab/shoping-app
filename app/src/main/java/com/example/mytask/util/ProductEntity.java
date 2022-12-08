package com.example.mytask.util;

import com.google.gson.annotations.SerializedName;

public class ProductEntity {

    @SerializedName("id")
    private Integer pId;

    @SerializedName("price")
    private String pPrice;

    @SerializedName("title")
    private String pTitle;

    @SerializedName("category")
    private String pCategory;

    @SerializedName("image")
    private String pTumbnail;


    public ProductEntity(Integer pId, String pPrice, String pTitle, String pCategory, String pTumbnail) {
        this.pId = pId;
        this.pPrice = pPrice;
        this.pTitle = pTitle;
        this.pCategory = pCategory;
        this.pTumbnail = pTumbnail;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getpTumbnail() {
        return pTumbnail;
    }

    public void setpTumbnail(String pTumbnail) {
        this.pTumbnail = pTumbnail;
    }
}
