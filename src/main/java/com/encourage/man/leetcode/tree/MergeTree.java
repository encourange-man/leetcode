package com.encourage.man.leetcode.tree;

import com.encourage.man.leetcode.tree.node.TreeNode;

/**
 * @author machen
 */
public class MergeTree {

    /**
     * 617. 合并二叉树
     * <p>
     * 思路：有三种情况
     * root1 == null && root2 == null，合并后节点为null
     * root1 == null && root2 != null, 合并后节点为root2
     * root1 != null && root2 == null, 合并后节点为root1
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        // 中
        root1.val += root2.val;
        //左
        root1.left = mergeTrees(root1.left, root2.left);
        // 右
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
