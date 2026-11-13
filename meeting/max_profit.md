## problem
Leetcode : https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/

Hackerrank: A taxi driver knows the pick-up and drop-off locations of people requesting services. All locations are measured in km from the starting point (0 km). For each km traveled, the driver charges 1 unit of money per passenger. Additionally, some passengers are willing to pay an extra tip.

 

Notes 

The taxi can accommodate only one passenger at a time.
The driver cannot backtrack. If a passenger is picked up at location 2 and dropped off at location 9, the driver cannot accommodate a passenger at locations 3 through 8.
If there are two people and their locations overlap, only one of them can be accepted.
 

Determine the maximum amount the driver can earn.

 

Example

pickup = [0, 2, 9, 10, 11, 12]

drop = [5, 9, 11, 11, 14, 17]

tip = [1, 2, 3, 2, 2, 1]

 

The optimal way to earn the most money is by accepting passengers at indices 1, 2, and 5:

Passenger at index 1: 9 - 2 + 2 = 9 (distance + tip)
Passenger at index 2: 11 - 9 + 3 = 5
Passenger at index 5: 17 - 12 + 1 = 6
Total earnings: 9 + 5 + 6 = 20


## Restate

We need pick rides/jobs are greedly which leads to max profit,

## Brute force pseudocode

Sort the starting point

```
maxprofit()

  if we reach end, then return

  next = i+1

  while( rides[next][0] < rides[i][end])
     next ++;
  take = jobprofit + maxProfit(next)
  skip = maxProfixt(i+1)

  return max( take, skip)
    
```


### optimized Psedocode

if
