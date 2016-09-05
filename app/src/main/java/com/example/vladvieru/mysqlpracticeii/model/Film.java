package com.example.vladvieru.mysqlpracticeii.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vladvieru on 7/20/16.
 */
public class Film implements Serializable {
    @Expose
    private String category;
    @Expose
    private double price;
    @Expose
    private String shortinfo;
    @Expose
    private String instructions;
    @Expose
    private String photo;
    @Expose
    private String name;
    @Expose
    private int productId;
    @Expose
    private String link;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    /*public String getShortinfo() {
        return shortinfo;
    }

    public void setShortinfo(String shortinfo) {
        this.shortinfo = shortinfo;
    }*/

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
