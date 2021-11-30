package com.csto.terceraprueba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup RADIO_GROUP;
    RadioButton RB_NULO, RB_BORIC, RB_KAST;
    Button BTN_VOTAR, BTN_RESULTADOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RADIO_GROUP = (RadioGroup) findViewById(R.id.radio_group);
        RB_NULO = (RadioButton) findViewById(R.id.radioButton_nulo);
        RB_BORIC = (RadioButton) findViewById(R.id.radioButton_boric);
        RB_KAST = (RadioButton) findViewById(R.id.radioButton_kast);
        BTN_VOTAR = (Button) findViewById(R.id.btn_votar);
        BTN_RESULTADOS = (Button) findViewById(R.id.btn_resultados);

        BTN_VOTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RB_NULO.isChecked()) {
                    AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿desea continuar votando EN BLANCO?").setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"VOTO REGISTRADO", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.create();
                    builder.show();
                }
            }
        });


    }
}