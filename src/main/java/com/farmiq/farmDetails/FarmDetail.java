package com.farmiq.farmDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FarmDetail {
@Id
@GeneratedValue

    private Long id;
    private String name;
    private double area;
    private Long regionId;
    private String emailAddress;
    private String farmKey;
    private String phoneNumber;
    private Long farmIqModuleId;
    private String farmClass;
    private String country;
    private String geometry;

    public FarmDetail(){}

    public FarmDetail(Long id, String name, double area, Long regionId, String emailAddress, String farmKey,
                      String phoneNumber, Long farmIqModuleId, String farmClass, String country, String geometry) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.regionId = regionId;
        this.emailAddress = emailAddress;
        this.farmKey = farmKey;
        this.phoneNumber = phoneNumber;
        this.farmIqModuleId = farmIqModuleId;
        this.farmClass = farmClass;
        this.country = country;
        this.geometry = geometry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFarmKey() {
        return farmKey;
    }

    public void setFarmKey(String farmKey) {
        this.farmKey = farmKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getFarmIqModuleId() {
        return farmIqModuleId;
    }

    public void setFarmIqModuleId(Long farmIqModuleId) {
        this.farmIqModuleId = farmIqModuleId;
    }

    public String getFarmClass() {
        return farmClass;
    }

    public void setFarmClass(String farmClass) {
        this.farmClass = farmClass;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
