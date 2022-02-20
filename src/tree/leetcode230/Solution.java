package tree.leetcode230;

import datastructure.TreeNode;

import java.util.Stack;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return
                    root.val;
            root = root.right;
        }
    }
}