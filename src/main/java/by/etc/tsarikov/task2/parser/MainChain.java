package by.etc.tsarikov.task2.parser;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;

import java.util.List;

public interface MainChain {
    void setNextChain(MainChain textParser);

    TextComponentImpl dispense(List<String> list);
}
