package com.encourage.man.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode46: 全排列问题（不含重复数字）
 *
 * @author machen
 */
public class Permute {

    /**
     * 定义结果对象
     */
    private List<List<Integer>> result = new LinkedList<>();

    /**
     * 计算排列结果
     *
     * @param nums:                     问题空间
     * @param index:                    记录处理到那个数字的索引
     * @param process：处理过程中的满足条件的数据保存位置
     * @return
     */
    private void calculatePermute(int[] nums, int index, LinkedList<Integer> process, boolean[] isUsed) {
        //递归终止条件：当 index == nums.length 时， 一次处理过程结束
        if (index == nums.length) {
            //这里的返回有坑
            result.add(new ArrayList<>(process));
            System.out.print("计算得出一组可能组合：");
            process.forEach(System.out::print);
            System.out.println();
            return;
        }

        //递归过程
        for (int i = 0; i < nums.length; i++) {
            //如果nums[i] 没有被使用过，说明当前元素可以使用使用（作为组合中的一个元素）
            if (!isUsed[i]) {
                //将当前元素加入到处理过程数组中，并标记当前元素已经被使用
                System.out.println("process:" + process.toString() + "添加：" + nums[i] + " index:" + index);
                process.add(nums[i]);
                isUsed[i] = true;

                //递归处理下一次情况
                calculatePermute(nums, index + 1, process, isUsed);

                //注意：递归结束回溯后（产出一种情况），此时要清楚当前数字的使用状态，因为下一组尝试需要当前元素
                process.removeLast();
                isUsed[i] = false;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        //边界情况处理
        if (nums.length == 0) {
            return result;
        }

        // 状态数组：用于标记某个元素是否已经被使用过了
        boolean[] isUsed = new boolean[nums.length];
        LinkedList<Integer> process = new LinkedList<>();
        calculatePermute(nums, 0, process, isUsed);

        System.out.println(result.toString());
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Permute permute = new Permute();
        permute.permute(array);
    }
}
