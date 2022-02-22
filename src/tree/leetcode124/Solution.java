package tree.leetcode124;

import datastructure.TreeNode;

public class Solution {
    int max_path_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_path_sum;
    }

    public int max_gain(TreeNode node) {
        if (node == null) return 0;
        int left_sum = Math.max(max_gain(node.left), 0);
        int right_sum = Math.max(max_gain(node.right), 0);

        int nodeTotal = node.val + left_sum + right_sum;

        max_path_sum = Math.max(nodeTotal, max_path_sum);

        return  Math.max(left_sum, right_sum) + node.val;
    }
}
