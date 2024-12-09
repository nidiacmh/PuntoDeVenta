package org.carolina.orden;

import org.carolina.descuento.Descuento;
import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.descuento.SinDescuento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrdenTest {
    @Test
    void testAgregarPedido(){
        Orden orden = new Orden();
        Producto producto = new Producto("Celular", 18000.0);
        orden.agregarProducto(producto);
        List<Producto> productos = orden.getProductos();

        assertEquals(1, productos.size());
        assertEquals("Celular", productos.get(0).getNombre());
    }

    @Test
    void testCalcularTotalSinDescuento(){
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;

        assertEquals(costoTotal, orden.calcularTotalSinDescuento());
    }

    @Test
    void testCalcularTotalConDescuentoTemporada() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new DescuentoTemporada();
        orden.setEstrategiaDescuento(descuento);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;
        double costoConDescuento = costoTotal * 0.90; // 10% de descuento

        assertEquals(costoTotal, orden.calcularTotalSinDescuento());
        assertEquals(costoConDescuento, orden.calcularTotalConDescuento());
    }

    @Test
    void testCalcularTotalConDescuentoClienteFrecuente() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new DescuentoClienteFrecuente();
        orden.setEstrategiaDescuento(descuento);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;
        double costoConDescuento = costoTotal * 0.85; // 15% de descuento

        assertEquals(costoTotal, orden.calcularTotalSinDescuento());
        assertEquals(costoConDescuento, orden.calcularTotalConDescuento());
    }

    @Test
    void testCalcularTotalSinDescuentoEstrategia() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new SinDescuento();
        orden.setEstrategiaDescuento(descuento);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;

        assertEquals(costoTotal, orden.calcularTotalSinDescuento());
        assertEquals(costoTotal, orden.calcularTotalConDescuento());
    }

    @Test
    void testEstrategiaDeDescuentoInvalida() {
        Descuento descuento = null;
        Orden orden = new Orden();
        assertThrows(Exception.class, () -> orden.setEstrategiaDescuento(descuento));
    }
}
