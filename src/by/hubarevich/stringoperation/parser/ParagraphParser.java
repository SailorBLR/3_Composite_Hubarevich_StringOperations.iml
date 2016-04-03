package by.hubarevich.stringoperation.parser;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.entity.Listing;
import by.hubarevich.stringoperation.entity.Word;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class-parser for Paragraph Entity
 * Created by Anton on 14.12.2015.
 */
public class ParagraphParser implements IDefaultParser {

    private final String REGEX_LISTING = "(/-(.*?)-/)";
    private final String REGEX_PARAGRAPH = "((\\p{Space}{4}|\\p{Space})(.*?)([.!?:])\\n{2})|";
    private final String REGEX_CHAPTER_NAME = "(\\p{Space}[1-9]{1,2}\\..*?\\n)|";
    private final String FULL_REGEX = REGEX_CHAPTER_NAME + REGEX_PARAGRAPH + REGEX_LISTING;

    private SentenceParser sentenceParser = null;

    public ParagraphParser(SentenceParser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }


    /**
     *
     * @param chapter
     * @param component
     */
    @Override
    public void handleText(String chapter, Component component) {

        String toProcess = chapter;

        Pattern paragraph = Pattern.compile(FULL_REGEX, Pattern.DOTALL);

        Matcher matchParagraph = paragraph.matcher(toProcess);


        while (matchParagraph.find()) {


            if (matchParagraph.group(1) != null) {
                Word chaptName = new Word(CompositeTypes.CHAPTER_NAME);
                chaptName.setComponentContent(matchParagraph.group(1));
                ((Composite) component).add(chaptName);
            }

            if (matchParagraph.group(2) != null) {
                Component paragraphComp = new Composite(CompositeTypes.PARAGRAPH);
                sentenceParser.handleText(matchParagraph.group(2), paragraphComp);
                ((Composite) component).add(paragraphComp);

            }
            if (matchParagraph.group(6) != null) {
                Listing listingLeaf = new Listing(CompositeTypes.LISTING);
                listingLeaf.setComponentContent(matchParagraph.group(6));
                ((Composite) component).add(listingLeaf);
            }

        }
    }
}
