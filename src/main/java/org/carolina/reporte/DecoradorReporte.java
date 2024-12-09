package org.carolina.reporte;

public abstract class DecoradorReporte implements Reporte {
    protected final Reporte reporteDecorado;

    protected DecoradorReporte(Reporte reporteDecorado) {
        this.reporteDecorado = reporteDecorado;
    }

    @Override
    public String generar() throws Exception {
        return reporteDecorado.generar();
    }
}
