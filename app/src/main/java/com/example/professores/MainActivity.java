package com.example.professores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.professores.model.Professor;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */

    private EditText edNome;
    private EditText edMatricula;
    private EditText edIdade;
    private RadioButton rbHorista;
    private RadioButton rbTitular;
    private Button btnCalc;

    private Professor prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnProx);
        edNome = findViewById(R.id.edNome);
        edIdade = findViewById(R.id.edIdade);
        edMatricula = findViewById(R.id.edMatricula);
        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbHorista);
        rbHorista.setChecked(false);
        
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {

        String nome = edNome.getText().toString();
        String matricula = edMatricula.getText().toString();
        int idade = Integer.parseInt(String.valueOf(edIdade.getText()));
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("matricula", matricula);
        bundle.putInt("idade", idade);

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i;
        if(rbTitular.isChecked()){
            i = new Intent(this, TitularActivity.class);
        } else{
            i = new Intent(this, HoristaActivity.class);
        }
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}