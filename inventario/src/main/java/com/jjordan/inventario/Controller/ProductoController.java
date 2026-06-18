package com.jjordan.inventario.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjordan.inventario.Service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public String getAllProductos() {
        return productoService.getAllProductos().toString();
    }

    @GetMapping("/find/{id}")
    public String getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id).toString();
    }

    


}
