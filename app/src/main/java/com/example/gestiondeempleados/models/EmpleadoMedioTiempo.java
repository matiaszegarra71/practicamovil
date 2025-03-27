package com.example.gestiondeempleados.models;

public class EmpleadoMedioTiempo extends Empleado {

    public EmpleadoMedioTiempo(String nombre, int id, String departamento, double salarioBase, int añosExperiencia) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
    }

    @Override
    public double calcularSalario() {
        // Ejemplo de cálculo: salario base + bonificación por experiencia, pero con descuento por medio tiempo
        double bonoExperiencia = 100 * añosExperiencia; // Por cada año de experiencia, $100 extra
        return (salarioBase / 2) + bonoExperiencia; // Medio tiempo recibe solo la mitad del salario base
    }
}
