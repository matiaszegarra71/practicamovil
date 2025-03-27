package com.example.gestiondeempleados.models;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioExtra;

    public EmpleadoTiempoCompleto(String nombre, int id, String departamento, double salarioBase, int añosExperiencia, double salarioExtra) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
        this.salarioExtra = salarioExtra;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + salarioExtra; // Aquí sumas el salario base y el salario extra
    }
}
