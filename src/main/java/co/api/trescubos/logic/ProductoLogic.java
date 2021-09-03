/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.api.trescubos.logic;

import co.api.trescubos.entities.ProductoEntity;
import co.api.trescubos.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de Producto
 * @author Cindy H.
 */
@Stateless
public class ProductoLogic {
    
    /**
     * Inyeccion del persistence de Producto
     */
    @Inject
    private ProductoPersistence persistence;
    
    /**
     * Obtener todos los objetos Producto
     * @return 
     */
    public List<ProductoEntity> obtenerProductos(){
        List<ProductoEntity> productos = persistence.findAll();
        return productos;
    }
    
    /**
     * Obtener producto por su id
     * @param id
     * @return productoEntity
     */
    public ProductoEntity obtenerProducto(Long id){
        ProductoEntity producto = persistence.find(id);
        if(producto == null){
            throw new IllegalArgumentException("El producto solicitado NO existe");
        }
        return producto;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un Producto
     * @param productoCrear
     * @return 
     */
    public ProductoEntity crearProducto(ProductoEntity productoCrear){
        persistence.create(productoCrear);
        return productoCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Producto
     * @param id
     * @param productoAcualizar
     * @return producto actualizado
     */
    public ProductoEntity actualizarProducto (Long id, ProductoEntity productoAcualizar){
        ProductoEntity productoUpdate = persistence.update(productoAcualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto Producto
     * @param id 
     */
    public void eliminarProducto(Long id){
        persistence.remove(id);
    }
}
