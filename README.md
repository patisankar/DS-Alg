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
