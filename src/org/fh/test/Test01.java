package org.fh.test;

import utils.TreeNode;

import java.util.*;

public class Test01 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                hashMap.put(poll.val, hashMap.getOrDefault(poll.val, 0));
                set.add(hashMap.getOrDefault(poll.val, 0));
                if (poll.left != null) {
                    if (set.add(hashMap.get(poll.val) - 1)) {
                        deque.offer(poll.left);
                        hashMap.put(poll.left.val, hashMap.get(poll.val) - 1);
                    }
                }
                if (poll.right != null) {
                    if (set.add(hashMap.get(poll.val) + 1)) {
                        deque.offer(poll.right);
                        hashMap.put(poll.right.val, hashMap.get(poll.val) + 1);
                    }
                }
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(hashMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entries) {
            res.add(entry.getKey());
        }
        return res;
    }
}
