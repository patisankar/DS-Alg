Problem
=======
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.

Approach
==========
This problem, root = max(left part of subtree)*max(right part of subtree)
Tree path sum = left+right+root

Min tree path sum = min (all possible tree path sum's)

DFS + memorization



```
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return dfs(arr, 0, n - 1, dp);
    }
    
    public int dfs(int[] arr, int s, int e, int[][] dp) {
        if (s == e) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int left = dfs(arr, s, i, dp);
            int right = dfs(arr, i + 1, e, dp);
            int maxLeft = 0, maxRight = 0;
            for (int j = s; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= e; j++) maxRight = Math.max(maxRight, arr[j]);
            ans = Math.min(ans, left + right + maxLeft * maxRight);
        }
        dp[s][e] = ans;
        return ans;
    }
}

```

2nd Approach - Monotonic Stack
=====

```
class Solution {
    // Use stack. Similar to trapping the rain water problem and the largest rectangle under histogram
    // Use stack to keep a decreasing order by adding smaller values, while there is bigger value 
    //arr[i] than the peek, pop it and store as mid and calculate the multiplication mid*min(arr[i],  
    //stack.peek()).
    
    // NOTE: if we observe the number array, in order to obtain the smallest sum of all non-leaf
    // values, we want to merge those small values first. In order words, the smaller a value
    // is, the lower leaf it should stay because this way as we are building the tree up, 
    // we are building smaller multiplication/parent node first as it is only going to get bigger
	// as we build the tree up. 
    
    // Ex: 4 3 2 1 5
    // There are many ways we can build a tree following the problem's requirement. However, to 
    // gain smallest sum. We need to merge 2 and 1 first as they are the two smallest ones. To
	// do that, we use the stack mentioned above as a decreasing order. After
    // that we get a parent node with value 2. This node could be a left or right child of its parent
    // but what we want is that its parent needs also be as small as possible. We also know that its
    // parent has one mutiplier already: 2. Note: this 2 is not from the product of 1 * 2, but from the max  of child
    // 1 and 2 as the problem requires. So, we see what values next to the leaf 2 could be a 
	// candidate. Obviously, 3 since it is the smallest one in the stack Then, 3
    // becomes the left child and 1*2 = 2 becomes right child. See below: 
    //  ...
    //  / \
    // 3   2
    //    / \
    //   2   1
    // 
    
    // If we observe carefully, 3 2 1 is decreasing... So how about every time we see a "dip" point
    // in the array we calculate its multiplication. To do that, say we are at arr[i] and their 
    // relations are arr[i-1] <= arr[i] <= arr[i+1]. The min multiplication is a[i] * min(arr[i-1], 
    // arr[i+1]). Then the example above is arr[i] = 1, arr[i-1] = 2, arr[i+1] = 5
    
    public int mctFromLeafValues(int[] arr) {
          if(arr == null || arr.length < 2){
              return 0;
          }
          
          int res = 0;
          Stack<Integer> stack = new Stack<>();          
          for(int num : arr){
              
             // while num is bigger than peek(), pop and calculate
             while(!stack.isEmpty() && stack.peek() <= num){
                 int mid = stack.pop();
                 if(stack.isEmpty()) 
                     res += mid * num;
                 else
                    res += mid * Math.min(stack.peek(), num);
             }
             
             stack.push(num); // if num is smaller, push into stack
         }
         
         // if there are values left in the stack, they sure will be mutiplied anyway
         // and added to the result. 
         while(stack.size() > 1){ // > 1 because we have a peek() after pop() below
             res += stack.pop() * stack.peek();
         }
         
         return res;
    }
}
```
