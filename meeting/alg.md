### Short version
The brute-force solution tries every possible investor-to-day assignment, which is exponential. 

The key observation is that on any day, delaying the investor with the earliest deadline is the riskiest choice. 

Therefore, I sort investors by start day and use a min-heap ordered by end day. 

Each day, I add newly available investors, remove expired ones, and schedule the investor with the earliest deadline. 

This reduces the complexity to O(n log n).

### prob
**Goal :**  Company like to schedule meetings with investors

**Constraint** investor can available only one day

Ex: firstDay = [1, 2, 3, 3, 3]

    lastDay = [2, 2, 3, 4, 4]
    
## Clarify the problem

Each investor gives an interval: [firstDay[i], lastDay[i]]

We can:
schedule at most one meeting per day,
meet an investor on any day within their interval,
meet each investor at most once,
maximize the number of meetings.

Example:
[1, 2], [2, 2], [3, 3], [3, 4], [3, 4]

The goal is not to schedule all meetings immediately. The goal is to use each day wisely.

## Brute-force idea
For every investor, try every possible available day.

For example, for investor [1, 2], we try:

Meet on day 1

Meet on day 2

Skip the investor

Then **recursively** do the same for every other investor.

### Problem with brute force

It explores almost every possible assignment of investors to days.

If there are n investors and many possible days, the number of combinations becomes enormous.

This is exponential and will not scale.

## Look for a greedy rule

Suppose several investors are available today:
```
Investor A: [1, 10]
Investor B: [1, 3]
Investor C: [1, 5]
```
**Who should we meet today?**

Choose Investor B because their deadline is earliest.

**Why?**

Investor B has fewer future options.

Investor A and C can still be met later.

If we postpone Investor B, we may lose that opportunity permanently.

So the greedy rule is:
```
On each day, meet the available investor with the earliest last day.
```
This is the key observation.

### Data structure needed
We need to repeatedly find the smallest lastDay among currently available investors.

That is exactly what a min-heap provides.

We maintain:
Min-heap = last days of investors currently available

For each day:
Add investors whose firstDay <= day.
Remove investors whose lastDay < day.
Meet the investor with the smallest lastDay.
Move to the next day.



