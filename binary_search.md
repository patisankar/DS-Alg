## important notes
When to exit the loop? Should we use left < right or left <= right as the while loop condition? 

How to initialize the boundary variable left and right?

How to update the boundary? How to choose the appropriate combination from left = mid , left = mid + 1 and right = mid, right = mid - 1?

Sometimes we won't even realize that the problem should be solved with binary search -- we might just turn to dynamic programming or DFS and get stuck for a very long time.

As for the question "When can we use binary search?", my answer is that, If we can discover some kind of **monotonicity**, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.

Use **greedy** to narrow down left and right **boundaries** in binary search.

### interview style

```
    while (low <= high) { // use == since the high maybe the solution. 
        long mid = (low + high) / 2;
        if (!valid(nums, m, mid)) { // Not valid, mid is too small. Cannot split into more subarrays to meet mid. 
            low = mid + 1; // drop the lower range
        } else {  // valid, see if we can even make it smaller
            if (mid == maxNum || !valid(nums, m, mid - 1)) { // there is no smaller valid value, mid is the best solution
                return (int) mid;
            } else {
                high = mid - 1;
            }
        }
    }

    throw new RuntimeException("Cannot find a solution");
```
### Real case - what does the mean monotonicity
The mental trick is to stop trying to find the answer directly.

Instead, change the question. Ask a much simpler, "Yes/No" question:

"If I set a maximum allowed sum (let's call it X), can I split the array into k bags (or fewer)?"

Now, think about the possible answers for X:

If you can't do it with a limit of X = 17, you definitely can't do it with X = 16, X = 15, etc.

If you can do it with a limit of X = 18, you definitely can do it with X = 19, X = 20, etc. (a bigger bag only makes it easier).

This creates a "sorted" range of answers: [No, No, No, No, Yes, Yes, Yes, Yes]

We are looking for the very first "Yes". This is a perfect job for Binary Search.


