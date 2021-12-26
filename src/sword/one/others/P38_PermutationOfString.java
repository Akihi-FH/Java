package sword.one.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermutationOfString {

    int n = 0;

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        this.n = s.length();
        backtrack(res, s.toCharArray(), 0);
        return res.toArray(new String[res.size()]);
    }

    private void backtrack(List<String> res, char[] chars, int index) {
        if (index == n) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> curChar = new HashSet<>();
        for (int i = index; i < n; i++) {
            if (curChar.contains(chars[i])) {
                continue;
            }
            curChar.add(chars[i]);
            swap(chars, i, index);
            backtrack(res, chars, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public class P38_PermutationOfString {
    public static void main(String[] args) {
        new PermutationOfString().permutation("abc");
    }
}
