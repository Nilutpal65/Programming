package DesignPatterns.Structural.Bridge;

import java.io.StringReader;

public class QuestionManager {
    protected Question q;
    public String catalog;
    public QuestionManager(String catalog) {
        this.catalog = catalog;
    }
    public void next(){
        q.nextQuestion();
    }
    public void previous(){
        q.previousQuestion();
    }
    public void newOne(String quest){
        q.newQuestion(quest);
    }
    public void delete(String quest){
        q.deleteQuestion(quest);
    }
    public void display(){
        q.displayQuestion();
    }
    public void displayAll(){
        System.out.println(catalog);
        q.displayAllQuestions();
    }
}
