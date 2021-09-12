package com.sunjinwei.array;

/**
 * 螺旋矩阵II 力扣59
 * 这是力扣54 的变种
 * 给你一个正整数 n ，生成一个包含 1 到 n * n 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * ps:
 * 1.继续采用螺旋矩阵54的思路
 */
public class SpiralOrderII {

    /**
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 方向 1代表从左到右 2代表从上到下 3代表从右到左 4代表从下到上
        int direction = 1;
        // 矩阵中元素的位置
        int i = 0;
        int j = 0;
        // 访问过的位置
        boolean[][] visited = new boolean[n][n];
        for (int index = 0; index < n * n; index++) {
            res[i][j] = index + 1;
            visited[i][j] = true;
            // 处理方向
            if (direction == 1 && (j == n - 1 || visited[i][j + 1])) {
                direction = 2;
            }
            if (direction == 2 && (i == n - 1 || visited[i + 1][j])) {
                direction = 3;
            }
            if (direction == 3 && (j == 0 || visited[i][j - 1])) {
                direction = 4;
            }
            if (direction == 4 && (i == 0 || visited[i - 1][j])) {
                direction = 1;
            }
            // 处理索引
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
