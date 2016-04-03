package by.hubarevich.stringoperation.entity;

import by.hubarevich.stringoperation.util.CompositeTypes;

/**
 * Class-entity for Leaf Word
 * Created by Anton on 14.12.2015.
 */
public class Word implements Component {


    private String componentContent;
    private CompositeTypes componentType;

    public Word(CompositeTypes componentType) {
        this.componentType = componentType;
    }

    public void setComponentContent(String componentContent) {
        this.componentContent = componentContent;
    }

    public String getComponentContent() {
        return componentContent;
    }

    @Override
    public CompositeTypes getType() {
        return componentType;
    }

    @Override
    public void reading() {


        System.out.print(" ".concat(componentContent));
    }

    @Override
    public String toString() {
        return componentContent;
    }


}
