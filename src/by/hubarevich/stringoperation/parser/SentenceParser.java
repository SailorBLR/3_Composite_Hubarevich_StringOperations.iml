package by.hubarevich.stringoperation.parser;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class-parser for sentences
 * Created by Anton on 13.12.2015.
 */
public class SentenceParser implements IDefaultParser {

    private final String REGEX = "((\\s*)[А-ЯA-Z]((т.п.|т.д.|пр.|etc.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!:])";
    private LexemeParser lexemeParser = null;

    public SentenceParser(LexemeParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    /**
     *
     * @param text
     * @param component
     */

    @Override
    public void handleText(String text, Component component) {
        String toProcess = text;
        Pattern sentence = Pattern.compile(REGEX, Pattern.DOTALL);
        Matcher matchSentence = sentence.matcher(toProcess);

        while (matchSentence.find()) {
            Component sentenceComp = new Composite(CompositeTypes.SENTENCE);
            lexemeParser.handleText(matchSentence.group(), sentenceComp);
            ((Composite) component).add(sentenceComp);
        }
    }
}





