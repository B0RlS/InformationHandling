package by.etc.tsarikov.task2.parser;

import by.etc.tsarikov.task2.component.impl.TextComponentImpl;
import by.etc.tsarikov.task2.exeption.ReaderException;
import by.etc.tsarikov.task2.reader.impl.ReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChainTest {

    @Test
    void defaultPars() throws ReaderException {
        TextComponentImpl textComponent = ConstructChain.take(new ReaderImpl().take("resources/text.txt"));
        Assert.assertNotNull(textComponent);
    }
}
