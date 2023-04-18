package com.antoniofrische.bestgamevendorapp.models;



import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class PlataformasEntity {

    private int idPlataformas;

    private String nombre;

    private LocalDate fechaSalida;

    private String descripcion;

    private Set<ProductosEntity> prodlist;

    public void setIdPlataformas(int idPlataformas) {
        this.idPlataformas = idPlataformas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<ProductosEntity> getProdlist() {
        return prodlist;
    }

    public void setProdlist(Set<ProductosEntity> prodlist) {
        this.prodlist = prodlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlataformasEntity that = (PlataformasEntity) o;
        return idPlataformas == that.idPlataformas && Objects.equals(nombre, that.nombre) && Objects.equals(fechaSalida, that.fechaSalida) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlataformas, nombre, fechaSalida, descripcion);
    }

    @Override
    public String toString() {
        return "PlataformasEntity{" +
                "idPlataformas=" + idPlataformas +
                ", nombre='" + nombre + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", descripcion='" + descripcion + '\'' +
                ", prodlist=" + prodlist +
                '}';
    }
}
