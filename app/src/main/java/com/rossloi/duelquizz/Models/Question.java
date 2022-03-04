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

    // Curseur = tableau
    public Question(Cursor cursor){
        question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }

    public String getQuestion(){
        return question;
    }

    /**
     * donne la réponse de la question
     *
     * @return la reponse de la question( 0 = faux, 1 = vrai)
     */
    public int getReponse() {
        return reponse;
    }
}
