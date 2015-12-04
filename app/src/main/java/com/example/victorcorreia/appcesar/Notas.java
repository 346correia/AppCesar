package com.example.victorcorreia.appcesar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Notas extends AppCompatActivity implements View.OnClickListener{

    //private TextView txtNomeNotas;
    private ListView lstMateria;
    private ListView lstNota;
    private TextView txtAvaliacao;
    private Button   btnAvalVoltar;
    private Button   btnAvalAvancar;
    private int nAv = 4;
    private int nMt = 6;
    private float media = 7;
    private String[] arrayMateria;
    private String[] arrayNota;
    private ArrayAdapter<String> adapterMateria;
    private ArrayAdapter<String> adapterNota;
    private float[][] nota = new float[nAv][nMt];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Notas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //txtNomeNotas = (TextView)findViewById(R.id.txtNomeNotas);
        lstMateria     = (ListView)findViewById(R.id.lstMateria);
        lstNota        = (ListView)findViewById(R.id.lstNota);
        txtAvaliacao    = (TextView)findViewById(R.id.txtAvaliacao);
        btnAvalVoltar   = (Button)findViewById(R.id.btnAvalVoltar);
        btnAvalAvancar  = (Button)findViewById(R.id.btnAvalAvancar);

        /*Recupera o nome do aluno
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){

            txtNomeNotas.setText(bundle.getString("NOME"));

        }
        /Fim: Recupera o nome do aluno*/

        //Seta os botões

        btnAvalVoltar.setOnClickListener(this);
        btnAvalAvancar.setOnClickListener(this);

        //Fim: Seta os botões

        arrayMateria  = new String[]{"Português", "Matemática", "História", "Geografia", "Ciências", "Ed. Física"};
        arrayNota  = new String[6];

        nota[0][0] = (float) 8.0;
        nota[0][1] = (float) 7.0;
        nota[0][2] = (float) 8.5;
        nota[0][3] = (float) 7.5;
        nota[0][4] = (float) 9.0;
        nota[0][5] = (float) 10.0;
        //nota[0][6] = ;
        //nota[0][7] = ;
        //nota[0][8] = ;
        //nota[0][9] = ;

        nota[1][0] = (float) 5.5;
        nota[1][1] = (float) 8.5;
        nota[1][2] = (float) 6.0;
        nota[1][3] = (float) 10.0;
        nota[1][4] = (float) 7.0;
        nota[1][5] = (float) 10.0;
        //nota[0][6] = ;
        //nota[0][7] = ;
        //nota[0][8] = ;
        //nota[0][9] = ;


        adapterMateria = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayMateria);
        lstMateria.setAdapter(adapterMateria);

        txtAvaliacao.setText("1ª Avaliação");

        if(txtAvaliacao.getText().toString()=="1ª Avaliação"){
            btnAvalVoltar.setVisibility(View.INVISIBLE);
        }

        alteraAvaliacao();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnAvalVoltar:

                switch (txtAvaliacao.getText().toString()){
                    case "1ª Avaliação":

                        break;
                    case "2ª Avaliação":

                        txtAvaliacao.setText("1ª Avaliação");
                        btnAvalVoltar.setVisibility(View.INVISIBLE);

                        break;
                    case "3ª Avaliação":

                        txtAvaliacao.setText("2ª Avaliação");

                        break;
                    case "4ª Avaliação":

                        txtAvaliacao.setText("3ª Avaliação");
                        btnAvalAvancar.setVisibility(View.VISIBLE);

                        break;
                }

                break;

            case R.id.btnAvalAvancar:

                switch (txtAvaliacao.getText().toString()){
                    case "1ª Avaliação":

                        txtAvaliacao.setText("2ª Avaliação");
                        btnAvalVoltar.setVisibility(View.VISIBLE);

                        break;
                    case "2ª Avaliação":

                        txtAvaliacao.setText("3ª Avaliação");

                        break;
                    case "3ª Avaliação":

                        txtAvaliacao.setText("4ª Avaliação");
                        btnAvalAvancar.setVisibility(View.INVISIBLE);

                        break;
                    case "4ª Avaliação":


                        break;
                }


                break;
        }

        alteraAvaliacao();

    }

    public void alteraAvaliacao(){

        switch (txtAvaliacao.getText().toString()) {

            case "1ª Avaliação":
                alteraNota(0);
                break;
            case "2ª Avaliação":
                alteraNota(1);
                break;
            case "3ª Avaliação":
                alteraNota(2);
                break;
            case "4ª Avaliação":
                alteraNota(3);
                break;
        }

        adapterNota = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayNota);
        lstNota.setAdapter(adapterNota);

    }

    public void alteraNota(int i){

        int j,n,nVazios = 0;
        String mediaRestante;

        for(j=0; j<nMt; j++ ){

            if(nota[i][j]!= 0) {

                arrayNota[j] = String.valueOf(nota[i][j]);

            }else{

                for(n=0; n<4; n++){

                    if(nota[n][j]==0){

                        nVazios++;

                    }
                }
                DecimalFormat df = new DecimalFormat("##.#");
                df.setRoundingMode(RoundingMode.UP);
                mediaRestante = df.format(((media*nAv)-(nota[0][j]+nota[1][j]+nota[2][j]+nota[3][j]))/nVazios);
                arrayNota[j] = "Precisa de "+mediaRestante;
                nVazios = 0;
            }
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
