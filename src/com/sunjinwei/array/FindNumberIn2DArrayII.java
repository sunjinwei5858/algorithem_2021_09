package com.sunjinwei.array;

/**
 * 74 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * ps:
 * 1.坐标轴法：左下角或者右上角 都可以
 */
public class FindNumberIn2DArrayII {

    /**
     * 坐标轴法：左下角
     * 如果大于target 那么往上移动
     * 如果小于target 那么往右移动
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
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
        // 左下角的索引
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    /**
     * 坐标轴法：右上角
     * 大于target：向左移动
     * 小于target：向下移动
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
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

        while (i < m && j >= 0) {
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
     * 二分法：两次二分
     * 第一次：找到所在的行
     * 第二次：找到所在的列
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        // 第一次二分 找到目标值在的最大的行 也可能不存在
        // 找右边方向的值
        int left = 0;
        int right = row - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                // 收缩左边界
                left = mid + 1;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 进行判断
        row = right;
        // 检查是否越界
        if (row < 0) {
            return false;
        }
        if (matrix[row][0] == target) {
            return true;
        }
        // 第二次二分
        // 定位到所在的行 二分寻找列
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
