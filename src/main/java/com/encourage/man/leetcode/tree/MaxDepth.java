package com.encourage.man.leetcode.tree;

import com.encourage.man.leetcode.tree.node.TreeNode;

/**
 * @author machen
 */
public class MaxDepth {
    /**
     * 104. 二叉树最大深度
     * 当前节点root的深度 = 其左子树的深度与右子树深度的最大值 + 1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //递归的终止条件
        if (root == null) {
            return 0;
        }
        //重叠子问题
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
