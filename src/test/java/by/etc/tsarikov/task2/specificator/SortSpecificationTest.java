package by.etc.tsarikov.task2.specificator;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.exeption.ReaderException;
import by.etc.tsarikov.task2.parser.ConstructChain;
import by.etc.tsarikov.task2.reader.impl.ReaderImpl;
import by.etc.tsarikov.task2.specification.impl.SortByLexeme;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.awt.*;


public class SortSpecificationTest {
    static final String STANDART_URI = "resources/text.txt";
    static final String FIRST_SORT__URI = "resources/testing.txt";


    TextComponentImpl create (String uri) throws ReaderException {
        TextComponentImpl text = ConstructChain.take(new ReaderImpl().take(uri));
        return text;
    }

    @Test
    void defaultSortBySymbol() throws ReaderException, IOException {
        TextComponentImpl standardComponent = create(STANDART_URI);
        List<String> list = Files.readAllLines(Paths.get(FIRST_SORT__URI));

        String text ="";

        for (String str:list) {
            text +=str;
        }
        standardComponent.sort(new SortByLexeme('a'));


        Assert.assertNotEquals(standardComponent.take(),text);
    }
}
