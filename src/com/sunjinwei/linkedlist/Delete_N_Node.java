package com.sunjinwei.linkedlist;

/**
 * 删除倒数第n个节点 【陌陌面试题】
 */
public class Delete_N_Node {

    /**
     * 方法1：使用 fast != null && fast.next != null 来判断
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode deleteNNode(ListNode head, int n) {
        // 情况1：链表为null 或者 n小于等于0
        if (head == null || n <= 0) {
            return head;
        }
        // 情况2：链表只有一个节点 并且 此时的 n大于等于1
        // 这里要请教面试官 这种情况 应该如何返回 是返回null 还是直接头节点
        if (head.next == null) {
            return null;
        }
        // 声明快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 这种写法是让fast可以走到最后一个位置，所以跳出while循环后 n要和1进行比较 而不是和0进行比较
        while (fast != null && fast.next != null) {
            if (n == 0) {
                break;
            }
            fast = fast.next;
            n--;
        }
        // n==1 说明要删除头节点
        if (n == 1) {
            return head.next;
        }
        // 说明n很大 直接返回头节点即可
        if (n > 1) {
            return head;
        }
        // 此时快慢指针继续走 并且采用的方式为可以到达最后一个节点 而不是空节点
        // 这样很好的帮助 我们定位到要删除的节点位置 就是slow的next
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 方法2：使用 fast != null 来判断
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode deleteNNode2(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走n 步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 声明一个pre节点
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // 此时的slow就是要删除的节点
        // 但是要判断一下 删除的节点是不是头节点的情况 此时pre也是为null的
        if (slow == head) {
            return head.next;
        }
        pre.next = slow.next;
        return head;
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Delete_N_Node delete_k_node = new Delete_N_Node();
        ListNode listNode = delete_k_node.deleteNNode(listNode1, 2);

        System.out.println(listNode);
    }
}
