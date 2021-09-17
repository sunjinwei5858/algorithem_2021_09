package com.sunjinwei.array;

/**
 * 74 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * ps:
 * 1.二维数组中的查找这道题是以右上角为根节点，
 * 2.这道题就是变种，以左下角为根节点，从上到下是递增 从左到右是递增
 */
public class FindNumberIn2DArrayII {

    /**
     * 坐标轴法：
     * 如果大于target 那么往上移动
     * 如果小于target 那么往右移动
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
        // 左上角的索引
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
}
