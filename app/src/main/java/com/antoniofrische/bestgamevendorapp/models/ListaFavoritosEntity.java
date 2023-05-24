package com.antoniofrische.bestgamevendorapp.models;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class ListaFavoritosEntity {

    private int idFavoritos;

    private String nombre;

    private UserEntity user;

    private Set<ProductosEntity> productlist;

    public ListaFavoritosEntity() {
    }

    public ListaFavoritosEntity(int idFavoritos, String nombre, UserEntity user, Set<ProductosEntity> productlist) {
        this.idFavoritos = idFavoritos;
        this.nombre = nombre;
        this.user = user;
        this.productlist = productlist;
    }

    public int getIdFavoritos() {
        return idFavoritos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity fkUser) {
        this.user = fkUser;
    }

    public Set <ProductosEntity> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<ProductosEntity> producto) {
        this.productlist = new HashSet<>(producto);
    }

    public void addProductToList(ProductosEntity producto){
        this.productlist.add(producto);
    }

    public void deleteProduct(ProductosEntity producto){
        this.productlist.remove(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaFavoritosEntity that = (ListaFavoritosEntity) o;
        return idFavoritos == that.idFavoritos && user == that.user && productlist == that.productlist && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavoritos, nombre, user, productlist);
    }

    @Override
    public String toString() {
        return "ListaFavoritosEntity{" +
                "idFavoritos=" + idFavoritos +
                ", nombre='" + nombre + '\'' +
                ", user=" + user +
                ", productlist=" + productlist +
                '}';
    }
}
