/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.api.trescubos.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase encargada de crear la entidad producto
 *
 * @author Cindy H.
 */
@Entity(name = "Producto")
public class ProductoEntity implements Serializable {

    /**
     * Llave primaria de la entidad producto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducto;

    /**
     * Columna que hace referencia al nombre del producto
     */
    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    /**
     * Columna que hace referencia al precio unitario del producto
     */
    @Column
    private double precioUnitario;

    /**
     * Columna que hace referencia a la marca del producto
     */
    @Column
    private String marcaProducto;

    /**
     * Columna que hace referencia la cantidad de productos que quedan en
     * inventario
     */
    @Column
    private int stock;

    /**
     * Constructor
     */
    public ProductoEntity() {
    }

    /* ----- METODOS SET Y GET ----- */
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
