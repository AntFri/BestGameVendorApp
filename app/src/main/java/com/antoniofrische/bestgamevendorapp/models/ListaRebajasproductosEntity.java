package com.antoniofrische.bestgamevendorapp.models;



import java.time.LocalDate;
import java.util.Objects;


public class ListaRebajasproductosEntity {

    private int idListaRebajas;
    private LocalDate fechaCambio;
    private Double precioRebajas;

    private int percentageRebajas;

    private CellingWebsiteEntity cellingwebsite;

    private ProductosEntity productos;

    public ListaRebajasproductosEntity() {
    }

    public ListaRebajasproductosEntity(int idListaRebajas, LocalDate fechaCambio, Double precioRebajas, int percentageRebajas, CellingWebsiteEntity cellingwebsite, ProductosEntity productos) {
        this.idListaRebajas = idListaRebajas;
        this.fechaCambio = fechaCambio;
        this.precioRebajas = precioRebajas;
        this.percentageRebajas = percentageRebajas;
        this.cellingwebsite = cellingwebsite;
        this.productos = productos;
    }

    public int getIdListaRebajas() {
        return idListaRebajas;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Double getPrecioRebajas() {
        return precioRebajas;
    }

    public void setPrecioRebajas(Double precioRebajas) {
        this.precioRebajas = precioRebajas;
    }

    public int getPercentageRebajas() {
        return percentageRebajas;
    }

    public void setPercentageRebajas(int percentageRebajas) {
        this.percentageRebajas = percentageRebajas;
    }

    public CellingWebsiteEntity getCellingwebsite() {
        return cellingwebsite;
    }

    public void setCellingwebsite(CellingWebsiteEntity fkWebsite) {
        this.cellingwebsite = fkWebsite;
    }

    public ProductosEntity getProductos() {
        return productos;
    }

    public void setProductos(ProductosEntity fkProduct) {
        this.productos = fkProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaRebajasproductosEntity that = (ListaRebajasproductosEntity) o;
        return idListaRebajas == that.idListaRebajas && cellingwebsite == that.cellingwebsite && productos == that.productos && Objects.equals(fechaCambio, that.fechaCambio) && Objects.equals(precioRebajas, that.precioRebajas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idListaRebajas, fechaCambio, precioRebajas, cellingwebsite, productos);
    }

    @Override
    public String toString() {
        return "ListaRebajasproductosEntity{" +
                "idListaRebajas=" + idListaRebajas +
                ", fechaCambio=" + fechaCambio +
                ", precioRebajas=" + precioRebajas +
                ", percentageRebajas=" + percentageRebajas +
                ", cellingwebsite=" + cellingwebsite +
                ", productos=" + productos +
                '}';
    }
}
