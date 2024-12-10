package org.carolina.reporte;

import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteDetalladoTest {
    @Test
    void testGenerarReporteDetalladoSinDescuento() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        Reporte reporte = new ReporteDetallado(new ReporteSimple(orden), orden);
        String resultado = reporte.generar();
        assertEquals("Total: 35000.0\nTotal de descuentos: $0.00\nDescuento aplicado: 0% ", resultado);
    }

    @Test
    void testGenerarReporteDetalladoConDescuentoClienteFrecuente() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoClienteFrecuente());
        Reporte reporte = new ReporteDetallado(new ReporteSimple(orden), orden);
        String resultado = reporte.generar();
        assertEquals("""
                Total: 29750.0
                Total de descuentos: $5250.00
                Descuento aplicado: 15%\s""", resultado);
    }

    @Test
    void testGenerarReporteDetalladoConDescuentoTemporada() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.setEstrategiaDescuento(new DescuentoTemporada());
        Reporte reporte = new ReporteDetallado(new ReporteSimple(orden), orden);
        String resultado = reporte.generar();
        assertEquals("""
                Total: 31500.0
                Total de descuentos: $3500.00
                Descuento aplicado: 10%\s""", resultado);
    }
}
