package by.etc.tsarikov.task2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Serializable {
    private static final long serialVersionUID = -1865076916301796394L;
    private List<Sentence> paragraph = new ArrayList<>();

    public Paragraph(){}
    public Paragraph(List<Sentence> paragraph){
        this.paragraph = paragraph;
    }

    public List<Sentence> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<Sentence> paragraph) {
        this.paragraph = paragraph;
    }

    public void addSentence(Sentence sentence){
        this.paragraph.add(sentence);
    }

    public void removeSentence(Paragraph sentence){
        paragraph.remove(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paragraph paragraph = (Paragraph) o;
        if(this.paragraph == null){
            if(paragraph.paragraph != null){
                return false;
            }
        }
        else{
            if(!paragraph.equals(paragraph.paragraph)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 + ((paragraph == null) ? 0 : paragraph.hashCode()));
    }

    @Override
    public String toString() {
        return  getClass().getName() + "Paragraph{" + paragraph + '}';
    }
}
