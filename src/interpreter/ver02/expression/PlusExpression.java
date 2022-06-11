package interpreter.ver02.expression;

import interpreter.ver02.PostExpression;

import java.util.Map;

public class PlusExpression implements PostExpression {

    private PostExpression postNum, preNum;

    public PlusExpression(PostExpression preNum, PostExpression postNum) {
        this.preNum = preNum;
        this.postNum = postNum;
    }

    @Override
    public int interpret() {
        return preNum.interpret() + postNum.interpret();
    }
}
