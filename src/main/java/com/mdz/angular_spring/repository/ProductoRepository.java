package com.mdz.angular_spring.repository;

import com.mdz.angular_spring.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Con esto tenemos disponible todos los métodos para hacer operaciones CRUD con la entidad Producto
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
