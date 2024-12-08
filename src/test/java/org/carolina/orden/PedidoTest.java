package org.carolina.orden;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {
    @Test
    void testAgregarPedido(){
        Pedido pedido = new Pedido();
        Producto producto = new Producto("Celular", 18000.0);
        pedido.agregarProducto(producto);
        List<Producto> productos = pedido.getProductos();

        assertEquals(1, productos.size());
        assertEquals("Celular", productos.get(0).getNombre());
    }
}
