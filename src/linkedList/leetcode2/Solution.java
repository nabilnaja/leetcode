package linkedList.leetcode2;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null){
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = carry + first + second;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            result = result.next;
        }
        if (carry > 0)
            result.next = new ListNode(carry);
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
