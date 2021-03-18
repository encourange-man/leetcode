package com.encourage.man.leetcode.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode17: 电话号码的字符组合问题（回溯算法）
 *
 * @author machen
 */
public class PhoneLetterCombinations {

    /**
     * 每个字符数字所代表的字符组合
     */
    private final String[] NUMBER_LETTER = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<>();

    private void calculateLetter(String digits, int index, String previousStr) {
        if (index == digits.length()) {
            result.add(previousStr);
            return;
        }

        //当前数字所代表的字符组合集
        char[] chars = digits.toCharArray();
        char num = chars[index];
        char[] letters = NUMBER_LETTER[num - '0'].toCharArray();

        for (int i = 0; i < letters.length; i++) {
            calculateLetter(digits, index + 1, previousStr + letters[i]);
        }

        return;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        calculateLetter(digits, 0, "");

        return result;
    }
}
