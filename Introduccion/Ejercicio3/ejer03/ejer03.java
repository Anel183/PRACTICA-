package Introduccion.Ejercicio3.ejer03;
public class ejer03 {
    public static void main(String[] args) {
        Producto p = new Producto("Laptop", 5500.0, 10);
        System.out.println(p);
        p.vender(3);
        System.out.println("Después de vender 3: " + p);
        p.reabastecer(5);
        System.out.println("Después de reabastecer 5: " + p);
        p.vender(20);
        System.out.println("Después de intento de venta excesiva: " + p);
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void vender(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Se vendieron " + cantidad + 
                               " unidades de " + nombre + ".");
        } else {
            System.out.println("Stock insuficiente. Solo hay " + stock + " unidades.");
        }
    }

    public void reabastecer(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            System.out.println("Se reabasteció con " + cantidad + " unidades.");
        } else {
            System.out.println("Cantidad inválida para reabastecer.");
        }
    }

    @Override
    public String toString() {
        return "Producto Nombre=" + nombre + 
               ", Precio=Bs. " + precio + 
               ", Stock=" + stock + "";
    }
}
