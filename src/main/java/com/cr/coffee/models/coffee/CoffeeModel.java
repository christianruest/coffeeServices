package com.cr.coffee.models.coffee;

import com.cr.coffee.models.coffee.enums.CoffeeType;
import com.cr.coffee.models.coffee.enums.RoastingGrade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="coffee")
public class CoffeeModel {

    @Id
    @Column(name="coffee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;

    private String name;

    private String region;

    @Column(name="origin_country_cd")
    private String originatingCountry;

    @Column(name = "roasted_in_country")
    private String roastedInCountry;

    @Column(name = "grade_of_roast")
    @Enumerated(EnumType.STRING)
    private RoastingGrade gradeOfRoast;

    @Min(0)
    @Max(100)
    private Integer composition;

    @ElementCollection
    @Column(name = "coffee_type", nullable = false)
    @CollectionTable(name = "coffee_type", joinColumns = {@JoinColumn(name = "coffee_id")})
    @Enumerated(EnumType.STRING)
    private Set<CoffeeType> coffeeTypes;

    private String description;

    // Getters and Setters
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRoastedInCountry() {
        return roastedInCountry;
    }

    public void setRoastedInCountry(String roastedInCountry) {
        this.roastedInCountry = roastedInCountry;
    }

    public RoastingGrade getGradeOfRoast() {
        return gradeOfRoast;
    }

    public void setGradeOfRoast(RoastingGrade gradeOfRoast) {
        this.gradeOfRoast = gradeOfRoast;
    }

    public Integer getComposition() {
        return composition;
    }

    public void setComposition(Integer composition) {
        this.composition = composition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CoffeeType> getCoffeeTypes() {
        return coffeeTypes;
    }

    public void setCoffeeTypes(Set<CoffeeType> coffeeTypes) {
        this.coffeeTypes = coffeeTypes;
    }


}
