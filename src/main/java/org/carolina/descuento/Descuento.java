package org.carolina.descuento;

public interface Descuento {
    double aplicarDescuento(double precioTotal) throws Exception;
    double getDescuento();
}
