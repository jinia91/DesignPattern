package interpreter.ver02;

import interpreter.ver02.expression.*;

import java.util.Stack;

public class PostFixParser {

    public static PostExpression parse(String expression) {
        Stack<PostExpression> stack = new Stack<>();
        String[] expressionArrays = expression.split(" ");
        for (String expressionToken : expressionArrays) {
            stack.push(getExpression(expressionToken, stack));
        }
        return stack.pop();
    }

    private static PostExpression getExpression(String expressionToken, Stack<PostExpression> stack) {
        switch (expressionToken) {
            case "+":
                return new PlusExpression(stack.pop(), stack.pop());
            case "-":
                return new MinusExpression(stack.pop(), stack.pop());
            case "*":
                return new MultipleExpression(stack.pop(), stack.pop());
            case "/":
                return new DivideExpression(stack.pop(), stack.pop());
            default:
                char[] chars = expressionToken.toCharArray();
                for (char aChar : chars) {
                    if (!Character.isDigit(aChar)) {
                        throw new IllegalArgumentException("잘못된 연산자 입력");
                    }
                }
                return new VariableExpression(expressionToken);
        }
    }
}
