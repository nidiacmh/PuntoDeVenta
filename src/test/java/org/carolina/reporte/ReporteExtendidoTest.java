package org.carolina.reporte;

import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteExtendidoTest {
    @Test
    void testGenerarReporteExtendidoSinDescuento() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        Reporte reporte = new ReporteExtendido(new ReporteDetallado(new ReporteSimple(orden), orden), orden);
        String resultado = reporte.generar();
        assertEquals("""
                Total: 35000.0
                Detalle de descuentos: $0.0
                Estadisticas adicionales:\s
                Numero de productos: 1""", resultado);
    }

    @Test
    void testGenerarReporteExtendidoConDescuentoClienteFrecuente() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoClienteFrecuente());
        Reporte reporte = new ReporteExtendido(new ReporteDetallado(new ReporteSimple(orden), orden), orden);
        String resultado = reporte.generar();
        assertEquals("""
                Total: 29750.0
                Detalle de descuentos: $5250.0
                Estadisticas adicionales:\s
                Numero de productos: 1""", resultado);
    }

    @Test
    void testGenerarReporteExtendidoConDescuentoTemporada() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoTemporada());
        Reporte reporte = new ReporteExtendido(new ReporteDetallado(new ReporteSimple(orden), orden), orden);
        String resultado = reporte.generar();
        assertEquals("""
                Total: 31500.0
                Detalle de descuentos: $3500.0
                Estadisticas adicionales:\s
                Numero de productos: 1""", resultado);
    }
}
