package by.etc.tsarikov.task2.parser.impl;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.interpreter.Context;
import by.etc.tsarikov.task2.parser.MainChain;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class LexemeChain implements MainChain {

    private static final String EMPTY_STRING = "";
    private static final String REG_EXP = " ";
    private static final String POINT = ".";
    private static final String CALCULATION = "^[1-9(][1-9(><|&].+$";
    private static final Context context = new Context();

    @Override
    public void setNextChain(MainChain textParser) {

    }

    @Override
    public TextComponentImpl dispense(List<String> list) {
        return null;
    }
}
