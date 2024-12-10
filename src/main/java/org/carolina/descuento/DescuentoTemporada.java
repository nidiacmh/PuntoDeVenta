package org.carolina.descuento;

public class DescuentoTemporada implements Descuento {

    public static final double DESCUENTO_TEMPORADA = 0.10;

    public double aplicarDescuento(double precioTotal) throws Exception {
        if (precioTotal <= 0)
            throw new Exception("Precio invalido");
        return precioTotal - (precioTotal * DESCUENTO_TEMPORADA);
    }

    @Override
    public double getDescuento() {
        return DESCUENTO_TEMPORADA;
    }
}
