package com.example.mobitech.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String address;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<PurchasedProduct> purchasedProducts;

    @ManyToMany
    private List<SelectedProduct> selectedProducts;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Order> orders;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public User setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
        return this;
    }

    public List<SelectedProduct> getSelectedProducts() {
        return selectedProducts;
    }

    public User setSelectedProducts(List<SelectedProduct> selectedProducts) {
        this.selectedProducts = selectedProducts;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public User setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public SelectedProduct findSelectedProductByImg(String img) {
        return this.selectedProducts.stream()
                .filter(p -> p.getImg().equals(img))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Order findOrderById(Long orderId) {
        return this.orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst().orElseThrow(NoSuchElementException::new);

    }

    public void addProductToPurchasedProductList(PurchasedProduct purchasedProduct) {
        if (this.purchasedProducts.contains(purchasedProduct)) {
            PurchasedProduct products = findPurchasedProductByImg(purchasedProduct.getImg());
            products.setQuantity(purchasedProduct.getQuantity() + purchasedProduct.getQuantity());
        } else {
            this.purchasedProducts.add(purchasedProduct);
        }
    }

    private PurchasedProduct findPurchasedProductByImg(String img) {
        return this.purchasedProducts.stream()
                .filter(p -> p.getImg().equals(img))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public void removeProductFromSelectedList(Long productId) {
        this.selectedProducts.removeIf(product -> product.getId().equals(productId));
    }
}
