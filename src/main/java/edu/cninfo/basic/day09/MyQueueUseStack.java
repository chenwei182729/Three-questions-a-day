package edu.cninfo.basic.day09;

import java.util.Stack;
import java.util.function.Supplier;

public class MyQueueUseStack {
    public Stack<Integer> enterStack;
    public Stack<Integer> outerStack;

    public MyQueueUseStack() {
        enterStack = new Stack<>();
        outerStack = new Stack<>();
    }

    public void add(int val) {
        enterStack.add(val);
    }

    public int poll() {
        return pollOrPeek(() -> outerStack.pop());
    }

    public int peek() {
        return pollOrPeek(outerStack::peek);
    }

    public int pollOrPeek(Supplier<Integer> action) {
        if (outerStack.isEmpty()) {
            while (!enterStack.isEmpty()) {
                outerStack.add(enterStack.pop());
            }
        }

        if (outerStack.isEmpty()) {
            throw new RuntimeException("no data");
        }

        return action.get();
    }

    public boolean isEmpty() {
        return enterStack.isEmpty() && outerStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueueUseStack myQueueUseStack = new MyQueueUseStack();
        myQueueUseStack.add(6);
        myQueueUseStack.add(5);
        myQueueUseStack.add(4);
        System.out.println(myQueueUseStack.poll());
        System.out.println(myQueueUseStack.peek());
        myQueueUseStack.add(3);
        myQueueUseStack.add(2);
        myQueueUseStack.add(1);

        while (!myQueueUseStack.isEmpty()){
            System.out.println(myQueueUseStack.poll());
        }
    }

}
