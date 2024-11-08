package com._Project.Tbay.User;

import jakarta.persistence.*;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;

    @Column(nullable=false)
    public String name;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String email;

//    @Column(nullable=true)
//    protected Listing[] wishlist;

    @Column(nullable=false)
    protected String role;

    @Column(nullable=false)
    protected boolean status;

    @Column(nullable=true)
    protected int cartId;

    public User(int userId, String name, String password, String email, String role) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setWishlist(Listing[] wishlist) {
//        this.wishlist = wishlist;
//    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

//    public Listing[] getWishlist() {
//        return wishlist;
//    }

    public String getRole() {
        return role;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCartId() {
        return cartId;
    }
}


