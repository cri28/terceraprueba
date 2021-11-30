package com.csto.terceraprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper  extends SQLiteOpenHelper {
    public static String Nombre_BD= "votaciones.db";
    public static int Version_DB=1;
    public static String Tabla_voto= "create table voto (id_voto Integer  primary key autoincrement, voto_blaco Integer, voto_nulo Integer, voto_boric Integer, voto_kast Integer)";

    public Dbhelper(@Nullable Context context) {
        super(context, Nombre_BD, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_voto);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists voto");
        sqLiteDatabase.execSQL(Tabla_voto);

    }
}
