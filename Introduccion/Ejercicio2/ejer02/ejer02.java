package Introduccion.Ejercicio2.ejer02;
public class ejer02 {
    public static void main(String[] args) {
        Bus miBus = new Bus(40); 
        miBus.subirPasajeros(25);
        double total = miBus.cobrarPasaje();
        System.out.println("Total recaudado: Bs. " + total);
        System.out.println("Asientos disponibles: " + miBus.asientosDisponibles());
        System.out.println(miBus);
    }
}
class Bus {
    private int capacidad;
    private int pasajeros;
    private double costoPasaje = 1.50;

    public Bus(int capacidad) {
        this.capacidad = capacidad;
        this.pasajeros = 0;
    }
    public void subirPasajeros(int cantidad) {
        if (pasajeros + cantidad <= capacidad) {
            pasajeros += cantidad;
            System.out.println(cantidad + " pasajeros subieron al bus.");
        } else {
            int espacio = capacidad - pasajeros;
            pasajeros = capacidad;
            System.out.println("Solo subieron " + espacio + 
                               " pasajeros (bus lleno).");
        }
    }

    public double cobrarPasaje() {
        return pasajeros * costoPasaje;
    }
    public int asientosDisponibles() {
        return capacidad - pasajeros;
    }

    @Override
    public String toString() {
        return "Bus [Capacidad=" + capacidad + 
               ", Pasajeros=" + pasajeros + 
               ", Costo Pasaje=Bs. " + costoPasaje + "]";
    }
}
