package com.antoniofrische.bestgamevendorapp.models;




import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class ProductosEntity {
    private int idProductos;

    private String nombre;

    private int edadMinima;

    private String photoProducto;

    private String descripcion;

    private LocalDate fechaSalida;

    private Double precioSalida;

    private PublisherEntity publisher;

    private GenreEntity genre;

    private RegionEntity region;

    private Set<ListaFavoritosEntity> listaFav;

    private Set<PlataformasEntity> platformList;

    public int getIdProductos() {
        return idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getPhotoProducto() {
        return photoProducto;
    }

    public void setPhotoProducto(String photoProducto) {
        this.photoProducto = photoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(Double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity fkGenre) {
        this.genre = fkGenre;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity fkRegion) {
        this.region = fkRegion;
    }

    public Set<ListaFavoritosEntity> getListaFav() {
        return listaFav;
    }

    public void setListaFav(Set<ListaFavoritosEntity> listaFav) {
        this.listaFav = listaFav;
    }

    public Set<PlataformasEntity> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(Set<PlataformasEntity> platformList) {
        this.platformList = platformList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosEntity that = (ProductosEntity) o;
        return idProductos == that.idProductos && edadMinima == that.edadMinima && publisher == that.publisher && genre == that.genre && region == that.region && Objects.equals(nombre, that.nombre) && Objects.equals(photoProducto, that.photoProducto) && Objects.equals(descripcion, that.descripcion) && Objects.equals(fechaSalida, that.fechaSalida) && Objects.equals(precioSalida, that.precioSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductos, nombre, edadMinima, photoProducto, descripcion, fechaSalida, precioSalida, publisher, genre, region);
    }

    @Override
    public String toString() {
        return "ProductosEntity{" +
                "idProductos=" + idProductos +
                ", nombre='" + nombre + '\'' +
                ", edadMinima=" + edadMinima +
                ", photoProducto='" + photoProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", precioSalida=" + precioSalida +
                ", publisher=" + publisher +
                ", genre=" + genre +
                ", region=" + region +
                ", listaFav=" + listaFav +
                ", platformList=" + platformList +
                '}';
    }
}
