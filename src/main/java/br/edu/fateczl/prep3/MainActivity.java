package br.edu.fateczl.prep3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int intervalo1 = 0;
    private int intervalo2 = 0;
    private int intervalo3 = 0;
    private int intervalo4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNumero = findViewById(R.id.editTextNumero);
        Button buttonAdicionar = findViewById(R.id.buttonAdicionar);
        Button buttonLimpar = findViewById(R.id.buttonLimpar);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        buttonAdicionar.setOnClickListener(v -> {
            String inputText = editTextNumero.getText().toString();

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Digite um número", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int numero = Integer.parseInt(inputText);

                if (numero == 0) {
                    mostrarResultado(textViewResultado);
                    editTextNumero.setText("");
                    return;
                }

                if (numero >= 1 && numero <= 25) {
                    intervalo1++;
                } else if (numero >= 26 && numero <= 50) {
                    intervalo2++;
                } else if (numero >= 51 && numero <= 75) {
                    intervalo3++;
                } else if (numero >= 76 && numero <= 100) {
                    intervalo4++;
                } else {
                    Toast.makeText(this, "Número fora dos intervalos (1-100)", Toast.LENGTH_SHORT).show();
                    editTextNumero.setText("");
                    return;
                }

                Toast.makeText(this, "Número " + numero + " adicionado!", Toast.LENGTH_SHORT).show();
                editTextNumero.setText("");

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite um número válido", Toast.LENGTH_SHORT).show();
            }
        });

        buttonLimpar.setOnClickListener(v -> {
            intervalo1 = 0;
            intervalo2 = 0;
            intervalo3 = 0;
            intervalo4 = 0;

            textViewResultado.setText("Resultados aparecerão aqui");
            editTextNumero.setText("");

            Toast.makeText(this, "Contadores zerados", Toast.LENGTH_SHORT).show();
        });
    }

    private void mostrarResultado(TextView textView) {
        String resultado =
                "RESULTADOS:\n\n" +
                        "[1-25]: " + intervalo1 + " números\n" +
                        "[26-50]: " + intervalo2 + " números\n" +
                        "[51-75]: " + intervalo3 + " números\n" +
                        "[76-100]: " + intervalo4 + " números\n\n" +
                        "Total: " + (intervalo1 + intervalo2 + intervalo3 + intervalo4) + " números";

        textView.setText(resultado);
    }
}
