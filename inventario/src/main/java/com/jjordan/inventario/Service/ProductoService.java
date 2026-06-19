package com.jjordan.inventario.Service;

import java.util.List;
import java.util.Optional;

import com.jjordan.inventario.Entities.ProductoEntities;

public interface ProductoService {
    List<ProductoEntities> getAllProductos();
    Optional<ProductoEntities> getProductoById(Long id);
    ProductoEntities saveProducto(ProductoEntities producto);
    void deleteProducto(Long id);
    ProductoEntities updateProducto(Long id, ProductoEntities producto);



}
