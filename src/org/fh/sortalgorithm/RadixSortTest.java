package org.fh.sortalgorithm;

import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        radixSortLSD(arr);
        System.out.println("基数：" + Arrays.toString(arr));

    }

    /**
     * LSD 从低位到高位
     *
     * @param arr
     */
    public static void radixSortLSD(int[] arr) {
        // 取出最大数
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        // 最大数有多少位
        int digit = 1;
        while ((max = max / 10) > 0) {
            digit++;
        }
        //申请一个 二维数组桶空间
        int[][] buckets = new int[10][arr.length];
        // 用来取出当前位的数字，每次10倍递增。base=1取个位; base =10取十位; ...
        int base = 1;
        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < digit; i++) {
            int[] bktLen = new int[10];  //各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] / base) % 10; // 这里很重要 计算元素放在哪个桶中
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            // m个桶
            for (int m = 0; m < buckets.length; m++) {
                // 每个桶 bktLen[m]个元素
                for (int n = 0; n < bktLen[m]; n++) {
                    arr[k++] = buckets[m][n];
                }
            }
            // 取下一位数字
            base *= 10;
        }

    }

    /**
     * MSD 从高位到低位
     *
     * @param arr
     */
    public static void radixSortMSD(int[] arr) {
        // 取出最大数
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        // 最大数有多少位
        int digit = 1;
        while ((max = max / 10) > 0) {
            digit++;
        }
        //申请一个 二维数组桶空间
        int[][] buckets = new int[10][arr.length];
        // 用来取出当前位的数字，每次10倍递增。base=1取个位; base =10取十位; ...
        int base = (int) Math.pow(10, --digit);
        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < digit; i++) {
            int[] bktLen = new int[10];  //各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] / base) % 10; // 这里很重要 计算元素放在哪个桶中
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备, ,因此从桶底先捞
            int k = 0;
            // m个桶
            for (int m = 0; m < buckets.length; m++) {
                // 每个桶 bktLen[m]个元素
                for (int n = 0; n < bktLen[m]; n++) {
                    arr[k++] = buckets[m][n];
                }
            }
            // 取下一位数字
            base = (int) Math.pow(10, --digit);
        }

    }
}
