package org.fh.SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        // 会有 length - k + 1 个窗口，即 length - k + 1 个值
        int[] res = new int[nums.length - k + 1];
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            // 窗口形成后，保证队列中只包含当前窗口的元素
            if (i > 0 && deque.peek() == nums[i - 1]) {
                deque.poll();
            }
            // 队列不为空时，保持队列中的元素递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.offer(nums[j]);
            // 窗口形成，取当前窗口最大值
            if (i >= 0) {
                res[i] = deque.peek();
            }
        }
        return res;
    }



    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        // 形成窗口后，i为窗口右指针
        for (int i = k; i < nums.length; i++) {
            // 窗口形成后，保证队列中只包含当前窗口的元素
            if (deque.peek() == nums[i - k]) {
                deque.poll();
            }
            // 保持队列中的元素递减
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offer(nums[i]);
            res[i - k + 1] = deque.peek();
        }

        return res;
    }
    */
}

public class P59_1_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 3, 5, 4};
        new MaxSlidingWindow().maxSlidingWindow(nums, 3);
    }
}
