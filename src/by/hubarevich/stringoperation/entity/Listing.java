package by.hubarevich.stringoperation.entity;

import by.hubarevich.stringoperation.util.CompositeTypes;

/**
 * Class-leaf for Listing Leaf
 * Created by Anton on 18.12.2015.
 */
public class Listing implements Component {

    private String componentContent;
    private CompositeTypes componentType;

    public Listing(CompositeTypes componentType) {
        this.componentType = componentType;
    }

    public void setComponentContent(String componentContent) {
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
