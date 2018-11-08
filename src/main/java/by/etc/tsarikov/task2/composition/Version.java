package by.etc.tsarikov.task2.composition;

import by.etc.tsarikov.task2.action.Iterator;

import java.util.List;

public interface Version {
    Iterator getIterator();

    void add(Version paragraph);

    void remove(Version paragraph);

    Version getElement(int index);

    void parse();
}
