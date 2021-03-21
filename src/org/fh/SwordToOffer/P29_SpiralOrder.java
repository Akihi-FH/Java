package org.fh.SwordToOffer;


class SpiralOrder {
    /**
     * 按层模拟
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] order = new int[rows * cols];
        int idx = 0;
        // top：上面的行坐标；   bottom：下面的行坐标；
        // left：左边的列坐标；   right：右边的列坐标；
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 上面一行，(top,left) -> (top,right)
            for (int y = left; y <= right; y++) {
                order[idx++] = matrix[top][y];
            }
            // 右边一列，(top+1,right) -> (bottom,right)
            for (int x = top + 1; x <= bottom; x++) {
                order[idx++] = matrix[x][right];
            }
            if (left < right && top < bottom) {
                // 下面一行，(bottom, right - 1) -> (botton,left + 1)
                for (int y = right - 1; y > left; y--) {
                    order[idx++] = matrix[bottom][y];
                }
                // 左边一列，(botton,left) -> (top+1,left)
                for (int x = bottom; x > top; x--) {
                    order[idx++] = matrix[x][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


    /**
     * 通过改变方向来模拟
     * @param matrix
     * @return
     */
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        // 记录访问过的位置
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        // 结果数组
        int[] order = new int[total];
        int row = 0, col = 0;
        // (0,1)表示横坐标不变，纵坐标加 1，(1,0)表示横坐标加 1，纵坐标不变；
        // (0,-1)表示横坐标不变，纵坐标减 1，(-1,0)表示横坐标减 1，纵坐标不变；
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dIdx = 0; // 控制方向的变量
        // 一共 total 个元素
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][col];
            // 设置访问过
            visited[row][col] = true;
            // 下一个元素的位置，即横纵坐标
            int nextRow = row + directions[dIdx][0];
            int nextCol = col + directions[dIdx][1];
            // 每次走完一个方向时，下一个元素的坐标会满足下面某个条件，
            // 此时就要变换方向即改变 dIdx 的值，取directions数组中的下一组值
            // 换方向后需要重新计算下一个元素的坐标
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                dIdx = (dIdx + 1) % 4;
            }
            // 换方向需要 重新计算横纵坐标的值
            row += directions[dIdx][0];
            col += directions[dIdx][1];
        }
        return order;
    }

}


public class P29_SpiralOrder {
}
