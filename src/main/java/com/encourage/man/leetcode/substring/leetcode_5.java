package com.encourage.man.leetcode.substring;


/**
 * 5: 最长回文字串
 *
 * @author machen
 */
public class leetcode_5 {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        //最长字串的区间下标，中间变量maxLength记录最长的长度
        int r = 0;
        int k = 0;
        int maxLength = 0;

        //左闭右闭区间
        for (int i = 0, j = 0; i < chars.length; ) {
            if (isPalindromeString(chars, i, j)) {
                if (maxLength > j - i + 1) {
                    maxLength = j - i + 1;
                    r = i;
                    k = j;
                    ++j;
                }
            } else {
                ++i;
                j = i;
            }
        }
        return "";
    }

    /**
     * 判断是否是回文串
     *
     * @param chars
     * @return
     */
    private static boolean isPalindromeString(char[] chars, int start, int end) {
        if (chars.length == 1 || chars.length == 0) {
            return false;
        }
        //区间左闭右闭
        for (int i = start, j = end; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
