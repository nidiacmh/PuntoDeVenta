package org.carolina.descuento;

public class DescuentoClienteFrecuente implements Descuento {

    public static final double DESCUENTO_CLIENTE_FRECUENTE = 0.15;

    @Override
    public double aplicarDescuento(double precioTotal) throws Exception {
        if (precioTotal <= 0)
            throw new Exception("Precio Invalido");
        return precioTotal - (precioTotal * DESCUENTO_CLIENTE_FRECUENTE);
    }
}
