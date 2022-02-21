package tree.leetcode235;

import datastructure.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        while (root != null)
        {
            if (root.val > n1.val && root.val > n2.val)
                root = root.left;
            else if (root.val < n1.val && root.val < n2.val)
                root = root.right;
            else return  root;
        }
        return null;
    }
}
