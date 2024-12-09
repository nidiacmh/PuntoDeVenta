package org.carolina.reporte;

import org.carolina.orden.Orden;

public class ReporteSimple implements Reporte {
    private  final Orden orden;
    public ReporteSimple(Orden orden) {
        this.orden = orden;
    }

    @Override
    public String generar() throws Exception {
        return "Total: " + orden.calcularTotalConDescuento();
    }
}
