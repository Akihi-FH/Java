package sword.one.others;

/**
 * 圆圈中剩下的最后数字
 */
class LastRemainingNum {
    /*
    m=3, idx为最后一个数在n不同的情况下的索引，从n=1往n=5的方向推导
    n=5, 0 1 2 3 4, idx = (m + idx) % n = (3+0)%5 = 3, 且此时索引idx就代表该位置的数值
    n=4, 3 4 0 1, idx = (m + idx) % n = (3+1)%4 = 0
    n=3, 1 3 4, idx = (m + idx) % n = (3+1)%3 = 1
    n=2, 1 3, idx = (m + idx) % n = (3+0)%2 = 1
    n=1, 3, idx = 0
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (m + res) % n;
        }
        return res;
    }

    public int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) return 0;
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}

public class P62_LastRemainingNum {
}
