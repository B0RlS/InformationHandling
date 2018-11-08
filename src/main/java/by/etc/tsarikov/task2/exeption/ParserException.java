package by.etc.tsarikov.task2.exeption;

import java.io.Serializable;

public class ParserException extends Exception implements Serializable {

    private static final long serialVersionUID = 8829411164590089640L;

    public ParserException(){
        super();
    }
    public ParserException(String message){
        super(message);
    }
    public ParserException(Exception e){
        super(e);
    }
    public ParserException(String message, Exception e){
        super(message, e);
    }
}
