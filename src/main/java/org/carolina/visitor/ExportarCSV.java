package org.carolina.visitor;

import org.carolina.orden.Orden;
import org.carolina.orden.Producto;

public class ExportarCSV implements Exportador{
    @Override
    public String exportar(Orden orden) {
        StringBuilder csv = new StringBuilder("Producto,Precio\n");
        for (Producto producto : orden.getProductos()){
            csv.append(producto.getNombre()).append(",").append(producto.getPrecio()).append("\n");
        }
        return csv.toString();
    }
}
