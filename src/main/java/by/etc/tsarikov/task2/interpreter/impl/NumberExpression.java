package by.etc.tsarikov.task2.interpreter.impl;

import by.etc.tsarikov.task2.interpreter.Expression;

public class NumberExpression implements Expression {
    private int number;
    public NumberExpression() {}
    public NumberExpression(int number) {
        this.number = number;
    }
    public NumberExpression(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return number;
    }
}
