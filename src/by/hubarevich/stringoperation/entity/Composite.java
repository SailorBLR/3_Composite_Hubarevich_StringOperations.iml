package by.hubarevich.stringoperation.entity;

import by.hubarevich.stringoperation.util.CompositeTypes;

import java.util.LinkedList;
import java.util.List;

/**
 * Class-composite to all Component children
 * Created by Anton on 14.12.2015.
 */
public class Composite implements Component {


    private CompositeTypes compositeType;
    private List<Component> components = new LinkedList<>();

    public Composite(CompositeTypes compositeType) {
        this.compositeType = compositeType;
    }

    @Override
    public CompositeTypes getType() {
        return compositeType;
    }

    @Override
    public void reading() {

        for (Component component : components) {

            if (CompositeTypes.PARAGRAPH.equals(component.getType()) |
                    CompositeTypes.LISTING.equals(component.getType()) |
                    CompositeTypes.CHAPTER_NAME.equals(component.getType())) {
                System.out.println("\n");
            }
            component.reading();
        }
    }

    public void add(Component component) {

        components.add(component);
    }

    public List<Component> getComponents() {

        return components;
    }
}
