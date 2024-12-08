package org.carolina.descuento;

public class DescuentoTemporada {

    public static final double DESCUENTO = 0.10;

    public double aplicarDescuento(double precioTotal) throws Exception {
        if (precioTotal <= 0)
            throw new Exception("Precio invalido");
        return precioTotal - (precioTotal * DESCUENTO);
    }
}
