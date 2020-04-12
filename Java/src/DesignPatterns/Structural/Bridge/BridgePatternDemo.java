package DesignPatterns.Structural.Bridge;

public class BridgePatternDemo {
    public static void main(String[] args){
        QuestionFormat question = new QuestionFormat("Java Question");
        question.q = new JavaQuestions();
        question.delete("What is class? ");
        question.displayAll();
    }
}
