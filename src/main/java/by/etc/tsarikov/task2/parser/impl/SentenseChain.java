package by.etc.tsarikov.task2.parser.impl;

import by.etc.tsarikov.task2.component.impl.LexemeComponentImpl;
import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.parser.MainChain;

import java.util.ArrayList;
import java.util.List;

public class SentenseChain implements MainChain {

    private MainChain chain;

    private final static String REG_EXP = "[.?!]\\s*";
    private static final String EMPTY_STRING = "";
    private static final String NEXTLINE_STRING = "\n";


    @Override
    public void setNextChain(MainChain textParser) {
        chain = textParser;
    }

    @Override
    public TextComponentImpl dispense(List<String> list) {
        TextComponentImpl partText = new TextComponentImpl();

        String text = EMPTY_STRING;
        for (String str : list) {
            text += str;
        }
        String[] sentenseArray = text.split(REG_EXP);
        for (int i=0;i<sentenseArray.length;i++) {
            ArrayList<String> listWords = new ArrayList<>();
            listWords.add(sentenseArray[i]);
            partText.add(chain.dispense(listWords));
        }

        partText.add(new LexemeComponentImpl(NEXTLINE_STRING));
        return partText;
    }
}
