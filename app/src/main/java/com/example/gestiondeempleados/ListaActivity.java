package com.example.gestiondeempleados;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondeempleados.managers.GestorEmpleados;
import com.example.gestiondeempleados.models.Empleado;
import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private ListView listEmpleados;
    private GestorEmpleados gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        gestor = GestorEmpleados.getInstance();  // Ahora usa la instancia única
        listEmpleados = findViewById(R.id.listEmpleados);

        // Agregar empleados solo si la lista está vacía (evita duplicados)
        if (gestor.obtenerTodosLosEmpleados().isEmpty()) {
            gestor.agregarEmpleado("Tiempo Completo", "Juan Pérez", 1, "Desarrollo", 5000, 5);
            gestor.agregarEmpleado("Medio Tiempo", "Ana López", 2, "Recursos Humanos", 3000, 2);
        }

        List<String> datosEmpleados = new ArrayList<>();
        List<Empleado> empleados = gestor.obtenerTodosLosEmpleados();

        Log.d("ListaActivity", "Cantidad de empleados: " + empleados.size());

        if (empleados.isEmpty()) {
            Log.e("ListaActivity", "No hay empleados registrados.");
        }

        for (Empleado e : empleados) {
            Log.d("ListaActivity", "Empleado: " + e.obtenerInformacion());
            datosEmpleados.add(e.obtenerInformacion());
        }

        // Adaptador para mostrar los empleados en el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datosEmpleados);
        listEmpleados.setAdapter(adapter);
    }
}
