package edu.cninfo.basic.day09;

import java.util.Stack;

public class MyStack {
    public Stack<Integer> pushStack;
    public Stack<Integer> minStack;

    public MyStack() {
        pushStack = new Stack<>();
        minStack = new Stack<>();
    }

    public boolean push(int val) {
        pushStack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int nowMin = Math.min(val, minStack.peek());
            minStack.push(nowMin);
        }
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        minStack.pop();
        return pushStack.pop();

    }

    public int getMin() {
        if (isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        if (minStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("no data now");
        } else if (minStack.isEmpty()) {
            throw new RuntimeException("minStack has not data");
        } else if (pushStack.isEmpty()) {
            throw new RuntimeException("pushStack has not data");
        }
        return false;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.push(3);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());

    }

}
