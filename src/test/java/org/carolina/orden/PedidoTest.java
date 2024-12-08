package org.carolina.orden;

import org.carolina.descuento.Descuento;
import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.descuento.SinDescuento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {
    @Test
    void testAgregarPedido(){
        Pedido pedido = new Pedido();
        Producto producto = new Producto("Celular", 18000.0);
        pedido.agregarProducto(producto);
        List<Producto> productos = pedido.getProductos();

        assertEquals(1, productos.size());
        assertEquals("Celular", productos.get(0).getNombre());
    }

    @Test
    void testCalcularTotalSinDescuento(){
        Pedido pedido = new Pedido();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);

        pedido.agregarProducto(laptop);
        pedido.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;

        assertEquals(costoTotal, pedido.calcularTotalSinDescuento());
    }

    @Test
    void testCalcularTotalConDescuentoTemporada() throws Exception {
        Pedido pedido = new Pedido();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new DescuentoTemporada();
        pedido.setEstrategiaDescuento(descuento);

        pedido.agregarProducto(laptop);
        pedido.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;
        double costoConDescuento = costoTotal * 0.90; // 10% de descuento

        assertEquals(costoTotal, pedido.calcularTotalSinDescuento());
        assertEquals(costoConDescuento, pedido.calcularTotalConDescuento());
    }

    @Test
    void testCalcularTotalConDescuentoClienteFrecuente() throws Exception {
        Pedido pedido = new Pedido();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new DescuentoClienteFrecuente();
        pedido.setEstrategiaDescuento(descuento);

        pedido.agregarProducto(laptop);
        pedido.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;
        double costoConDescuento = costoTotal * 0.85; // 15% de descuento

        assertEquals(costoTotal, pedido.calcularTotalSinDescuento());
        assertEquals(costoConDescuento, pedido.calcularTotalConDescuento());
    }

    @Test
    void testCalcularTotalSinDescuentoEstrategia() throws Exception {
        Pedido pedido = new Pedido();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);
        Descuento descuento = new SinDescuento();
        pedido.setEstrategiaDescuento(descuento);

        pedido.agregarProducto(laptop);
        pedido.agregarProducto(tablet);

        double costoTotal= precioLaptop + precioTablet;

        assertEquals(costoTotal, pedido.calcularTotalSinDescuento());
        assertEquals(costoTotal, pedido.calcularTotalConDescuento());
    }
}
