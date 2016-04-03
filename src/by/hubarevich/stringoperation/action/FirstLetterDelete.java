package by.hubarevich.stringoperation.action;

import by.hubarevich.stringoperation.entity.Component;
import by.hubarevich.stringoperation.entity.Composite;
import by.hubarevich.stringoperation.entity.Word;
import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.Iterator;

/**
 * Class to delete the inclusion of the first letter
 * Created by Anton on 23.12.2015.
 */
public class FirstLetterDelete {

    /**
     * Get the component parameter and performs the operation()
     * @param component
     */
    public void deleteLetters(Component component) {
        Iterator<Component> compositeIterator = ((Composite) component).getComponents().iterator();

        Character letter;
        StringBuilder tempWord = new StringBuilder();

        while (compositeIterator.hasNext()) {
            Component nextComponent = compositeIterator.next();
            if (nextComponent.getType().equals(CompositeTypes.WORD)) {


                tempWord.append(((Word) nextComponent).getComponentContent());

                letter = tempWord.charAt(0);

                for (int i = 1; i < tempWord.length(); i++) {

                    if (tempWord.charAt(i) == letter) {

                        tempWord.deleteCharAt(i);

                        ((Word) nextComponent).setComponentContent(tempWord.toString());

                    }
                }
                tempWord.setLength(0);

            } else {
                if (nextComponent instanceof Composite) {
                    deleteLetters(nextComponent);
                }
            }
        }
    }

}
