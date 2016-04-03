package by.hubarevich.stringoperation.parser;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class-parser for Chapter composite
 * Created by Anton on 14.12.2015.
 */

public class ChapterParser implements IDefaultParser {

    private final String REGEX = "\\p{Space}(.*?)\\n{3}";
    private ParagraphParser paragraphParser;

    public ChapterParser(ParagraphParser nextParser) {
        this.paragraphParser = nextParser;
    }


    /**
     *
     * @param text
     * @param component
     */
    @Override
    public void handleText(String text, Component component) {

        String toProcess = text;
        Pattern chapter = Pattern.compile(REGEX, Pattern.DOTALL);
        Matcher matchChapter = chapter.matcher(toProcess);
        while (matchChapter.find()) {


            Component chapterComp = new Composite(CompositeTypes.CHAPTER);
            paragraphParser.handleText(matchChapter.group(),chapterComp);
            ((Composite)component).add(chapterComp);

        }
    }
}
