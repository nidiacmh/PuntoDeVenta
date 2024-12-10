package org.carolina.visitor;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExportarJSONTest {
    @Test
    void testExportarOrdenJSON() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.agregarProducto(new Producto("Tablet", 25000.0));

        Exportador exportador = new ExportarJSON();
        String resultado = exportador.exportar(orden);

        assertTrue(resultado.contains("\"nombre\" : \"Laptop\""));
        assertTrue(resultado.contains("\"precio\" : 35000.0"));
        assertTrue(resultado.contains("\"nombre\" : \"Tablet\""));
        assertTrue(resultado.contains("\"precio\" : 25000.0"));
    }
}
