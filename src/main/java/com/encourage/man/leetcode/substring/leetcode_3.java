package com.encourage.man.leetcode.substring;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author machen
 */
public class leetcode_3 {
    /**
     *  题目描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *      示例1：
     *          输入: "abcabcbb"
     *          输出: 3
     *          解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *      示例2：
     *          输入: "bbbbb"
     *          输出: 1
     *          解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1
     *      示例3：
     *          输入: "pwwkew"
     *          输出: 3
     *          解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *
     *     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */


    /**
     * 解题思路：
     * 1。模式识别1：涉及重复次数，使用散列表
     */
    public static void main(String[] args) {
        int n = lengthOfLongestSubstring("s ");
        System.out.println(n);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        //记录最大不重复字串的长度
        int mathLength = 0;
        //记录滑动窗口中出现的字符
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; j < chars.length; ) {
            if (set.contains(chars[j])) {
                mathLength = mathLength > (j - i) ? mathLength : (j - i);
                j = ++i;
                set.clear();
            } else {
                set.add(chars[j++]);
            }
        }
        return mathLength > set.size() ? mathLength : set.size();
    }
}
