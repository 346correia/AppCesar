package com.example.victorcorreia.appcesar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class Horario extends AppCompatActivity implements View.OnClickListener{

    //private TextView txtNmAluno;
    private TextView txtSerie;
    private Button btnBackDia;
    private Button btnNextDia;
    private TextView txtDiaSemana;
    private TextView txtMateria1;
    private TextView txtMateria2;
    private TextView txtMateria3;
    private TextView txtMateria4;
    private String[] diaSemana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Horário de Aulas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //txtNmAluno = (TextView)findViewById(R.id.txtNmAluno);
        txtSerie   = (TextView)findViewById(R.id.txtSerie);
        btnBackDia = (Button)findViewById(R.id.btnBackDia);
        btnNextDia = (Button)findViewById(R.id.btnNextDia);
        txtDiaSemana = (TextView)findViewById(R.id.txtDiaSemana);
        txtMateria1 = (TextView)findViewById(R.id.txtMateria1);
        txtMateria2 = (TextView)findViewById(R.id.txtMateria2);
        txtMateria3 = (TextView)findViewById(R.id.txtMateria3);
        txtMateria4 = (TextView)findViewById(R.id.txtMateria4);

        /*Recupera o nome do aluno
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            txtNmAluno.setText(bundle.getString("NOME"));

        }

        //Fim: Recupera o nome do aluno*/

        txtSerie.setText("4º ano");

        diaSemana = new String[]{"Segunda","Terça","Quarta","Quinta","Sexta"};
        Calendar cal = Calendar.getInstance();
        int diaCorrente = cal.get(Calendar.DAY_OF_WEEK);

        if(diaCorrente==1){
            txtDiaSemana.setText(diaSemana[0]);
        }else if (diaCorrente==2){
            txtDiaSemana.setText(diaSemana[0]);
        }else if (diaCorrente==3){
            txtDiaSemana.setText(diaSemana[1]);
        }else if (diaCorrente==4){
            txtDiaSemana.setText(diaSemana[2]);
        }else if (diaCorrente==5){
            txtDiaSemana.setText(diaSemana[3]);
        }else if (diaCorrente==6){
            txtDiaSemana.setText(diaSemana[4]);
        }else if (diaCorrente==7) {
            txtDiaSemana.setText(diaSemana[0]);
        }

        if(txtDiaSemana.getText().toString()=="Segunda"){
            btnBackDia.setVisibility(View.INVISIBLE);
        }

        btnBackDia.setOnClickListener(this);
        btnNextDia.setOnClickListener(this);

        alteraMaterias();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){

            case R.id.btnBackDia:

                switch (txtDiaSemana.getText().toString()){
                    case "Segunda":


                        break;
                    case "Terça":

                        txtDiaSemana.setText("Segunda");
                        btnBackDia.setVisibility(View.INVISIBLE);

                        break;
                    case "Quarta":

                        txtDiaSemana.setText("Terça");

                        break;
                    case "Quinta":

                        txtDiaSemana.setText("Quarta");

                        break;
                    case "Sexta":

                        txtDiaSemana.setText("Quinta");
                        btnNextDia.setVisibility(View.VISIBLE);

                        break;
                }

                break;

            case R.id.btnNextDia:

                switch (txtDiaSemana.getText().toString()){
                    case "Segunda":

                        txtDiaSemana.setText("Terça");
                        btnBackDia.setVisibility(View.VISIBLE);

                        break;
                    case "Terça":

                        txtDiaSemana.setText("Quarta");

                        break;
                    case "Quarta":

                        txtDiaSemana.setText("Quinta");

                        break;
                    case "Quinta":

                        txtDiaSemana.setText("Sexta");
                        btnNextDia.setVisibility(View.INVISIBLE);

                        break;
                    case "Sexta":


                        break;
                }


                break;
        }

        alteraMaterias();

    }

    private void alteraMaterias() {

        switch (txtDiaSemana.getText().toString()) {

            case "Segunda":
                txtMateria1.setText("Português");
                txtMateria2.setText("Matemática");
                txtMateria3.setText("Recreio");
                txtMateria4.setText("História");
                break;
            case "Terça":
                txtMateria1.setText("Ciências");
                txtMateria2.setText("História");
                txtMateria3.setText("Recreio");
                txtMateria4.setText("Geografia");
                break;
            case "Quarta":
                txtMateria1.setText("Português");
                txtMateria2.setText("Matemática");
                txtMateria3.setText("Recreio");
                txtMateria4.setText("Geografia");
                break;
            case "Quinta":
                txtMateria1.setText("Ciências");
                txtMateria2.setText("História");
                txtMateria3.setText("Recreio");
                txtMateria4.setText("Geografia");
                break;
            case "Sexta":
                txtMateria1.setText("Português");
                txtMateria2.setText("Matemática");
                txtMateria3.setText("Recreio");
                txtMateria4.setText("Ed. Física");
                break;
        }

    }
}
