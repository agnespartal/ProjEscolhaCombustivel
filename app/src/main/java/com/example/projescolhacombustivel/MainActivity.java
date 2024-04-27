package com.example.projescolhacombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtnValorEtanol;
    private EditText txtnValorGasolina;
    private TextView txtsResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnValorEtanol = findViewById(R.id.txtnValorEtanol);
        txtnValorEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtnValorGasolina = findViewById(R.id.txtnValorGasolina);
        txtnValorGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        txtsResultado = findViewById(R.id.txtsResultado)
        txtsResultado.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Button btnDescobrir = findViewById(R.id.btnResultado);

        btnDescobrir.setOnClickListener(op -> Descobrir());
    }

    private void Descobrir()
    {
        double fValorEtanol = Double.parseDouble(txtnValorEtanol.getText().toString());
        double fValorGasolina = Double.parseDouble(txtnValorGasolina.getText().toString());

        double fResultado = fValorGasolina * 0.7;

        String combustivel;
        if (fValorEtanol <= fResultado)
        {
            combustivel = getString(R.string.exibirResultado) + " Etanol";
        }
        else
        {
            combustivel = getString(R.string.exibirResultado) + " Gasolina";
        }
        txtsResultado.setText(combustivel);
    }
}