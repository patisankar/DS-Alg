# Binary Search Thinking Framework

https://leetcode.com/discuss/post/786126/python-powerful-ultimate-binary-search-t-rwv8/

## Before Coding

1. **What am I searching for?**
   An index, capacity, speed, day, distance, threshold, or another answer value?
2. **What is the search space?**
   What are the minimum and maximum possible answers?
3. **Can I change the question into something easier to answer?**
4. **What does `condition(mid)` mean?**
   Write it as one yes/no question.
5. **Is the condition monotonic?**

   ```
   false false false true true true
   ```
   or:
   ```
   true true true false false false
   ```

6. **Which boundary am I finding?**
   First true? Last true? Exact target?
7. **What should happen when `condition(mid)` is true?**
8. **Can `mid` still be the answer?**
   - Yes → retain it with `right = mid` or `left = mid`.
   - No → discard it with `left = mid + 1` or `right = mid - 1`.
9. **Why does the search interval shrink every iteration?**
10. **What does `left` represent after the loop?**
11. **Should I return `left`, `right`, or `left - 1`?**

## While Debugging

#### Write the variable contract
```
Goal: find the first valid index

left: index
right: index
mid: index

condition(mid):
points[mid] - points[0] >= threshold
```

1. Does the initial range contain every possible answer?
2. Is `condition(mid)` returning the expected result?
3. Does each update remove part of the search space?
4. Could `left`, `right`, and `mid` stop changing?
5. Am I accidentally removing a valid `mid`?
6. Am I keeping a `mid` that is known to be invalid?
7. Is equality handled correctly?
8. What happens with only two candidates remaining?
9. What happens when the answer is the lower bound?
10. What happens when the answer is the upper bound?

Use this trace:

```
left | right | mid | condition(mid) | next left | next right
```

## After Coding

1. Why is the lower bound valid?
2. Why is the upper bound valid?
3. Why is the condition monotonic?
4. What loop invariant does the algorithm maintain?
5. Why does the algorithm terminate?
6. Why is the returned value correct?
7. What is the cost of one condition check?
8. What is the total time complexity?
9. What is the extra-space complexity?
10. Which edge cases should be tested?

## First-True Template

Use when the condition looks like:

```
F F F T T T
      ↑
   answer
```

```
while left < right
  mid = left + (right - left) / 2

  if condition(mid)
    right = mid
  else
    left = mid + 1
  end
end

return left
```

> If `mid` works, keep it and search for something smaller. If `mid` fails, remove it and search larger values.

## Last-True Template

Use when the condition looks like:

```
T T T F F F
    ↑
 answer
```

```
while left < right
  mid = left + (right - left + 1) / 2

  if condition(mid)
    left = mid
  else
    right = mid - 1
  end
end

return left
```

> If `mid` works, keep it and search for something larger. If `mid` fails, remove it and search smaller values.

