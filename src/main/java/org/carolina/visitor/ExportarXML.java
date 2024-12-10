package org.carolina.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.carolina.orden.Orden;

public class ExportarXML implements Exportador {
    @Override
    public String exportar(Orden orden) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orden.getProductos());
    }
}
