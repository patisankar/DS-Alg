# Preparation Pause-and-Think Step

Before reading the solution, pause for 2–5 minutes.

## Ask myself

1. What is the brute-force approach?
2. What makes the brute-force approach slow?
3. What repeated work can I eliminate?
4. Is there a pattern?
5. Is there monotonicity, ordering, or an invariant?
6. What would I search for: an index, a value, or an answer?
7. Can I explain why the optimized approach is correct?

## After studying the solution

Close the explanation and reproduce:

- The idea in my own words
- The key invariant
- One example
- The complexity
- The code without looking

## Final self-check

If I cannot explain **why the optimization works**, I have memorized the solution but have not understood it yet.

### Daily rule

Do not solve many problems passively.

For each problem:

```text
Think → Attempt → Explain → Study → Close → Rebuild → Review
```

Why Use A Linked List Instead Of An Array?
=====
The issue with an array is it must reindex the whole array from the position of removal of any element besides the last one.

Pattern: Sliding Window
=====

**Recognize when:**
- The problem asks for a longest, shortest, or count of a contiguous range.

**Idea:**
- Expand the right side; shrink the left side when the constraint is violated.

**Template:**
```
left = 0

items.each_with_index do |item, right|
  # Add item to the window

  while invalid_window?
    # Remove items[left]
    left += 1
  end

  # Update answer
end
```

**Complexity**: O(n) time, O(k) space

**Common mistake:**
- Forgetting to remove the left-side value when shrinking.
