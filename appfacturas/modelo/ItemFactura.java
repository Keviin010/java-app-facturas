package org.dair.appfacturas.modelo;

public class ItemFactura {
    private int cantidad;
    private Producto producto;

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Calcula el importe usando double, consistente con Producto.getPrecio().
     * Lanza IllegalStateException si producto es null para evitar resultados silenciosos.
     */
    public double calcularImporte() {
        if (this.producto == null) {
            throw new IllegalStateException("No se puede calcular el importe: producto es null");
        }
        return this.cantidad * this.producto.getPrecio();
    }
}
