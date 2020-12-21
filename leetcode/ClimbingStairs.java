package leetcode.dp.easy;
import java.util.Map;
import java.util.HashMap;
/**
* Leet code 70
**/

public class ClimbingStairs{
	 Map<Integer,Integer> cache = new HashMap<>();
	 
	 public int climbStairs(int n) {
        //base case
		if(n==0){
			
			return 1;
		}
		//base case
		if(n== -1){
			
			return 0;
		}
		//Checking in cache
		if(cache.containsKey(n)){
			return cache.get(n);
		}
		//recursivisly left
		int left = climbStairs(n-1);
		//recursively right
		int right = climbStairs(n-2);
		
		//memoize the n
        cache.put(n, left+right);
        
		return cache.get(n);
    
    }
	
	public static void main(String[] arr){
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(3));
	}


}