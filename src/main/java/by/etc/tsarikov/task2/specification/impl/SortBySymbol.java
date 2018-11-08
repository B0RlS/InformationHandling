package by.etc.tsarikov.task2.specification.impl;

import by.etc.tsarikov.task2.component.Component;
import by.etc.tsarikov.task2.specification.SortSpecification;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBySymbol implements SortSpecification {

    private final static String POINT = ".";

    @Override
    public void perform(List<Component> list) {


        for (Component b : list) {


            List<Component> sentenses = b.getComponent();

            for (Component sentense : sentenses) {


                if (sentense == null) {
                    continue;
                }

                List<Component> lexemes = sentense.getComponent();

                if (lexemes == null) {
                    continue;
                }
                Collections.sort(lexemes, new Comparator<Component>() {
                    @Override
                    public int compare(Component component, Component component2) {
                        if (component.take().equals(POINT) || component2.take().equals(POINT)) {
                            return 0;
                        }
                        return component.take().length() - component2.take().length();
                    }
                });
            }
        }
    }
}
