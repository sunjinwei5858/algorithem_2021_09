package com.sunjinwei.array;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * ps:
 * 数组元素的 索引 和 值 是 一对多 的关系。
 * 因为所有数字都是在 0 - (n-1)的范围 ，所以可以把数字进行归位
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            swap(nums, nums[i], i);
            i--;
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int number = findRepeatNumber.findRepeatNumber(nums);
        System.out.println(number);
    }
}
