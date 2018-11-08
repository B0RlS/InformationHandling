package by.etc.tsarikov.task2.parser;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.parser.MainChain;
import by.etc.tsarikov.task2.parser.impl.LexemeChain;
import by.etc.tsarikov.task2.parser.impl.ParagraphChain;
import by.etc.tsarikov.task2.parser.impl.SentenseChain;

import java.util.List;

public interface ConstructChain {
    public static TextComponentImpl take (List<String> list) {

        MainChain paragraph = new ParagraphChain();
        MainChain sentense = new SentenseChain();
        MainChain lexeme = new LexemeChain();

        sentense.setNextChain(lexeme);
        paragraph.setNextChain(sentense);

        return paragraph.dispense(list);
    }
}
