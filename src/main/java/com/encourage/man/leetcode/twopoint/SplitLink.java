package com.encourage.man.leetcode.twopoint;

/**
 * @author machen
 */
public class SplitLink {

    /**
     * 86. 分割链表
     * 输入：
     * head = [1,4,3,2,5,2], x = 3
     * 输出：
     * [1,2,2,4,3,5]
     * 思路：
     * 使用两个指针，smallHead，largerHead 这两个哑节点（定义哑节点的目的是为了更方便地处理头节点为空的边界条件）。
     * 顺序遍历原链表，smallHead添加的是小于target的节点， largerHead添加的是大于target的节点
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //定义表头的哑节点
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);

        ListNode smallNode = smallHead;
        ListNode largeNode = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                largeNode.next = head;
                largeNode = largeNode.next;
            }
            head = head.next;
        }

        //遍历结束后，我们将 largeNode 的 next 指针置空，这是因为当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于 target 的节点，我们需要切断这个引用
        largeNode.next = null;
        smallNode.next = largeHead.next;
        return smallHead.next;
    }
}
