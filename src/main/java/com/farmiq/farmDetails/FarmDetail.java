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
    private String name;
    private double area;
    private Long regionId;
    @Column(length = 25555)
    //@Type(type="org.hibernate.spatial.GeometryType")
    //@JsonDeserialize(using=GeometryDeserializer.class)
    //@Type(type = "org.hibernate.spatial.GeometryUserType")
    private String geometry;

    public FarmDetail(){}

    public FarmDetail(Long id, String name, double area, Long regionId, String geometry) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.regionId = regionId;
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
