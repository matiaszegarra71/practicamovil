package com.example.gestiondeempleados.models;

public abstract class Empleado {
    protected String nombre;
    protected int id;
    public String departamento;
    protected double salarioBase;
    public int añosExperiencia;

    // Constructor
    public Empleado(String nombre, int id, String departamento, double salarioBase, int añosExperiencia) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
        this.salarioBase = salarioBase;
        this.añosExperiencia = añosExperiencia;
    }

    // Método abstracto para calcular salario
    public abstract double calcularSalario();

    // Método para obtener la información del empleado
    public String obtenerInformacion() {
        return "ID: " + id + " | Nombre: " + nombre + " | Departamento: " + departamento +
                " | Salario: $" + calcularSalario() + " | Experiencia: " + añosExperiencia + " años";
    }
}
