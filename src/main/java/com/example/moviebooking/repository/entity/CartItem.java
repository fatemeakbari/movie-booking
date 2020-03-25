package com.example.moviebooking.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item_tbl")
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name ="media_showing_id")
    private MediaShowingPlace mediaShowing;

    @ManyToOne
    @JoinColumn(name ="cart_id")
    @JsonIgnore
    private Cart cart;

    private int quantity;

    private double totalPrice;

    public  CartItem(){}

    public CartItem(MediaShowingPlace mediaShowing) {
        this.mediaShowing = mediaShowing;
        this.quantity = 1;
        this.totalPrice = mediaShowing.getPrice();
    }

    public CartItem(MediaShowingPlace mediaShowing, int quantity, double totalPrice) {
        this.mediaShowing = mediaShowing;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long cartItemId) {
        this.id = cartItemId;
    }

    public MediaShowingPlace getMediaShowing() {
        return mediaShowing;
    }

    public void setMediaShowing(MediaShowingPlace mediaShowing) {
        this.mediaShowing = mediaShowing;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
