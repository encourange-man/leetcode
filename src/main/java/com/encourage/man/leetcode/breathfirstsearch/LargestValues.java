package com.encourage.man.leetcode.breathfirstsearch;

import com.encourage.man.leetcode.tree.node.TreeNode;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author machen
 */
public class LargestValues {
    /**
     * 515
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();
        if (root == null) {
            return largestValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxNodeVale = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxNodeVale = Math.max(maxNodeVale, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            largestValues.add(maxNodeVale);
        }
        return largestValues;
    }
}
