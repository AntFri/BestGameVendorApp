package com.antoniofrische.bestgamevendorapp.models;



import java.io.Serializable;
import java.util.Objects;


public class RegionEntity implements Serializable {

    private int idRegion;

    private String nombre;

    private String descripcion;

    public int getIdRegion() {
        return idRegion;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desciption) {
        this.descripcion = desciption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionEntity that = (RegionEntity) o;
        return idRegion == that.idRegion && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "RegionEntity{" +
                "idRegion=" + idRegion +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
