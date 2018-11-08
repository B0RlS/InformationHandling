package by.etc.tsarikov.task2.reader;

import by.etc.tsarikov.task2.exeption.ReaderException;
import by.etc.tsarikov.task2.reader.impl.ReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TextReaderTest {
    ReadInformation text = new ReaderImpl();
    @Test
    void defaultRead() throws ReaderException {
        List<String> list = text.take("resources/text.txt");
        Assert.assertNotNull(list);
    }
}
