## Problem
LC : 801. Minimum Swaps To Make Sequences Increasing
You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].

For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.

An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].


## solution

```java
public int minSwap(int[] A, int[] B) {
        int[] noSwap = new int[A.length];
        int[] swap = new int[A.length];
        swap[0] = 1;
        for (int i=1; i<A.length; ++i) {

            // This is max value, could be anything as long as they are higher
            // than max possible value (which would be A.length-1, since max
            // swaps you can do is A.length-1)
            noSwap[i] = A.length; swap[i] = A.length;

            if (A[i]>A[i-1] && B[i]>B[i-1]) {
                // We are here because this index does not need to swap.

                // Great, what would be the cost to reach here and not swap?
                // It'll be same as cost of not swapping for prev. index.
                // Why dont we rather take min(noSwap[i-1], swap[i-1]), because
                // in that case noSwap[i-1] will be min anyway.
                noSwap[i] = noSwap[i-1];


                // what would be the cost to reach here and swap?
                // It'll be cost of swapping for prev. index + 1.
                // Why dont we rather take min(noSwap[i-1], swap[i-1]) + 1, because
                // we are tracking optimistic swaps and if we do min, we will lose
                // track of swaps that were needed and done in past.
                swap[i] = swap[i-1] + 1;

//                System.out.println("no need to swap-----");
//                System.out.println(Arrays.toString(swap));
//                System.out.println(Arrays.toString(noSwap));

            } else {
                // This index needs to be swapped, so lets keep max values for current swap
                // and noSwap values.
//                System.out.println("need to swap-----");
            }

            if (A[i]>B[i-1] && B[i]>A[i-1]) {
                // We are here because this index is a candidate of swapping
                // and keeping the seq increasing.
                // If swapping is not needed then being here will be noop, since
                // we are using min of values we set in prev if statement and value we
                // will set here in pessimistic case

                // what would be the cost to reach here and not swap?
                // It'll be min of:
                //      cost of swapping for prev. index
                //      or cost of not swapping prev index.
                // The catch is that if swapping is needed then
                // (noSwap[i] == A.length) > swap[i-1]
                // And if swapping is not needed then,
                // noSwap[i] will be set in prev. if statement and
                // will be less than swap[i-1]
                noSwap[i] = Math.min(noSwap[i], swap[i-1]);


                // what would be the cost to reach here and swap?
                // It'll be min of:
                //      cost of not swapping for prev. index + 1
                //      or cost of swapping this index.
                // The catch is that if swapping is needed then
                // (swap[i] == A.length) > (noSwap[i-1]+1)
                // And if swapping is not needed then,
                // swap[i] will be set in prev. if statement and
                // will _still_ be more than (noSwap[i-1]+1)
                //
                // so can this be replaced with: swap[i] = noSwap[i-1]+1;
                swap[i] = Math.min(noSwap[i-1]+1, swap[i]);


//                System.out.println("can swap-----");
//                System.out.println(Arrays.toString(swap));
//                System.out.println(Arrays.toString(noSwap));
            } else {
                // This index can't be swapped so we will keep the values
                // from previous if statement.

                // Note that it's given in question that there wiill be no invalid
                // cases, so in every case code will enter at least one if statement.
//                System.out.println("cant swap-----");
            }

//            System.out.println();
//            System.out.println();
//            System.out.println();

        }

        // Now that we cost of swapping and not swapping each index,
        // answer is:
        return Math.min(noSwap[A.length-1], swap[A.length-1]);
```
