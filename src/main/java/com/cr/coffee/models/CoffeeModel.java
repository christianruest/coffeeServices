package com.cr.coffee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="coffee")
public class CoffeeModel {

    @Id
    @Column(name="coffee_id")
    private long id;
    private String brand;
    private String name;
    @Column(name="orgin_country_cd")
    private String originatingCountry;
    private String roastery;


    public CoffeeModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public String getRoastery() {
        return roastery;
    }

    public void setRoastery(String roastery) {
        this.roastery = roastery;
    }
}
