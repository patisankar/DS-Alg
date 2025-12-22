Problem
======
Given a set of nodes and a set of edges between pairs of nodes, your task is to first identify the connected components in the graph. A connected component is a group of nodes that are all linked, either directly or through other nodes in the group. For each connected component, calculate the difference between its largest and smallest node values, and return the maximum of these differences.
Example Suppose you’re given the following array of nodes, [1, 2, 3, 4], which are connected as follows: g_from = [1, 2] g_to = [2, 3] Node 1 connects to Node 2, and Node 2 connects to Node 3. Node 4 is not connected to any other node. Therefore, the only connected component among these nodes is [1, 2, 3]. 
The difference between the maximum and minimum values in this connected component is 3 - 1 = 2, therefore, return 2.

Soultion
==========
```
import java.util.*;

public class Solution {

    public static int maximumDifference(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        UnionFind uf = new UnionFind(gNodes);

        // 1) Build components
        for (int i = 0; i < gFrom.size(); i++) {
            uf.union(gFrom.get(i), gTo.get(i));
        }

        // 2) Track min/max per component root
        int[] compMin = new int[gNodes + 1];
        int[] compMax = new int[gNodes + 1];
        Arrays.fill(compMin, Integer.MAX_VALUE);
        Arrays.fill(compMax, Integer.MIN_VALUE);

        for (int node = 1; node <= gNodes; node++) {
            int root = uf.find(node);
            compMin[root] = Math.min(compMin[root], node);
            compMax[root] = Math.max(compMax[root], node);
        }

        // 3) Compute maximum difference among components
        int ans = 0;
        for (int i = 1; i <= gNodes; i++) {
            if (compMin[i] != Integer.MAX_VALUE) { // root exists
                ans = Math.max(ans, compMax[i] - compMin[i]);
            }
        }

        return ans;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n + 1]; // 1-based
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;

            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
    }
}

```

Union–Find approach
=================
Idea
Union endpoints of every edge → forms connected components.

For each node i, find its root, and track:

min[root] = smallest node value in that component

max[root] = largest node value in that component

Answer = max over roots (max[root] - min[root])

Time: ~O((n+e) α(n)) ≈ linear.

Union–Find is a data structure for tracking connected components.
Each node initially belongs to its own set.
The find operation returns the representative of a node’s component, and union merges two components.
With path compression and union by rank, operations run in near-constant time.
It’s ideal when we need to repeatedly merge nodes and query connectivity
