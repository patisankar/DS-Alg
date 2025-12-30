#### Minimum (Maximum) Path to Reach a Target

1. [Dungeon Game](https://www.educative.io/interview-prep/coding/dungeon-game)

   We start from bottom-right to top-left , calculate min energy required.

   **Base case** : dp[m][n-1] = 1, dp[m-1][n] = 1
   Take min cost to reach next cell.
   ```
   need = min(dp[m-1][n], dp[m][n-1]) - cost[m-1][n-1]
   dp[m-1][n-1] = Math.max(1, need)
   
   ```
