package com.cr.coffee.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="restaurant")
public class RestaurantModel {

    @Id
    @Column(name="restaurant_id")
    private long id;
    private String address;
    private String city;
    private String name;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="zip_code")
    private int zipCode;
    @Column(name="search_text")
    private String searchText;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private List<RestCoffeeModel> restCoffeeModels;

    public RestaurantModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<RestCoffeeModel> getRestCoffeeModels() {
        return restCoffeeModels;
    }

    public void setRestCoffeeModels(List<RestCoffeeModel> restCoffeeModels) {
        this.restCoffeeModels = restCoffeeModels;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
