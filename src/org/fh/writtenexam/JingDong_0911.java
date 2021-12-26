package org.fh.writtenexam;

import java.util.*;

public class JingDong_0911 {
    static void p1() {
        Scanner scanner = new Scanner(System.in);
        String[] inStrs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inStrs[0]);
        int m = Integer.parseInt(inStrs[1]);
        int x = Integer.parseInt(inStrs[2]);
        int y = Integer.parseInt(inStrs[3]);
        int z = Integer.parseInt(inStrs[4]);

        int count = 0;
        // 记录元素位置
        Map<Character, int[]> map = new HashMap<>();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String keybords = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                char c = keybords.charAt(j);
                matrix[i][j] = c;
                map.put(c, new int[]{i, j});
            }
//           matrix[i] = keybords.toCharArray();
        }
        String target = scanner.nextLine();

        int row = 0, col = 0;
        for (char c : target.toCharArray()) {
            // 获取字符位置
            int[] loc = map.get(c);
            int a = loc[0];
            int b = loc[1];
            // 判断是否移动
            if (c != matrix[row][col]) {
                // 移动次数 * 移动耗时
                int move = Math.abs(a - row) + Math.abs(b - col);
                count += move * x;

                // 转向
                if (row != a && col != b) {
                    count += y;
                }
                // 更新当前位置
                row = a;
                col = b;
            }
            // 点击
            count += z;
        }
        System.out.println(count);
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(matrix[i][j]);
            }
        }*/
    }


    static void p2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        Set<Integer> status = new HashSet<>();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
            /*if (map.get(c) != null) {
                set = map.get(c);
            } else {
                set = new HashSet<>();
            }*/
            for (int j = 0; j < c; j++) {
                int num = scanner.nextInt();
                set.add(num);
            }
            map.put(c, set);
        }
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int num = scanner.nextInt();
            if (op == 1 && !status.contains(num)) {
                status.add(num);
                Set<Integer> set = map.get(num);
                status.addAll(set);
            }
            if (op == 0 && status.contains(num)) {
                for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().contains(num)) {
                        status.remove(num);
                        status.remove(entry.getKey());
                    }
                }
            }
            System.out.println(status.size());
        }
    }
}
