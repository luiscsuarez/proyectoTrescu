/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.api.trescubos.persistence;

import co.api.trescubos.entities.ProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase manejadora de la transaccionalidad de la entidad Producto
 * @author Cindy H.
 */ 
@Stateless
public class ProductoPersistence {
    
    /**
     * Instancia del entity manager
     */
    @PersistenceContext(unitName = "TrescubosPU")
    private EntityManager entityManager;
    
    /**
     * Metodo que trae todos los datos que se encuentran en la tabla Producto
     * @return lista resultante
     */
    public List<ProductoEntity> findAll(){
        Query queryProducto = entityManager.createQuery("select p from Producto p");
        return queryProducto.getResultList();
    }
    
    /**
     * Metodo que busca un objeto Producto mediante su id
     * @param id
     * @return producto encontrado
     */
    public ProductoEntity find(Long id){
        return entityManager.find(ProductoEntity.class, id);
    }
    
    /**
     * Metodo para crear un objeto de la entidad Producto
     * @param productoNuevo
     * @return productoNuevo
     */
    public ProductoEntity create(ProductoEntity productoNuevo){
        entityManager.persist(productoNuevo);
        return productoNuevo;
    }
    
    /**
     * Metodo para actualizar un dato de la entidad producto
     * @param productoActualizar
     * @return producto actualizado
     */
    public ProductoEntity update(ProductoEntity productoActualizar){
        return entityManager.merge(productoActualizar);
    }
    
    /**
     * Metodo usado para eliminar un producto
     * @param id 
     */
    public void remove(Long id){
        ProductoEntity productoEliminar = entityManager.find(ProductoEntity.class, id);
        entityManager.remove(productoEliminar);
    }
}
