package by.etc.tsarikov.task2.interpreter.impl;

import by.etc.tsarikov.task2.interpreter.Expression;

public class OrExpression implements Expression {

    private Expression rightExpression;
    private Expression leftExpression;

    public OrExpression () {
    }
    public OrExpression (Expression leftExpression,Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return rightExpression.interpret() | leftExpression.interpret();
    }
}
