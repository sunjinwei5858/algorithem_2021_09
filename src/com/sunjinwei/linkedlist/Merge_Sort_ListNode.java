package com.sunjinwei.linkedlist;

/**
 * 合并有序链表
 * ps:
 * 1.递归法
 * 2.迭代法：想到哨兵节点 O(1)空间
 */
public class Merge_Sort_ListNode {

    public ListNode mergeSortListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeSortListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeSortListNode(l1, l2.next);
        return l2;
    }

    public ListNode mergeSortListNode2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 使用哨兵节点
        ListNode shaobing = new ListNode(-1);
        ListNode curr = shaobing;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) {
            curr.next = l2;
        }else {
            curr.next = l1;
        }
        return shaobing.next;
    }


}
