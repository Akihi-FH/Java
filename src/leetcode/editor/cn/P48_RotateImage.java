//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 746 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P48_RotateImage {
    public static void main(String[] args) {
        Solution solution = new P48_RotateImage().new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 翻转代替旋转
         * 顺时针旋转 90 度
         * ===
         * 水平翻转后再根据主对角线翻转
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 水平翻转
            for (int i = 0; i < n / 2; i++) {
//                int[] temp = matrix[i];
//                matrix[i] = matrix[n-i-1];
//                matrix[n-i-1] = temp;
                for (int j = 0; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-i-1][j];
                    matrix[n-i-1][j] = temp;
                }
            }

            // 主对角线翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }


        /**
         * 原地旋转
         * 这四个位置循环交换
         * [row][col] ->
         * [col][n-row-1] ->
         * [n-row-1][n-col-1] ->
         * [n-col-1][row] ->
         *
         * 将数组划分为四个部分
         *
         * @param matrix
         */
        /*public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }*/


        /**
         * 辅助数组
         * 第i行旋转后变为第n-i-1列, i -> (0到n-1)
         * nums[row][col] -> nums[clo][n-i-1]
         *
         * @param matrix
         */
        /*public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] nums = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = nums[i][j];
                }
            }
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

