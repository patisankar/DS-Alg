## problem

[remove box - DP_merge_Interval](https://leetcode.com/problems/remove-boxes/description)

## how to slipt original problem into subproblems
1. Our original problem now becomes T(0, n - 1, 0), since there is no boxes attached to the left of the input array at the beginning.
2. The termination conditions now will be:
    a. T(i, i - 1, k) = 0: no boxes so no points, and this is true for any k (you can interpret it as nowhere to attach the boxes).
    b. T(i, i, k) = (k + 1) * (k + 1): only one box left in the subarray but we've already got k boxes of the same color attached to its left,
       so the total number of boxes of the same color is (k + 1) and the maximum point is (k + 1) * (k + 1)
3. The recurrence relation is as follows and the maximum points will be the larger of the two cases: Either we remove or attach
   a. 
