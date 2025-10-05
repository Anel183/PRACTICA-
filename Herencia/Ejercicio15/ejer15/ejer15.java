package Herencia.Ejercicio15.ejer15;
class Nadador {
    private String estiloNatacion;

    public Nadador(String estiloNatacion) {
        this.estiloNatacion = estiloNatacion;
    }

    public void nadar() {
        System.out.println("Nadando estilo " + estiloNatacion);
    }

    public String getEstiloNatacion() { return estiloNatacion; }
}

class Ciclista {
    private String tipoBicicleta;

    public Ciclista(String tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public void pedalear() {
        System.out.println("Pedaleando en bicicleta tipo " + tipoBicicleta);
    }

    public String getTipoBicicleta() { return tipoBicicleta; }
}

class Corredor {
    private float distanciaPreferida;

    public Corredor(float distanciaPreferida) {
        this.distanciaPreferida = distanciaPreferida;
    }

    public void correr() {
        System.out.println("Corriendo una distancia de " + distanciaPreferida + " km");
    }

    public float getDistanciaPreferida() { return distanciaPreferida; }
}

class Triatleta extends Nadador {
    private Ciclista ciclista;
    private Corredor corredor;

    public Triatleta(String estiloNatacion, String tipoBicicleta, float distanciaPreferida) {
        super(estiloNatacion);
        this.ciclista = new Ciclista(tipoBicicleta);
        this.corredor = new Corredor(distanciaPreferida);
    }

    public void pedalear() {
        ciclista.pedalear();
    }

    public void correr() {
        corredor.correr();
    }
}

public class ejer15 {
    public static void main(String[] args) {
        Triatleta triatleta = new Triatleta("Mariposa", "Carrera", 10.5f);

        System.out.println("Acciones del triatleta:");
        triatleta.nadar();
        triatleta.pedalear();
        triatleta.correr();
    }
}
