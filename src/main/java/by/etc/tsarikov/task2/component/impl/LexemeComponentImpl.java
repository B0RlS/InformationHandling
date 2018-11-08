package by.etc.tsarikov.task2.component.impl;

import by.etc.tsarikov.task2.component.Component;

import java.util.List;

public class LexemeComponentImpl implements Component {

    private String value;
    private static final String NEXT_LINE = "\n";
    private static final String SPACE = " ";

    public LexemeComponentImpl(){}

    public LexemeComponentImpl(String value){
        this.value=value;
    }

    @Override
    public String take() {
        if (value.equals(NEXT_LINE)) {
            return value;
        }
        return value + SPACE;
    }

    @Override
    public List<Component> getComponent() {
        return null;
    }
}
