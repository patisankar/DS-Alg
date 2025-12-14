Ruby performance
==========
1. Know the evolution: 5.x → 6.x → 7.x
2. N+1 and preloading story
3. Indexing and query-plan story
4. Caching + background jobs story
5. Rails upgrade story (5 → 6 or 6 → 7, performance and maintenance improvements)

Steps
=========
Identify the slowest pages.
Fix:
  N+1 queries using includes/preload.
  Missing indexes (use EXPLAIN and add migrations).
  Add caching to at least one page or partial.
  Benchmark and profile one piece of Ruby code

Use Benchmark.ips and stackprof to compare and summarize findings.
Schema and ActiveRecord design
Design a mini schema for a domain you know (e.g., orders/payments/subscriptions).

Scopes for common filters.
I extract repeated filtering conditions into model scopes so the query logic is centralized, composable, and testable. For very complex logic, I wrap scopes inside a Query Object that orchestrates all filters cleanly.

React
===========
Minimize overfetching by using GraphQL fragments
Storybook for documentation
