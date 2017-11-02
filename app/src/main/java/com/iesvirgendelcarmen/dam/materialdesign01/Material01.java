package com.iesvirgendelcarmen.dam.materialdesign01;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Material01 extends AppCompatActivity {

    private TextInputLayout controlNombre;
    private EditText campoNombre;
    public Button botonAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material01);

        botonAceptar = (Button) findViewById(R.id.boton_aceptar);


        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });

        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                controlNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private boolean esNombreValido(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z]+$");

        if(!patron.matcher(nombre).matches()||nombre.length()>30){
            controlNombre.setError("ERROR EN NOMBRE");
            return false;
        }else{
            controlNombre.setError(null);
        }
        return true;
    }

    private void validarDatos(){
        String nombre = controlNombre.getEditText().getText().toString();
        boolean a = esNombreValido(nombre);
        if(a){
            Toast.makeText(this,"REGISTRO CORRECTO",Toast.LENGTH_LONG).show();
        }
    }

}
