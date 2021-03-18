package com.encourage.man.leetcode.tree;

import com.encourage.man.leetcode.tree.node.TreeNode;

/**
 * leetcode110: 判断是否是平衡二叉树
 *
 * @author machen
 */
public class IsBalance {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //计算左子树高度
        int leftHeight = calculateHeight(root.left);
        //计算右子树高度
        int rightHeight = calculateHeight(root.right);

        //计算左右子树高度差值
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        //判断左子树和右子树是否都是平衡的，如果都是，root就是平衡的，否则就不是
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(calculateHeight(root.left) + 1, calculateHeight(root.right) + 1);

    }

}

