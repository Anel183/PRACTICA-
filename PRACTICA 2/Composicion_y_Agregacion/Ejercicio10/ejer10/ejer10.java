package Composicion_y_Agregacion.Ejercicio10.ejer10;
class Persona {
    String nombre;
    String apellido;
    int edad;
    int ci;

    public Persona(String nombre, String apellido, int edad, int ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ci = ci;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (CI: " + ci + ", Edad: " + edad + ")";
    }
}

class Speaker extends Persona {
    String especialidad;

    public Speaker(String nombre, String apellido, int edad, int ci, String especialidad) {
        super(nombre, apellido, edad, ci);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Speaker: " + super.toString() + " | Especialidad: " + especialidad;
    }
}

class Participante extends Persona {
    int nroTicket;

    public Participante(String nombre, String apellido, int edad, int ci, int nroTicket) {
        super(nombre, apellido, edad, ci);
        this.nroTicket = nroTicket;
    }

    @Override
    public String toString() {
        return "Participante: " + super.toString() + " | Ticket: " + nroTicket;
    }
}

class Charla {
    String lugar;
    String nombreCharla;
    Speaker speaker;
    int np;
    Participante[] participantes; 

    public Charla(String lugar, String nombreCharla, Speaker speaker) {
        this.lugar = lugar;
        this.nombreCharla = nombreCharla;
        this.speaker = speaker;
        this.np = 0;
        this.participantes = new Participante[50];
    }

    public void agregarParticipante(Participante p) {
        if (np < 50) {
            participantes[np] = p;
            np++;
        } else {
            System.out.println("Charla llena: " + nombreCharla);
        }
    }

    public int getNumeroParticipantes() {
        return np;
    }

    public double calcularEdadPromedioParticipantes() {
        if (np == 0) return 0;
        int suma = 0;
        for (int i = 0; i < np; i++) {
            suma += participantes[i].edad;
        }
        return (double) suma / np;
    }

    @Override
    public String toString() {
        String info = "=== CHARLA: " + nombreCharla + " ===\n";
        info += "Lugar: " + lugar + "\n";
        info += "Speaker: " + speaker + "\n";
        info += "Participantes (" + np + "):\n";
        for (int i = 0; i < np; i++) {
            info += "  → " + participantes[i] + "\n";
        }
        info += "Edad promedio: " + String.format("%.2f", calcularEdadPromedioParticipantes()) + "\n";
        info += "--------------------------------------\n";
        return info;
    }
}
class Evento {
    String nombre;
    int nc; 
    Charla[] charlas; 

    public Evento(String nombre) {
        this.nombre = nombre;
        this.nc = 0;
        this.charlas = new Charla[50];
    }

    public void agregarCharla(Charla charla) {
        if (nc < 50) {
            charlas[nc] = charla;
            nc++;
        }
    }

