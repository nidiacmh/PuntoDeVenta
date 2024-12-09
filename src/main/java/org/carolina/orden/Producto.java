package org.carolina.orden;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) throws Exception {
        validarPrecio(precio);
        this.nombre = nombre;
        this.precio = precio;
    }

    private static void validarPrecio(double precio) throws Exception {
        if (precio <= 0)
            throw new Exception("El precio debe ser mayor a cero");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws Exception {
        validarPrecio(precio);
        this.precio = precio;
    }
}
