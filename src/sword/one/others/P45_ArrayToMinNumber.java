package sword.one.others;

import java.util.Arrays;
import java.util.Comparator;

class ArrayToMinNumber {
    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1+o2).compareTo(o2+o1));

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}

public class P45_ArrayToMinNumber {
}
