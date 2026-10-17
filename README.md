# Coding Interview Problem-Solving Template

## Before Coding

1. **What am I trying to find?**
   - State the output precisely: minimum count, maximum value, index, path, or feasibility.

2. **What are the rules and constraints?**
   - What operations or moves are allowed?
   - Is the input sorted?
   - Are there mandatory starting or ending points?
   - What should happen if no solution exists?

3. **Can I walk through one small example?**
   - Solve it manually.
   - Explain each decision.
   - Identify what makes a solution valid.

4. **What is the brute-force solution?**
   - What would I enumerate or explore?
   - Why does this guarantee the correct answer?
   - What are its time and space complexities?

5. **What work is repeated or unnecessary?**
   - Am I revisiting the same states?
   - Am I repeatedly scanning the same elements?
   - Am I exploring choices that cannot improve the answer?

6. **What observation simplifies the problem?**
   > Because ___, I only need to ___.

7. **Can I change the question?**
   > Instead of directly finding ___, can I ask ___?

   For a candidate answer:
   > Can I achieve ___ using this candidate?

8. **Which algorithm fits, and why?**
   - What property supports this choice?
   - Does it improve on brute force?
   - What are the tradeoffs?

9. **Why is the solution correct?**
   - What stays true throughout the algorithm?
   - Why is it safe to discard certain choices?
   - Why will the final result be optimal?

## While Coding

10. **What does each variable mean?**
    - Define boundaries, counters, and state.
    - Keep their meaning consistent.

11. **Why does each update make progress?**
    - Explain boundary changes or state transitions.
    - Check that no valid answer is accidentally excluded.
    - Explain when and why the algorithm terminates.

## After Coding

12. **Which edge cases should I verify?**
    - Smallest valid input.
    - Duplicate values.
    - Answer at the beginning or end.
    - Impossible case.
    - Exact boundary conditions.

13. **What are the final complexities?**
    - Time: ___, because ___.
    - Extra space: ___, because ___.

## Binary Search Follow-up

Use these questions when the problem has a monotonic condition.

1. **What am I searching for?**
   - An index, capacity, speed, day, distance, or threshold?

2. **What is the search space?**
   - What are the minimum and maximum possible answers?
   - Why are these bounds valid?

3. **What does `condition(mid)` mean?**
   - Write it as one yes/no question.

4. **Is the condition monotonic?**
   - Does it change from false to true, or true to false?
   - Why can it never change back?

5. **Which boundary am I finding?**
   - First true or last true?

6. **What is my invariant?**
   - What remains true about the search boundaries?

7. **Why are my boundary updates safe?**
   - Should I keep `mid` or exclude it?
   - Does every iteration shrink the search space?

8. **What should I return?**
   - Why does the final boundary represent the answer?
   - What happens if no candidate satisfies the condition?

## Interview Flow

Clarify → Example → Brute force → Find waste → Simplify →
Choose algorithm → Prove → Code → Verify

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
