package com.csto.terceraprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class resultados extends AppCompatActivity {

    Button BTN_VOLVER;
    TextView TV_NULO, TV_BLANCO, TV_BORIC, TV_KAST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        BTN_VOLVER=(Button) findViewById(R.id.btn_volver);
        TV_NULO=(TextView) findViewById(R.id.textView_nulo);
        TV_BLANCO=(TextView) findViewById(R.id.textView_blanco);
        TV_BORIC=(TextView) findViewById(R.id.textView_boric);
        TV_KAST=(TextView) findViewById(R.id.textView_kast);

        Integer totalblancos=0, totalnulos=0, totalboric=0, totalkast=0;

        SQLiteDatabase db;
        Dbhelper conn =new Dbhelper(getApplicationContext());
        db =conn.getReadableDatabase();
        Cursor C = db.query("votos",null,null, null, null, null, null);
        if(C!=null){
            if (C.moveToFirst())
            {
                do {
                    if (C.getString(2).equals("voto_nulo")) {
                        totalnulos++;
                    }
                    if (C.getString(2).equals("voto_boric")) {
                        totalboric++;
                    }
                    if (C.getString(2).equals("voto_kast")) {
                        totalkast++;
                    }
                    if (C.getString(2).equals("voto_blaco")) {
                        totalblancos++;
                    }

                }while (C.moveToNext());
            }
        }
        TV_NULO.setText((""+totalnulos));
        TV_BLANCO.setText((""+totalblancos));
        TV_BORIC.setText((""+totalboric));
        TV_KAST.setText((""+totalkast));

        BTN_VOLVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

    }
}