package com.encourage.man.leetcode.dynamicprogram;

/**
 * @author machen
 */
public class MinPathSum {

    /**
     * leetcode64. 最小路径和 （0-1背包问题的衍生）
     * 状态T[i][j]: 表示到(i,j)位置的最小路径和
     * 状态转移方程： T[i][j] = Min{ T[i-1][j], T[i][j-1]} + grid[i][j]
     * 终止条件：遍历到右下角就终止
     * <p>
     * 时间复杂度：O(mn), 空间复杂度O(mn) 需要将整个数组遍历一遍
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[][] remember = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            if (j == 0) {
                remember[0][j] = grid[0][j];
            } else {
                remember[0][j] = remember[0][j - 1] + grid[0][j];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            remember[i][0] = remember[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                remember[i][j] = Math.min(remember[i - 1][j], remember[i][j - 1]) + grid[i][j];
            }
        }
        return remember[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}};
        System.out.println(minPathSum(grid));
    }
}
