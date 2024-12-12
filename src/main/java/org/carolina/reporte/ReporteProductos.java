package org.carolina.reporte;

import org.carolina.orden.Orden;

public class ReporteProductos  extends DecoradorReporte  {
    private final Orden orden;
    public ReporteProductos(Reporte reporte, Orden orden) {
        super(reporte);
        this.orden = orden;
    }

    @Override
    public String generar() throws Exception {
        return super.generar() + "\nProductos:\n" + imprimirProductos(orden);
    }

    private String imprimirProductos(Orden orden) {
        StringBuilder resultado = new StringBuilder();
        orden.getProductos().forEach(
                producto -> resultado.append(producto.getNombre()).append(", $").append(String.format("%.2f", producto.getPrecio())).append("\n")
        );
        return resultado.toString();
    }
}
