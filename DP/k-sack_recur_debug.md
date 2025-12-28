Problem setup (example)
======
iv       = [2, 4, 4, 5]
articles = [2, 2, 3, 4]
cost     = [4, 4, 6, 8]   // 2 * articles
p = 15

2nd Review:
=========

Need to find subproblem,
dp[c] = maximum intellectual value achievable using at most c pages
If I am allowed to read at most c pages today, what is the maximum intellectual value I can achieve?

Max value we can get by reading c articles.

## Transition Logic Using the Subproblem

For an article with:

- `w = 2 × articles[i]`  (pages consumed when read twice)
- `v = iv[i]`            (intellectual value gained)

If `c ≥ w`, then:

dp[c] = max(
dp[c], # do not take the article
dp[c - w] + v # take the article
)

### Why this works

- `dp[c - w]` already represents the **best possible intellectual value** achievable using `c - w` pages.
- By taking the current article, we extend that optimal solution by adding `v`.
- Taking the maximum ensures we always keep the best choice.

---

## Base Case
dp[0] = 0

dp[n]
This represents the **maximum intellectual value** achievable within the full daily page limit.





Debug
======
Call:

findMaxLearning(15, iv, articles, 0)
Each node in the recursion tree is:

(startIndex, remainingPages) → bestValue

Level 0 (start = 0)
=====
f(0, 15)
Two choices (since 15 >= 4):

                f(0,15)
               /        \
        take article 0   skip article 0
         +2 pages=4      no pages
So:

f(0,15) =
max(
    2 + f(1, 11),
    f(1, 15)
)

Level 1
======
Left branch: f(1,11)
(cost of article 1 = 4)

f(1,11) =
max(
    4 + f(2,7),
    f(2,11)
)
Right branch: f(1,15)

f(1,15) =
max(
    4 + f(2,11),
    f(2,15)
)

Level 2
=======
Expand f(2,7) (cost = 6)

f(2,7) =
max(
    4 + f(3,1),
    f(3,7)
)
Expand f(2,11)

f(2,11) =
max(
    4 + f(3,5),
    f(3,11)
)
Expand f(2,15)

f(2,15) =
max(
    4 + f(3,9),
    f(3,15)
)

Level 3 (article 3, cost = 8)
===========
f(3,1)
Remaining < 8 → cannot take

f(3,1) = f(4,1) = 0
f(3,7)
Remaining < 8 → cannot take

f(3,7) = f(4,7) = 0
f(3,5)
Remaining < 8 → cannot take

f(3,5) = f(4,5) = 0
f(3,11)

f(3,11) =
max(
    5 + f(4,3),
    f(4,11)
)
= max(5, 0) = 5
f(3,9)

f(3,9) =
max(
    5 + f(4,1),
    f(4,9)
)
= max(5, 0) = 5
f(3,15)

f(3,15) =
max(
    5 + f(4,7),
    f(4,15)
)
= max(5, 0) = 5

Bubble results upward
========
Resolve level 2

f(2,7)  = max(4 + 0, 0) = 4
f(2,11) = max(4 + 0, 5) = 5
f(2,15) = max(4 + 5, 5) = 9
Resolve level 1

f(1,11) = max(4 + 4, 5) = 8
f(1,15) = max(4 + 5, 9) = 9
Resolve level 0

f(0,15) = max(2 + 8, 9) = 10

Final Answer
========
maximumLearning = 10

How to debug this in interviews
1️⃣ Always label a node as:

(index, remainingCapacity)
2️⃣ At each node ask:
* Can I take this item?
* Can I skip this item?
3️⃣ Base cases to check first:

if (idx == n || remaining <= 0) return 0;
4️⃣ Mentally prune impossible branches
If remaining < cost, there is only one branch (skip).

Why memoization matters (important insight)
Notice states like:

f(2,11)
f(3,7)
appear multiple times. Memoization collapses the tree into a DAG, turning exponential recursion into polynomial DP.
