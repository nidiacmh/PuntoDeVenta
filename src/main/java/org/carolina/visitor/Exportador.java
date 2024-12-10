package org.carolina.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.carolina.orden.Orden;

public interface Exportador {
    String exportar(Orden orden) throws JsonProcessingException;
}
