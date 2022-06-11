package interpreter.ver02;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("후위 표기식으로 계산식을 기입하세요 e.g) 1 2 3 + -");
        String input = sc.nextLine();

        PostExpression expressionTree = PostFixParser.parse(input);
        System.out.println("= " + expressionTree.interpret());
    }
}
