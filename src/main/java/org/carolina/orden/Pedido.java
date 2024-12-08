package org.carolina.orden;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

}
