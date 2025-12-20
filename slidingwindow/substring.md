What is Sliding Window 
=========
Sliding Window is used when we need to process contiguous subarrays / substrings while maintaining some running condition efficiently.
Sliding window lets me process all valid substrings in linear time by expanding when the constraint holds and shrinking only when it breaks.

When to choose Sliding Window 
==========
Say this explicitly:
I choose sliding window because the problem asks for the longest / shortest / count of a contiguous subarray or substring under a constraint.
Typical constraints:
* count ≤ k
* sum ≤ k
* at most k distinct
* at most k bad / abnormal characters
If the array/string is contiguous and the constraint is monotonic (only grows or shrinks), sliding window applies.

Core idea
=========
We maintain a window using two pointers:
* left → start of window
* right → end of window
We expand the window to include new elements and shrink it only when the condition breaks.

Explanation 
===========
I use two pointers to maintain a sliding window. As I move the right pointer, I update the count of abnormal characters. If the count exceeds the allowed limit, I shrink the window from the left until the condition is valid again. At each valid window, I update the maximum length.

Step-by-step logic 
===========
1. Initialize left = 0
2. Traverse the array/string with right
3. Update the count of non-normal / abnormal characters
4. If the count exceeds the allowed limit:
    * Move left forward
    * Reduce the count accordingly
5. When the window is valid:
    * Update the maximum window size
6. Continue until right reaches the end

Template
========
```
for right in range(n):
    include right element
    update abnormalCount

    while abnormalCount > allowed:
        remove left element
        left++

    // window is valid here
    maxLen = max(maxLen, right - left + 1)
```

