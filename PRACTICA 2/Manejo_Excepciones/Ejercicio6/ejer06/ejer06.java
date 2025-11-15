package Manejo_Excepciones.Ejercicio6.ejer06;
class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}
class CuentaBancaria {
    String numeroCuenta;
    String titular;
    double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (numeroCuenta == null || numeroCuenta.isEmpty())
            throw new IllegalArgumentException("Número de cuenta no puede estar vacío.");
        if (titular == null || titular.isEmpty())
            throw new IllegalArgumentException("Titular no puede estar vacío.");
        if (saldoInicial < 0)
            throw new IllegalArgumentException("Saldo inicial no puede ser negativo.");

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
        System.out.println("Depósito exitoso: +" + String.format("%.2f", monto) + " | Nuevo saldo: " + String.format("%.2f", saldo));
    }

    public void retirar(double monto) throws FondosInsuficientesException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new FondosInsuficientesException(
                "Fondos insuficientes. Saldo actual: " + String.format("%.2f", saldo) +
                " | Intento de retiro: " + String.format("%.2f", monto)
            );
        }
        saldo -= monto;
        System.out.println("Retiro exitoso: -" + String.format("%.2f", monto) + " | Nuevo saldo: " + String.format("%.2f", saldo));
    }
    public void mostrarInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        CUENTA BANCARIA");
        System.out.println("=".repeat(50));
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: Bs. " + String.format("%.2f", saldo));
        System.out.println("=".repeat(50) + "\n");
    }
}

public class ejer06 {
    public static void main(String[] args) {
        CuentaBancaria cuenta = null;
        try {
            cuenta = new CuentaBancaria("12345", "Juan Pérez", 1000.00);
            System.out.println("Cuenta creada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR al crear cuenta: " + e.getMessage());
            return;
        }
        cuenta.mostrarInfo();
        System.out.println("1. Intentando depósito válido de 500.00...");
        try {
            cuenta.depositar(500.00);
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR en depósito: " + e.getMessage());
        }
        System.out.println("\n2. Intentando depósito inválido de -200.00...");
        try {
            cuenta.depositar(-200.00);
        } catch (IllegalArgumentException e) {
            System.err.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }
        System.out.println("\n3. Intentando retiro válido de 300.00...");
        try {
            cuenta.retirar(300.00);
        } catch (FondosInsuficientesException e) {
            System.err.println("ERROR: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println("\n4. Intentando retiro inválido de 5000.00...");
        try {
            cuenta.retirar(5000.00);
        } catch (FondosInsuficientesException e) {
            System.err.println("EXCEPCIÓN PERSONALIZADA CAPTURADA: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        cuenta.mostrarInfo();
        System.out.println("5. Intentando crear cuenta con saldo negativo...");
        try {
            new CuentaBancaria("99999", "Ana López", -500);
        } catch (IllegalArgumentException e) {
            System.err.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }
    }
}
