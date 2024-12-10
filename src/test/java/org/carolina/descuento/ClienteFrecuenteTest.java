package org.carolina.descuento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteFrecuenteTest {
    @Test
    void testAplicarDescuento() throws Exception {
        Descuento descuento = new DescuentoClienteFrecuente();
        double resultado = descuento.aplicarDescuento(100); // aplica un 15% de descuento
        assertEquals(85.0, resultado);
    }

    @Test
    void testAplicarDescuento110() throws Exception {
        Descuento descuento = new DescuentoClienteFrecuente();
        double resultado = descuento.aplicarDescuento(110); // aplica un 15% de descuento
        assertEquals(93.5, resultado);
    }

    @Test
    void testAplicarDescuentoMenorCero() {
        Descuento descuento = new DescuentoClienteFrecuente();
        assertThrows(Exception.class, () -> descuento.aplicarDescuento(-1));
    }

    @Test
    void testObtenerDescuento(){
        Descuento descuento = new DescuentoClienteFrecuente();
        assertEquals(0.15, descuento.getDescuento());
    }
}
