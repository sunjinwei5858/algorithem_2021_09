package com.sunjinwei.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵 力扣54 各大互联网公司面试题
 * 别名：顺时针打印矩阵【剑指offer29】
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * ps:
 * 1这道题剑指offer上也有 比较经典
 */
public class SpiralOrder {

    /**
     * 1.采用力扣评论上一位作者的解法 区间为左闭右开
     * 顺时针：
     * 从左到右1
     * 从上到下2
     * 从右到左3
     * 从下到上4
     * 2.如果矩阵中的数字有范围限制 那么visited数组可以直接使用matrix代替 不需要声明额外的数组了
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 方向 1代表从左到右 2代表从上到下 3代表从右到左 4代表从下到上
        int direction = 1;
        // 总共有多少个数字 m行n列
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;
        ArrayList<Integer> res = new ArrayList<>();
        // 矩阵的第一个元素索引
        int i = 0;
        int j = 0;
        // 声明访问过的位置
        boolean[][] visited = new boolean[m][n];
        for (int index = 0; index < len; index++) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            // 判断是否要切换方向
            // 向右变向下
            if (direction == 1 && (j == n - 1 || visited[i][j + 1])) {
                direction = 2;
            }
            // 向下变向左
            if (direction == 2 && (i == m - 1 || visited[i + 1][j])) {
                direction = 3;
            }
            // 向左变向上
            if (direction == 3 && (j == 0 || visited[i][j - 1])) {
                direction = 4;
            }
            // 向上变向右
            if (direction == 4 && (i == 0 || visited[i - 1][j])) {
                direction = 1;
            }
            // 根据在什么方向移动 进行索引++
            if (direction == 1) {
                j++;
            }
            if (direction == 2) {
                i++;
            }
            if (direction == 3) {
                j--;
            }
            if (direction == 4) {
                i--;
            }
        }
        return res;
    }
}
