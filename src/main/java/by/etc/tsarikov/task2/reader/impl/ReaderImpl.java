package by.etc.tsarikov.task2.reader.impl;

import by.etc.tsarikov.task2.exeption.ReaderException;
import by.etc.tsarikov.task2.reader.ReadInformation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements ReadInformation, Serializable {
    private static final long serialVersionUID = 839096528734058353L;
    private static final Logger logger = LogManager.getLogger(ReaderImpl.class);

    @Override
    public List<String> take(String uri) throws ReaderException {
        List list = new ArrayList();

        try {

            list = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

        } catch (IOException e) {

            logger.error("Error reading",e);

            throw new ReaderException(e);
        }

        return list;
    }
}
