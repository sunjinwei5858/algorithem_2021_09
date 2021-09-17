package com.sunjinwei.array;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * ps:
 * 1. 转化 想象成一颗bst 右上角为根节点 来进行二分
 * 2. 注意鲁棒性的判断 i和j的范围
 */
public class FindNumberIn2DArray {

    /**
     * 坐标轴法
     * 如果大于target 那么向左移动
     * 如果小于target 那么向下移动
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
}
