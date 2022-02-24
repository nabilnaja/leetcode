package tree.leetcode572;

import datastructure.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        if (isSame(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.val == root2.val
                && isSame(root1.left, root2.left)
                && isSame(root1.right, root2.right));
    }
}
