package by.etc.tsarikov.task2.exeption;

import java.io.Serializable;

public class ReaderException extends Exception implements Serializable {

    private static final long serialVersionUID = 1135261835440714762L;

    public ReaderException() {
        super();
    }

    public ReaderException (Exception exception) {
        super(exception);
    }

    public ReaderException (String message , Exception exception) {
        super(message,exception);
    }

    public ReaderException (String message) {
        super(message);
    }
}