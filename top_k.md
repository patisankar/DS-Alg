# Overview
Find the top k largest or smallest elements, naive way is sort array - O(nlog(n)) then find k elements. With Top K pattern eleminate need of sorting. Using heap DS, solve by O(nlogk).

top k largest elements (by using min heap , keep the smallest of the large elements at the top ) or top k smallest elements (by using max heap)

## Pseudocode
```
FUNCTION findTopKElements(arr, k):
  # Initialize a min heap
  minHeap = new MinHeap()

  # Insert the first k elements into the heap
  FOR i FROM 0 TO k - 1:
    minHeap.insert(arr[i])

  # Process the remaining elements
  FOR i FROM k TO length of arr - 1:
    IF arr[i] > minHeap.peek():  # Compare with the smallest in heap
      minHeap.extractMin()  # Remove the smallest element
      minHeap.insert(arr[i])  # Insert the new larger element

  RETURN minHeap.toList()  # Convert heap to list and return
```
Note:  Top element always small (min heap) , we are building solution from bottom-top,

Example
======
```
Input: words = ["i","love","leetcode","i","love","coding"], k = 2


First insert k words with freq into min_heap => i-1,love-1

freq_map = {
For i from k+1 to words.length-1
  feq_map[words[i] += 1
  if min_heap top word freq  < feq_map[words[i] 
     insert into min_heap
// how to sort map and transform keys to array
freq_map.sort_by { |word, freq| -freq}.map(&:first)    

```
real world
===
Rearrange the given string so that no two identical characters are adjacent to each other. 
By rearranging the string such that the most frequently occurring character is listed first, then the next most frequent element and so on, in round-robin fashion, we are guaranteed to find a rearrangement if it exists.

