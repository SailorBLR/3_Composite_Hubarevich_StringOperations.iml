package by.hubarevich.stringoperation.parser;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.entity.Listing;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class-pares for Lexemes
 * Created by Anton on 14.12.2015.
 */
public class LexemeParser implements IDefaultParser {


    private final String REGEX = "((\\w+?-?\\w*?)[,.!?:\\s])|(#.*?-#)";
    private WordParser wordParser = null;

    public LexemeParser(WordParser wordParser) {
        this.wordParser = wordParser;
    }

    /**
     *
     * @param text
     * @param component
     */
    @Override
    public void handleText(String text, Component component) {

        String toProcess = text;

        Pattern lexeme = Pattern.compile(REGEX, Pattern.DOTALL);
        Matcher matchLexeme = lexeme.matcher(toProcess);

        while (matchLexeme.find()) {
            if (matchLexeme.group(1) != null) {
                Component lexemeComp = new Composite(CompositeTypes.LEXEME);
                wordParser.handleText(matchLexeme.group(1), lexemeComp);
                ((Composite) component).add(lexemeComp);
            }

            if (matchLexeme.group(3) != null) {
                Listing innerCode = new Listing(CompositeTypes.INNER_CODE);
                innerCode.setComponentContent(matchLexeme.group(3));
                ((Composite) component).add(innerCode);
            }
        }
    }
}
