# Why Do We Need Prefix Sum?

## Problem (Simple View)

Pat runs between markers, and **every marker between start and end is visited**.

If we count visits directly for every sprint by looping through markers, we repeat a lot of work.

Prefix sum helps us **avoid repeated counting**.

---

## Example Input

n = 5
sprints = [2, 4, 1, 3]

yaml
Copy code

Markers: `1 2 3 4 5`

Sprints:
- 2 → 4 → visits {2, 3, 4}
- 4 → 1 → visits {4, 3, 2, 1}
- 1 → 3 → visits {1, 2, 3}

---

## Final Visit Count (Expected)

Marker: 1 2 3 4 5
Visits: 2 3 3 2 0

yaml
Copy code

Most visits = `3`  
Lowest marker with max visits = **2**

---

## Why Prefix Sum?

### Naive way (slow)

For sprint `2 → 4`:
+1 to 2
+1 to 3
+1 to 4

yaml
Copy code

Doing this for every sprint repeats work and is slow.

---

## Prefix Sum Idea (Smart way)

Instead of counting every marker:

- **Start counting at `l`**
- **Stop counting after `r`**

Example: `2 → 4`
start +1 at 2
stop +1 after 4

yaml
Copy code

We only record **where counting starts and stops**.

---

## Step 1: Record Starts and Stops (Difference Array)

diff[l] += 1
diff[r + 1] -= 1

yaml
Copy code

For all sprints, we only update two positions per sprint.

At this stage, we **do not know visits per marker yet**.

---

## Step 2: Prefix Sum Applies the Counts

Prefix sum means:

> Carry forward all previous changes.

When we run prefix sum, each marker automatically gets the correct number of visits.

visits[i] = visits[i - 1] + diff[i]

yaml
Copy code

This expands the start/stop information into real counts.

---

## Key One-Liner (Interview Ready)

> Prefix sum lets us efficiently apply range updates by marking where counting starts and stops, then converting that into actual visit counts.

---

## Why We Need Prefix Sum (One Sentence)

**Because we only record where visits begin and end, and prefix sum turns that into per-
