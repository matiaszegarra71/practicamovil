package com.example.gestiondeempleados.managers;

import com.example.gestiondeempleados.models.Empleado;
import com.example.gestiondeempleados.models.EmpleadoTiempoCompleto;
import com.example.gestiondeempleados.models.EmpleadoMedioTiempo;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private static GestorEmpleados instancia;
    private List<Empleado> empleados;

    private GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public static GestorEmpleados getInstance() {
        if (instancia == null) {
            instancia = new GestorEmpleados();
        }
        return instancia;
    }

    public void agregarEmpleado(String tipo, String nombre, int id, String departamento, double salarioBase, int añosExperiencia) {
        Empleado nuevoEmpleado;
        if (tipo.equalsIgnoreCase("Tiempo Completo")) {
            nuevoEmpleado = new EmpleadoTiempoCompleto(nombre, id, departamento, salarioBase, añosExperiencia, 1000);
        } else if (tipo.equalsIgnoreCase("Medio Tiempo")) {
            nuevoEmpleado = new EmpleadoMedioTiempo(nombre, id, departamento, salarioBase, añosExperiencia);
        } else {
            return;
        }
        empleados.add(nuevoEmpleado);
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleados;
    }
}
