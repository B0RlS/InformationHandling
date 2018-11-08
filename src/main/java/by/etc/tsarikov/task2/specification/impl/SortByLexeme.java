package by.etc.tsarikov.task2.specification.impl;

import by.etc.tsarikov.task2.component.Component;
import by.etc.tsarikov.task2.specification.SortSpecification;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByLexeme implements SortSpecification {

    private char symbol;
    private final static int ZERO = 0;

    public SortByLexeme() {}
    public SortByLexeme(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void perform(List<Component> list) {
        for (Component com :list) {



            List<Component> sentences = com.getComponent();

            for (Component sentense :sentences) {


                if (sentense==null) {
                    continue;
                }

                List<Component> lexems  = sentense.getComponent();

                if (lexems == null) {
                    continue;
                }
                Collections.sort(lexems, new Comparator<Component>() {
                    @Override
                    public int compare(Component component, Component component2) {
                        int count1 = ZERO;
                        int count2 = ZERO;

                        String str1 = component.take();
                        String str2 = component2.take();

                        for (int i=0;i<str1.length();i++) {
                            if (str1.charAt(i)==symbol) {
                                count1++;
                            }
                        }

                        for (int i=0;i<str2.length();i++) {
                            if (str2.charAt(i)==symbol) {
                                count2++;
                            }
                        }

                        if (count1==count2) {
                            return str1.length()-str2.length();
                        }
                        return count1-count2;
                    }
                });
            }
        }
    }
}
