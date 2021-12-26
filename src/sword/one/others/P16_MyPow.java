package sword.one.others;

import java.util.Random;

class MyPow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1.0;
        // 若n= - 2^31，则 -n会越界，因为int正整数最大为 2^31 - 1
        long b = n;
        // n < 0，则为 (1/x)^(-n)
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>>= 1;
        }
        return res;
    }
}

public class P16_MyPow {
}
