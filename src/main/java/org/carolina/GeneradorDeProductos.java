package org.carolina;

import org.carolina.orden.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorDeProductos {

    private static final String[] NOMBRES_PRODUCTOS = {
            "Laptop", "Tablet", "Smartphone", "Monitor", "Teclado",
            "Mouse", "Auriculares", "Impresora", "Smartwatch", "Cámara"
    };

    private static final double PRECIO_MINIMO = 1000.0; // Precio mínimo de productos
    private static final double PRECIO_MAXIMO = 50000.0; // Precio máximo de productos

    public static List<Producto> generarListaDeProductos(int cantidad) {
        List<Producto> productos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            try {
                String nombre = NOMBRES_PRODUCTOS[random.nextInt(NOMBRES_PRODUCTOS.length)];
                double precio = PRECIO_MINIMO + (PRECIO_MAXIMO - PRECIO_MINIMO) * random.nextDouble();
                productos.add(new Producto(nombre, Math.round(precio * 100.0) / 100.0));
            } catch (Exception e) {
                System.err.println("Error al generar producto: " + e.getMessage());
            }
        }

        return productos;
    }
}
