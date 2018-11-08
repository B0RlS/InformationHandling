package by.etc.tsarikov.task2.component.impl;

import by.etc.tsarikov.task2.component.Component;
import by.etc.tsarikov.task2.specification.SortSpecification;

import java.util.ArrayList;
import java.util.List;

public class TextComponentImpl implements Component {

    private static final String EMPTY_STRING = "";
    private List<Component> components;

    public TextComponentImpl() {
        components = new ArrayList<>();
    }

    public void add (Component component) {
        components.add(component);
    }

    public void remove (Component component) {
        components.remove(component);
    }


    public void sort(SortSpecification sortSpecification) {
        sortSpecification.perform(components);
    }

    @Override
    public String take() {
        String values = EMPTY_STRING;

        for (Component com :components) {
            values +=com.take();
        }

        return values;
    }

    @Override
    public List<Component> getComponent() {
        return components;
    }
}
