package org.carolina.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.carolina.orden.Orden;

import java.util.HashMap;
import java.util.Map;

public class ExportarJSON implements Exportador {
    @Override
    public String exportar(Orden orden) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> datos = new HashMap<>();
        datos.put("productos", orden.getProductos());
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(datos);
    }
}
