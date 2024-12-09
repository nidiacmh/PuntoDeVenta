package org.carolina.reporte;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteSimpleTest {
    @Test
    void testGenerarReporteSimple() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        Reporte reporte = new ReporteSimple(orden);
        String resultado = reporte.generar();
        assertEquals("Total: 35000.0", resultado);

    }
}
