package org.carolina.descuento;

public class SinDescuento implements Descuento {
    @Override
    public double aplicarDescuento(double precioTotal) throws Exception {
        if (precioTotal <= 0)
            throw new Exception("Precio invalido");
        return precioTotal;
    }
}
