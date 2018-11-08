package by.etc.tsarikov.task2.parser.impl;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.parser.MainChain;

import java.util.ArrayList;
import java.util.List;

public class ParagraphChain implements MainChain {

    private MainChain chain;

    private static final String REGEX_EXP= "\t";
    private static final String EMPTY_STRING ="";


    @Override
    public void setNextChain(MainChain textParser) {
        this.chain = textParser;
    }

    @Override
    public TextComponentImpl dispense(List<String> list) {
        TextComponentImpl mainText = new TextComponentImpl();
        String text = EMPTY_STRING;
        for (String str : list) {
            text += str;
        }

        String[] partArray = text.split(REGEX_EXP);
        for (int i=1;i<partArray.length;i++) {
            List<String> listPart = new ArrayList<>();
            String string = partArray[i];
            listPart.add(string);
            mainText.add(chain.dispense(listPart));
        }
        return mainText;
    }
}
