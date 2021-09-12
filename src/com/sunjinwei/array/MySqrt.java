package com.sunjinwei.array;

/**
 * x的平方根 力扣69 难度：简单 【腾讯和字节面试题】
 * 给你一个非负整数 x ，计算并返回x的平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * ps：
 * 1.二分相关题目
 */
public class MySqrt {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int s = mid * mid;
            // 在二分查找的每一步中，我们只需要比较中间元素mid 的平方与x的大小关系，
            // 并通过比较的结果调整上下界的范围
            if (s <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
