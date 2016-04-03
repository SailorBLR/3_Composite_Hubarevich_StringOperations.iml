package by.hubarevich.stringoperation.parser;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.entity.Symbol;
import by.hubarevich.stringoperation.entity.Word;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anton on 14.12.2015.
 * Parser-clas for Word Leaf
 */
public class WordParser implements IDefaultParser {

    private final String REGEX = "(\\w+)|(\\p{Punct})";


    /**
     *
     * @param text inputed type
     * @param component - parent-component
     */
    @Override
    public void handleText(String text, Component component) {
       String toProcess = text;

        Pattern wordPat = Pattern.compile(REGEX);

        Matcher matchWord = wordPat.matcher(toProcess);


        while (matchWord.find()) {

            if (matchWord.group(1) != null) {
                Word word = new Word(CompositeTypes.WORD);
                word.setComponentContent(matchWord.group(1));
               ((Composite) component).add(word);


            }
            if (matchWord.group(2) != null) {
                Symbol symbol = new Symbol(CompositeTypes.SYMBOL);
                symbol.setComponentContent(matchWord.group(2).charAt(0));
                ((Composite) component).add(symbol);

            }
        }

    }
}
