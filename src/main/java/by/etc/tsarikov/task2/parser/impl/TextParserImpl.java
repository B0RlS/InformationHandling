package by.etc.tsarikov.task2.parser.impl;

import by.etc.tsarikov.task2.composition.impl.Composite;
import by.etc.tsarikov.task2.entity.Paragraph;
import by.etc.tsarikov.task2.entity.Text;
import by.etc.tsarikov.task2.exeption.ParserException;
import by.etc.tsarikov.task2.parser.TextParser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class TextParserImpl implements TextParser, Serializable {
    private static final long serialVersionUID = -4980294047999331022L;

    public static final String REGEX_LISTING = "\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITHOUT_LISTING = "\\t(.+))([^((Start listing)([^\\t]+)(End listing))]";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_EMPTY = ".]*";

    public TextParserImpl() {
    }

    public Composite parse(String path) throws ParserException {
        String text = initialization(path);
        Composite wholeText = new Composite();
        wholeText = parseToParagraph(wholeText, text);
        return wholeText;
    }

    private String initialization(final String path) throws ParserException {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            throw new ParserException("Not file in resources", e);
        } catch (IOException e) {
            throw new ParserException(e);
        }
        return text;
    }

    private Composite parseToParagraph(Composite wholeText, String text) {
        // parse to paragraph
        Composite paragraphList = new Composite();
        Pattern pattertParagraph = Pattern
                .compile(REGEX_PARAGRAPH_WITH_LISTING);
        Composite paragraphLeaf = null;
        String paragraph = "";
        Matcher matcher = pattertParagraph.matcher(text);
        while (matcher.find()) {
            paragraph = matcher.group();
            if (Pattern.matches(REGEX_LISTING, paragraph)) {
                paragraphLeaf = new Composite(paragraph);
                System.out.print(paragraphLeaf);
                paragraphList.add(paragraphLeaf);
            } else {
                System.out.print(paragraph);
                paragraphList = parseToSentense(paragraphList, paragraph);
            }
            wholeText.add(paragraphList);
        }

        return wholeText;
    }

    private Composite parseToSentense(Composite paragraphList, String paragraph) {
        Composite sentenceList = new Composite();
        Pattern pattertSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher m2 = pattertSentence.matcher(paragraph);
        String sentence = "";
        while (m2.find()) {
            sentence = m2.group();
            sentenceList = parseToLexeme(sentenceList, sentence);
            paragraphList.add(sentenceList);
        }
        return paragraphList;
    }

    private Composite parseToLexeme(Composite sentenceList, String sentence) {
        Pattern pattertWord = Pattern.compile(REGEX_WORD);
        String word = "";
        Matcher matcher = pattertWord.matcher(sentence);
        Composite wordList = new Composite();
        while (matcher.find()) {
            word = matcher.group();
            wordList = parseToSignAndLexeme(wordList, word);
            sentenceList.add(wordList);
        }
        return sentenceList;
    }

    private Composite parseToSignAndLexeme(Composite wordList, String word) {
        Pattern pattern = Pattern.compile(REGEX_WORD_AND_SIGN);
        String wordSign = "";
        Matcher matcher = pattern.matcher(word);
        Composite wordSignList = new Composite();
        while (matcher.find()) {
            wordSign = matcher.group();
            wordSignList = parseToSymbol(wordSignList, wordSign);
            wordList.add(wordSignList);
        }
        return wordList;
    }

    private Composite parseToSymbol(Composite wordSignList, String wordSign) {
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        String symbol = "";
        Matcher matcher = pattern.matcher(wordSign);
        Composite symbolList;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolList = new Composite(symbol);
        }
        return wordSignList;
    }

    @Override
    public Text read(List<Paragraph> paragraphs) throws ParserException {
        return null;
    }
}
