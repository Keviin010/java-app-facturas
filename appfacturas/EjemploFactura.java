package org.dair.appfacturas;

import org.dair.appfacturas.modelo.Cliente;
import org.dair.appfacturas.modelo.Factura;
import org.dair.appfacturas.modelo.ItemFactura;
import org.dair.appfacturas.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("7776-6");
        cliente.setNombre("Kevin");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una descripción de la factura: ");
        String desc = s.nextLine();
        Factura factura = new Factura(cliente, desc);

        Producto producto;
        String nombre;
        double precio;
        int cantidad;

        System.out.println();

        for (int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto N° " + producto.getCodigo() + ": ");
             nombre = s.nextLine();
             producto.setNombre(nombre);

            System.out.print("Ingrese el precio:");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = s.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemsFactura(item);

            System.out.println();
             s.nextLine();


        }        System.out.println("");
        System.out.println(factura.generarDetalle());

    }
}
