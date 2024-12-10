package org.carolina;

import org.carolina.descuento.Descuento;
import org.carolina.descuento.DescuentoClienteFrecuente;
import org.carolina.descuento.DescuentoTemporada;
import org.carolina.descuento.SinDescuento;
import org.carolina.orden.Orden;
import org.carolina.reporte.Reporte;
import org.carolina.reporte.ReporteDetallado;
import org.carolina.reporte.ReporteExtendido;
import org.carolina.reporte.ReporteSimple;
import org.carolina.visitor.Exportador;
import org.carolina.visitor.ExportarCSV;
import org.carolina.visitor.ExportarJSON;
import org.carolina.visitor.ExportarXML;

public class Main {
    public static void main(String[] args) throws Exception {
        imprimirOrden(new SinDescuento(), "sin descuento");
        imprimirOrden(new DescuentoTemporada(), "con descuento de temporada");
        imprimirOrden(new DescuentoClienteFrecuente(), "con descuento de cliente frecuente");
    }

    private static void imprimirOrden(Descuento descuento, String tipo) throws Exception {
        // Creamos una orden de compra de 8 productos
        System.out.println("*** Orden " + tipo + " ***");
        Orden orden = new Orden();
        orden.setEstrategiaDescuento(descuento);
        orden.agregarProductos(GeneradorDeProductos.generarListaDeProductos(8));

        // Creamos los diferentes reportes para nuestra orden Decorator
        Reporte reporteSimple = new ReporteSimple(orden);
        System.out.println("Reporte Simple: ");
        System.out.println(reporteSimple.generar());
        System.out.println("\n");

        Reporte reporteDetallado = new ReporteDetallado(reporteSimple, orden);
        System.out.println("Reporte Detallado: ");
        System.out.println(reporteDetallado.generar());
        System.out.println("\n");

        Reporte reporteExtendido = new ReporteExtendido(reporteDetallado, orden);
        System.out.println("Reporte Extendido: ");
        System.out.println(reporteExtendido.generar());
        System.out.println("\n");

        //Creamos la exportacion de orden con patron Visitor
        Exportador exportadorCSV = new ExportarCSV();
        System.out.println("Exportar CSV: ");
        String csv = orden.aceptar(exportadorCSV);
        System.out.println(csv);
        System.out.println("\n");

        Exportador exportadorJSON = new ExportarJSON();
        System.out.println("Exportar JSON: ");
        String json = orden.aceptar(exportadorJSON);
        System.out.println(json);
        System.out.println("\n");

        Exportador exportadorXML = new ExportarXML();
        System.out.println("Exportar XML: ");
        String xml = orden.aceptar(exportadorXML);
        System.out.println(xml);
        System.out.println("_____________________________________________________");
    }
}