package org.fh.test;

public class BinarySearchByDiGuiTets {

    static int val = Integer.MIN_VALUE;

    public static void bin(int[] arr, int left, int right, int tar) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == tar) {
            val = mid;
        } else if (arr[mid] < tar) {
            bin(arr, mid + 1, right, tar);
        } else {
            bin(arr, left, mid - 1, tar);
        }
    }
}
