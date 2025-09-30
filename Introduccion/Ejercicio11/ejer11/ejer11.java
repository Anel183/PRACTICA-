package Introduccion.Ejercicio11.ejer11;
public class ejer11 {
    public static void main(String[] args) {
        // c) Crear un objeto por cada clase y mostrarlo
        Producto cafe = new Producto("Café Latte", 18.5);
        Pedido pedido1 = new Pedido(101, "Registrado");

        System.out.println(cafe);
        System.out.println(pedido1);
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Objeto Producto eliminado de memoria.");
        super.finalize();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto (Nombre=" + nombre + ", Precio=Bs. " + precio + ")";
    }
}

class Pedido {
    private int idPedido;
    private String estado;

    public Pedido(int idPedido, String estado) {
        this.idPedido = idPedido;
        this.estado = estado;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("eliminado de memoria.");
        super.finalize();
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Pedido (ID=" + idPedido + ", Estado=" + estado + ")";
    }
}

