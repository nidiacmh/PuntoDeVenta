package org.carolina.descuento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescuentoTemporadaTest {
    @Test
    void testAplicarDescuento(){
        DescuentoTemporada descuento = new DescuentoTemporada();
        double resultado = descuento.aplicarDescuento(100);//aplica un 10% de descuento
        assertEquals(90.0, resultado);
    }
}
