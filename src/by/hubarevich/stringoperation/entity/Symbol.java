package by.hubarevich.stringoperation.entity;

import by.hubarevich.stringoperation.util.CompositeTypes;

/**
 * Class-entity for Leaf Symbol
 * Created by Anton on 14.12.2015.
 */
public class Symbol implements Component {


    private Character componentContent;
    private CompositeTypes componentType;

    public Symbol(CompositeTypes componentType) {
        this.componentType = componentType;
    }

    public void setComponentContent(Character componentContent) {
        this.componentContent = componentContent;
    }

    @Override
    public CompositeTypes getType() {
        return componentType;
    }

    @Override
    public void reading() {
        System.out.print(componentContent);
    }

}
