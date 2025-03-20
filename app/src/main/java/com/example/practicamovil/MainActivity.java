package com.example.practicamovil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCardView, btnExpandableListView;
    FrameLayout container;
    LinearLayout buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCardView = findViewById(R.id.btnCardView);
        btnExpandableListView = findViewById(R.id.btnExpandableListView);
        container = findViewById(R.id.container);
        buttonContainer = findViewById(R.id.buttonContainer);

        // Propiedades de CardView
        String[] cardProperties = {
                "cardElevation", "cardCornerRadius", "cardBackgroundColor",
                "cardMaxElevation", "cardUseCompatPadding", "cardPreventCornerOverlap",
                "contentPadding", "cardStateListAnimator", "cardViewShape", "Click Elevation"
        };

        // Agregar botones para cada propiedad de CardView
        for (String property : cardProperties) {
            Button btn = new Button(this);
            btn.setText("Ejemplo: " + property);
            btn.setOnClickListener(v -> showCardExample(property));
            buttonContainer.addView(btn);
        }

        // ExpandableListView con ejemplos
        btnExpandableListView.setOnClickListener(v -> {
            container.removeAllViews();  // Limpiamos el contenedor antes de agregar el ExpandableListView
            ExpandableListView expandableListView = new ExpandableListView(MainActivity.this);

            List<String> groups = new ArrayList<>();
            HashMap<String, List<String>> children = new HashMap<>();

            groups.add("Ejemplos de Propiedades de ExpandableListView");
            List<String> childList = new ArrayList<>();
            childList.add("divider");
            childList.add("dividerHeight");
            childList.add("indicatorLeft");
            childList.add("indicatorRight");
            childList.add("childIndicatorLeft");
            childList.add("childIndicatorRight");
            childList.add("groupIndicator");
            childList.add("itemIndicator");
            childList.add("itemHeight");
            childList.add("groupIndicatorHeight");

            children.put(groups.get(0), childList);
            ExpandableListAdapter adapter = new ExpandableListAdapter(MainActivity.this, groups, children);
            expandableListView.setAdapter(adapter);

            // Añadir el ExpandableListView al contenedor
            container.addView(expandableListView);
        });
    }

    // Método para mostrar un ejemplo visual de cada propiedad de CardView
    private void showCardExample(String property) {
        container.removeAllViews();  // Limpiamos el contenedor antes de agregar el CardView
        CardView cardView = new CardView(this);
        cardView.setCardBackgroundColor(Color.WHITE);
        cardView.setPadding(30, 30, 30, 30);

        TextView textView = new TextView(this);
        textView.setText("Ejemplo de " + property);
        textView.setPadding(20, 20, 20, 20);
        textView.setTextColor(Color.BLACK);

        switch (property) {
            case "cardElevation":
                cardView.setCardElevation(15);
                textView.append("\nLa propiedad cardElevation eleva la tarjeta a 15dp.");
                break;
            case "cardCornerRadius":
                cardView.setRadius(25);
                textView.append("\nLa propiedad cardCornerRadius redondea las esquinas de la tarjeta con un radio de 25dp.");
                break;
            case "cardBackgroundColor":
                cardView.setCardBackgroundColor(Color.CYAN);
                textView.append("\nLa propiedad cardBackgroundColor cambia el color de fondo a Cyan.");
                break;
            case "cardMaxElevation":
                cardView.setMaxCardElevation(20);
                textView.append("\nLa propiedad cardMaxElevation establece la elevación máxima de la tarjeta a 20dp.");
                break;
            case "cardUseCompatPadding":
                cardView.setUseCompatPadding(true);
                textView.append("\nLa propiedad cardUseCompatPadding permite un padding adicional para compatibilidad.");
                break;
            case "cardPreventCornerOverlap":
                cardView.setPreventCornerOverlap(false);
                textView.append("\nLa propiedad cardPreventCornerOverlap desactiva la prevención del solapamiento de esquinas.");
                break;
            case "contentPadding":
                cardView.setContentPadding(50, 50, 50, 50);
                textView.append("\nLa propiedad contentPadding agrega padding alrededor del contenido de la tarjeta.");
                break;
            case "cardStateListAnimator":
                // Aquí puedes agregar una animación personalizada si lo deseas.
                textView.append("\nLa propiedad cardStateListAnimator permite la animación de la tarjeta en diferentes estados.");
                break;
            case "cardViewShape":
                // Aquí puedes aplicar un drawable personalizado si lo necesitas.
                textView.append("\nLa propiedad cardViewShape permite personalizar la forma de la tarjeta.");
                break;
            case "Click Elevation":
                cardView.setOnClickListener(v -> cardView.setCardElevation(30));
                textView.append("\nLa propiedad Click Elevation cambia la elevación cuando se hace clic.");
                break;
        }

        // Añadir el TextView y el CardView al contenedor
        cardView.addView(textView);
        container.addView(cardView);
    }

    // ExpandableListView adaptado para mostrar ejemplos literales de propiedades
    private void showExpandableListViewExample() {
        container.removeAllViews();  // Limpiamos el contenedor antes de agregar el ExpandableListView
        ExpandableListView expandableListView = new ExpandableListView(MainActivity.this);

        List<String> groups = new ArrayList<>();
        HashMap<String, List<String>> children = new HashMap<>();

        groups.add("Propiedades de ExpandableListView:");
        List<String> childList = new ArrayList<>();
        childList.add("divider: Se utiliza para mostrar un divisor entre los elementos.");
        childList.add("dividerHeight: Establece la altura del divisor entre los elementos.");
        childList.add("indicatorLeft: Define el indicador a la izquierda de los grupos.");
        childList.add("indicatorRight: Define el indicador a la derecha de los grupos.");
        childList.add("childIndicatorLeft: Define el indicador a la izquierda de los elementos hijos.");
        childList.add("childIndicatorRight: Define el indicador a la derecha de los elementos hijos.");
        childList.add("groupIndicator: Establece el indicador de grupo.");
        childList.add("itemIndicator: Establece el indicador de los ítems.");
        childList.add("itemHeight: Establece la altura de los ítems.");
        childList.add("groupIndicatorHeight: Establece la altura del indicador del grupo.");

        children.put(groups.get(0), childList);
        ExpandableListAdapter adapter = new ExpandableListAdapter(MainActivity.this, groups, children);
        expandableListView.setAdapter(adapter);

        // Añadir el ExpandableListView al contenedor
        container.addView(expandableListView);
    }
}
