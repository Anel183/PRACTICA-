package Herencia.Ejercicio1.ejer01;
class Persona {
    private String nombre;
    private String apellido;
    private String ci;

    public Persona(String nombre, String apellido, String ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCi() { return ci; }
    public void setCi(String ci) { this.ci = ci; }
}

class Cliente extends Persona {
    private String nroCompra;
    private String idCliente;

    public Cliente(String nombre, String apellido, String ci, String nroCompra, String idCliente) {
        super(nombre, apellido, ci);
        this.nroCompra = nroCompra;
        this.idCliente = idCliente;
    }

    public String getNroCompra() { return nroCompra; }
    public void setNroCompra(String nroCompra) { this.nroCompra = nroCompra; }
    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
}

class Jefe extends Persona {
    private String sucursal;
    private String tipo;

    public Jefe(String nombre, String apellido, String ci, String sucursal, String tipo) {
        super(nombre, apellido, ci);
        this.sucursal = sucursal;
        this.tipo = tipo;
    }

    public String getSucursal() { return sucursal; }
    public void setSucursal(String sucursal) { this.sucursal = sucursal; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}

public class ejer01 {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan", "Perez", "123456", "COMP001", "CLI001");
        Jefe jefe = new Jefe("Ana", "Lopez", "654321", "Sucursal Central", "Gerente");
        
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + ", CI: " + cliente.getCi());
        System.out.println("Jefe: " + jefe.getNombre() + " " + jefe.getApellido() + ", Sucursal: " + jefe.getSucursal());
    }
}
