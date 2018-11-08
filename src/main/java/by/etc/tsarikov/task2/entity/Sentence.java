package by.etc.tsarikov.task2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements Serializable {
    private static final long serialVersionUID = -2113377245357375455L;
    private List<Lexeme> sentence = new ArrayList<>();

    public Sentence(){}
    public Sentence(List<Lexeme> sentence){
        this.sentence = sentence;
    }

    public List<Lexeme> getSentence() {
        return sentence;
    }

    public void setSentence(List<Lexeme> sentence) {
        this.sentence = sentence;
    }

    public void addLexeme(Lexeme lexeme){
        this.sentence.add(lexeme);
    }

    public void removeLexeme(Lexeme lexeme){
        sentence.remove(lexeme);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) o;
        if(this.sentence == null){
            if(sentence.sentence != null){
                return false;
            }
        }
        else{
            if(!sentence.equals(sentence.sentence)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 + ((sentence == null) ? 0 : sentence.hashCode()));
    }

    @Override
    public String toString() {
        return  getClass().getName() + sentence;
    }
}
