package com.example.moviebooking.entity.userInfo;

import com.example.moviebooking.config.validator.ValidEmail;
import com.example.moviebooking.config.validator.ValidPhoneNumber;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_tbl",
uniqueConstraints = {@UniqueConstraint(columnNames ="username", name = "unique_username"),
                     //@UniqueConstraint(columnNames ="email", name = "unique_email"),
                    @UniqueConstraint(columnNames ="phone_number", name = "unique_phone_number")})


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username must not be null")
    @Size(min = 8, message = "the username length must be greater than 8 character")
    @Column(nullable = false)
    private String username;

    @NotEmpty(message = "Password must not be null")
    @Size(min = 8, message = "the password length must be greater than 8 character")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Email must not be null")
    @ValidEmail
    @Column(nullable = false)
    private String email;

    //@NotEmpty(message = "Phone number must not be null")
    @ValidPhoneNumber
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;


    private boolean enabled;

    @Column(updatable = false)
    private Date createAt;


    private Date updateAt;

    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Set<Authority> authoritySet;

    @ApiModelProperty(hidden = true)
    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    private VerificationToken verificationToken;

    @ApiModelProperty(hidden = true)
    @OneToOne(mappedBy = "user")
    private Cart cart;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
        this.verificationToken = verificationToken;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
