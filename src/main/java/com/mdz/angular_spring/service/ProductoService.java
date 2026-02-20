package com.mdz.angular_spring.service;

import com.mdz.angular_spring.model.Producto;
import com.mdz.angular_spring.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        return this.productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public boolean eliminarProductoPorId(Integer idProducto) {
        if (this.productoRepository.existsById(idProducto)) {
            this.productoRepository.deleteById(idProducto);
            return true;
        }
        return false;
    }
}
