package com.antoniofrische.bestgamevendorapp.models;


import java.util.Objects;


public class ProductImageEntity {
    private int id;
    private String name;
    private String imgURL;

    public ProductImageEntity( String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    public ProductImageEntity() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImageEntity that = (ProductImageEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductImageEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
