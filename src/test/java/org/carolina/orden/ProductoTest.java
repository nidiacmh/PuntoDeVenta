package org.carolina.orden;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductoTest {
    @Test
    void testCrearProducto() throws Exception {
        Producto producto = new Producto("Laptop", 35000.0);
        assertEquals("Laptop", producto.getNombre());
        assertEquals(35000.0, producto.getPrecio());
    }
    @Test
    void testModificarProducto() throws Exception {
        Producto producto = new Producto("Laptop", 35000.0);

        producto.setNombre("tablet");
        producto.setPrecio(25000.0);

        assertEquals("tablet", producto.getNombre());
        assertEquals(25000.0, producto.getPrecio());
    }
    @Test
    void testAsignarPrecioCero() throws Exception {
        Producto producto = new Producto("Laptop", 35000.0);
        producto.setNombre("tablet");
        assertThrows(Exception.class, () -> producto.setPrecio(0));
    }

    @Test
    void testCrearPrecioCero() {
        assertThrows(Exception.class, () -> new Producto("Laptop", 0));
    }

    @Test
    void testAsignarPrecioMenorCero() throws Exception {
        Producto producto = new Producto("Laptop", 35000.0);
        producto.setNombre("tablet");
        assertThrows(Exception.class, () -> producto.setPrecio(-1));
    }

    @Test
    void testCrearPrecioMenorCero() {
        assertThrows(Exception.class, () -> new Producto("Laptop", -1));
    }

}
