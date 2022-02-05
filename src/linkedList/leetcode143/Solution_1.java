package linkedList.leetcode143;

import datastructure.ListNode;

import java.util.Stack;

public class Solution_1 {

    public void reorderList(ListNode head) {
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            ListNode end = stack.pop();
            if(end == head || head.next == end){
                end.next = null;
                return;
            }
            ListNode temp = head.next;
            temp.next = head.next.next;
            head.next = end;
            end.next = temp;
            head = head.next.next;
        }
    }
}
