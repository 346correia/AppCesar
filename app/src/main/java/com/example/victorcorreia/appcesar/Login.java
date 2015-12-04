package com.example.victorcorreia.appcesar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText edtLogin;
    private EditText edtSenha;
    private Button btnEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Aplicativo Cesar");
        setSupportActionBar(toolbar);


        edtLogin = (EditText)findViewById(R.id.edtLogin);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Ubuntu-R.ttf");
        edtLogin.setTypeface(font);
        edtSenha.setTypeface(font);
        btnEntrar.setTypeface(font);

        btnEntrar.setOnClickListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        String Login = new String("346correia@gmail.com");
        String Senha = new String("3");


        //if(edtLogin.getText().toString().equals(Login) && edtSenha.getText().toString().equals(Senha)){

        Intent it = new Intent(this, EscolhaAluno.class);
        startActivity(it);

        //}else{

        //    Toast toast = Toast.makeText(this, "Email e/ou Senha incorretos", Toast.LENGTH_SHORT);
        //    toast.show();

        // }
    }

}
