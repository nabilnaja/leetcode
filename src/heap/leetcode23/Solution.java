package heap.leetcode23;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        ListNode tail = head;
        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            if (tail.next.next != null)
                heap.add(tail.next.next);
            tail = tail.next;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
