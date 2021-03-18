package com.encourage.man.leetcode.backtracking;


/**
 * leetcode79: 单词搜索（二维平面上的回溯算法）
 *
 * @author machen
 */
public class exist {

    //定义顺时针方向
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    //数组的越界deadline
    int m, n;

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findExist(board, i, j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    //从board[x][y] 开始，寻找work[index ... word.size()]
    private boolean findExist(char[][] board, int x, int y, char[] word, int index) {
        //当要查找的字符是字符串的最后一个字符时，判断当前所出的位置是不是等于最后一个字符
        if (index == word.length - 1) {
            return board[x][y] == word[index];
        }

        //初始化数组边界
        m = board.length;
        n = board[0].length;

        //状态标记数组：用于标记某个下标是否被访问过了
        int[][] sign = new int[board.length][board[0].length];

        if (board[x][y] == word[index]) {
            sign[x][y] = 1;


            //从x,y出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = x + direction[i][0];
                int newy = x + direction[i][1];

                //判断新的下标是否满足情况，注意新的下标不能越界
                if (inArea(newx, newy) && sign[x][y] == 0 && findExist(board, newx, newy, word, index + 1)) {
                    //递归
                    return true;
                }
            }

            //四个方向都没有结果
            sign[x][y] = 0;
        }

        return false;
    }

    boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
