
- [leetcode](#leetcode)
  - [Tips](#tips)
    - [摩尔投票算法](#摩尔投票算法)
  - [树](#树)
  - [链表](#链表)
  - [回溯算法](#回溯算法)
  - [子串问题](#子串问题)
  - [广度优先遍历](#广度优先遍历)
  - [双指针](#双指针)
    - [快慢指针](#快慢指针)
      - [26.删除有序数组中的重复项](#26删除有序数组中的重复项)
      - [80.删除有序数组中的重复项II](#80删除有序数组中的重复项ii)
  - [贪心算法](#贪心算法)
    - [55.跳跃游戏I](#55跳跃游戏i)
    - [45.跳跃游戏II](#45跳跃游戏ii)
  - [动态规划](#动态规划)
    - [509.斐波那契数列-（体会重叠子问题）](#509斐波那契数列-体会重叠子问题)
    - [322.凑零钱](#322凑零钱)
    - [64.最小路径和](#64最小路径和)
    - [120.三角形最小路径和](#120三角形最小路径和)
    - [买卖股票的最佳时机](#买卖股票的最佳时机)


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

## 数组/字符串
### 14.最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
```java
/***
 * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
 * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，
 * 当前列之前的部分为最长公共前缀。
 * 
 * 时间复杂度：O(mn)，
 * m 是字符串数组中的字符串的平均长度，
 * n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c || i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
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
贪心算法可以理解为一中特殊的动态规划问题，拥有一些更特殊的性质，可以进一步降低动态规划算法的时间复杂度。有关动态规划的问题，大多是让你求最值，比如最长子序列，最小编辑距离，最长公共子串等等。因为动态规划的本身就是运筹学里的一种求最值的算法。

下面以两个经典的贪心算法为例：跳跃问题I 和 跳跃问题II，理解一下贪心算法的动态规划的不同。

### 55.跳跃游戏I
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
 * 思路：
 *  如果每一步都跳最大的长度，那么只需要判断最后一步，是否能到达最后一个下标即可。
 *  每一步都取最大的长度，这就是一个局部最优
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
### 45.跳跃游戏II
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标。数组中的每个元素代表你在该位置可以条约的最大长度。你的目标是使用**最少**的跳跃次数到达数组的最后一个位置。假设你总是可以达到数组的最后一个位置。

```text
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
```

```java
/**
 * 现在的意思就是：保证你一定可以跳到最后一格，请问最少要跳多少次，才能跳度过去。
 * 
 * 看到求最值，第一个想到动态规划，尝试下动态规划的思路：
 * 
 */
```


## 动态规划
动态规划其实是运筹学的一种最优化方法，一般形式就是求最值。求解动态规划核心问题就是穷举。穷举所有可行解其实并不是一件容易的事，需要你熟练掌握递归思维，只有列出正确的「状态转移方程」，才能正确地穷举。
而且，你需要判断算法问题是否具备「最优子结构」，是否能够通过子问题的最值得到原问题的最值。另外，动态规划问题存在「重叠子问题」，如果暴力穷举的话效率会很低，所以需要你使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
动态规划的三要素：
- 重叠子问题
- 最优子结构
- 状态转移方程

一个思维框架，辅助思考状态转移方程：

**明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义**

```java
//自顶向下递归的动态规划
dp(状态1, 状态2, ...):
    for 选择 in 所有可能的选择:
        // 此时的状态已经因为做了选择而改变
        result = 求最值(result, dp(状态1, 状态2, ...))
    return result

//自底向上迭代的动态规划
//初始化 base case
dp[0][0][...] = base case
//进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)

```

序号 | 题目  | 思路
---|--- | ---
509 | 斐波那契数 | 如何通过「备忘录」 或者「dp table」的方法优化递归树
322|凑零钱 | 如何流程化的确定「状态转移方程」，只要通过状态转移方程写出暴力递归树，剩下的也就是优化递归树，消除重叠子问题
120 | 三角形最小路径和 |
64 | 最小路径和 | 0-1背包的衍生题目
53 | 最大子序和 |
5 | 回文子串 |  （中心扩展法）枚举每一个可能的回文中心，然后两指针向两边扩展，出现不相同时，停止扩展  <br> 长度为n的字符串，会有2n-1组回文中心
132 | 分割回文串II |
70 | 爬楼梯 | 空间复杂度优化方向：使用滚动窗口 O(1)
198 | 打家劫舍 | 动态规划 + 滚动数组 （整理笔记）
213 | 打家劫舍II | TODO

### 509.斐波那契数列-（体会重叠子问题）
斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n)

```java
//递归版本
class Solution {
    public int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
```
> 带备忘录的递归解法(自顶向下)：
```java
/***
 * 带备忘录的递归解法：
 *  递归版本中有大量的重复计算（重叠子问题），可以造一个「备忘录」，将每次子问题的结果存储到备忘录中，
 *  如果备忘录中已经有子问题的计算结果，直接将答案取出来即可
 */
class Solution {
  public int fib(int n) {
    int[] memo = new int[n + 1];
    //自顶向下求解
    return dp(memo, n);
  }
  
  //带着备忘录进行递归
  public int dp(int[] memo, int n) {
      //base case
      if(n == 0 || n == 1){
          return 1;
      }
      
      //如果备忘中有值，说明该子问题已经计算过了，直接返回
      if(memo[n] != 0) {
          return memo[n];
      }
      
      memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
      return memo[n];
  }
}
```
> 带dp table的迭代解法（自底向上）：
```java
/**
 * 带dp table的迭代（递推）解法：自底向上的解法
 *  f(n) = f(n-1) + f(n-2)
 */
class Solution {
  public int fib(int n) {
    //base case
    if (n == 0 || n == 1) {
      return n;
    }

    //代表dp[i-2]
    int dp_i_2 = 0;
    //代表dp[i-1]
    int dp_i_1 = 1;

    for (int i = 2; i <= n; i++) {
      //状态转移方程
      int dp = dp_i_1 + dp_i_2;
      dp_i_2 = dp_i_1;
      dp_i_1 = dp;
    }
    return dp_i_1;
  }
}
```
### 322.凑零钱
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

```text
示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
```
```text
首先，这个问题是不是动态规划，是否具有「最优子结构」。要符合「最优子结构」，子问题之间必须独立，假设要从面值1，2，5
的硬币中凑出amount=11的最少硬币数，如果知道amount=10,9,6 的最少硬币（子问题），只需要把子问题的答案+1
（再选一枚1，2，5的硬币），求个最值，这就是原文题的答案。因为硬币的数量是没有限制的，所有子问题之间是独立的。

既然是动态规划，如何思考出正确的状态转移方程？
1.确定base case。当amount=0时算法返回0，因为不需要任何硬币就已经凑出目标金额

2.确定「状态」，也就是原文题和子问题中变化的变量。由于硬币的数量是无限的，硬币的面额也是给定的，所有只有
amount是不断的变化的。

3.确定「选择」，也就是导致「状态」产生变化的行为。目标金额为什么变化，因为选择了不同的硬币，所以硬币的面额
就是你的选择。

4.明确「dp函数」的定义。自顶向下的解法，会有一个递归的dp函数，一般来说函数的参数就是状态转移过程中会变化的值，
函数的返回值就是我们要计算的值。所以就本题来说，状态只有一个，即「目标金额」。所以可定义dp函数：dp(n)表示，
输入一个目标金额n，返回凑出目标金额 n 所需要的最少硬币数量
```
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        //最终结果是dp(amount)
        return dp(coins, amount);
    }

    int dp(int[] coins, int n) {
        //base case
        if(n == 0) return 0;
        if(n < 0) return -1;

        //记录最优结果
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            //做选择后，计算子问题的结果
            int subProblem = dp(coins, n - coin);
            //子问题无解，则跳过
            if(subProblem == -1) continue;

            //在子问题中选择最优解
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
```
> 带备忘录的递归：
```java
/***
 * 消除重叠子问题，带备忘录的递归
 */
class Solution {
    //备忘录
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        //备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    int dp(int[] coins, int n) {
        //base case
        if(n == 0) return 0;
        if(n < 0) return -1;
        //备忘录，防止重复计算
        if(memo[n] != -666) {
            return memo[n];
        }

        //记录最优结果
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            //做选择后，计算子问题的结果
            int subProblem =  dp(coins, n - coin);
            //子问题无解，则跳过
            if(subProblem == -1) continue;

            //在子问题中选择最优解
            res = Math.min(res, subProblem + 1);
        }

        //把计算结果存入备忘录中
        memo[n] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[n];
    }
}
```
> dp 数组的迭代解法：
```java
/**
 * dp数组的定义和上面dp函数类似，也是把「状态」即目标金额作为变量。
 * 不过dp函数体现在函数参数，而dp数组体现在数组索。
 * dp数组的定义：
 *      当目标金额为 i 时， 至少需要dp[i]枚硬币凑出。
 *
 *          0, n==0
 * dp(n) =  -1, n < 0
 *          min{dp(n - coin) + 1}
 *
 * 为什么dp数组要初始化为amount + 1 ？
 *  因为凑成amount金额的硬币最多只能等于amount，最后求的是最小值，所以 amount + 1 就相当于正无穷了
 *
 */
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        //初始化dp数组,
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //base case
       dp[0] = 0;

       //遍历所有目标金额
       for(int i = 0; i < dp.length; i++) {

          for (int coin : coins) {
              //子问题无解，跳过
              if(i - coin < 0) {
                continue;
              }
              dp[i] = Math.min(dp[i], dp[i - coin] + 1);
          }
       }
       return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
```

### 64.最小路径和
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
```text
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

输入：grid = [[1,2,3],[4,5,6]]
输出：12
```
> 带备忘录的递归操作（自顶向下）：
```java
/***
 * dp[i][j] 表示从(0,0)到(i,j)最小路径和
 * 
 *              0, i<0 || j<0
 *              dp(grid, 0, j -1) + grid[i][j]， i=0 && j>0
 * dp[i][j] =   dp(grid, i - 1, j) + grid[i][j] ，i>0 && j==0
 *              Math.min(dp(grid, i-1, j), dp(grid, i, j-1)) + grid[i][j], i >0 && j>0
 */
class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        //初始化备忘录
        memo = new int[grid.length][grid[0].length];
        for(int i =0; i<grid.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        return dp(grid, grid.length-1,grid[0].length-1);
    }

    int dp(int[][] grid, int i, int j) {
        //base case
        if(i < 0 || j < 0) {
            return 0;
        }
        //备忘录中字问题如果已经计算过，直接返回
        if(memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        int res;
        if(i == 0 && j >= 0) {
            res =  dp(grid, 0, j -1) + grid[i][j];
        } else if(j == 0 && i >= 0) {
            res =  dp(grid, i - 1, j) + grid[i][j];
        } else{
            res =  Math.min(dp(grid, i-1, j), dp(grid, i, j-1)) + grid[i][j];
        }

        //子问题结果保存到备忘录中
        memo[i][j] = res;
        return res;
    }
}
```
> 带dp table的遍历（自底向上）：

```java
class Solution {

    public int minPathSum(int[][] grid) {
        //dp table
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                }

                if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }

                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }

                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

}
```

### 120.三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

```text
示例1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为11（即，2+ 3 + 5 + 1 = 11）。

示例2：
输入：triangle = [[-10]]
输出：-10
```


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


