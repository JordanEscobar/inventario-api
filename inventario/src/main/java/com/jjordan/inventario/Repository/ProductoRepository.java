package com.jjordan.inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjordan.inventario.Entities.ProductoEntities;

public interface ProductoRepository extends JpaRepository<ProductoEntities,Long>{

}
