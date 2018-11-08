package by.etc.tsarikov.task2.specification.impl;

import by.etc.tsarikov.task2.component.Component;
import by.etc.tsarikov.task2.specification.SortSpecification;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBySentence implements SortSpecification {
    private final static int ZERO = 0;

    @Override
    public void perform(List<Component> list) {

        Collections.sort(list, new Comparator<Component>() {
            @Override
            public int compare(Component component, Component component2) {

                String str1 = component.take();
                String str2 = component.take();

                int count1 = ZERO;
                int count2 = ZERO;

                for (int i=0;i<str1.length();i++) {
                    if (str1.charAt(i)=='.') {
                        count1++;
                    }
                }

                for (int i=0;i<str2.length();i++) {
                    if (str2.charAt(i)=='.') {
                        count2++;
                    }
                }
                return count1-count2;
            }
        });

    }
}
