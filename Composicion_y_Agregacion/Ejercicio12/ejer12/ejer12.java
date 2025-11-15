package Composicion_y_Agregacion.Ejercicio12.ejer12;

import java.util.ArrayList;
class Doctor {
    String nombre;
    String especialidad;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Dr. " + nombre + " - Especialidad: " + especialidad;
    }
}

class Hospital {
    String nombre;
    ArrayList<Doctor> doctores; 

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
    }

    public void asignarDoctor(Doctor doctor) {
        if (!doctores.contains(doctor)) {
            doctores.add(doctor);
            System.out.println(doctor.nombre + " asignado a " + nombre);
        } else {
            System.out.println(doctor.nombre + " ya trabaja en " + nombre);
        }
    }

    public void mostrarDoctores() {
        System.out.println("\n=== HOSPITAL: " + nombre + " ===");
        if (doctores.isEmpty()) {
            System.out.println("  No hay doctores asignados.");
        } else {
            System.out.println("  Doctores (" + doctores.size() + "):");
            for (Doctor d : doctores) {
                System.out.println("  → " + d);
            }
        }
        System.out.println("--------------------------------\n");
    }
}

public class ejer12 {
    public static void main(String[] args) {

        Doctor doc1 = new Doctor("Carlos Méndez", "Cardiología");
        Doctor doc2 = new Doctor("Laura Gómez", "Pediatría");
        Doctor doc3 = new Doctor("Miguel Torres", "Neurología");
        Doctor doc4 = new Doctor("Ana Rodríguez", "Dermatología");

        Hospital hospital1 = new Hospital("Hospital Central");
        Hospital hospital2 = new Hospital("Clínica del Sur");

        hospital1.asignarDoctor(doc1);  
        hospital1.asignarDoctor(doc2);  
        hospital1.asignarDoctor(doc3); 

        hospital2.asignarDoctor(doc2);  
        hospital2.asignarDoctor(doc4);  
        hospital1.asignarDoctor(doc2);  

        hospital1.mostrarDoctores();
        hospital2.mostrarDoctores();

        Doctor docIndependiente = new Doctor("Pedro Sánchez", "Medicina General");
        System.out.println("Doctor independiente (no asignado): " + docIndependiente);
    }
}
