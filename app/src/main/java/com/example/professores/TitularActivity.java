package com.example.professores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.professores.model.Professor;
import com.example.professores.model.ProfessorTitular;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TitularActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */

    private ProfessorTitular prof = new ProfessorTitular();
    private EditText edAnosInstituicao;
    private EditText edSalario;
    private Button btnCalc;

    private TextView txtSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titular);

        btnCalc = findViewById(R.id.btnCalc);
        edAnosInstituicao = findViewById(R.id.edAnos);
        edSalario = findViewById(R.id.edSalario);
        txtSaida = findViewById(R.id.txtSaida);
        btnCalc.setOnClickListener(op -> exibir());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        prof.setNome(bundle.getString("nome"));
        prof.setMatricula(bundle.getString("matricula"));
        prof.setIdade(bundle.getInt("idade"));
        Button btnVoltar = findViewById(R.id.button);
        btnVoltar.setOnClickListener(op -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
    private void exibir() {
        prof.setAnosInstituicao(Integer.parseInt(String.valueOf(edAnosInstituicao.getText())));
        prof.setSalario(Double.parseDouble(String.valueOf(edSalario.getText())));
        double salario = prof.calcSalario();
        BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.CEILING);
        txtSaida.setText("Professor Titular: \nMatrícula: "+ prof.getMatricula()+ "\nR$" + sal);

    }
}