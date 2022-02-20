#### 230. Kth Smallest Element in a BST

* Description

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

* Complexity analysis

Time complexity: O(h + k). h is the height of the tree, we should find the first node first, then we try to find to k element.

Space complexity: O(h).