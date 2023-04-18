package com.antoniofrische.bestgamevendorapp.models;


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class UserEntity implements Serializable {

    private int idUsuario;

    private String nombre;

    private String apellido;

    private String email;

    private Date fechaNacimiento;

    private String password;

    private String role;

    private boolean accountActive;

    private RegionEntity region;

    public int getIdUsuario() {
        return idUsuario;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity fkRegion) {
        this.region = fkRegion;
    }

    public boolean getAccountActive() {
        return accountActive;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUsuario == that.idUsuario && region == that.region && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, apellido, email, fechaNacimiento, password, region);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", accountActive=" + accountActive +
                ", region=" + region +
                '}';
    }
}
