package org.carolina.reporte;

import org.carolina.orden.Orden;

public class ReporteExtendido extends DecoradorReporte {
    private final Orden orden;
    public ReporteExtendido(Reporte reporte, Orden orden) {
        super(reporte);
        this.orden = orden;
    }

    @Override
    public String generar() throws Exception {
        return super.generar() + "\nEstadisticas adicionales: \nNumero de productos: " + orden.getNumeroDeProductos();
    }
}
