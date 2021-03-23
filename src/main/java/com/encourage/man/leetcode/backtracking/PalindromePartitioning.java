package com.encourage.man.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131： 分割回文串
 * leetcode: https://leetcode-cn.com/problems/palindrome-partitioning/solution/fen-ge-hui-wen-chuan-by-leetcode-solutio-6jkv/
 *
 * 题目描述：
 *      给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *      （回文串 是正着读和反着读都一样的字符串）。
 * 案例1：
 *      输入：s = "aab"
 *      输出：[["a","a","b"],["aa","b"]]
 * 案例2：
 *      输入：s = "a"
 *      输出：[["a"]]
 *
 * 思路：
 *      求解全部解的可能，暴力破解，回溯算法
 * @author machen
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> aab = palindromePartitioning.partition("aab");

    }

    /**
     * 方案1： 回溯算法
     *
     * @param s
     * @return
     */
    List<List<String>> str = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, new ArrayList<>(), 0);
        return str;
    }
    /**
     * 回溯主逻辑
     * @param s 原始数据
     * @param preChoice 之前的数据集
     * @param index 当前递归索引的位置
     */
    private void backTrack(String s, List<String> preChoice, Integer index) {
        //递归终止条件，
        if(index == s.length()){
            str.add(new ArrayList<>( preChoice));
            return;
        }

        for(int j = index; j < s.length(); j++ ) {
            //分割子串s[index, j]，判断是否是回文串，如果是添加，
            String substring = s.substring(index, j + 1);
            if(isHuiWen(s, index, j)) {
                preChoice.add(substring);
                backTrack(s, preChoice, j + 1);
                preChoice.remove(preChoice.size() - 1);
            }
        }
    }
    private boolean isHuiWen(String s, Integer left, Integer right) {
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
