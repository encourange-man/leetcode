package com.encourage.man.leetcode.breathfirstsearch;

import com.encourage.man.leetcode.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode199: 二叉树的右视图
 *
 * @author machen
 */
public class RightSideView {
    /**
     * 题目描述：
     * 输入：
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     * 输出：
     * [1, 3, 4]
     * <p>
     * 思路：
     * 二叉树的层序遍历，收集每层的最后一个数据
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if (root == null) {
            return rightSideView;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //收集层序遍历每层最后一个节点
                if (i == size - 1) {
                    rightSideView.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightSideView;
    }
}
