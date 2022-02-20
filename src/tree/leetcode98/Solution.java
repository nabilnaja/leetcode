package tree.leetcode98;


import datastructure.TreeNode;

public class Solution {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev =  null;
        return isValidBSTUtil(root);
    }

    public boolean isValidBSTUtil(TreeNode root) {
        if (root != null){
            if (!isValidBSTUtil(root.left))
                return false;
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            return isValidBSTUtil(root.right);
        }
        return true;
    }
}
