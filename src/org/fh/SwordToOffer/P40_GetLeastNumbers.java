package org.fh.SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的 k 个数
 */
class GetLeastNumbers {

    // 排序再取出
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    /**
     * 优先级队列实现大顶堆，先入队k个元素自动降序，
     * 之后插入后面的元素，比堆顶小则入队。
     * @param arr
     * @param k
     * @return
     */
    /*public int[] getLeastNumbersByHeap(int[] arr, int k) {
        int[] nums = new int[k];
        if (k == 0) {
            return nums;
        }
        // 优先级队列，传参实现大顶堆，自动降序排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }*/
}


public class P40_GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr= new int[]{4,5,1,6,2,7,3,8};
        arr = new GetLeastNumbers().getLeastNumbers(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
