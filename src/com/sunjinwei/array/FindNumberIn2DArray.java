package com.sunjinwei.array;

/**
 * 剑指 Offer 04. 二维数组中的查找【力扣 240 搜索二维矩阵II】
 * <p>
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * ps:
 * 1. 转化 想象成一颗bst 右上角为根节点 来进行二分
 * 2. 注意鲁棒性的判断 i和j的范围
 */
public class FindNumberIn2DArray {

    /**
     * 坐标轴法: 右上角
     * 如果大于target 那么向左移动
     * 如果小于target 那么向下移动
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 鲁棒性
        if (matrix == null) {
            return false;
        }
        // 行
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        // 列
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        // 右上角的索引
        int i = 0;
        int j = n - 1;
        // 开始进行比较
        while (i >= 0 && j >= 0 && i < m && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 坐标轴法：左下角
     * 大于target 那么向上移动
     * 小于target 那么向右移动
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 鲁棒性
        if (matrix == null) {
            return false;
        }
        // 行
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        // 列
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        // 左上角的索引m
        int i = m - 1;
        int j = 0;
        // 开始进行比较
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                // 向上移动
                i--;
            } else {
                // 向右移动
                j++;
            }
        }
        return false;
    }

    /**
     * 两次二分
     * 第一次：找到所在行
     * 第二次：找到所在列
     * ps：第一次二分 要从右上角开始
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        // 第一次二分：找到所在行 横坐标为 [i][column-1];
        int left = 0;
        int right = row - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][column - 1] == target) {
                // 收缩左边界
                left = mid + 1;
            } else if (matrix[mid][column - 1] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0) {
            return false;
        }
        row = right;
        if (matrix[row][column - 1] == target) {
            return true;
        }
        // 第二次二分
        left = 0;
        right = column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
