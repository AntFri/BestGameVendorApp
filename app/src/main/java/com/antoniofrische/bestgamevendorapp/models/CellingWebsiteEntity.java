package com.antoniofrische.bestgamevendorapp.models;



import java.util.Objects;


public class CellingWebsiteEntity {

    private int idcellingWebsite;

    private String nombre;

    private String link;

    public CellingWebsiteEntity() {
    }

    public CellingWebsiteEntity(int idcellingWebsite, String nombre, String link) {
        this.idcellingWebsite = idcellingWebsite;
        this.nombre = nombre;
        this.link = link;
    }

    public int getIdcellingWebsite() {
        return idcellingWebsite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellingWebsiteEntity that = (CellingWebsiteEntity) o;
        return idcellingWebsite == that.idcellingWebsite && Objects.equals(nombre, that.nombre) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcellingWebsite, nombre, link);
    }

    @Override
    public String toString() {
        return "CellingWebsiteEntity{" +
                "idcellingWebsite=" + idcellingWebsite +
                ", nombre='" + nombre + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
