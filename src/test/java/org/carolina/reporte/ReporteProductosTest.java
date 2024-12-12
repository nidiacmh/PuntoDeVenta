package org.carolina.reporte;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteProductosTest {
    @Test
    void testGenerarReporteProductosSinDescuento() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        Reporte reporte = new ReporteProductos(new ReporteSimple(orden), orden);
        String resultado = reporte.generar();
        assertEquals("Total: $35000.00\nProductos:\nLaptop, $35000.00\n", resultado);
    }
}
