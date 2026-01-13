# Pattern: Sliding Window

## Why

### Purpose
Sliding Window exists to efficiently process **contiguous subarrays / substrings** where:

- You care about **aggregates**
  - Example: *maximum number of fruits you can pick*
- Recomputing from scratch for every subarray would be wasteful
- The window moves **monotonically forward** (no backtracking)

### Key Property
> **What you add on the right, you can undo on the left**

This reversibility is what makes the pattern work in linear time.

---

## When (Trigger Conditions)

- The problem involves **contiguous elements**
- You must process elements **in order**
- You are allowed to **expand and shrink** a range
- Example constraint:
  - *You must pick exactly one fruit from each tree*
  - *You can use only two baskets*

This directly implies a **fixed constraint over a moving window**.

---

## State

### Window Definition
- The window represents the **current range of trees** being considered.
- You have **two baskets**, and:
  - Each basket can hold **only one type of fruit**
  - Total distinct fruit types in the window ≤ 2

### State Variables
- `left` pointer → start of the window
- `right` pointer → end of the window
- `frequency map` → counts of fruit types in the window
- `distinctCount` → number of fruit types currently in the window

---

## Choices — What can I do at each step?

At every step:

1. **Expand the window**
   - Pick exactly **one fruit** from index `i` (move `right`)
   - Add `arr[right]` to the window state

2. **Shrink the window (only if needed)**
   - Remove fruits from the left (move `left`)
   - Update the state accordingly

There are **no branching choices**—only controlled movement of pointers.

---

## Invariant — What must always be true?

> **The window must contain at most 2 distinct fruit types**

This invariant determines **when to shrink**.

### Violation Condition
- If the number of fruit types becomes **greater than 2**

### Restoration Logic
```java
while (invariant is violated) {
    remove(arr[left]);
    left++;
}
