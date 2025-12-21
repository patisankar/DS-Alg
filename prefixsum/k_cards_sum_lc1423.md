Problem
=====
I/P:  Array of elments => cardPoints = [1,2,3,4,5,6,1], k = 3
O/P:  max k cards sum
Constraint:  Cards can take from left or right only, that means not from middle

Intituation:
======

### Input
cardPoints = [11, 49, 100, 20, 86, 29, 72]  
k = 4

---

### Your Greedy Approach (Take Larger End Each Time)

Step-by-step picks:

1. Compare ends → 11 vs 72 → take **72**  
   score = 72

2. Compare ends → 11 vs 29 → take **29**  
   score = 101

3. Compare ends → 11 vs 86 → take **86**  
   score = 187

4. Compare ends → 11 vs 20 → take **20**  
   score = 207

**Greedy Result = 207**

---

### Why This Is Not Optimal

To take `100` from the left, you must first remove `11` and `49`.  
Greedy never does this because it only looks at the current ends.

A better valid sequence:

- take 72 (right)
- take 11 (left)
- take 49 (left)
- take 100 (left)

**Optimal Result = 232**

---

### Correct Pattern: Sliding Window (Leave Middle)

Total sum = 367  
Cards taken = 4 → cards left = `n - k = 3`

Find minimum sum subarray of length 3:

| Subarray        | Sum |
|-----------------|-----|
| [11,49,100]     | 160 |
| [49,100,20]     | 169 |
| [10]()


## Prefix Sum Pattern for This Problem

### Core Idea
You must take **exactly k cards** from either the **left or right end**.

Instead of deciding greedily, enumerate **all valid combinations**:
- Take `i` cards from the left
- Take `k - i` cards from the right  
for all `i = 0 .. k`

Prefix sums allow each combination to be evaluated in **O(1)** time.

---

### Step 1: Build Prefix Sums

**Left prefix sum**
left[i] = sum of first i cards


**Right prefix sum**


right[i] = sum of last i cards


Example:


cardPoints = [11, 49, 100, 20, 86, 29, 72]


Left prefix:


i: 0 1 2 3 4
left: 0 11 60 160 180


Right prefix:


i: 0 1 2 3 4
right: 0 72 101 187 207


---

### Step 2: Try All Splits

For each `i` from `0` to `k`:


score = left[i] + right[k - i]


| i (left) | k-i (right) | score |
|----------|-------------|-------|
| 0        | 4           | 207   |
| 1        | 3           | 198   |
| 2        | 2           | 161   |
| 3        | 1           | 232   |
| 4        | 0           | 180   |

**Maximum = 232**

---

### Why This Works (Interview Explanation)
- Taking cards only affects the ends
- Any valid pick sequence is equivalent to:
  - some cards from the left + the rest from the right
- Prefix sums let us evaluate all possibilities efficiently

---

### Complexity
- Time: **O(n + k)**
- Space: **O(k)**

---

### When to Use This Pattern
- “Take from ends”
- “Choose exactly k elements”
- “Multiple left/right combinations”

This is the **prefix sum enumeration** version of the same logic that sliding window sol
