package com.example.moviebooking.entity.userInfo;

import com.example.moviebooking.entity.Performance;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart_tbl")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id_3"), nullable = false)
    private User user;

    @Min(value = 0, message = "Grand total must be greater than zero")
    private Double grandTotal;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;


    public Cart() {
        this.grandTotal = 0d;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void calculateGrandTotal(){
        this.grandTotal = 0d;
        for(CartItem cartItem: cartItemList){
            this.grandTotal += cartItem.getTotalPrice();
        }
    }
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public CartItem checkCartItemIsExitIfNotCreate(Performance performance, List<Long> seatIdList){
        for(int i=0;i<this.cartItemList.size();i++){
            CartItem cartItem = cartItemList.get(i);
            if(cartItem.getPerformance().getId().equals(performance.getId())){
                cartItem.getSeatIdSet().addAll(seatIdList);
                cartItem.setSeatIdSet(cartItem.getSeatIdSet());
                cartItem.setQuantity(cartItem.getSeatIdSet().size());
                this.cartItemList.set(i,cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(this);
        cartItem.setPerformance(performance);
        cartItem.setSeatIdSet((Set<Long>) seatIdList);
        cartItem.setQuantity(cartItem.getSeatIdSet().size());
        this.cartItemList.add(cartItem);
        return cartItem;
    }
}
