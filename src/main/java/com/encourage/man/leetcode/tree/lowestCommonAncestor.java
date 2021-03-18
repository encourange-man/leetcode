package com.encourage.man.leetcode.tree;

import com.encourage.man.leetcode.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 offer 68： 二叉搜索树的最近公共祖先
 *
 * @author machen
 */
public class lowestCommonAncestor {

    List<TreeNode> pPathNodes = new ArrayList<>();
    List<TreeNode> qPathNodes = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //临界情况
        if (root == null || p == null) {
            return null;
        }


        pPathNodes = gatherPathNode(root, p, pPathNodes);
        qPathNodes = gatherPathNode(root, p, qPathNodes);

        int end = Math.max(pPathNodes.size(), qPathNodes.size());
        for (int i = end - 1; i > -1; i--) {
            if (pPathNodes.get(i).val == qPathNodes.get(i).val) {
                return pPathNodes.get(i);
            }
        }
        return null;
    }

    private List<TreeNode> gatherPathNode(TreeNode root, TreeNode target, List<TreeNode> pathNodeList) {
        if (root == null) {
            return new ArrayList<>(pathNodeList);
        }
        //添加路径上的节点
        pathNodeList.add(root);
        return target.val > root.val ? gatherPathNode(root.right, target, pathNodeList) : gatherPathNode(root.left, target, pathNodeList);
    }

    public static void main(String[] args) {

    }
}
