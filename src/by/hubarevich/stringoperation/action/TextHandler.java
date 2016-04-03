package by.hubarevich.stringoperation.action;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.exception.WrongInputException;
import by.hubarevich.stringoperation.parser.*;
import by.hubarevich.stringoperation.util.CompositeTypes;
import by.hubarevich.stringoperation.util.InputFileParser;
import org.apache.log4j.Logger;

/**
 * Class-handler for operating with composite
 * Created by Anton on 16.12.2015.
 */
public class TextHandler {


    private static final Logger LOGGER = Logger.getLogger(TextHandler.class);
    private Component component;
    public void handleText (String fileAddress) {

        try {
            WordSorter wordSorter = new WordSorter();
            FirstLetterDelete firstLetterDelete = new FirstLetterDelete();

            component = new Composite(CompositeTypes.TEXT);
            WordParser wordParser = new WordParser();
            LexemeParser lexemeParser = new LexemeParser(wordParser);
            SentenceParser sentenceParser = new SentenceParser(lexemeParser);
            ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
            ChapterParser chapterParser = new ChapterParser(paragraphParser);
            chapterParser.handleText(InputFileParser.makeInputString(fileAddress), component);
            wordSorter.sortWords(component);
            firstLetterDelete.deleteLetters(component);
            component.operation();

        } catch (WrongInputException e) {
            LOGGER.error(e);
        }
    }
}
