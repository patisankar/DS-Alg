# Algorithm Notes

| Problem | Goal | Greedy choice | Exact approach or graph model | Greedy risk |
|---|---|---|---|---|
| Set cover | Cover all states with as few stations as possible | Pick the station covering the most uncovered states | Exact DP can track the covered-state subset; with 50 states, there may be up to `2^50` subsets. Graph: stations connect to the states they cover. | May use more stations than the optimum. |
| TSP | Visit every city once, return to the start, and minimize cost | Go to the nearest unvisited city | Exact DP tracks `(visited cities, current city)`, about `O(n^2 * 2^n)`. Graph: cities are vertices and travel costs are weighted edges. | A locally cheap choice can make the full tour more expensive. |

### TSP and shortest path

- **Shortest path:** Cheapest path between two specified cities.
- **TSP:** Cheapest tour visiting every city once and returning to the start.
- A shortest-path algorithm does not generally solve TSP.
