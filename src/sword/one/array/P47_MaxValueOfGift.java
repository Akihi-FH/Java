package sword.one.array;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
class MaxValueOfGift {
    /**
     * dp(i,j)dp(i,j) 代表从棋盘的左上角开始，到达单元格 (i,j)(i,j) 时能拿到礼物的最大累计价值。
     * i == 0 && j == 0,为起始元素，dp[i][j] = grid(i,j)
     * i == 0 && j != 0,第一行元素，只能从左边到达，dp[i][j] = grid(i,j)+dp(i,j−1)
     * i != 0 && j == 0,第一列元素，只能从上方到达，dp[i][j] = grid(i,j)+dp(i−1,j)
     * i != 0 && j != 0,可以从左边或者上方到达，dp[i][j] = grid(i,j)+max[dp(i−1,j),dp(i,j−1)]
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // 初始化第一行每个位置能获得的价值
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第一列每个位置能获得的价值
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[rows - 1][cols - 1];
    }


    public int maxValue2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}

public class P47_MaxValueOfGift {
}
