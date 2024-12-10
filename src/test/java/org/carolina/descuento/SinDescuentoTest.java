package org.carolina.descuento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinDescuentoTest {
    @Test
    void testSinDescuento() throws Exception {
        Descuento descuento = new SinDescuento();
        double resultado = descuento.aplicarDescuento(100); // no aplica un descuento
        assertEquals(100.0, resultado);
    }

    @Test
    void testAplicarDescuentoMenorCero() {
        Descuento descuento = new SinDescuento();
        assertThrows(Exception.class, () -> descuento.aplicarDescuento(-1));
    }

    @Test
    void testObtenerDescuento(){
        Descuento descuento = new SinDescuento();
        assertEquals(0.0, descuento.getDescuento());
    }
}
