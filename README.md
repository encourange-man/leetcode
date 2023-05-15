# leetcode

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

