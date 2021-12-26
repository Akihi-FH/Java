package sword.one.array;

class SpiralOrderOfArray {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        int[] res = new int[rows * cols];
        int index = 0;

        while (left <= right && top <= bottom) {
            for (int y = left; y <= right; y++) {
                res[index++] = matrix[top][y];
            }
            for (int x = top + 1; x <= bottom; x++) {
                res[index++] = matrix[x][right];
            }
            if (left < right && top < bottom) {
                for (int y = right - 1; y > left; y--) {
                    res[index++] = matrix[bottom][y];
                }
                for (int x = bottom; x > top; x--) {
                    res[index++] = matrix[x][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;

        int total = rows * cols;
        int[] res = new int[total];
        boolean[][] visited = new boolean[rows][cols];
        int x = 0, y = 0;

        int[][] directions = {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int directIdx = 0;

        for (int i = 0; i < total; i++) {
            res[i] = matrix[x][y];
            visited[x][y] = true;

            int newX = x + directions[directIdx][0];
            int newY = y + directions[directIdx][1];
            if (newX < 0 || newX >= rows || newY < 0 || newY > cols || visited[newX][newY]) {
                directIdx = (directIdx + 1) % 4;
            }
            x += directions[directIdx][0];
            y += directions[directIdx][1];
        }
        return res;
    }
}

public class P29_SpiralOrderOfArray {
}
