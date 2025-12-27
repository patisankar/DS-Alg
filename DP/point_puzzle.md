### problem
In an escape game, players must solve puzzles to earn points and progress. One puzzle involves an array of integers and specific rules for 
earning points. Here are the rules:

Select a value v. Remove all occurrences of that value from the array and add their sum to your score.
Remove all elements equal to v + 1 or v - 1 without scoring points.
Repeat steps 1 and 2 until the array is empty.
Determine the maximum score that can be obtained by following these rules.

 

Example

elements = [5, 6, 6, 4, 11] 

 

Delete 11 for 11 points.  Since there are no elements equal to 11-1 = 10 or 11 + 1 = 12,  proceed with the remaining elements: [5, 6, 6, 4]. 

Delete the two 6's for 12 more points.  Delete any elements equal to 6 - 1 = 5 or 6+1 = 7. Then proceed with the remaining elements: [4]. 

Finally delete the 4 and add 4 points for total points 11 + 12 + 4 = 27.

### Solution
Step1
======
Q) If we select 5, what is  score?
   otherwise what is the score?
   If we solve subproblem , it leads to main problem

   max = [ 5, 11] [12, 11] [4,12, 11]

   dp formala,  dp[i] = max(dp[i - 1], dp[i - 2] + freq[i] * i) for all i from 2 to N
Lets understand solution
```
import java.util.*;

public class Solution {
    public static long maxScore(List<Integer> elements) {
        if (elements == null || elements.isEmpty()) return 0;

        int maxVal = 0;
        for (int x : elements) maxVal = Math.max(maxVal, x);

        long[] points = new long[maxVal + 1];
        for (int x : elements) {
            points[x] += x; // add value itself for each occurrence => sum of all x's
        }

        // dp[i] depends only on dp[i-1] and dp[i-2], so we can do rolling DP
        long prev2 = 0;                 // dp[i-2]
        long prev1 = points[0];         // dp[i-1] when i=1 will be dp[0]
        // More simply: handle i=1 separately
        if (maxVal == 0) return points[0];

        prev1 = points[1];              // dp[1] = points[1]
        prev2 = 0;                      // dp[0] = 0
        //1 based index
        for (int i = 2; i <= maxVal; i++) {
            long take = prev2 + points[i];
            long skip = prev1;
            long cur = Math.max(skip, take);
            prev2 = prev1;
            prev1 = cur;
        }
        return (maxVal == 1) ? points[1] : prev1;
    }

    // quick test
    public static void main(String[] args) {
        System.out.println(maxScore(Arrays.asList(5, 6, 6, 4, 11))); // 27
    }
}
```
   
