package org.dair.appfacturas.modelo;

public class Producto {
    private int codigo;
    private String nombre;
    private  double precio;
    private static int uitimoCodigo;

    public Producto(){
        this.codigo = ++uitimoCodigo;
    }

    public int getCodigo() {
        return codigo;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
