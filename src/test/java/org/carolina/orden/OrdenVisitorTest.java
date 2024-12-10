package org.carolina.orden;

import org.carolina.visitor.Exportador;
import org.carolina.visitor.ExportarCSV;
import org.carolina.visitor.ExportarJSON;
import org.carolina.visitor.ExportarXML;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdenVisitorTest {
    @Test
    void testOrdenVisitorCSV() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        Exportador visitor = new ExportarCSV();
        String resultado = orden.aceptar(visitor);
        String csv = "Producto,Precio\nLaptop,35000.0\nTablet,25000.0\n";
        assertEquals(resultado, csv);

    }

    @Test
    void testOrdenVisitorJSON() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        Exportador visitor = new ExportarJSON();
        String resultado = orden.aceptar(visitor);

        assertTrue(resultado.contains("\"nombre\" : \"Laptop\""));
        assertTrue(resultado.contains("\"precio\" : 35000.0"));
        assertTrue(resultado.contains("\"nombre\" : \"Tablet\""));
        assertTrue(resultado.contains("\"precio\" : 25000.0"));

    }

    @Test
    void testOrdenVisitorXML() throws Exception {
        Orden orden = new Orden();
        double precioLaptop = 35000.0;
        double precioTablet = 25000.0;
        Producto laptop = new Producto("Laptop", precioLaptop);
        Producto tablet = new Producto("Tablet", precioTablet);

        orden.agregarProducto(laptop);
        orden.agregarProducto(tablet);

        Exportador visitor = new ExportarXML();
        String resultado = orden.aceptar(visitor);
        assertTrue(resultado.contains("<nombre>Laptop</nombre>"));
        assertTrue(resultado.contains("<precio>35000.0</precio>"));
        assertTrue(resultado.contains("<nombre>Tablet</nombre>"));
        assertTrue(resultado.contains("<precio>25000.0</precio>"));

    }
}
