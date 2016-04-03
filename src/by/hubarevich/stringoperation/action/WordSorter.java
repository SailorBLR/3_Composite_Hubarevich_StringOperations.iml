package by.hubarevich.stringoperation.action;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class to sort words in alphabetical order
 * Created by Anton on 23.12.2015.s
 */
public class WordSorter {


    private Character currentChar;

    private ArrayList<Component> totalWords = new ArrayList<>();

    public ArrayList<Component> searchForAllWords(Component component) {
        Iterator<Component> compositeIterator = ((Composite) component).getComponents().iterator();

        while (compositeIterator.hasNext()) {
            Component nextComponent = compositeIterator.next();
            if (nextComponent.getType().equals(CompositeTypes.WORD)) {
                totalWords.add(nextComponent);
            } else {
                if (nextComponent instanceof Composite) {
                    searchForAllWords(nextComponent);
                }
            }
        }
        return totalWords;
    }

    public void sortWords (Component component) {

        searchForAllWords(component);

        List<String> wordsToString = new ArrayList<>();
        for (Component word : totalWords) {
            wordsToString.add(word.toString().toLowerCase());
        }

        Collections.sort(wordsToString);
        currentChar = wordsToString.get(0).charAt(0);
        for (String word : wordsToString) {

            if (currentChar != word.charAt(0)) {
                System.out.print("\n    ".concat(word));
                currentChar = word.charAt(0);
            } else {

                System.out.print(" ".concat(word));
            }
        }
     }
}
