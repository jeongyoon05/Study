package linear.stack.impl;

public class ArrayStack implements Stack {

    private int top;
    private int stackSize;
    private char stackArr[];

    public ArrayStack(int stackSize) {
        top = -1;
        this.stackSize = stackSize;
        stackArr = new char[this.stackSize];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == this.stackSize-1;
    }

    @Override
    public void push(char item) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            stackArr[++top] = item;
            System.out.println("Inserted Item : " + item);
        }
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        } else {
            System.out.println("Deleted Item : " + stackArr[top]);
            return stackArr[--top];
        }
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        } else {
            System.out.println("Peek Item : " + stackArr[top]);
            return stackArr[top];
        }
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            top = -1;
            stackArr = new char[this.stackSize];
            System.out.println("Stack is Clear");
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.print("Stack : ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int stackSize = 5;
        ArrayStack arrayStack = new ArrayStack(stackSize);

        arrayStack.push('A');
        arrayStack.printStack();

        arrayStack.push('B');
        arrayStack.printStack();

        arrayStack.push('C');
        arrayStack.printStack();

        arrayStack.pop();
        arrayStack.printStack();

        arrayStack.pop();
        arrayStack.printStack();

        arrayStack.peek();
        arrayStack.printStack();

        arrayStack.clear();
        arrayStack.printStack();
    }
}
