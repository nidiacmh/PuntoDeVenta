package org.carolina.reporte;

import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteSimpleTest {
    @Test
    void testGenerarReporteSimpleSinDescuento() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        Reporte reporte = new ReporteSimple(orden);
        String resultado = reporte.generar();
        assertEquals("Total: $35000.00", resultado);
    }

    @Test
    void testGenerarReporteSimpleConDescuentoClienteFrecuente() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoClienteFrecuente());
        Reporte reporte = new ReporteSimple(orden);
        String resultado = reporte.generar();
        assertEquals("Total: $29750.00", resultado);
    }

    @Test
    void testGenerarReporteSimpleConDescuentoTemporada() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoTemporada());
        Reporte reporte = new ReporteSimple(orden);
        String resultado = reporte.generar();
        assertEquals("Total: $31500.00", resultado);
    }
}
