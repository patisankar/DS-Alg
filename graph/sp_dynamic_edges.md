Problem
=========
Number of nodes: g_nodes, numbered from 1 to g_nodes Number of edges: g_edges No edge connects a node to itself. The edge from g_from[i] to g_to[i] is directed, and the weight is g_weight[i]. The weight of a path is the sum of the weights of the edges traversed on that path. You are allowed to add extra directed edges of weight 1 between any two distinct nodes that are not already connected by an edge. Determine the minimum possible weight of the path from node 1 to node g_nodes. Example 1 The following list of edges in a 4-node graph is given: 
From To Weight 1 2 3 1 3 3 1 4 3 2 1 3 A directed edge already exists from node 1 to node 4, and the path 1 →3 4 is the minimum-cost path. Return 3.

Solution
==========
Key idea

From any node u, you can take:

Existing directed edges (u → v, weight w) from input.

Implicit extra edges of weight 1 to every node v != u such that there is NO existing edge u → v.

So for each u, the “extra” neighbors are the complement of outNeighbors[u] (excluding u).

Efficient Dijkstra with complement edges

We maintain:

dist[i] = current best distance to node i

PriorityQueue by (dist, node)

remaining = a TreeSet<Integer> (or HashSet + linked structure) of nodes that have not yet been “claimed” via an implicit (weight 1) relaxation.

Trick:

When we process node u (in increasing dist[u] order), any node v that can be reached from u via an implicit edge would get candidate distance dist[u] + 1.

The first time we assign a node v via an implicit edge from a popped node, that value is already optimal among all possible implicit edges (because Dijkstra pops in nondecreasing distance).
Therefore, we can safely remove v from remaining to avoid scanning it again in future complement relaxations.

To avoid 
𝑂(𝑛)
clearing of a boolean array each time, we use a timestamp marking array to mark outgoing neighbors of u.

Pseudocode
=========
```
build adjacency list adj[u] = list of (v, w)
build a fast "hasEdge(u,v)" check via HashSet per u (or mark array via adjacency list)

dist[*] = INF
dist[1] = 0
pq = min-heap (dist, node)
push (0, 1)

remaining = {2..n}   // nodes not yet relaxed via implicit edges

while pq not empty:
    (d, u) = pop
    if d != dist[u]: continue
    if u == n: break

    // relax explicit edges
    for (v, w) in adj[u]:
        if dist[v] > d + w:
            dist[v] = d + w
            push(dist[v], v)

    // relax implicit edges of weight 1: to nodes not in outNeighbors[u] and not u
    mark all outNeighbors[u] as blocked (timestamp)

    iterate v over remaining:
        if v is NOT blocked:
            if dist[v] > d + 1:
                dist[v] = d + 1
                push(dist[v], v)
            remove v from remaining   // important optimization
        else:
            keep v

return dist[n]

```
Java
======

```
import java.util.*;

public class Solution {

    static class Edge {
        int to;
        int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class State {
        int node;
        long dist;
        State(int node, long dist) { this.node = node; this.dist = dist; }
    }

    public static long minPathWithExtraEdges(int gNodes,
                                             List<Integer> gFrom,
                                             List<Integer> gTo,
                                             List<Integer> gWeight) {

        // Build adjacency list (1-based)
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= gNodes; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < gFrom.size(); i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int w = gWeight.get(i);
            adj.get(u).add(new Edge(v, w));
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[gNodes + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(s -> s.dist));
        pq.offer(new State(1, 0));

        // Nodes not yet "claimed" by an implicit (weight 1) relaxation
        TreeSet<Integer> remaining = new TreeSet<>();
        for (int i = 2; i <= gNodes; i++) remaining.add(i);

        // For marking u's outgoing neighbors quickly (timestamp trick)
        int[] mark = new int[gNodes + 1];
        int token = 1;

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;

            if (d != dist[u]) continue;
            if (u == gNodes) break;

            // 1) Relax explicit edges
            for (Edge e : adj.get(u)) {
                int v = e.to;
                long nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new State(v, nd));
                }
            }

            // 2) Relax implicit edges of weight 1 to all v not in outNeighbors[u]
            token++;

            // Mark all outgoing neighbors of u as "blocked"
            for (Edge e : adj.get(u)) {
                mark[e.to] = token;
            }
            // Also block self (can't add edge to itself)
            mark[u] = token;

            // Iterate remaining nodes; any node not blocked is reachable via implicit edge (u -> v) of weight 1
            Iterator<Integer> it = remaining.iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (mark[v] != token) { // not blocked => implicit edge exists
                    long nd = d + 1;
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        pq.offer(new State(v, nd));
                    }
                    // Safe optimization: remove so we never scan v again for implicit edges
                    it.remove();
                }
            }
        }

        return dist[gNodes];
    }

    // quick sanity
    public static void main(String[] args) {
        int gNodes = 4;
        List<Integer> from = Arrays.asList(1, 1, 1, 2);
        List<Integer> to   = Arrays.asList(2, 3, 4, 1);
        List<Integer> w    = Arrays.asList(3, 3, 3, 3);

        System.out.println(minPathWithExtraEdges(gNodes, from, to, w)); // expected 3
    }
}

```
)
O(n) clearing of a boolean array each time, we use a timestamp marking array to mark outgoing neighbors of u.
