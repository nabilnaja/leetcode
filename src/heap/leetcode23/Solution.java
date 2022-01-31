package heap.leetcode23;


import datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution {

    // todo : Add a new solution using -> Quickselect (Hoare's selection algorithm)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
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
}
