package com.antoniofrische.bestgamevendorapp.models;




import java.time.LocalDate;
import java.util.Objects;

public class PublisherEntity {

    private int idPublisher;

    private String nombre;

    private LocalDate fechaInauguracion;

    private String descripcion;

    private RegionEntity origenContry;

    public int getIdPublisher() {
        return idPublisher;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(LocalDate fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RegionEntity getOrigenContry() {
        return origenContry;
    }

    public void setOrigenContry(RegionEntity origenContry) {
        this.origenContry = origenContry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherEntity that = (PublisherEntity) o;
        return idPublisher == that.idPublisher && Objects.equals(nombre, that.nombre) && Objects.equals(fechaInauguracion, that.fechaInauguracion) && Objects.equals(descripcion, that.descripcion) && Objects.equals(origenContry, that.origenContry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublisher, nombre, fechaInauguracion, descripcion, origenContry);
    }

    @Override
    public String toString() {
        return "PublisherEntity{" +
                "idPublisher=" + idPublisher +
                ", nombre='" + nombre + '\'' +
                ", fechaInauguracion=" + fechaInauguracion +
                ", descripcion='" + descripcion + '\'' +
                ", origenContry=" + origenContry +
                '}';
    }
}
