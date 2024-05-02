package com.fatec.zl.amos.aula_mobile_03_exe1;

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


    private EditText etEtanol;
    private EditText etGasolina;

    private TextView tvRes;
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
        etEtanol = findViewById(R.id.etEtanol);
        etEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etGasolina = findViewById(R.id.etGasolina);
        etGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());

    }
    private void calc(){
        float etanolPreco = Float.parseFloat(etEtanol.getText().toString());
        float gasolinaPreco = Float.parseFloat(etGasolina.getText().toString());

        float resultado = etanolPreco / gasolinaPreco;

        if (resultado <= 0.7) {
            tvRes.setText("Abasteça com Etanol!");
        } else {
            tvRes.setText("Abasteça com Gasolina!");
        }

        etGasolina.setText("");
        etEtanol.setText("");
    }




}