package com.encourage.man.leetcode.dynamicprogram;

/**
 * @author machen
 */
public class CountSubstrings {
    /**
     * 647. 回文子串
     * 思路： 中心扩展法
     * 枚举每一个可能的回文中心，然后两指针向两边扩展，出现不相同时，停止扩展  <br> 长度为n的字符串，会有2n-1组回文中心
     * 假设 n = 4, 可能的回文中心：
     * 编号 i          	回文中心左起始位置 Li            回文中心右起始位置 Ri
     * 0	                0	                            0
     * ​          1	                0	                            1
     * 2	                1	                            1
     * 3	                1	                            2
     * 4	                2	                            2
     * 5	                2	                            3
     * 6	                3	                            3
     * <p>
     * 长度为 nn 的字符串会生成 2n-12n−1 组回文中心 [l_i, r_i]， l_i = i / 2, r_i = l_i + (i % 2)
     * 这样我们只要从 00 到 2n - 22n−2 遍历 ii，就可以得到所有可能的回文中心，这样就把奇数长度和偶数长度两种情况统一起来了
     * ​
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
