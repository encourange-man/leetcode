package com.encourage.man.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode77: 组合问题
 * 题目描述：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 *
 * @author machen
 */
public class Combine {

    /**
     * 定义结果对象
     */
    private List<List<Integer>> result = new LinkedList<>();


    /**
     * 计算组合过程
     *
     * @param n
     * @param k
     * @param start:   可选空间为[start, n]， 因为[1,2]和[2,1]是一个组合，所以默认向后查找选择空间
     * @param process: 中间过程，存储中间满足条件和数据
     */
    private void calculateCombine(int n, int k, int start, LinkedList<Integer> process) {
        //递归终止条件
        if (process.size() == k) {
            System.out.print("计算得出一组可能组合：");
            process.forEach(System.out::print);
            System.out.println();
            result.add(new ArrayList<>(process));
            return;
        }

        //递归过程
        for (int i = start; i <= n; i++) {
            System.out.println("process 添加 " + process.toString() + "元素：" + start + " index: " + i);
            process.add(i);

            calculateCombine(n, k, i + 1, process);

            System.out.println("回溯删除：" + process.getLast());
            process.removeLast();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        //边界情况
        if (n == 0 || k == 0 || k > n) {
            return result;
        }

        LinkedList<Integer> process = new LinkedList<>();

        calculateCombine(n, k, 1, process);

        return result;
    }

    public static void main(String[] args) {

        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(combine1.toString());


    }
}
