package org.carolina.reporte;

import org.carolina.orden.Orden;

public class ReporteDetallado extends DecoradorReporte {
    private final Orden orden;
    public ReporteDetallado(Reporte reporte, Orden orden) {
        super(reporte);
        this.orden = orden;
    }

    @Override
    public String generar() throws Exception {
        double totalDescuento = orden.calcularTotalSinDescuento() - orden.calcularTotalConDescuento();
        return super.generar() + "\nDetalle de descuentos: $" + totalDescuento;
    }

}
