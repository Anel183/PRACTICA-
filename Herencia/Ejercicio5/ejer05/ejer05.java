package Herencia.Ejercicio5.ejer05;
class Vehiculo {
    protected String conductor;
    protected String placa;
    protected int id;

    public Vehiculo(String conductor, String placa, int id) {
        this.conductor = conductor;
        this.placa = placa;
        this.id = id;
    }

    public String getConductor() { return conductor; }
    public String getPlaca() { return placa; }
    public int getId() { return id; }

    public void cambiarConductor(String nuevoConductor) {
        this.conductor = nuevoConductor;
        System.out.println("Conductor cambiado a: " + nuevoConductor);
    }
}

class Bus extends Vehiculo {
    private int capacidad;
    private String sindicato;

    public Bus(String conductor, String placa, int id, int capacidad, String sindicato) {
        super(conductor, placa, id);
        this.capacidad = capacidad;
        this.sindicato = sindicato;
    }
}

class Auto extends Vehiculo {
    private int caballosFuerza;
    private boolean descapotable;

    public Auto(String conductor, String placa, int id, int caballosFuerza, boolean descapotable) {
        super(conductor, placa, id);
        this.caballosFuerza = caballosFuerza;
        this.descapotable = descapotable;
    }
}

class Moto extends Vehiculo {
    private int cilindrada;
    private boolean casco;

    public Moto(String conductor, String placa, int id, int cilindrada, boolean casco) {
        super(conductor, placa, id);
        this.cilindrada = cilindrada;
        this.casco = casco;
    }
}

public class ejer05 {
    public static void main(String[] args) {
        Bus bus = new Bus("Samanta", "ABC123", 1, 50, "Sindicato1");
        Auto auto = new Auto("Talia", "DEF456", 2, 150, true);
        Moto moto = new Moto("Mario", "GHI789", 3, 250, true);

        System.out.println("Bus - Placa: " + bus.getPlaca() + ", Conductor: " + bus.getConductor());
        System.out.println("Auto - Placa: " + auto.getPlaca() + ", Conductor: " + auto.getConductor());
        System.out.println("Moto - Placa: " + moto.getPlaca() + ", Conductor: " + moto.getConductor());

        bus.cambiarConductor("Nuevo Conductor");
    }
}
