package org.carolina.orden;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {
    @Test
    void testCrearProducto(){
        Producto producto = new Producto("Laptop", 35000.0);
        assertEquals("Laptop", producto.getNombre());
        assertEquals(35000.0, producto.getPrecio());
    }
    @Test
    void testModificarProducto(){
        Producto producto = new Producto("Laptop", 35000.0);

        producto.setNombre("tablet");
        producto.setPrecio(25000.0);

        assertEquals("tablet", producto.getNombre());
        assertEquals(25000.0, producto.getPrecio());
    }


}
