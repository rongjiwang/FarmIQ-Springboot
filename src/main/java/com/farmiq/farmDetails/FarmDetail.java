package com.farmiq.farmDetails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import sun.jvm.hotspot.runtime.Bytes;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class FarmDetail {
    @Id
    @GeneratedValue
    private Long id;
    private double unitsHa;
    private double calciumValue;
    private double calciumPerHa;
    private double sulfurValue;
    private double sulfurPerHa;
    private double NitrogenValue;
    private double NitrogenPerHa;
    private double phosphorusValue;
    private double phosphorusPerHa;
    private double potassiumValue;
    private double potassiumPerHa;
    private String name;
    private double area;
    private Long regionId;
    @Column(length = 25555)
    //@Type(type="org.hibernate.spatial.GeometryType")
    //@JsonDeserialize(using=GeometryDeserializer.class)
    //@Type(type = "org.hibernate.spatial.GeometryUserType")
    private String geometry;

    public FarmDetail() {
    }

    public FarmDetail(double unitsHa, double calciumValue, double calciumPerHa, double sulfurValue, double sulfurPerHa, double nitrogenValue, double nitrogenPerHa, double phosphorusValue, double phosphorusPerHa, double potassiumValue, double potassiumPerHa, String name, double area, Long regionId, String geometry) {
        this.unitsHa = unitsHa;
        this.calciumValue = calciumValue;
        this.calciumPerHa = calciumPerHa;
        this.sulfurValue = sulfurValue;
        this.sulfurPerHa = sulfurPerHa;
        NitrogenValue = nitrogenValue;
        NitrogenPerHa = nitrogenPerHa;
        this.phosphorusValue = phosphorusValue;
        this.phosphorusPerHa = phosphorusPerHa;
        this.potassiumValue = potassiumValue;
        this.potassiumPerHa = potassiumPerHa;
        this.name = name;
        this.area = area;
        this.regionId = regionId;
        this.geometry = geometry;
    }

    /*
    * ALL GETTER AND SETTER BELOW
    * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getUnitsHa() {
        return unitsHa;
    }

    public void setUnitsHa(double unitsHa) {
        this.unitsHa = unitsHa;
    }

    public double getCalciumValue() {
        return calciumValue;
    }

    public void setCalciumValue(double calciumValue) {
        this.calciumValue = calciumValue;
    }

    public double getCalciumPerHa() {
        return calciumPerHa;
    }

    public void setCalciumPerHa(double calciumPerHa) {
        this.calciumPerHa = calciumPerHa;
    }

    public double getSulfurValue() {
        return sulfurValue;
    }

    public void setSulfurValue(double sulfurValue) {
        this.sulfurValue = sulfurValue;
    }

    public double getSulfurPerHa() {
        return sulfurPerHa;
    }

    public void setSulfurPerHa(double sulfurPerHa) {
        this.sulfurPerHa = sulfurPerHa;
    }

    public double getNitrogenValue() {
        return NitrogenValue;
    }

    public void setNitrogenValue(double nitrogenValue) {
        NitrogenValue = nitrogenValue;
    }

    public double getNitrogenPerHa() {
        return NitrogenPerHa;
    }

    public void setNitrogenPerHa(double nitrogenPerHa) {
        NitrogenPerHa = nitrogenPerHa;
    }

    public double getPhosphorusValue() {
        return phosphorusValue;
    }

    public void setPhosphorusValue(double phosphorusValue) {
        this.phosphorusValue = phosphorusValue;
    }

    public double getPhosphorusPerHa() {
        return phosphorusPerHa;
    }

    public void setPhosphorusPerHa(double phosphorusPerHa) {
        this.phosphorusPerHa = phosphorusPerHa;
    }

    public double getPotassiumValue() {
        return potassiumValue;
    }

    public void setPotassiumValue(double potassiumValue) {
        this.potassiumValue = potassiumValue;
    }

    public double getPotassiumPerHa() {
        return potassiumPerHa;
    }

    public void setPotassiumPerHa(double potassiumPerHa) {
        this.potassiumPerHa = potassiumPerHa;
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

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}
