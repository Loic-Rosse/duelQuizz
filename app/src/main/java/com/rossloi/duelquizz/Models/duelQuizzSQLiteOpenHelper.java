package com.rossloi.duelquizz.Models;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class duelQuizzSQLiteOpenHelper extends SQLiteOpenHelper {

        static String DB_NAME="SpeedQuiz.db";
        static int DB_VERSION=1;
        public duelQuizzSQLiteOpenHelper(Context context)
        {
            super(context,DB_NAME,null,DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlCreateDatatableQuiz = "CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY,question TEXT,reponse INTEGER);";
            db.execSQL(sqlCreateDatatableQuiz);
            db.execSQL("INSERT INTO quiz VALUES(1,\"Le joueur avec le plus de ballon d'or est Lionel Messi\",1)");
            db.execSQL("INSERT INTO quiz VALUES(2,\"Seprais est un village\",0)");
            db.execSQL("INSERT INTO quiz VALUES(3,\"Lewis Hamilton est le seul pilote avec 7 titres de champions du monde\",0)");
            db.execSQL("INSERT INTO quiz VALUES(4,\"Madrid est la capitale de l'Espagne\",1)");
            db.execSQL("INSERT INTO quiz VALUES(5,\"Sinalco est une boisson norvégienne\",0)");
            db.execSQL("INSERT INTO quiz VALUES(6,\"Bastien est mauvais à l'école\",1)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    }