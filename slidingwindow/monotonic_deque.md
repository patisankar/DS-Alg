Problem
====
For each segment of contiguous computers of length x, find the minimum available disk space within that segment. Then determine the maximum value among all these minimums.

Example 1

Input: x = 2, the segment length, n = 4, the number of computers, space = [8, 2, 4, 6]

Output: 4

Explanation: The segments of length 2 are [8, 2], [2, 4], and [4, 6]. The minimum values in each segment are 2, 2, and 4, respectively. The maximum of these values is 4

Intiaution
====
We will iterate over each index from left to right and maintain a monotonic deque which will store indices having values in increasing order such that no index is out of the window of size k from the current index. Now, the first element of the deque represents the index in the array which has the minimum value for the given window.

Why
====
Deque hold all increasing order elements => so that we don't have to calculate min for range
And make sure, deque size is  k

Suppose we have the following array: [3,5,1,2,4,3,5] and a window of size 3. Here, we will show what the queue looks like after processing each index.  For clarity, the values that would be pointed to are shown instead of their indices.


i = 0, q = [3],
i = 1, q = [3,5],
i = 2, q = [1], (3 and 5 removed as they are larger than 1.) Answer for window [0,2] is 1
i = 3, q = [1,2], Answer for window [1,3] is 1
i = 4, q = [1,2,4], Answer for window [2,4] is 1
i = 5, q = [2,3], (1 removed as it was out of the current window, 4 removed as it was larger than 3.) Answer for window [3,5] is 2
i = 6, q = [3,5], (2 removed as it was out of the current window) Answer for window [4,6] is 3

