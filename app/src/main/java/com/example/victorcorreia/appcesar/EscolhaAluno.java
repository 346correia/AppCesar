package com.example.victorcorreia.appcesar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EscolhaAluno extends AppCompatActivity implements View.OnClickListener {

    //private ListView lstAlunos;
    private TextView txtAluno1;
    private TextView txtAluno2;
    private TextView txtAluno3;
    private TextView txtAluno4;
    private TextView txtAluno5;
    private View lineAluno2e3;
    private View lineAluno3e4;
    private View lineAluno4e5;
    private View lineAluno5end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Selecione o Aluno");
        setSupportActionBar(toolbar);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        String[] arrayAlunos = new String[]{"Gabriela da Costa Machado","Felipe da Costa Machado","","",""};

        txtAluno1 = (TextView)findViewById(R.id.txtAluno1);
        txtAluno2 = (TextView)findViewById(R.id.txtAluno2);
        txtAluno3 = (TextView)findViewById(R.id.txtAluno3);
        txtAluno4 = (TextView)findViewById(R.id.txtAluno4);
        txtAluno5 = (TextView)findViewById(R.id.txtAluno5);
        lineAluno2e3 = (View)findViewById(R.id.line_aluno_2_3);
        lineAluno3e4 = (View)findViewById(R.id.line_aluno_3_4);
        lineAluno4e5 = (View)findViewById(R.id.line_aluno_4_5);
        lineAluno5end = (View)findViewById(R.id.line_aluno_5_end);

        txtAluno1.setText(arrayAlunos[0]);
        txtAluno2.setText(arrayAlunos[1]);
        txtAluno3.setText(arrayAlunos[2]);
        txtAluno4.setText(arrayAlunos[3]);
        txtAluno5.setText(arrayAlunos[4]);

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Ubuntu-R.ttf");
        txtAluno1.setTypeface(font);
        txtAluno2.setTypeface(font);
        txtAluno3.setTypeface(font);
        txtAluno4.setTypeface(font);
        txtAluno5.setTypeface(font);

        txtAluno1.setOnClickListener(this);
        txtAluno2.setOnClickListener(this);
        txtAluno3.setOnClickListener(this);
        txtAluno4.setOnClickListener(this);
        txtAluno5.setOnClickListener(this);

        if(arrayAlunos[1]==""){
            Intent it;
            it = new Intent(this, Menu.class);
            it.putExtra("NOME", txtAluno1.getText().toString());
            lineAluno2e3.setVisibility(View.INVISIBLE);
            lineAluno3e4.setVisibility(View.INVISIBLE);
            lineAluno4e5.setVisibility(View.INVISIBLE);
            lineAluno5end.setVisibility(View.INVISIBLE);
            startActivity(it);
        }else if (arrayAlunos[2]==""){
            lineAluno3e4.setVisibility(View.INVISIBLE);
            lineAluno4e5.setVisibility(View.INVISIBLE);
            lineAluno5end.setVisibility(View.INVISIBLE);
        }else if (arrayAlunos[3]==""){
            lineAluno4e5.setVisibility(View.INVISIBLE);
            lineAluno5end.setVisibility(View.INVISIBLE);
        }else if (arrayAlunos[4]==""){
            lineAluno5end.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Encerrar Sessão");
        builder.setMessage("Deseja realmente sair?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    @Override
    public void onClick(View v) {

        Intent it;

        switch (v.getId()){
            case R.id.txtAluno1:
                if(txtAluno1.getText().toString().equals("")==false) {
                    it = new Intent(this, Menu.class);
                    it.putExtra("NOME", txtAluno1.getText().toString());
                    startActivity(it);
            }
                break;

            case R.id.txtAluno2:
                if(txtAluno2.getText().toString().equals("")==false) {
                    it = new Intent(this, Menu.class);
                    it.putExtra("NOME", txtAluno2.getText().toString());
                    startActivity(it);
                }
                break;

            case R.id.txtAluno3:
                if(txtAluno3.getText().toString().equals("")==false) {
                    it = new Intent(this, Menu.class);
                    it.putExtra("NOME", txtAluno3.getText().toString());
                    startActivity(it);
                }
                break;

            case R.id.txtAluno4:
                if(txtAluno4.getText().toString().equals("")==false) {
                    it = new Intent(this, Menu.class);
                    it.putExtra("NOME", txtAluno4.getText().toString());
                    startActivity(it);
                }
                break;

            case R.id.txtAluno5:
                if(txtAluno5.getText().toString().equals("")==false) {
                    it = new Intent(this, Menu.class);
                    it.putExtra("NOME", txtAluno5.getText().toString());
                    startActivity(it);
                }
                break;
        }

    }
}