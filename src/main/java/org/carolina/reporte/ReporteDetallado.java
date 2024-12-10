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
        String mensajeDetallado = "\nTotal de descuentos: $" +
                String.format("%.2f", totalDescuento) +
                "\nDescuento aplicado: " +
                getDescuento() + "% ";
        return super.generar() + mensajeDetallado;
    }

    private int getDescuento() {
        return (int) (orden.getDescuento() * 100);
    }

}
