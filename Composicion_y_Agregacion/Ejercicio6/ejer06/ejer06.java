package Composicion_y_Agregacion.Ejercicio6.ejer06;

import java.util.ArrayList;
import java.util.Date;

// Clase Registro (hoja - composición fuerte)
class Registro {
    String lote;
    Date fechaVencimiento;
    String laboratorio;

    public Registro(String lote, Date fechaVencimiento, String laboratorio) {
        this.lote = lote;
        this.fechaVencimiento = fechaVencimiento;
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "Registro{lote='" + lote + "', vencimiento=" + fechaVencimiento +", laboratorio='" + laboratorio + "'}";
    }
}

// Clase intermedia con composición
class DetalleMedicamento {
    double precio;
    int stock;
    Registro registro; // COMPOSICIÓN

    public DetalleMedicamento(double precio, int stock, Registro registro) {
        this.precio = precio;
        this.stock = stock;
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "DetalleMedicamento{precio=" + precio + ", stock=" + stock + ", " + registro + "}";
    }
}

// CLASE PADRE ABSTRACTA (herencia)
abstract class ProductoFarmacia {
    String codigo;
    String categoria;

    public ProductoFarmacia(String codigo, String categoria) {
        this.codigo = codigo;
        this.categoria = categoria;
    }

    // MÉTODO ABSTRACTO → todas las hijas deben implementarlo
    public abstract void mostrarInformacion();
}

// MEDICAMENTO (hereda y tiene composición)
class Medicamento extends ProductoFarmacia {
    String nombre;
    String principioActivo;
    DetalleMedicamento detalle; // COMPOSICIÓN

    public Medicamento(String codigo, String nombre, String principioActivo,double precio, int stock, String lote, Date fechaVencimiento, String laboratorio) {
        super(codigo, "Medicamento");
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.detalle = new DetalleMedicamento(precio, stock,
            new Registro(lote, fechaVencimiento, laboratorio));
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== MEDICAMENTO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Principio Activo: " + principioActivo);
        System.out.println(detalle);
        System.out.println("-----------------------------\n");
    }
}

// SUPLEMENTO (otra clase que hereda)
class Suplemento extends ProductoFarmacia {
    String marca;
    int miligramos;

    public Suplemento(String codigo, String marca, int miligramos) {
        super(codigo, "Suplemento");
        this.marca = marca;
        this.miligramos = miligramos;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== SUPLEMENTO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Marca: " + marca);
        System.out.println("Dosis: " + miligramos + "mg");
        System.out.println("----------------------------\n");
    }
}

// CLASE PRINCIPAL: FARMACIA (contexto)
public class ejer06 {
    String nombreFarmacia;
    String direccion;
    ArrayList<ProductoFarmacia> productos; // POLIMORFISMO

    public ejer06(String nombreFarmacia, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoFarmacia p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.getClass().getSimpleName());
    }

    public void mostrarTodosLosProductos() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("     FARMACIA: " + nombreFarmacia.toUpperCase());
        System.out.println("     Dirección: " + direccion);
        System.out.println("=".repeat(50));

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (ProductoFarmacia p : productos) {
                p.mostrarInformacion(); // POLIMORFISMO PERFECTO → sin instanceof!
            }
        }
        System.out.println("=".repeat(50) + "\n");
    }

    public static void main(String[] args) {
        // Crear farmacia
        ejer06 farmacia = new ejer06("Farmacia Central", "Av. Busch #123");

        // Crear medicamentos con composición
        Medicamento paracetamol = new Medicamento(
            "MED-001", "Paracetamol 500mg", "Paracetamol",
            15.50, 100, "LOT-2024A", new Date(2026 - 1900, 11, 31), "Roche"
        );

        Medicamento ibuprofeno = new Medicamento(
            "MED-002", "Ibuprofeno 400mg", "Ibuprofeno",
            18.00, 75, "LOT-2025B", new Date(2027 - 1900, 5, 15), "Pfizer"
        );

        // Crear suplemento
        Suplemento vitaminaC = new Suplemento("SUP-001", "Nature's Bounty", 1000);

        // Agregar a la farmacia
        farmacia.agregarProducto(paracetamol);
        farmacia.agregarProducto(ibuprofeno);
        farmacia.agregarProducto(vitaminaC);

        // Mostrar todo
        farmacia.mostrarTodosLosProductos();
    }
}