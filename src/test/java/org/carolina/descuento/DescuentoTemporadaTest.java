package org.carolina.descuento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescuentoTemporadaTest {
    @Test
    void testAplicarDescuento() throws Exception {
        Descuento descuento = new DescuentoTemporada();
        double resultado = descuento.aplicarDescuento(100); // aplica un 10% de descuento
        assertEquals(90.0, resultado);
    }

    @Test
    void testAplicarDescuento110() throws Exception {
        Descuento descuento = new DescuentoTemporada();
        double resultado = descuento.aplicarDescuento(110); // aplica un 10% de descuento
        assertEquals(99.0, resultado);
    }

    @Test
    void testAplicarDescuentoMenorCero() {
        Descuento descuento = new DescuentoTemporada();
        assertThrows(Exception.class, () -> descuento.aplicarDescuento(-1));
    }
    @Test
    void testObtenerDescuento(){
        Descuento descuento = new DescuentoTemporada();
        assertEquals(0.1, descuento.getDescuento());
    }
}
