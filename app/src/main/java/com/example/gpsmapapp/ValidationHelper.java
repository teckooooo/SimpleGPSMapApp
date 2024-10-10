package com.example.gpsmapapp;

import java.util.regex.Pattern;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class ValidationHelper {

    private Context context;

    // Constructor que recibe el contexto para mostrar el Toast
    public ValidationHelper(Context context) {
        this.context = context;
    }

    // Método para validar la entrada del usuario
    public boolean isValidInput(EditText inputField) {
        String input = inputField.getText().toString();
        String regex = "^[a-zA-Z0-9_]*$";  // Expresión regular para caracteres permitidos
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(input).matches()) {
            return true;
        } else {
            // Muestra un mensaje de error si la entrada no es válida
            Toast.makeText(context, "Entrada no válida", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
