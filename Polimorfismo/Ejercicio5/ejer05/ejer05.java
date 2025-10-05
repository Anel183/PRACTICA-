package Polimorfismo.Ejercicio5.ejer05;

class Celular {
    private String nroTel;
    private String dueño;
    private float espacio;  
    private int ram;         
    private int nroApp;

    public Celular(String nroTel, String dueño, float espacio, int ram, int nroApp) {
        this.nroTel = nroTel;
        this.dueño = dueño;
        this.espacio = espacio;
        this.ram = ram;
        this.nroApp = nroApp;
    }

    public void mostrar() {
        System.out.println("Telefono : " + nroTel);
        System.out.println("Dueño    : " + dueño);
        System.out.println("Espacio  : " + espacio + " GB");
        System.out.println("RAM      : " + ram + " GB");
        System.out.println("Nro Apps : " + nroApp);
        System.out.println("---------------------------");
    }

    public void aumentarApps() {
        nroApp += 10;
    }

    public void disminuirEspacio() {
        espacio -= 5;
        if (espacio < 0) espacio = 0;
    }
}

public class ejer05{
    public static void main(String[] args) {
        Celular cel = new Celular("789-456", "Ana", 64.0f, 6, 20);

        System.out.println("Datos Iniciales");
        cel.mostrar();

        cel.aumentarApps();      
        cel.disminuirEspacio(); 

        System.out.println("Después de aplicar métodos");
        cel.mostrar();
    }
}

