package com.example.victorcorreia.appcesar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private TextView txtNomeMenu;
    private TextView txtNotas;
    private TextView txtHorario;
    private TextView txtCalendario;
    private TextView txtBoleto;
    private TableRow trHorario;
    private TableRow trCalendario;
    private TableRow trBoleto;
    private TableRow trNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        toolbar.setSubtitle("Selecione a opção desejada:");
        //toolbar.setLogo(R.mipmap.ic_launcher);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        txtNotas = (TextView)findViewById(R.id.txtNotas);
        txtHorario = (TextView)findViewById(R.id.txtHorario);
        txtCalendario = (TextView)findViewById(R.id.txtCalendario);
        txtBoleto = (TextView)findViewById(R.id.txtBoleto);

        trNotas = (TableRow)findViewById(R.id.trNotas);
        trHorario = (TableRow)findViewById(R.id.trHorario);
        trCalendario = (TableRow)findViewById(R.id.trCalendario);
        trBoleto = (TableRow)findViewById(R.id.trBoleto);
        txtNomeMenu = (TextView)findViewById(R.id.txtNomeMenu);

        Typeface fontR = Typeface.createFromAsset(getAssets(),"fonts/Ubuntu-R.ttf");
        //Typeface fontB = Typeface.createFromAsset(getAssets(),"fonts/Ubuntu-B.ttf");
        txtNotas.setTypeface(fontR);
        txtHorario.setTypeface(fontR);
        txtCalendario.setTypeface(fontR);
        txtBoleto.setTypeface(fontR);
        txtNomeMenu.setTypeface(fontR);

        trNotas.setOnClickListener(this);
        trHorario.setOnClickListener(this);
        trCalendario.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            txtNomeMenu.setText(bundle.getString("NOME"));

        }
    }

    @Override
    public void onClick(View v) {

        Intent it;

        switch (v.getId()) {

            case R.id.trNotas:
                it = new Intent(this, Notas.class);
                it.putExtra("NOME", txtNomeMenu.getText().toString());
                startActivity(it);
                break;

            case R.id.trHorario:
                it = new Intent(this, Horario.class);
                it.putExtra("NOME", txtNomeMenu.getText().toString());
                startActivity(it);
                break;

            case R.id.trCalendario:
                it = new Intent(this, Calendario.class);
                it.putExtra("NOME", txtNomeMenu.getText().toString());
                startActivity(it);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

}
