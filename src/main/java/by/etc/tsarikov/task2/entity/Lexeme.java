package by.etc.tsarikov.task2.entity;

import java.io.Serializable;

public class Lexeme implements Serializable {
    private static final long serialVersionUID = -581221314946601618L;
    private String lexeme;

    public Lexeme(){}
    public Lexeme(String lexeme){
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        if(this.lexeme == null){
            if(lexeme.lexeme != null){
                return false;
            }
        }
        else{
            if(!lexeme.equals(lexeme.lexeme)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(31 + ((lexeme == null) ? 0 : lexeme.hashCode()));
    }

    @Override
    public String toString() {
        return  getClass().getName()  + lexeme ;
    }
}
