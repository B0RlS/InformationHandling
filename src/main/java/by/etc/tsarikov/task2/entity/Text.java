package by.etc.tsarikov.task2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Serializable {
    private static final long serialVersionUID = -1951383773589681351L;
    private List<Paragraph> text = new ArrayList<>();

    public Text(){}
    public Text(List<Paragraph> test){
        this.text = test;
    }

    public List<Paragraph> getText() {
        return text;
    }

    public void setText(List<Paragraph> text) {
        this.text = text;
    }

    public void addParagraph(Paragraph paragraph){
        this.text.add(paragraph);
    }

    public void removeParagraph(Paragraph paragraph){
        text.remove(paragraph);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        if(this.text == null){
            if(text.text != null){
                return false;
            }
        }
        else{
            if(!text.equals(text.text)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 + ((text == null) ? 0 : text.hashCode()));
    }

    @Override
    public String toString() {
        return  getClass().getName() + "Version{" + text + '}';
    }
}

