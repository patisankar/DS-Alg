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
