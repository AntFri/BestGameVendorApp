package com.antoniofrische.bestgamevendorapp.models;




import java.util.Objects;
import java.util.Set;


public class ProductosEntity {
    private int idProductos;

    private String nombre;

    private int edadMinima;

    private ProductImageEntity productimage;

    private String descripcion;

    private String fechaSalida;

    private Double precioSalida;

    private PublisherEntity publisher;

    private GenreEntity genre;

    private RegionEntity region;

    private Set<PlataformasEntity> platformList;

    public ProductosEntity() {
    }

    public ProductosEntity(int idProductos, String nombre, int edadMinima, ProductImageEntity productimage, String descripcion, String fechaSalida, Double precioSalida, PublisherEntity publisher, GenreEntity genre, RegionEntity region, Set<PlataformasEntity> platformList) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.productimage = productimage;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.precioSalida = precioSalida;
        this.publisher = publisher;
        this.genre = genre;
        this.region = region;

        this.platformList = platformList;
    }

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

    public ProductImageEntity getProductimage() {
        return productimage;
    }

    public void setProductimage(ProductImageEntity productimage) {
        this.productimage = productimage;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
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
        return idProductos == that.idProductos && edadMinima == that.edadMinima && publisher == that.publisher && genre == that.genre && region == that.region && Objects.equals(nombre, that.nombre) && Objects.equals(productimage, that.productimage) && Objects.equals(descripcion, that.descripcion) && Objects.equals(fechaSalida, that.fechaSalida) && Objects.equals(precioSalida, that.precioSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductos, nombre, edadMinima, productimage, descripcion, fechaSalida, precioSalida, publisher, genre, region);
    }

    @Override
    public String toString() {
        return "ProductosEntity{" +
                "idProductos=" + idProductos +
                ", nombre='" + nombre + '\'' +
                ", edadMinima=" + edadMinima +
                ", photoProducto='" + productimage.getImgURL() + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", precioSalida=" + precioSalida +
                ", publisher=" + publisher +
                ", genre=" + genre +
                ", region=" + region +
                ", platformList=" + platformList +
                '}';
    }
}
