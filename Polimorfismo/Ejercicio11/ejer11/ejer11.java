package Polimorfismo.Ejercicio11.ejer11;
class Pasajero {
    private String nombre;
    private int nrHabitacion;
    private String genero;
    private double costoPasaje;

    public Pasajero(String nombre, int nrHabitacion, String genero, double costoPasaje) {
        this.nombre = nombre;
        this.nrHabitacion = nrHabitacion;
        this.genero = genero;
        this.costoPasaje = costoPasaje;
    }

    public String getNombre() { return nombre; }
    public int getNrHabitacion() { return nrHabitacion; }
    public String getGenero() { return genero; }
    public double getCostoPasaje() { return costoPasaje; }

    @Override
    public String toString() {
        return nombre + " (Hab: " + nrHabitacion + ", Género: " + genero + ", Costo: " + costoPasaje + ")";
    }
}

class Crucero {
    private String nombre;
    private String paisOrigen;
    private String paisDestino;
    private int nrPasajeros;
    private Pasajero[] pasajeros; 

    public Crucero(String nombre, String paisOrigen, String paisDestino, int capacidadMax) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.nrPasajeros = 0;
        this.pasajeros = new Pasajero[capacidadMax];
    }

    public String getNombre() { return nombre; }
    public int getNrPasajeros() { return nrPasajeros; }
    public Pasajero[] getPasajeros() { return pasajeros; }

    public void addPasajero(Pasajero p) { // Simula +
        if (nrPasajeros < pasajeros.length) {
            pasajeros[nrPasajeros++] = p;
            System.out.println("Añadido: " + p.getNombre());
        } else {
            System.out.println("Crucero lleno.");
        }
    }

    public void removePasajero(String nombreBuscado) {
        for (int i = 0; i < nrPasajeros; i++) {
            if (pasajeros[i] != null && pasajeros[i].getNombre().equals(nombreBuscado)) {
                pasajeros[i] = null;
                nrPasajeros--;
                System.out.println("Removido: " + nombreBuscado);
                return;
            }
        }
        System.out.println("Pasajero no encontrado.");
    }

    public double calculateTotalCost() { 
        double total = 0.0;
        for (int i = 0; i < nrPasajeros; i++) {
            if (pasajeros[i] != null) {
                total += pasajeros[i].getCostoPasaje();
            }
        }
        return total;
    }

    public boolean samePassengerCount(Crucero otro) { 
        return this.nrPasajeros == otro.getNrPasajeros();
    }

    public void showGenderCount() { 
        int mujeres = 0, hombres = 0;
        for (int i = 0; i < nrPasajeros; i++) {
            if (pasajeros[i] != null) {
                if ("M".equals(pasajeros[i].getGenero())) mujeres++;
                else if ("H".equals(pasajeros[i].getGenero())) hombres++;
            }
        }
        System.out.println("Mujeres: " + mujeres + ", Hombres: " + hombres);
    }

    @Override
    public String toString() {
        return "Crucero{" + nombre + ", Pasajeros: " + nrPasajeros + "}";
    }
}

public class ejer11 {
    public static void main(String[] args) {
        // a) Instanciar 2 cruceros y 5 pasajeros
        Crucero crucero1 = new Crucero("CruceroA", "España", "Italia", 100);
        Crucero crucero2 = new Crucero("CruceroB", "Francia", "Grecia", 100);

        Pasajero p1 = new Pasajero("Juan Vargas", 502, "H", 500);
        Pasajero p2 = new Pasajero("Martina Vasques", 603, "M", 1000);
        Pasajero p3 = new Pasajero("Wilmer Montero", 401, "H", 925);
        Pasajero p4 = new Pasajero("Ana López", 504, "M", 750);
        Pasajero p5 = new Pasajero("Carlos Ruiz", 505, "H", 850);

        // Añadir algunos a crucero1
        crucero1.addPasajero(p1);
        crucero1.addPasajero(p2);
        crucero1.addPasajero(p3);

        System.out.println(crucero1);
        System.out.println("Total costo: " + crucero1.calculateTotalCost()); // c

        crucero1.removePasajero("Juan Vargas"); // b

        System.out.println("¿Misma cantidad que crucero2? " + crucero1.samePassengerCount(crucero2)); // d

        crucero1.showGenderCount(); // e
    }
}