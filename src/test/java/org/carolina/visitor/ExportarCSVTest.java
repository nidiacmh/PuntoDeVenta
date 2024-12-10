package org.carolina.visitor;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportarCSVTest {
    @Test
    void testExportarOrdenCSV() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.agregarProducto(new Producto("Tablet", 25000.0));

        Exportador exportador = new ExportarCSV();
        String resultado = exportador.exportar(orden);

        String csv = "Producto,Precio\nLaptop,35000.0\nTablet,25000.0\n";
        assertEquals(resultado, csv);
    }
}
