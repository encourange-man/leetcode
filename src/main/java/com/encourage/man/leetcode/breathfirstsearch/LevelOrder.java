package com.encourage.man.leetcode.breathfirstsearch;

import com.encourage.man.leetcode.tree.node.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429: N 叉树的层序遍历
 *
 * @author machen
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);

                for (Node no : node.children) {
                    if (no != null) {
                        queue.offer(no);
                    }
                }
            }
            levelOrder.add(list);
        }
        return levelOrder;
    }
}
