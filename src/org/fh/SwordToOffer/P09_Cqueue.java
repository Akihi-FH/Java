package org.fh.SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        // stack1负责插入，stack2负责删除
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /**
     * 插入
     * stack1直接添加元素
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 从头部删除
     *
     * 删除时，先判断stack2是否为空
     *  若stack2为空，先将stack1中的元素添加到stack2中
     *
     * 判断stack2是否为空，是则返回 -1
     * 否则返回头部元素
     *
     * @return
     */
    public int deleteHead() {
        /*if (stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0) {
            return -1;
        } else {
            return stack2.pop();
        }*/


        if (stack2.size() != 0) {
            return stack2.pop();
        } else if (stack1.size() == 0){
            return -1;
        } else {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
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