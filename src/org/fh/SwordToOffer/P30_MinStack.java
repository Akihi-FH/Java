package org.fh.SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    // 一个栈存储值，一个栈存最小值
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.size() == 0 ||  x <= minStack.peek()) {
            minStack.push(x);
        }/* else {
            minStack.push(minStack.peek());
        }*/
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

public class P30_MinStack {
    public static void main(String[] args) {

    }
}
