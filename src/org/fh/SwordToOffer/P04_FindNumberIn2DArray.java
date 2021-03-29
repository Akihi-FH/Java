package org.fh.SwordToOffer;

class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;
        // 首先和右上角的数字比，target小的话左移，target大的话下移
        while (r < rows && c >= 0) {
            int num = matrix[r][c];
            if (num == target) {
                return true;
            } else if (num < target) {
                r++; // 行坐标 +1，下移
            } else {
                c--; // 列坐标 -1，左移
            }
        }
        return false;
    }


    // 暴力循环
    /*
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    */
}

public class P04_FindNumberIn2DArray {
}
