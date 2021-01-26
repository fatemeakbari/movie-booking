package com.example.moviebooking.entity.userInfo;

import com.example.moviebooking.entity.Performance;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "cart_item_tbl")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private int quantity;

    private double totalPrice;

    @ElementCollection
    private Set<Long> seatIdSet;

    @ManyToOne
    @JoinColumn(name ="media_showing_place_id",
            foreignKey = @ForeignKey(name = "fk_media_showing_place_id"))
    private Performance performance;

    @ManyToOne
    @JoinColumn(name ="cart_id", foreignKey = @ForeignKey(name = "fk_cart_id"), nullable = false)
    @JsonIgnore
    private Cart cart;


    public  CartItem(){}

    public CartItem(Performance performance) {
        this.performance = performance;
        this.quantity = 1;
        this.totalPrice = performance.getPrice();
    }

    public CartItem(Performance performance, int quantity, double totalPrice) {
        this.performance = performance;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long cartItemId) {
        this.id = cartItemId;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
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

    public Set<Long> getSeatIdSet() {
        return seatIdSet;
    }

    public void setSeatIdSet(Set<Long> seatIdSet) {
        this.seatIdSet = seatIdSet;
    }


}
