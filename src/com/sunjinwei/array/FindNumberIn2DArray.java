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
 * 3.一行一行的二分
 */
public class FindNumberIn2DArray {

    /**
     * 坐标轴法: 右上角
     * 如果大于target 那么向左移动
     * 如果小于target 那么向下移动
     * <p>
     * 时间复杂度：O（m+n）
     * 空间复杂度: O(1)
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
     * 一行一行的进行二分
     * 时间复杂度：如果是 m 行 n 列，就是 O(mlog(n))
     * 空间复杂度：O（1）
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            // 剪枝：如果该行第一列的元素大于target 退出循环
            if (matrix[i][0] > target) {
                break;
            }
            // 剪枝：如果该行最后一列元素小于target 进入下一个
            if (matrix[i][column - 1] < target) {
                continue;
            }
            // 进入二分处理
            int res = binarySearch(matrix, i, column, target);
            if (res != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[][] matrix, int row, int column, int target) {
        int left = 0;
        int right = column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                // 这里要返回mid 不能返回target 因为target也可能等于-1
                return mid;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
