package org.fh.writtenexam;

public class TengXun_0321 {
    public static int getCount2(int num) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int num = sc.nextInt();
//            int cnt = getCount2(num);
//            System.out.println(cnt);
//        }
        if (num < 2) {
            System.out.println(num);
            return num;
        }
        int[] dp = new int[num + 1];
        dp[1] = 1;
        for (int i = 2; i < num; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                min = dp[i / 3] + 1;
            }
            if ((i & 1) == 0) {
                min = Math.min(min, dp[i >> 1] + 1);
            }
            min = Math.min(min, dp[i - 1] + 1);
            dp[i] = min;
        }
        return dp[num];
    }

    public static int getCount(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int count = Math.min(
                getCount((num - num % 2) / 2) + num % 2,
                getCount((num - num % 3) / 3) + num % 3)
                + 1;
        return count;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class t1 {

//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.left =node1;
//        root.right =node2;
//        solve(root, new int[]{2});


/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 你需要返回m个指针，第i个指针指向一条链，表示第i个问题的答案
 *
 * @param root TreeNode类 指向链表树的根
 * @param b    int整型一维数组 表示每个问题是什么
 * @return ListNode类一维数组
 */
    /*public static ListNode[] solve(TreeNode root, int[] b) {
        // write code here
        int bLen = b.length;
        ListNode[] ln = new ListNode[b.length];
        for (int i = 0; i < bLen; i++) {
            ListNode head = new ListNode(-1);
            find(root, b[i], head);
            ln[i] = head.next;
        }
        return ln;
    }

    public static boolean find(TreeNode root, int b, ListNode head) {
        if (root == null) {
            return false;
        }
        head.next = new ListNode(root.val);
        if (root.val == b) {
            return true;
        }
        boolean l = find(root.left, b, head.next);
        if (l) {
            return true;
        }
        boolean r = find(root.right, b, head.next);
        return r;
    }*/
}