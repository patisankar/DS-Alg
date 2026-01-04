#### Minimum (Maximum) Path to Reach a Target

1. [Dungeon Game](https://www.educative.io/interview-prep/coding/dungeon-game)

   We start from bottom-right to top-left , calculate min energy required.

   **Base case** : dp[m][n-1] = 1, dp[m-1][n] = 1
   Take min cost to reach next cell.

   ```
   need = min(dp[m-1][n], dp[m][n-1]) - cost[m-1][n-1]
   
    // The knight must have at least 1 HP at any time
   dp[m-1][n-1] = Math.max(1, need)
   
   ```

### problem
[Minimum Complexity Level](https://www.hackerrank.com/x/library/hackerrank/all/questions/588397/try)

First we need do k partitions on array, find min of max of sub arrays.

Dp problems, first need to find the **state**, and **transition**

here, **state**:
dp[d][i] = minimum total complexity to schedule the first i lectures into d days.

So the final answer is dp[days][n]

**Transition**
To compute dp[d][i], decide where the last day starts.

If last day covers lectures k..i-1 (0-based), then:

previous cost = dp[d-1][k]

last day cost = max(a[k..i-1])

```
dp[d][i] = min over k in [d-1 .. i-1] of ( dp[d-1][k] + max(a[k..i-1]) )
```
