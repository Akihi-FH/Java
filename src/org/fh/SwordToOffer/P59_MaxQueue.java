package org.fh.SwordToOffer;


import java.util.Deque;
import java.util.LinkedList;

class MaxQueue {
    // 两个队列，一个保存值，一个保存队列当前最大值
    Deque<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.size() == 0) {
            return -1;
        }
        return maxQueue.peek();
    }

    /**
     * 值value入队时，
     * 若maxQueue不为空 且 maxQueue队列尾值 < 将要入队的值value
     *      则先移除maxQueue的队列尾值
     *  执行入两个队列操作
     *  value入队queue
     *  value入队maxQueue
     *
     * @param value
     */
    public void push_back(int value) {
        while (maxQueue.size() != 0 && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        queue.offer(value);
        maxQueue.offer(value);
    }

    /**
     * queue出队时
     * 若queue队列头的值 == maxQueue中队列头的值
     * 则maxQueue队列头也出队
     *
     * @return
     */
    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        }
        int res = queue.poll();
        if (res == maxQueue.peek()) {
            maxQueue.poll();
        }
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

/*
// 方法二：
class MaxQueue {
    int[] q = new int[20000];
    int begin = 0, end = 0;

    public MaxQueue() {

    }

    public int max_value() {
        int ans = -1;
        for (int i = begin; i != end; ++i) {
            ans = Math.max(ans, q[i]);
        }
        return ans;
    }

    public void push_back(int value) {
        q[end++] = value;
    }

    public int pop_front() {
        if (begin == end) {
            return -1;
        }
        return q[begin++];
    }
}
 */


public class P59_MaxQueue {
    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.push_back(1);
        mq.push_back(2);
        mq.max_value();

    }
}
