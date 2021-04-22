package org.fh.writtenexam;

import java.util.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XieCheng_0415 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer[]> list = new LinkedList<>();
        boolean flag = true;
        int n = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                break;
            }
            if (flag) {
                flag = false;
                n = Integer.parseInt(s);
                continue;
            }

            String[] strs = s.split(",");
            Integer[] nums = new Integer[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            list.add(nums);
        }
        System.out.println(getSum(list, n));


    }

    private static int getSum(List<Integer[]> list, int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (Integer[] arr : list) {
            for (int i = 1; i < arr.length; i++) {
                if (set.contains(arr[i])) {
                    set.add(arr[0]);
                    break;
                }
            }
        }
        set.remove(n);
        if (set.isEmpty()) {
            return -1;
        }
        for (int num : set) {
            sum += num;
        }

        return sum;
    }

}

class Main2 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String buildingHouse(String n) {
        int N;
        try {
            N = Integer.parseInt(n);
            if (N < 1 || N > 12) {
                return "O";
            }
        } catch (Exception e) {
            return "N";
        }
        TreeNode root = new TreeNode('R');
        dfs(root, N - 1);
        StringBuilder res = new StringBuilder();
        getVal(root, res);
        return res.toString();
    }

    private static void getVal(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        getVal(root.left, res);
        res.append(root.val);
        getVal(root.right, res);
    }

    private static void dfs(TreeNode root, int h) {
        if (h == 0) {
            return;
        }
        root.left = new TreeNode('G');
        root.right = new TreeNode('R');
        dfs(root.left, h - 1);
        dfs(root.right, h - 1);
    }


    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

        public TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /******************************结束写代码******************************/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _n;
        try {
            _n = in.nextLine();
        } catch (Exception e) {
            _n = null;
        }

        res = buildingHouse(_n);
        System.out.println(res);
    }
}