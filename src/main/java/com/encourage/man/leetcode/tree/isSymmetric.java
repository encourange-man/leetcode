package com.encourage.man.leetcode.tree;


import com.encourage.man.leetcode.tree.node.TreeNode;

/**
 * leetcode101: 对称二叉树
 *
 * @author machen
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }


    /**
     * 使用两个指针同步遍历整个树
     *
     * @param leftRoot
     * @param rightRoot
     * @return
     */
    private boolean symmetric(TreeNode leftRoot, TreeNode rightRoot) {
        // 递归终止条件
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }

        return leftRoot.val == rightRoot.val && symmetric(leftRoot.left, rightRoot.right) && symmetric(leftRoot.right, rightRoot.left);
    }

}
