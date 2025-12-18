package org.dair.appfacturas.modelo;

// Importes necesarios para manejar fechas y formatos
import java.text.SimpleDateFormat;
import java.util.Date;

// Clase Factura → representa una factura real
public class Factura {

    // ===== ATRIBUTOS =====

    // Número único de la factura
    private int folio;

    // Descripción de la factura
    private String descripcion;

    // Fecha de creación de la factura
    private Date fecha;

    // Cliente al que pertenece la factura (relación)
    private Cliente cliente;

    // Arreglo de ítems de la factura
    private ItemFactura[] items;

    // Controla cuántos items se han agregado
    private int indiceItems;

    // Máximo permitido de ítems por factura
    public static final int MAXIMO_ITEMS = 12;

    // Folio compartido por todas las facturas
    private static int ultimoFolio;

    // ===== CONSTRUCTOR =====
    // Se ejecuta cuando se crea una factura con new
    public Factura(Cliente cliente, String descripcion) {
        this.cliente = cliente;              // Asignamos el cliente
        this.descripcion = descripcion;      // Asignamos descripción
        this.items = new ItemFactura[MAXIMO_ITEMS]; // Creamos el arreglo
        this.folio = ++ultimoFolio;           // Generamos folio automático
        this.fecha = new Date();              // Fecha actual
    }

    // ===== GETTERS =====

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    // ===== MÉTODOS =====

    // Agrega un ítem a la factura
    public void addItemsFactura(ItemFactura item) {
        // Verificamos que no supere el máximo
        if (indiceItems < MAXIMO_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    // Calcula el total de la factura
    public double calcularTotal() {
        double total = 0.0;

        // Recorremos el arreglo de ítems
        for (ItemFactura item : this.items) {
            // Si el ítem es null, lo saltamos
            if (item == null) {
                continue;
            }
            // Sumamos el importe de cada ítem
            total += item.calcularImporte();
        }
        return total;
    }

    // Genera el detalle completo de la factura
    public String generarDetalle() {

        // StringBuilder es más eficiente que concatenar Strings
        StringBuilder sb = new StringBuilder("Factura N°: ");

        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n\n");

        // Formato de fecha
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n\n");

        // Encabezado de tabla
        sb.append("#\tNombre\tPrecio\tCant.\tTotal\n");

        // Recorremos los ítems
        for (ItemFactura item : this.items) {
            if (item == null) continue;

            sb.append(item.getProducto().getCodigo()).append("\t")
                    .append(item.getProducto().getNombre()).append("\t")
                    .append(item.getProducto().getPrecio()).append("\t")
                    .append(item.getCantidad()).append("\t")
                    .append(item.calcularImporte()).append("\n");
        }

        // Total final
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }
}
