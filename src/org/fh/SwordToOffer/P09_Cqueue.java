package org.fh.SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class P09_Cqueue {
    public static void main(String[] args) {
        CQueue solution = new CQueue();
    }
}