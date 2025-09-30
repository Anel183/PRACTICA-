package Introduccion.Ejercicio13.ejer13;

import java.util.*;
class Fruta {
    private String nombre;
    private String tipo;
    private int nroVitaminas;
    private List<String> vitaminas;

    public Fruta(String nombre, String tipo, List<String> vitaminas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vitaminas = new ArrayList<>(vitaminas);
        this.nroVitaminas = vitaminas.size();
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNroVitaminas() { return nroVitaminas; }
    public List<String> getVitaminas() { return vitaminas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Fruta{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nroVitaminas=" + nroVitaminas +
                ", vitaminas=" + vitaminas +
                '}';
    }
}

public class ejer13 {
    public static void main(String[] args) {
        Fruta kiwi = new Fruta("Kiwi", "Subtropical", Arrays.asList("K", "C", "E"));

        List<String> vitNaranja = new ArrayList<>();
        vitNaranja.add("C");
        vitNaranja.add("B1");
        Fruta naranja = new Fruta("Naranja", "Cítrica", vitNaranja);

        Fruta mango = new Fruta("Mango", "Tropical",
                                new ArrayList<>(List.of("A", "C", "E")));

        List<Fruta> frutas = Arrays.asList(kiwi, naranja, mango);
        Fruta masVitaminas = Collections.max(frutas,
                Comparator.comparingInt(Fruta::getNroVitaminas));
        System.out.println("Fruta con más vitaminas: " + masVitaminas.getNombre()
                           + " (" + masVitaminas.getNroVitaminas() + " vitaminas)");

        System.out.println("Vitaminas de Kiwi: " + kiwi.getVitaminas());

        Set<String> vitaminasCitricas = new HashSet<>(Arrays.asList("C", "B1"));
        int totalCitricas = 0;
        for (Fruta f : frutas) {
            for (String v : f.getVitaminas()) {
                if (vitaminasCitricas.contains(v)) {
                    totalCitricas++;
                }
            }
        }
        System.out.println("Cantidad total de vitaminas cítricas: " + totalCitricas);

        for (Fruta f : frutas) {
            List<String> ordenadas = new ArrayList<>(f.getVitaminas());
            Collections.sort(ordenadas);
            System.out.println("Vitaminas de " + f.getNombre()
                               + " ordenadas: " + ordenadas);
        }
    }
}
