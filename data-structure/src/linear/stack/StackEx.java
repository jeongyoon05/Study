package linear.stack;

import java.util.Stack;

public class StackEx {

    private final static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {

        stack.push('A');
        stack.push('B');
        stack.push('C');

        stack.pop();

        System.out.println(stack);
    }
}
