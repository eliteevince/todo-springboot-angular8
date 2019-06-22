/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.proxy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

/**
 *
 * @author PDP_Shiva
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductProxy implements Serializable {

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the uom
     */
    public String getUom() {
        return uom;
    }

    /**
     * @param uom the uom to set
     */
    public void setUom(String uom) {
        this.uom = uom;
    }

    /**
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    private Long id;
    private String productName;
    private Double price;
    private String uom;
    private Double quantity;
    private Double cartQuantity;
    private Boolean isActive;

    public ProductProxy() {
    }

    
    public ProductProxy(Long id, String productName, Double quantity, Double price, String uom,Boolean isActive) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.uom = uom;
        this.quantity = quantity;
        this.isActive = isActive;
    }

    /**
     * @return the cartQuantity
     */
    public Double getCartQuantity() {
        return cartQuantity;
    }

    /**
     * @param cartQuantity the cartQuantity to set
     */
    public void setCartQuantity(Double cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    
    
}
