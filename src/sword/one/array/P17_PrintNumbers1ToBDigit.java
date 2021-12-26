package sword.one.array;

class PrintNumbers1ToBDigit {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i] = i;
        }
        return res;
    }

    int cnt = 0;

    public int[] printNumbers2(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        backtrack(res, new StringBuilder(), n, 0);
        return res;
    }

    public void backtrack(int[] res, StringBuilder sb, int n, int digit) {
        if (digit == n) {
            int num = Integer.parseInt(sb.toString());
            if (num != 0) {
                res[cnt++] = num;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            sb.append(i);
            backtrack(res, sb, n, digit + 1);
            sb.deleteCharAt(digit);
        }
    }
}

public class P17_PrintNumbers1ToBDigit {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        System.out.println(sb.toString());
    }
}
