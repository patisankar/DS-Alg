Problem
=======
From index 0, can you reach the last index using the allowed jumps at each position?

Example
=========

For nums = [3, 2, 1, 1, 4], we start at index 0 (value 3). From index 0, we can jump to index 1, 2, or 3 (1, 2, or 3 steps).
* Jump 1 step → index 1 (value 2)
* Jump 2 steps → index 2 (value 1)
* Jump 3 steps → index 3 (value 1)
You can then continue checking from those indices whether the last index (4) is reachable.

Naive Approach
=========
We can explore all possible jump combinations from index 0 to see if we can reach the last index. This means trying every path recursively, which leads to an exponential time complexity.

Greedy vs DP
============
Dynamic Programming (DP):

Use DP when the problem has overlapping subproblems and optimal substructure.
You often need to explore multiple paths or choices and remember intermediate results to avoid redundant work.
DP is generally used when making a local choice doesn’t guarantee a global optimum.
Example: Finding the minimum cost path, longest common subsequence, or knapsack problems.
Greedy Algorithms:

Use greedy when making the best local choice at each step guarantees a global optimum.
Greedy algorithms do not revisit or reconsider previous choices.
