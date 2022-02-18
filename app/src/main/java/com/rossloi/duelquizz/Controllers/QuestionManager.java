package com.rossloi.duelquizz.Controllers;

import android.content.Context;

import com.rossloi.duelquizz.Models.Question;

import java.util.List;
import java.util.Random;

public class QuestionManager {

    private List<Question> questionList;

    /**
     * Constructeur de classe qui initialise une nouvelle liste de questions
     * @param context Contexte d'application
     */
    public QuestionManager(Context context){
        questionList = initQuestionList(context);
    }

    /**
     * Retourne une arrayList d'index de questions déjà posées
     * @return Une Array List <Integer>*/
    public List<Question> getQuestionList() {
        return questionList;
    }

    /**
     * Sélectionne la question à poser et la retire de la liste des questions
     * @param questionList ArrayList de questions
     * @return un objet Question
     */
    public Question getRandomQuestion(List<Question> questionList){

    int randomIndex = getQuestionIndex(questionList);
    Question question = questionList.get(randomIndex);

    questionList.remove(randomIndex);

    return question;
    }

    /**
     * Génère un indey aléatoire pour choisir une question
     * @return un nombre entier
     */
    private int getQuestionIndex(List<Question> questionList){
        Random rand = new Random();
        return rand.nextInt(questionList.size());
    }

    /**
     * Renvoi vrai si toutes les questions ont été posées
     * @param questionList Une arraylist de questions
     * @return Une valeur boolean
     */
    public boolean isLastQuestion(List<Question> questionList){
       if (questionList.isEmpty()){
           return true;
       }
       return false;
    }

    /**
     * Initialise la liste des questions de manière static
     * @param questionList Tableaux a deux dimensions pour la liste des questions
     */
    private void initQuestionList(List<Question> questionList){
        questionList.add(new Question("Le joueur avec le plus de ballon d'or est Lionel Messi", 1));
        questionList.add(new Question("Seprais est un village", 0));
        questionList.add(new Question("Lewis Hamilton est le seul pilote avec 7 titres de champions du monde", 0));
        questionList.add(new Question("Madrid est la capitale de l'Espagne", 1));
        questionList.add(new Question("Sinalco est une boisson norvégienne", 0));
        questionList.add(new Question("Bastien est mauvais à l'école", 1));

    }

}
