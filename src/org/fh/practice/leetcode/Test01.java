package org.fh.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Test01 {
    public static void main(String[] args) {

    }

    /**
     * 使用map + 一层for循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 两层for循环
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            int temp = target - nums[i];
            for(int j =i+1; j<nums.length; j++){
                if(temp == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
