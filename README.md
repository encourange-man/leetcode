
# leetcode

## Tips
### 摩尔投票算法
给定一个数组nums，找出其中出现次数大于 [n/2]的元素，[LeetCode题目：多数元素](https://leetcode.cn/problems/majority-element/)
```java
/**
 * 思路：
 *  如果我们把众数记为+1，把其他数记为−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多
 *  
 * 算法：
 *  我们定义了两个变量 candidate 和 count ， candidate 存储当前候选元素， count 存储当前元素出现的次数。 
 *  遍历列表中的每个元素，如果 count 为0，则将当前元素设置为候选元素。
 *  然后，如果当前元素等于候选元素，则将计数器加1，否则将计数器减1。如果计数器变为0，则更新候选元素为当前元素。 
 *  最终， candidate 变量将包含出现次数超过一半的元素，并作为结果返回
 *  
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
```

## 树
序号 | 题目  | 思路
---|--- | ---
110 | 判断是否是平衡二叉树 | 注意：最后返回结果的判断逻辑 
101 | 对称二叉树 | 在树中使用双指针 
98 | 验证二叉搜索树 | 验证树的中序遍历的结果是否是严格的升序数组
104 | 二叉树最大深度 | DFS(后序遍历)
111 | 二叉树的最小深度 | DFS
543 | 二叉树的直径 | 

## 链表
序号 | 题目  | 思路
---|--- | ---
146 | LRU | hash表 + 双向链表 【收藏】
147 | 对链表进行插入排序 | TODO
148 | 排序链表 | 归并排序（TODO）

## 回溯算法
序号 | 题目  | 思路
---|--- | ---
17 | 电话号码的字母组合 | 回溯之组合问题 
46 | 全排列 | 回溯之排列问题
77 | 组合问题 |
131 | 分割回文串 |  回溯 + 动态规划

## 子串问题

序号 | 题目  | 思路
---|--- | ---
3 | 无重复字串的最长字串 | 滑动窗口
5 | 最长回文字串问题 | 滑动串窗口 + 回文串的判断

## 广度优先遍历
序号 | 题目  | 思路
---|--- | ---
102 | 二叉树层序遍历 | 
107 | 二叉树层序遍历II | 
199 | 二叉树的右视图 | 层序遍历，收集每层的最后一个值
637 | 二叉树的层平均值 |
429 | N 叉树的层序遍历 | 
515 | 在每个树行中找到最大值 | 
116 | 填充每个节点的下一个右侧节点指针【TODO】 |  

## 双指针
序号 | 题目  | 思路
---|--- | ---
86 | 分割链表 |
141 | 环形指针 | 快慢指针
142 | 唤醒指针II|
76 | 最小覆盖子串【困难】 | TODO（有点难，没想明白）
### 快慢指针
#### 26.删除有序数组中的重复项
升序数组，原地删除重复出现的元素，空间复杂度O(1)，不改变元素的相对位置
[LeetCode题目](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&id=top-interview-150)
```java
/**
 * 慢指针slow走在后面, 快指针走在前面探路，nums[0..slow] 就是不重复的数据区间，
 * 因为是升序数据，所以只需要比较nums[fast] ?= nums[slow] 就能判断是否是重复的数据
 * 找到一个不重复的数据，slow++, nums[slow] = nums[fast]
 */

public int removeDuplicates(int[] nums) {
    if(nums.length == 0) {
        return 0;
    }
    int slow = 0; int fast = 0;
    while (fast < nums.length) {
        if(nums[slow] != nums[fast]) {
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
    }
    return slow + 1;
}
```
#### 80.删除有序数组中的重复项II
升序数组，原地删除重复出现的元素，保证重复出现的元素次数不超过2个，空间复杂度O(1) [LeetCode题目](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/)

```java
/**
 * 因为要求元素最多出现两次，且是升序的数组，所以只需要检查上一个被保存的元素nums[slow-2] ?= nums[fast]
 * 注意：数组的前两个元素必然需要被保留，所以数组的长度需要大于2
 */
public int removeDuplicates(int[] nums) {
    if(nums.length < 2) {
        return nums.length;
    }

    int slow = 2; int fast = 2;
    while (fast < nums.length) {
        if(nums[slow-2] != nums[fast]) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
}
```

## 贪心算法
### 跳跃游戏
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标
```text
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
```

```java
/**
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        int step = 0;
        for(int i = 0; i < nums.length -1; i++) {
            //不断计算能跳到的最远位置（局部最优）
            step = Math.max(step, i + nums[i]);
            //可能碰到0，卡住就跳不多了
            if(step <= i) {
                return false;
            }
        }
        return step >= (nums.length -1);
    }
}
```
### 跳跃游戏II



## 动态规划
序号 | 题目  | 思路
---|--- | ---
120 | 三角形最小路径和 | 
64 | 最小路径和 | 0-1背包的衍生题目
53 | 最大子序和 | 
5 | 回文子串 |  （中心扩展法）枚举每一个可能的回文中心，然后两指针向两边扩展，出现不相同时，停止扩展  <br> 长度为n的字符串，会有2n-1组回文中心
132 | 分割回文串II | 
70 | 爬楼梯 | 空间复杂度优化方向：使用滚动窗口 O(1)
198 | 打家劫舍 | 动态规划 + 滚动数组 （整理笔记）
213 | 打家劫舍II | TODO

### 买卖股票的最佳时机
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0。

```text
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
```

```java
/**
 * TODO:再润色一下，还不是完全理解
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
```


