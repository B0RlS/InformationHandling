package by.etc.tsarikov.task2.reader;

import by.etc.tsarikov.task2.exeption.ReaderException;

import java.util.List;

public interface ReadInformation {

    List<String> take(String uri) throws ReaderException;
}
