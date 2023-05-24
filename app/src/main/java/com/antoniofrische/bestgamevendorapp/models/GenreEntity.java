package com.antoniofrische.bestgamevendorapp.models;



import java.util.Objects;


public class GenreEntity {

    private int idGenre;

    private String nombre;

    private String descripcion;

    public GenreEntity() {
    }

    public GenreEntity(int idGenre, String nombre, String descripcion) {
        this.idGenre = idGenre;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdGenre() {
        return idGenre;
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

    public void setDescripcion(String description) {
        this.descripcion = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return idGenre == that.idGenre && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "idGenre=" + idGenre +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
