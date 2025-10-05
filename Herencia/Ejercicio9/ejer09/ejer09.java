package Herencia.Ejercicio9.ejer09;

class Politico {
    private String profesion;
    private int añosExp;

    public Politico(String profesion, int añosExp) {
        this.profesion = profesion;
        this.añosExp = añosExp;
    }

    public String getProfesion() { return profesion; }
    public int getAñosExp() { return añosExp; }
}

class Partido {
    private String nombreP;
    private String rol;

    public Partido(String nombreP, String rol) {
        this.nombreP = nombreP;
        this.rol = rol;
    }

    public String getNombreP() { return nombreP; }
    public String getRol() { return rol; }
}

class Presidente extends Politico {
    private String nombre;
    private String apellido;
    private Partido partido;

    public Presidente(String nombre, String apellido, String profesion, int añosExp, String nombreP, String rol) {
        super(profesion, añosExp);
        this.nombre = nombre;
        this.apellido = apellido;
        this.partido = new Partido(nombreP, rol);
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getNombreP() { return partido.getNombreP(); }
    public String getRol() { return partido.getRol(); }
}

public class ejer09 {
    public static void main(String[] args) {
        Presidente pres1 = new Presidente("Luis", "Garcia", "Abogado", 15, "Partido A", "Lider");
        String nombre = "Neysa";
        String apellido = "Rodriguez";
        String profesion = "Abogada";
        int añosExp = 10;
        String nombreP = "Partido B";
        String rol = "Secretario";
        Presidente pres2 = new Presidente(nombre, apellido, profesion, añosExp, nombreP, rol);

        Presidente[] presidentes = new Presidente[3];
        presidentes[0] = new Presidente("Luis", "Garcia", "Abogado", 15, "Partido A", "Lider");
        presidentes[1] = new Presidente("Neysa", "Rodriguez", "Abogada", 10, "Partido B", "Secretario");
        presidentes[2] = new Presidente("Carlos", "Perez", "Ingeniero", 20, "Partido C", "Presidente");

        String nombreBuscado = "Neysa";
        boolean encontrado = false;
        for (Presidente p : presidentes) {
            if (p.getNombre().equals(nombreBuscado)) {
                System.out.println("Presidente encontrado: " + p.getNombre() + " " + p.getApellido());
                System.out.println("Partido Político: " + p.getNombreP() + ", Rol: " + p.getRol());
                System.out.println("Profesión: " + p.getProfesion());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un presidente con el nombre " + nombreBuscado);
        }
    }
}