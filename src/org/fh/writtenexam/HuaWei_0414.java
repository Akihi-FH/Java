package org.fh.writtenexam;

import java.util.*;

public class HuaWei_0414 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            nums[i] = data;
        }
        int min = getRelay(nums);
        System.out.println(min);
    }

    private static int getRelay(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j - i <= nums[i] && j < nums.length; j++) {
                if (dp[j] == 0 || dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        return dp[nums.length - 1];
    }
//    static int min = Integer.MAX_VALUE;
//
//    private static void getRelay(int[] nums, int cnt, int distance) {
//        if (nums[distance] == 0) {
//            return;
//        }
//        if (distance >= nums.length) {
//            min = Math.min(min, cnt);
//        }
//        for (int i = 1; i <= nums[distance]; i++) {
//            getRelay(nums, cnt + 1, distance + i);
//        }
//
//        /*int min = 0;
//        int far = 0; // 最远下标
//        int cnt = 0; // 中转次数
//        for (int i = 0; i < nums.length; i++) {
//            if (i<=far) {
//                far = Math.max(far, nums[i] + i);
//            }
//            if (far>=nums.length-1) {
//                min = Math.min(min, cnt);
//            }
//            cnt++;
//
//        }
//        return min;*/
//    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            nums[i] = data;
        }
        List<Integer> res = getUpload(nums);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1)
                System.out.print(",");
        }

    }

    public static List<Integer> getUpload(int[] nums) {
        int cycle = 30;
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        int cnt = 0;
        int aeb = 0;
        int front = 0, after = 0;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            cnt++;
            if (nums[i - 1] - nums[i] >= 9) {
                for (int j = i + 1; j < nums.length && j < i + 5; j++) {
                    if (nums[j - 1] - nums[j] >= 9) {
                        aeb++;
                    }
                    if (aeb >= 4) {
                        front = i - 4;
                        cnt = 0;
                    }
                }
            } else if (aeb >= 4) {
                List<Integer> tmp = new ArrayList<>();
                after = i;
                after = Math.min(after + 4, nums.length);
                for (int k = front; k < after; k++) {
                    tmp.add(nums[k]);
                }
                aeb = 0;
                cnt = 0;
                if (set.add(tmp)) {
                    res.addAll(tmp);
                }
            } else if (cycle == cnt) {
                cnt = 0;
                res.add(nums[i]);
            }
        }
        return res;
    }


    private void test1() {
        Scanner sc = new Scanner(System.in);
        // 获取字符串
        String str = sc.nextLine();
        // 保存结果
        StringBuilder res = new StringBuilder();

        if (str == null || str.length() == 0) {
            System.out.println(str);
        }
        // 栈
        Deque<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            // 左括号和字母入栈
            if (c != ')') {
                stack.push(c);
            } else {
                // 遇到右括号，取出栈中字符串直到遇到左括号，然后将取出的反转
                List<Character> tmp = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    tmp.add(stack.pop());
                }
                stack.pop();
                for (char c1 : tmp) {
                    stack.push(c1);
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        System.out.println(res.reverse().toString());
    }
}
