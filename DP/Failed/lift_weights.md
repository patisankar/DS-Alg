### problem
An athlete is lifting weights. The barbell has a maximum capacity of maxCapacity. Each barbell plate has a specific weight given by weight[i]. Determine the maximum weight of plates that can be added to the barbell without exceeding maxCapacity.

**Example**
weights = [7, 1, 5, 6, 2]
maxCapacity = 7
There are 3 ways to reach the maximum weight that is optimal: {7}, {1, 6}, and {2, 5}. Return 7.

### failed approach

```
 public static void maxWeight(List<Integer> weights, int maxCapacity, int pathSum,  int start ){
        if(start >= weights.size() || maxCapacity < 0 ){
            return ;
        }
        if(pathSum > maxCap){
            maxCap = pathSum;
        }
        
        maxWeight(weights, maxCapacity-weights.get(start), pathSum+weights.get(start), start+1);
         maxWeight(weights, maxCapacity, pathSum, start+1);
    }

```

#### code review
**You update maxCap even when the path is invalid (capacity negative)**
You only stop recursion when maxCapacity < 0, but you update maxCap before exploring children, using the current pathSum.
In your current structure, this is mostly safe because pathSum is updated together with maxCapacity, and you return immediately when negative. However, it is still cleaner and safer to prune before updating:
  If maxCapacity < 0 → invalid branch, return
  Otherwise update best
This avoids any chance of accidentally recording an overweight path if the logic changes.

**You are missing easy pruning**

```
if (maxCapacity == 0) {
    maxCap = Math.max(maxCap, pathSum);
    return;
}
```
### correct version

```
private static int dfs(List<Integer> w, int i, int cap, int sum) {
    if (cap < 0) return Integer.MIN_VALUE; // invalid
    if (i == w.size() || cap == 0) return sum;

    // skip
    int best = dfs(w, i + 1, cap, sum);

    // take
    best = Math.max(best, dfs(w, i + 1, cap - w.get(i), sum + w.get(i)));

    return best;

}
```
### DP
```
dp[c] = true
means:
Using the plates processed so far,
I can form total weight exactly c
```

