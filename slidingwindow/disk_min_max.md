**Question**
For each segment of contiguous computers of length x, find the minimum available disk space within that segment. Then determine the maximum value among all these minimums.

 

**Example 1**

Input: x = 2, the segment length, n = 4, the number of computers, space = [8, 2, 4, 6]

Output: 4

Explanation: The segments of length 2 are [8, 2], [2, 4], and [4, 6]. The minimum values in each segment are 2, 2, and 4, respectively. The maximum of these values is 4.

## my solution

```ruby
def segment(x, space)
  result = []
  deque = []

  space.each do |e|
    if deque.size >= x
      result << deque.shift
    end

    deque.push(e)
  end

  result.max
end
```

## Problems

**Problem 1**: shift does not return the minimum

What a **monotonic deque** does
Instead of storing all window elements, it stores only candidates for the minimum.
The values in the deque are always in increasing order from front to back.
 
