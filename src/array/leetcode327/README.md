#### 327. Count of Range Sum

* Description

Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.

Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.

Example 1:

Input: nums = [-2,5,-1], lower = -2, upper = 2
Output: 3
Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
Example 2:

Input: nums = [0], lower = 0, upper = 0
Output: 1

* Complexity analysis

Time complexity: O(n log n).

Space complexity: O(n).

* More infos

This was a hard problem, I had trouble understanding how we can use merge sort to solve this problem. 
Hopefully, I found 2 leetcode discussion explaining how they solved the problem and why this solution work. 

Also, understanding how a prefix sum array works and how to use it to get different range sums is helpful. it's the first step before trying to solve the problem. 

You can check this links for more details : 

https://leetcode.com/problems/count-of-range-sum/discuss/1267104/C%2B%2B-SIMPLE-explanation-for-BEGINNERS-to-HARD-problems
https://leetcode.com/problems/count-of-range-sum/discuss/1597810/JAVA-nlogn-based-on