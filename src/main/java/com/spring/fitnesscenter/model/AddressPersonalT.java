package com.spring.fitnesscenter.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AddressPersonalT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nation;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String postalCode;

    @Column
    private String homeNumber;

    @OneToMany
    private List<PersonalTrainer> personalTrainers;

    public AddressPersonalT() {
    }

    public AddressPersonalT(String nation, String region, String city, String province, String postalCode, String homeNumber,
            List<PersonalTrainer> personalTrainers) {
        this.nation = nation;
        this.region = region;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.homeNumber = homeNumber;
        this.personalTrainers = personalTrainers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public List<PersonalTrainer> getPersonalTrainers() {
        return personalTrainers;
    }

    public void setPersonalTrainers(List<PersonalTrainer> personalTrainers) {
        this.personalTrainers = personalTrainers;
    }

    
}
