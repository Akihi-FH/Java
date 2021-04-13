package org.fh.writtenexam;

import java.util.*;

public class JD_0410 {


    static  int maxScore;
    static Deque<Integer> left = new LinkedList<>();
    static Deque<Integer> right = new LinkedList<>();
    public static void getNum(int[] nums, int index, int score){
        if (index == nums.length) {
            maxScore= Math.max(maxScore, score);
            return;
        }
        if (!left.isEmpty() && nums[index] == left.element()) {
            getNum(nums, index + 1, score + 1);
        } else {
            left.push(nums[index]);
            getNum(nums, index + 1, score);
            left.pop();

        }

        if (!right.isEmpty() && nums[index] == right.element()) {
            score++;
            getNum(nums, index + 1, score + 1);
        } else {
            right.push(nums[index]);
            getNum(nums, index + 1, score);
            right.pop();
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 保存正整数
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
        }
        getNum(nums, 0, 0);
        System.out.println(maxScore);
    }



    private static void getMaxScore(int[] nums, int index, int score, int flag) {
        int c = score;
        if (index == nums.length) {
            maxScore = Math.max(maxScore, score);
            return;
        }
        left.push(nums[index]);
        if (!left.isEmpty()) {
            Integer pop = left.pop();
            if (!left.isEmpty() && pop == left.element()){
                score++;
            }
            left.push(pop);
        }
//        if (flag ==1 &&!right.isEmpty() && nums[index] == right.element()) {
//            score++;
//        }

        getMaxScore(nums, index + 1, score, 0);
//        getMaxScore(nums, index + 1, score, 1);
        left.pop();

        right.push(nums[index]);
        if (!right.isEmpty()) {
            Integer pop = right.pop();
            if (!right.isEmpty() && pop == right.element()){
                c++;
            }
            right.push(pop);
        }

        getMaxScore(nums, index + 1, c, 0);
//        getMaxScore(nums, index + 1, score, 1);
        right.pop();
    }



    private static void test2(int[] nums, int index, int score, int flag) {
        if (index == nums.length) {
            maxScore = Math.max(maxScore, score);
            return;
        }
        if (flag ==0 && !left.isEmpty() && nums[index] == left.element()) {
            score++;
        }
        if (flag ==1 &&!right.isEmpty() && nums[index] == right.element()) {
            score++;
        }

        left.push(nums[index]);
        getMaxScore(nums, index + 1, score, 0);
        getMaxScore(nums, index + 1, score, 1);
        left.pop();

        right.push(nums[index]);
        getMaxScore(nums, index + 1, score, 0);
        getMaxScore(nums, index + 1, score, 1);
        right.pop();
    }


    public void test1() {
        Scanner sc = new Scanner(System.in);
        // n条直线
        int n = sc.nextInt();
        // 保存斜率和截距
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int k = sc.nextInt();
            int b = sc.nextInt();
            map.put("k", k);
            map.put("b", b);
            list.add(map);
        }
    }

}