    public double edadPromedioParticipantesEvento() {
        int totalParticipantes = 0;
        int sumaEdades = 0;
        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < charlas[i].np; j++) {
                sumaEdades += charlas[i].participantes[j].edad;
                totalParticipantes++;
            }
        }
        return totalParticipantes == 0 ? 0 : (double) sumaEdades / totalParticipantes;
    }

    public boolean buscarPersona(String nombre, String apellido) {
        for (int i = 0; i < nc; i++) {
            if (charlas[i].speaker.nombre.equals(nombre) && charlas[i].speaker.apellido.equals(apellido)) {
                System.out.println(nombre + " " + apellido + " es SPEAKER en la charla: " + charlas[i].nombreCharla);
                return true;
            }
            for (int j = 0; j < charlas[i].np; j++) {
                Participante p = charlas[i].participantes[j];
                if (p.nombre.equals(nombre) && p.apellido.equals(apellido)) {
                    System.out.println(nombre + " " + apellido + " es PARTICIPANTE en la charla: " + charlas[i].nombreCharla);
                    return true;
                }
            }
        }
        System.out.println(nombre + " " + apellido + " NO se encuentra en ninguna charla.");
        return false;
    }

    public void eliminarCharlasDeSpeaker(int ciSpeaker) {
        int eliminadas = 0;
        for (int i = 0; i < nc; i++) {
            if (charlas[i].speaker.ci == ciSpeaker) {
                System.out.println("Eliminando charla: " + charlas[i].nombreCharla + " (Speaker CI: " + ciSpeaker + ")");
                for (int j = i; j < nc - 1; j++) {
                    charlas[j] = charlas[j + 1];
                }
                charlas[nc - 1] = null;
                nc--;
                i--; 
                eliminadas++;
            }
        }
        if (eliminadas == 0) {
            System.out.println("No se encontró speaker con CI: " + ciSpeaker);
        } else {
            System.out.println("Se eliminaron " + eliminadas + " charla(s).");
        }
    }

    public void ordenarCharlasPorParticipantes() {
        for (int i = 0; i < nc - 1; i++) {
            for (int j = 0; j < nc - i - 1; j++) {
                if (charlas[j].getNumeroParticipantes() < charlas[j + 1].getNumeroParticipantes()) {
                    Charla temp = charlas[j];
                    charlas[j] = charlas[j + 1];
                    charlas[j + 1] = temp;
                }
            }
        }
    }

    public void mostrarEvento() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("            EVENTO: " + nombre.toUpperCase());
        System.out.println("Edad promedio de participantes: " + String.format("%.2f", edadPromedioParticipantesEvento()));
        System.out.println("=".repeat(60));
        for (int i = 0; i < nc; i++) {
            System.out.println(charlas[i]);
        }
        System.out.println("=".repeat(60) + "\n");
    }
}

public class ejer10 {
    public static void main(String[] args) {
        Evento evento = new Evento("Tech Conference 2025");

        Speaker sp1 = new Speaker("Ana", "García", 35, 1001, "Inteligencia Artificial");
        Speaker sp2 = new Speaker("Luis", "Martínez", 42, 1002, "Ciberseguridad");

        Charla charla1 = new Charla("Sala A", "IA en la Vida Diaria", sp1);
        Charla charla2 = new Charla("Sala B", "Protección de Datos", sp2);
        Charla charla3 = new Charla("Sala C", "Machine Learning Básico", sp1);

        Participante p1 = new Participante("Juan", "Pérez", 22, 2001, 101);
        Participante p2 = new Participante("María", "López", 25, 2002, 102);
        Participante p3 = new Participante("Carlos", "Ruiz", 19, 2003, 103);
        Participante p4 = new Participante("Sofía", "Díaz", 28, 2004, 104);
        Participante p5 = new Participante("Pedro", "Sánchez", 30, 2005, 105);

        charla1.agregarParticipante(p1);
        charla1.agregarParticipante(p2);
        charla1.agregarParticipante(p3);

        charla2.agregarParticipante(p4);
        charla2.agregarParticipante(p5);

        charla3.agregarParticipante(p1);
        charla3.agregarParticipante(p4);

        evento.agregarCharla(charla1);
        evento.agregarCharla(charla2);
        evento.agregarCharla(charla3);

        evento.mostrarEvento();

        System.out.println("a) Edad promedio de participantes en el evento: " +
                String.format("%.2f", evento.edadPromedioParticipantesEvento()));

        System.out.println("\nb) Buscando persona:");
        evento.buscarPersona("Juan", "Pérez");
        evento.buscarPersona("Ana", "García");

        System.out.println("\nc) Eliminando charlas del speaker CI 1001...");
        evento.eliminarCharlasDeSpeaker(1001);
        evento.mostrarEvento();

        System.out.println("d) Ordenando charlas por número de participantes...");
        evento.ordenarCharlasPorParticipantes();
        evento.mostrarEvento();
    }
}