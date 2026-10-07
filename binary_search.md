# Binary Search Thinking Framework

https://leetcode.com/discuss/post/786126/python-powerful-ultimate-binary-search-t-rwv8/

## Before Coding

1. **What am I searching for?**
   An index, capacity, speed, day, distance, threshold, or another answer value?
2. **What is the search space?**
   What are the minimum and maximum possible answers?
3. **What does `condition(mid)` mean?**
   Write it as one yes/no question.
4. **Is the condition monotonic?**

   ```
   false false false true true true
   ```
   or:
   ```
   true true true false false false
   ```

5. **Which boundary am I finding?**
   First true? Last true? Exact target?
6. **What should happen when `condition(mid)` is true?**
7. **Can `mid` still be the answer?**
   - Yes → retain it with `right = mid` or `left = mid`.
   - No → discard it with `left = mid + 1` or `right = mid - 1`.
8. **Why does the search interval shrink every iteration?**
9. **What does `left` represent after the loop?**
10. **Should I return `left`, `right`, or `left - 1`?**

## While Debugging

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

## Problem-Specific Questions

After the universal questions, each problem usually needs only four more:

1. How do I calculate the lower and upper bounds for this problem?
2. How do I implement `condition(mid)`?
3. Why is that condition monotonic?
4. What special constraints must `condition(mid)` preserve?

### Ship Packages Within D Days

1. Why is the lower bound `max(weights)`?
2. Why is the upper bound `sum(weights)`?
3. How do I count the days required for a capacity?
4. How do I preserve package order?

### Koko Eating Bananas

1. Why is the speed range `1..max(piles)`?
2. How do I calculate hours using ceiling division?
3. Why does increasing speed never increase the required hours?
4. Is the total time within `H` hours?

### Minimum Days to Make Bouquets

1. Is making `m` bouquets possible at all?
2. What range of days should I search?
3. How do I count adjacent bloomed flowers?
4. Why does waiting longer never reduce the number of possible bouquets?

## Reusable Note Template

```
## Binary Search

- Search value:
- Lower bound:
- Upper bound:
- condition(mid):
- Monotonic direction:
- First true or last true:
- Update when true:
- Update when false:
- Return value:
- Condition cost:
- Total complexity:
- Edge cases:
```



