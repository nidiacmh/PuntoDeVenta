package org.carolina.visitor;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExportarXMLTest {
    @Test
    void testExportarOrdenXML() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.agregarProducto(new Producto("Tablet", 25000.0));

        Exportador exportador = new ExportarXML();
        String resultado = exportador.exportar(orden);

        System.out.println(resultado);

        assertTrue(resultado.contains("<nombre>Laptop</nombre>"));
        assertTrue(resultado.contains("<precio>35000.0</precio>"));
        assertTrue(resultado.contains("<nombre>Tablet</nombre>"));
        assertTrue(resultado.contains("<precio>25000.0</precio>"));
    }
}
