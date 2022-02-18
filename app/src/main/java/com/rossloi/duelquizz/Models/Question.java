package com.rossloi.duelquizz.Models;

import android.annotation.SuppressLint;
import android.database.Cursor;

/**
 * Classe qui représente une question
 */
public class Question {

    private String question;

    private int reponse;

    public Question(){};

    /**
     * Constructeur de la classe
     * @param question la question
     * @param reponse la réponse
     */
    public Question(String question, int reponse){
        this.question = question;
        this.reponse = reponse;
    }

    @SuppressLint("Range")
    public Question(Cursor cursor){
        question = cursor.getString(cursor.getColumnIndex("question"));
        reponse = cursor.getInt(cursor.getColumnIndex("reponse"));
    }

    public String getQuestion(){
        return question;
    }

    public int isReponse(){
        return reponse;
    }
}
