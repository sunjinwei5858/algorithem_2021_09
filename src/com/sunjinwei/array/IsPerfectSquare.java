package com.sunjinwei.array;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * 输入：num = 16
 * 输出：true
 * 输入：num = 14
 * 输出：false
 * <p>
 * ps:
 * 1.二分题目
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        // 从 [2, num/2] 的区间范围，每次选取中间的值，来判断。
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long s = mid * mid;
            if (s == num) {
                return true;
            }
            if (s > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();

        boolean perfectSquare = isPerfectSquare.isPerfectSquare(12);
        System.out.println(perfectSquare);
    }
}
