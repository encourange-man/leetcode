package com.encourage.man.leetcode.dynamicprogram;

/**
 * @author machen
 */
public class RobI {
    /**
     * 198. 打家劫舍
     * 思路：递归使用记忆化搜索的方式解决
     *
     *                      考虑 [0..n-1] 范围的房子
     *                   偷(0) /         | 偷(1)      \ 偷(n-1)
     *                考虑[2..n-1]   考虑[2..n-1]    考虑[]
     *              偷(2)/   偷(3)\
     *        考虑[4..n-1]   考虑[5..n-1]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //定义记忆话中间数据空间
        int[] array  = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            array[i] = -1;
        }
        return solve(nums.length - 1, nums, array);
    }

    public int solve(int index,int[] nums,int[] array){
        if(index < 0){
            return 0;
        }
        //有记忆过中间数据，直接返回
        if(array[index] != -1){
            return array[index];
        }

        int max = 0;
        max=  Math.max(nums[index] + solve(index-2,nums,array), solve(index-1,nums,array));
        array[index] = max;
        return max;
    }


    /**
     * 思路：动态规划 + 滚动数组
     *
     *  对于第 k (k>2) 间房屋，有两个选项：
     *          1。偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 k 间房屋的金额之和。
     *          2。不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
     *  在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kk 间房屋能偷窃到的最高总金额
     *
     *  状态定义：
     *          dp[i] - 表示前 ii 间房屋能偷窃到的最高总金额
     *  状态转移方程：
     *          dp[i] = max{dp[i-1], dp[i-2] + nums[i]}
     *  边界情况：
     *          dp[0] = nums[0]             ​只有一间房屋，则偷窃该房屋
     *          dp[1]=max(nums[0],nums[1])  只有两间房屋，选择其中金额较高的房屋进行偷窃
     *
     * 最终的答案即为 dp[n−1]，其中 n 是数组的长度。
     *
     * 备注：
     *      考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


}
