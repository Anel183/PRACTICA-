package Composicion_y_Agregacion.Ejercicio4.ejer04;

import java.util.Scanner;

class Ropa {
    String tipo;
    String material;

    public Ropa(String tipo, String material) {
        this.tipo = tipo;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Material: " + material;
    }
}

class Ropero {
    String material;
    Ropa[] ropas;
    int nroRopas;

    public Ropero(String material) {
        this.material = material;
        this.ropas = new Ropa[20];
        this.nroRopas = 0;
    }

    // a) Adicionar N prendas al ropero
    public void adicionarPrenda(Ropa prenda) {
        if (nroRopas < 20) {
            ropas[nroRopas] = prenda;
            nroRopas++;
            System.out.println("Prenda agregada: " + prenda);
        } else {
            System.out.println("Ropero lleno. No se puede agregar más prendas.");
        }
    }

    // c) Eliminar prendas de material X o tipo Y
    public void eliminarPorMaterialOTipo(String materialX, String tipoY) {
        int eliminados = 0;
        for (int i = 0; i < nroRopas; i++) {
            if (ropas[i] != null && 
                (ropas[i].material.equalsIgnoreCase(materialX) || ropas[i].tipo.equalsIgnoreCase(tipoY))) {
                System.out.println("Eliminando: " + ropas[i]);
                // Mover elementos hacia atrás
                for (int j = i; j < nroRopas - 1; j++) {
                    ropas[j] = ropas[j + 1];
                }
                ropas[nroRopas - 1] = null;
                nroRopas--;
                i--; // Revisar el mismo índice nuevamente
                eliminados++;
            }
        }
        if (eliminados == 0) {
            System.out.println("No se encontró ninguna prenda con material '" + materialX + "' o tipo '" + tipoY + "'");
        } else {
            System.out.println("Se eliminaron " + eliminados + " prenda(s).");
        }
    }

    // d) Mostrar prendas de material X y tipo Y
    public void mostrarPorMaterialYTipo(String materialX, String tipoY) {
        System.out.println("\n--- Prendas con material '" + materialX + "' y tipo '" + tipoY + "' ---");
        boolean encontrado = false;
        for (int i = 0; i < nroRopas; i++) {
            if (ropas[i] != null && 
                ropas[i].material.equalsIgnoreCase(materialX) && 
                ropas[i].tipo.equalsIgnoreCase(tipoY)) {
                System.out.println(ropas[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay prendas con ese material y tipo.");
        }
        System.out.println("----------------------------------------\n");
    }

    // Mostrar todo el ropero
    public void mostrarRopero() {
        System.out.println("\n=== ROPERO DE " + material.toUpperCase() + " ===");
        System.out.println("Total de prendas: " + nroRopas);
        if (nroRopas == 0) {
            System.out.println("El ropero está vacío.");
        } else {
            for (int i = 0; i < nroRopas; i++) {
                System.out.println((i + 1) + ". " + ropas[i]);
            }
        }
        System.out.println("=============================\n");
    }
}

public class ejer04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ropero ropero = new Ropero("madera");

        int opcion;
        do {
            System.out.println("\nMENU ROPERO");
            System.out.println("1. Agregar prenda");
            System.out.println("2. Eliminar por material o tipo");
            System.out.println("3. Mostrar prendas por material y tipo");
            System.out.println("4. Mostrar todo el ropero");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de prenda (camisa, pantalon, etc.): ");
                    String tipo = sc.nextLine();
                    System.out.print("Material (algodón, cuero, etc.): ");
                    String material = sc.nextLine();
                    Ropa prenda = new Ropa(tipo, material);
                    ropero.adicionarPrenda(prenda);
                    break;

                case 2:
                    System.out.print("Material a eliminar (o dejar vacío): ");
                    String mat = sc.nextLine();
                    System.out.print("Tipo a eliminar (o dejar vacío): ");
                    String tip = sc.nextLine();
                    if (mat.isEmpty() && tip.isEmpty()) {
                        System.out.println("Debe ingresar al menos un criterio.");
                    } else {
                        ropero.eliminarPorMaterialOTipo(mat.isEmpty() ? "NO_EXISTE" : mat, tip.isEmpty() ? "NO_EXISTE" : tip);
                    }
                    break;

                case 3:
                    System.out.print("Material a buscar: ");
                    String matB = sc.nextLine();
                    System.out.print("Tipo a buscar: ");
                    String tipB = sc.nextLine();
                    ropero.mostrarPorMaterialYTipo(matB, tipB);
                    break;

                case 4:
                    ropero.mostrarRopero();
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
