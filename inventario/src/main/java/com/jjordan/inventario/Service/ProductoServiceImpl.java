package com.jjordan.inventario.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<ProductoEntities> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntities saveProducto(ProductoEntities producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoEntities updateProducto(Long id, ProductoEntities producto) {
        Optional<ProductoEntities> existeProducto = productoRepository.findById(id);
        if(existeProducto.isPresent()){
            ProductoEntities pEditado = existeProducto.get();
            pEditado.setCantidad(producto.getCantidad());
            pEditado.setNombre(producto.getNombre());
            pEditado.setPrecio(producto.getPrecio());
            pEditado.setEstado(producto.isEstado());
            return productoRepository.save(pEditado);
        }
        return null;
    }

    @Override
    public List<ProductoEntities> findByNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

}
