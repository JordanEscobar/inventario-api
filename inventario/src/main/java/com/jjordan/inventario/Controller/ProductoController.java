package com.jjordan.inventario.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjordan.inventario.Entities.ProductoEntities;
import com.jjordan.inventario.Service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductoEntities>> getAllProductos() {
        return ResponseEntity.ok( productoService.getAllProductos());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        
        Optional<ProductoEntities> producto = productoService.getProductoById(id);
        if(producto.isPresent()){
            return ResponseEntity.ok(producto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado"); 
    }

    @PostMapping("/save")
    public ResponseEntity<ProductoEntities> saveProducto(@RequestBody ProductoEntities producto){
        ProductoEntities savedProducto = productoService.saveProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductoEntities> deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProductoEntities> updateProducto(@PathVariable Long id,@RequestBody ProductoEntities producto){
        ProductoEntities pUpdated = productoService.updateProducto(id, producto);
        if(pUpdated != null)
        {
            return ResponseEntity.ok(pUpdated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }




    


}
