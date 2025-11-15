package Manejo_Excepciones.Ejercicio2.ejer02;
class NumeroInvalidoException extends Exception {
    public NumeroInvalidoException(String mensaje) {
        super(mensaje);
    }
}
class Calculadora {
    public static double sumar(double a, double b) {
        return a + b;
    }
    public static double restar(double a, double b) {
        return a - b;
    }
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return dividendo / divisor;
    }
    public static int convertirAEntero(String texto) throws NumeroInvalidoException {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException("El valor '" + texto + "' no es un número entero válido.");
        }
    }
}

public class ejer02 {
    public static void main(String[] args) {
        System.out.println("CALCULADORA BÁSICA - PRUEBA DE OPERACIONES\n");

        System.out.println("1. OPERACIONES BÁSICAS:");
        System.out.println("   10 + 5 = " + Calculadora.sumar(10, 5));
        System.out.println("   10 - 5 = " + Calculadora.restar(10, 5));
        System.out.println("   10 * 5 = " + Calculadora.multiplicar(10, 5));
        try {
            System.out.println("   10 / 2 = " + Calculadora.dividir(10, 2));
        } catch (ArithmeticException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println("\n2. DIVISIÓN POR CERO:");
        try {
            System.out.println("   10 / 0 = ?");
            Calculadora.dividir(10, 0);
        } catch (ArithmeticException e) {
            System.err.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }
        System.out.println("\n3. CONVERSIÓN DE STRING A NÚMERO:");
        try {
            String valido = "456";
            int numero = Calculadora.convertirAEntero(valido);
            System.out.println("   '" + valido + "' → " + numero + " (éxito)");
        } catch (NumeroInvalidoException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        try {
            String invalido = "abc123";
            System.out.println("   '" + invalido + "' → ?");
            int numero = Calculadora.convertirAEntero(invalido);
            System.out.println("   Resultado: " + numero);
        } catch (NumeroInvalidoException e) {
            System.err.println("EXCEPCIÓN PERSONALIZADA CAPTURADA: " + e.getMessage());
        }
        try {
            System.out.println("   '  789  ' → ?");
            int numero = Calculadora.convertirAEntero("  789  ");
            System.out.println("   Resultado: " + numero);
        } catch (NumeroInvalidoException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n4. USO COMBINADO (CONVERSIÓN + OPERACIÓN):");
        try {
            String num1Str = "25";
            String num2Str = "5";
            int n1 = Calculadora.convertirAEntero(num1Str);
            int n2 = Calculadora.convertirAEntero(num2Str);
            System.out.println("   " + num1Str + " + " + num2Str + " = " + Calculadora.sumar(n1, n2));
        } catch (NumeroInvalidoException e) {
            System.err.println("ERROR en conversión: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("     PRUEBA COMPLETA FINALIZADA CON ÉXITO");
        System.out.println("=".repeat(60));
    }
}