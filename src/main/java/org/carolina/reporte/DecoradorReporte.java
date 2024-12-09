package org.carolina.reporte;

/*
* Se crea una clase abtracta que implementa una interfaz Reporte pra hacer uso del patron de diseño Decorator
* de esta manera podemos implementar diferentes reportes reutilizando el metodo generarReporte del padre.
* */
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
