package com.example.gestiondeempleados;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondeempleados.managers.GestorEmpleados;

public class RegistroActivity extends AppCompatActivity {
    private EditText etNombre, etId, etDepartamento, etSalarioBase, etExperiencia, etSalarioExtra;
    private Button btnGuardar;
    private GestorEmpleados gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Usar la instancia Singleton
        gestor = GestorEmpleados.getInstance();

        etNombre = findViewById(R.id.etNombre);
        etId = findViewById(R.id.etId);
        etDepartamento = findViewById(R.id.etDepartamento);
        etSalarioBase = findViewById(R.id.etSalarioBase);
        etExperiencia = findViewById(R.id.etExperiencia);
        etSalarioExtra = findViewById(R.id.etSalarioExtra);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            int id = Integer.parseInt(etId.getText().toString());
            String departamento = etDepartamento.getText().toString();
            double salarioBase = Double.parseDouble(etSalarioBase.getText().toString());
            int experiencia = Integer.parseInt(etExperiencia.getText().toString());
            double salarioExtra = Double.parseDouble(etSalarioExtra.getText().toString());

            // Usar el método agregarEmpleado con parámetros individuales
            gestor.agregarEmpleado("Tiempo Completo", nombre, id, departamento, salarioBase, experiencia);

            Toast.makeText(RegistroActivity.this, "Empleado Registrado", Toast.LENGTH_SHORT).show();
            finish(); // Cerrar la actividad después de registrar
        });
    }
}
