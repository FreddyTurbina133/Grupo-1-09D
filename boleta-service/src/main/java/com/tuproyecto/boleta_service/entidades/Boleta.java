package com.tuproyecto.boleta_service.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // O el nombre que realmente tiene la columna en tu tabla
    private Integer boletaId;


    private LocalDateTime fechaPedido;
    private int idPedido;
    private int usuarioId;
    private String nombreUsuario;
    private int idProducto;
    private String nombreProducto;
    private String marcaProducto;
    private int precioProducto;

    // --- Getters y Setters ---

    public Integer getBoletaId() {
        return boletaId;
    }

    public void setBoletaId(Integer boletaId) {
        this.boletaId = boletaId;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "boletaId=" + boletaId +
                ", fechaPedido=" + fechaPedido +
                ", idPedido=" + idPedido +
                ", usuarioId=" + usuarioId +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", marcaProducto='" + marcaProducto + '\'' +
                ", precioProducto=" + precioProducto +
                '}';
    }
}
