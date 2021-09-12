package com.sunjinwei.array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {

    /**
     * 搞清楚有哪几种情况，因为退出循环的条件是 left>right，所以直接返回right+1即可 或者 left
     * 1 [0,-1] 最左边 right+1
     * 2 [left, right] 找到
     * 3 [left, right] 在区间中找下一个位置 right+1
     * 4 [left, right] 最右边 right+1
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                // 收缩右边界
                right = mid - 1;
            } else {
                // 收缩左边界
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
