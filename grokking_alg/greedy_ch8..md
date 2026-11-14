# Algorithm Notes

## NP-complete problems

No polynomial-time algorithm is known for solving every instance of an NP-complete problem exactly. When the input is large, consider an approximation algorithm if a near-optimal solution is acceptable. Check its guarantee.

## Worked examples

| Problem | Goal | Exact approach or graph model | Greedy approach | What can go wrong? |
|---|---|---|---|---|
| **Set cover** | Cover every state with as few radio stations as possible. | DP can track the exact subset of covered states. With 50 states, there may be up to `2^50` subsets. Graph: stations connect to the states they cover. | Repeatedly pick the station that covers the most currently uncovered states. This is an approximation. | Greedy may use more stations than the optimal solution. Tracking only the number of covered states loses which states remain. |
| **Traveling Salesperson (TSP)** | Visit every city once, return to the start, and minimize total cost. | DP tracks `(visited cities, current city)`, with about `O(n^2 * 2^n)` time. Graph: cities are vertices and travel costs are weighted edges. | Go to the nearest unvisited city, then return to the start after visiting all cities. This is a heuristic; this rule has no general approximation guarantee. | A nearby choice can make the remaining route expensive. |

## TSP and shortest path

- **Shortest path:** Find the cheapest path between two specified cities.
- **TSP:** Find the cheapest tour that visits every city once and returns to the start.
- A shortest-path algorithm does not generally solve TSP. TSP has the added requirement to visit every city.
