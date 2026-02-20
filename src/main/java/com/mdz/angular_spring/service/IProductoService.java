package com.mdz.angular_spring.service;

import com.mdz.angular_spring.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();

    Producto buscarProductoPorId(Integer idProducto);

    Producto guardarProducto(Producto producto);

    boolean eliminarProductoPorId(Integer idProducto);
}
