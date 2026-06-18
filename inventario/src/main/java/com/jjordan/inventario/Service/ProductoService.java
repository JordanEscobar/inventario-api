package com.jjordan.inventario.Service;

import java.util.List;

import com.jjordan.inventario.Entities.ProductoEntities;

public interface ProductoService {
    List<ProductoEntities> getAllProductos();
    ProductoEntities getProductoById(Long id);



}
