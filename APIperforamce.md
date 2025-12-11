### API performance patterns
Database latency: Slow queries, N+1 query patterns, or unindexed lookups can dominate response time. Even a fast API can’t outrun a sluggish database.
N+1 queries: This classic ORM pitfall means your API makes one query per item, ballooning DB calls as data grows.
Network overhead: Every remote call (to a DB, microservice, or external API) adds unpredictable latency.
Serialization costs: Converting objects to JSON or XML isn’t free, especially for large or deeply nested payloads.
Thread pool saturation: If your thread pool is maxed out, new requests wait in line, increasing latency for everyone.
Blocking I/O: Synchronous file, DB, or network operations tie up threads, reducing throughput.
Unoptimized payloads: Sending too much data (or too many fields) wastes bandwidth and CPU.
Excessive synchronous calls: Chaining blocking calls multiplies latency and resource usage.


Caching: Reduces repeated computation or DB hits, but can serve stale data if not managed carefully.
Async processing: Frees up threads for I/O-bound tasks, but adds complexity and requires careful error handling.
Batching: Combines multiple requests into one, cutting down on round-trips, but can increase latency for small requests.
Pagination: Limits payload size, improving response time and memory use, but requires client-side handling.

