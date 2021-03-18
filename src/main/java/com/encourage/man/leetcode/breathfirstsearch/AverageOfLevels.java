package com.encourage.man.leetcode.breathfirstsearch;

import com.encourage.man.leetcode.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 637: 二叉树的层平均值
 *
 * @author machen
 */
public class AverageOfLevels {

    /**
     * 输入：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出：
     * [3, 14.5, 11]
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageOfLevels = new ArrayList<>();
        if (root == null) {
            return averageOfLevels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            averageOfLevels.add(list.stream().collect(Collectors.averagingDouble(e -> e)));
        }
        return averageOfLevels;
    }
}
