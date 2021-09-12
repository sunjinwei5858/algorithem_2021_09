package com.sunjinwei.array;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置 力扣34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * ps:
 * 1.注意细节 找左边界就是收缩右边界 此时返回的left就是答案，但是要做判断 left是否越界 并left对应的值是不是等于target
 */
public class SearchRange {

    /**
     * 分成两次查找即可
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        // 1先找左边界的索引
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                // 收缩右边界
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 鲁棒性判断 bug
        // 判断left是否越界
        if (left > nums.length - 1 || nums[left] != target) {
            return res;
        }
        res[0] = left;
        // 3再找右边界的索引
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                // 收缩左边界
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 4判断是不是等于target
        if (nums[right] == target) {
            res[1] = right;
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] ints = searchRange.searchRange(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}
