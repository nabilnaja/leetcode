#### 3. Longest Substring Without Repeating Characters

* Description

Given a string s, find the length of the longest substring without repeating characters.

* Complexity analysis

Both solutions have the same complexity. But to be more precise, the first solution complexity is O(2n).

Time complexity: O(n).

Space complexity: O(min(m,n)). m is the size of the HashSet and it's size The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.