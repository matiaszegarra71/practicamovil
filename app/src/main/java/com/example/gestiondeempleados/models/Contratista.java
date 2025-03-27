package com.example.gestiondeempleados.models;

public class Contratista extends Empleado {
    private int duracionContrato; // En meses
    private double tarifaProyecto;

    public Contratista(String nombre, int id, String departamento, double salarioBase, int añosExperiencia, int duracionContrato, double tarifaProyecto) {
        super(nombre, id, departamento, salarioBase, añosExperiencia);
        this.duracionContrato = duracionContrato;
        this.tarifaProyecto = tarifaProyecto;
    }

    @Override
    public double calcularSalario() {
        return tarifaProyecto / duracionContrato;
    }
}
