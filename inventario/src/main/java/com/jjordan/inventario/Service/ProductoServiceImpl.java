package com.jjordan.inventario.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjordan.inventario.Entities.ProductoEntities;
import com.jjordan.inventario.Repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoEntities> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntities getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

}
