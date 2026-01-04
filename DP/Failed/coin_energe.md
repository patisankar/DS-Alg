### problem
Alex visits houses arranged in a line. Each house contains both coins and energy. Alex must start at the first house and visit consecutive houses without skipping any, though the journey can end at any point. 
Moving from one house to the next costs 1 unit of energy.

When visiting a house, Alex can collect either the energy or the coins available there, but not both. 
The goal is to determine the maximum number of coins Alex can collect while never having a negative energy amount.

### my approach
Coins are the objective, energy is a constraint.
DP must track energy explicitly because it determines reachability.

take energe only it reaches 0, otherwise take coins

it will fail, 
```
initialEnergy = 1
energy = [2, 0, 0]
coins  = [0, 100, 100]
```
### optimal approach

## Dynamic Programming Formulation

### State

**dp[i][e]**

- `i` → index of the current house (0-based)
- `e` → remaining energy after visiting house `i`
- Value stored:
  - **maximum coins** Alex can have
- Invalid states are treated as `-∞`

Interpretation:

> `dp[i][e]` = maximum coins collectible after processing houses `0..i`
> and ending at house `i` with `e` energy left

---

### Base Case (House 0)

No movement cost before the first house.

Two valid starting states:

1. Take coins at house `0`
   `dp[0][initialEnergy] = coins[0]`

Take energy at house 0

`dp[0][initialEnergy + energy[0]] = 0`

---

### Transition

To move from house `i-1` to house `i`:

- Moving costs **1 energy**
- Only states with `e ≥ 1` are valid

From a valid state `dp[i-1][e]`:

`energyAfterMove = e - 1'

Now choose at house `i`:

#### Option 1: Take coins

```
dp[i][energyAfterMove] =
max(dp[i][energyAfterMove],
dp[i-1][e] + coins[i])
```

#### Option 2: Take energy

```
dp[i][energyAfterMove + energy[i]] =
max(dp[i][energyAfterMove + energy[i]],
dp[i-1][e])
```
#### Solution

```
import java.util.*;

public class Solution {

    public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
        int n = energy.size();

        // Same trick as Python: shift starting energy by +1
        int startEnergy = (int) Math.min(n, initialEnergy + 1);

        // dp[i][e] = max coins after i houses with e energy
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][startEnergy] = 0;

        for (int i = 1; i <= n; i++) {
            int houseEnergy = energy.get(i - 1);
            int houseCoins = coins.get(i - 1);

            for (int e = 1; e <= n; e++) {
                if (dp[i - 1][e] == -1) continue;

                // Option 1: take energy at house i-1
                int newEnergy = Math.min(n, e - 1 + houseEnergy);
                dp[i][newEnergy] = Math.max(dp[i][newEnergy], dp[i - 1][e]);

                // Option 2: take coins at house i-1
                dp[i][e - 1] = Math.max(dp[i][e - 1], dp[i - 1][e] + houseCoins);
            }
        }

        // Can stop at any house with any energy
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int e = 0; e <= n; e++) {
                result = Math.max(result, dp[i][e]);
            }
        }

        return result;
    }
}

```
