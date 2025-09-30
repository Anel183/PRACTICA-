package Polimorfismo.Ejercicio7.ejer07;

class Sistema {
    private String[] admins;
    private int nroAdmins;

    private String[][] autos; 
    private int nroAutos;

    public Sistema() {
        admins = new String[100];   
        nroAdmins = 0;

        autos = new String[100][3];
        nroAutos = 0;
    }

    public Sistema(String[] adminsIniciales, String[][] autosIniciales) {
        this.admins = new String[100];
        this.nroAdmins = 0;
        for (String admin : adminsIniciales) {
            this.admins[nroAdmins++] = admin;
        }

        this.autos = new String[100][3];
        this.nroAutos = 0;
        for (String[] auto : autosIniciales) {
            this.autos[nroAutos++] = auto;
        }
    }

    // b) Mostrar información
    public void mostrar() {
        System.out.println("Admins:");
        for (int i = 0; i < nroAdmins; i++) {
            System.out.println(" " + admins[i]);
        }

        System.out.println("\nAutos:");
        for (int i = 0; i < nroAutos; i++) {
            System.out.println("  Marca: " + autos[i][0] +
                               ", Modelo: " + autos[i][1] +
                               ", Año: " + autos[i][2]);
        }
        System.out.println("");
    }

    public void adicionar(String admin) {
        if (nroAdmins < admins.length) {
            admins[nroAdmins++] = admin;
            System.out.println("Admin agregado: " + admin);
        } else {
            System.out.println("No se pueden agregar más admins");
        }
    }

    public void adicionar(String marca, String modelo, String año) {
        if (nroAutos < autos.length) {
            autos[nroAutos][0] = marca;
            autos[nroAutos][1] = modelo;
            autos[nroAutos][2] = año;
            nroAutos++;
            System.out.println("Auto agregado: " + marca + " " + modelo + " " + año);
        } else {
            System.out.println("No se pueden agregar más autos");
        }
    }
}

public class ejer07 {
    public static void main(String[] args) {
        Sistema sis = new Sistema();

        System.out.println("Estado Inicial ");
        sis.mostrar();

        sis.adicionar("Juan");
        sis.adicionar("Ana");

        sis.adicionar("Toyota", "Corolla", "2020");
        sis.adicionar("Ford", "Mustang", "2022");

        System.out.println("\nEstado Final");
        sis.mostrar();

        String[] adminsIni = {"Luis", "Marta"};
        String[][] autosIni = {{"Honda", "Civic", "2019"}};
        Sistema sis2 = new Sistema(adminsIni, autosIni);
        System.out.println("\nSistema 2");
        sis2.mostrar();
    }
}
