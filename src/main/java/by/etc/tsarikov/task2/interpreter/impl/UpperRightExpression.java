package by.etc.tsarikov.task2.interpreter.impl;

import by.etc.tsarikov.task2.interpreter.Expression;

public class UpperRightExpression implements Expression {
    private Expression rightExpression;
    private Expression leftExpression;

    public UpperRightExpression () {
    }
    public UpperRightExpression (Expression leftExpression,Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return leftExpression.interpret() >> rightExpression.interpret() ;
    }
}
