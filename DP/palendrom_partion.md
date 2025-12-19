### navie backtrack
try all possible palendrom strings , backtrack

```
  public void backtrack(List<String> solution, String s, int start){

   if(s.length() == start){
    //add solution to result
   }

   for(int end=start; end<s.length(); end++){
     if(string(start,end) is palendrom){
        solution.add(string(start,end))
        backtrack(solution, s, end+1);
        solution.removelast()
      }
      
   }
 }

```
### backtrack +memorization bottom-up dp

```
void dfs(List<List<String>> r, String s, int start, List<String> path, boolean[][] dp) {
        int len = s.length();
        if (start >= len) r.add(new ArrayList<>(path));

        for (int i = start; i < len; i++) {
            //    i 
            // abca ...  //a == a, ok
            if (s.charAt(i) != s.charAt(start)) continue;
            //    i
            // abca ...   //b != c continue
            if (i - 1 > start + 1 && !dp[start + 1][i - 1]) continue;
            dp[start][i] = true;
            path.add(s.substring(start, i + 1));
            dfs(r, s, i + 1, path, dp);
            path.remove(path.size() - 1);
        }
    }
```
