package com.example.professores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.professores.model.ProfessorHorista;
import com.example.professores.model.ProfessorTitular;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HoristaActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */
    private ProfessorHorista prof = new ProfessorHorista();
    private EditText edValorHora;
    private EditText edHoraAula;
    private Button btnCalc;
    private TextView txtSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horista);

        btnCalc = findViewById(R.id.btnCalc);
        edHoraAula = findViewById(R.id.edHoraAula);
        edValorHora = findViewById(R.id.edValorHora);

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
        prof.setHorasAula(Integer.parseInt(String.valueOf(edHoraAula.getText())));
        prof.setValorHoraAula(Double.parseDouble(String.valueOf(edValorHora.getText())));
        double salario = prof.calcSalario();
        BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.CEILING);
        txtSaida.setText("Professor Horista: \nMatrícula: "+ prof.getMatricula()+ "\nR$" + sal);

    }

}