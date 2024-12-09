package org.carolina.orden;


import org.carolina.descuento.Descuento;
import org.carolina.descuento.SinDescuento;

import java.util.ArrayList;
import java.util.List;

public class Orden{
    private final List<Producto> productos = new ArrayList<>();
    private Descuento estrategiaDescuento;

    public Orden() {
        this.estrategiaDescuento = new SinDescuento(); // si no se asigna no hay descuento
    }

    public void setEstrategiaDescuento(Descuento estrategiaDescuento) throws Exception {
        if (estrategiaDescuento == null)
            throw new Exception("la estrategia no puede ser nula");
        this.estrategiaDescuento = estrategiaDescuento;
    }


    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotalSinDescuento() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public double calcularTotalConDescuento() throws Exception {
        return estrategiaDescuento.aplicarDescuento(calcularTotalSinDescuento());
    }
    public int getNumeroDeProductos() {
        return productos.size();
    }
}
