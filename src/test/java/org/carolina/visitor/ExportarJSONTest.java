package org.carolina.visitor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.carolina.orden.Orden;
import org.carolina.orden.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportarJSONTest {
    @Test
    void testExportarOrdenJSON() throws Exception {
        Orden orden = new Orden();
        orden.agregarProducto(new Producto("Laptop", 35000.0));
        orden.agregarProducto(new Producto("Tablet", 25000.0));

        Exportador exportador = new ExportarJSON();
        String resultado = exportador.exportar(orden);

        String cadenaEsperada = """
                {
                  "productos" : [ {
                    "nombre" : "Laptop",
                    "precio" : 35000.0
                  }, {
                    "nombre" : "Tablet",
                    "precio" : 25000.0
                  } ]
                }""";

        // Convierte en objetos json por que los string generados tienen diferente formato, uno es LF y el otro CRLF
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonEsperado = mapper.readTree(cadenaEsperada);
        JsonNode jsonResultado = mapper.readTree(resultado);

        assertEquals(jsonEsperado, jsonResultado);
    }
}
