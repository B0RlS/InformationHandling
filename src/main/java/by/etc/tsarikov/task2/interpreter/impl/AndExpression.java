package by.etc.tsarikov.task2.interpreter.impl;

import by.etc.tsarikov.task2.interpreter.Expression;

public class AndExpression implements Expression {
    private Expression rightExpression;
    private Expression leftExpression;
    public AndExpression () {
    }
    public AndExpression (Expression leftExpression,Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public int interpret() {
        return rightExpression.interpret() & leftExpression.interpret();
    }
}
