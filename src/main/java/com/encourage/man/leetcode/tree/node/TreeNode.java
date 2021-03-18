package com.encourage.man.leetcode.tree.node;

import lombok.Builder;
import lombok.Data;

/**
 * @author machen
 */

@Builder
@Data
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
