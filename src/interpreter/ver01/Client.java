package interpreter.ver01;

import java.util.Scanner;
import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("후위 표기식으로 계산식을 기입하세요 e.g) 1 2 3 + -");
        String input = sc.nextLine();

        String[] tokens = input.split(" ");

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int sz = token.length();
            for (int i = 0; i < sz; i++) {
                char c = token.charAt(i);
                if (!Character.isDigit(c)) {
                    if(c != '+' && c != '-' && c != '*' &&  c != '/'){
                        throw new IllegalArgumentException("잘못된 값 입력");
                    }
                    switch (c){
                        case '+':
                            stack.push(stack.pop() + stack.pop());
                            break;
                        case '-':
                            Integer postNumber = stack.pop();
                            Integer preNumber = stack.pop();
                            stack.push(preNumber - postNumber);
                            break;
                        case '*':
                            stack.push(stack.pop() * stack.pop());
                            break;
                        case '/':
                            postNumber = stack.pop();
                            preNumber = stack.pop();
                            stack.push(preNumber / postNumber);
                            break;
                    }
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        System.out.println("result = " + stack.pop());
    }
}
