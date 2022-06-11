package interpreter.ver02.expression;

import interpreter.ver02.PostExpression;

import java.util.Map;

public class VariableExpression implements PostExpression {

    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public int interpret() {
        return Integer.parseInt(variable);
    }
}
