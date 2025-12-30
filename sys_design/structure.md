# System Design Interview – Spoken Script (Rehearsal)

This is a **spoken scaffold**, not a memorization script. Internalize the flow and adapt the wording naturally during interviews.
## 1. Clear Train of Thought (How You Think)

### What they are testing
- Can you take an ambiguous problem and structure it?
- Do you reason step-by-step instead of dumping components?

### How to demonstrate
- Start by breaking the problem into smaller sub-problems.
- Solve them incrementally, narrating *why* you are making each choice.
- Avoid listing technologies without justification.

### Signal you want to send
> “I can reason like an engineer, not just recall architectures.”

---

## 2. Comfort With Scale (Not Intimidated by Big Numbers)

### What they are testing
- Do large numbers freeze you or excite you?
- Can you reason proportionally instead of over-engineering?

### Key mindset
- Interview scale is smaller than real production.
- You are not expected to build a bullet-proof system in 45 minutes.

### How to demonstrate
- Acknowledge scale, then move forward confidently.
- Use rough estimates (order of magnitude is enough).
- Say explicitly:  
  > “This won’t handle infinite scale, but it’s a good baseline.”

### Signal
> “I’ve seen scale before, and I know how to grow into it.”

---

## 3. Solving the Problem (Design + Trade-offs)

### What they are testing
- Can you apply common patterns appropriately?
- Do you understand trade-offs and bottlenecks?

### Use Reusable Building Blocks
Most systems reuse the same core template:
Client → DNS → Load Balancer → Backend → Database / Cache / Queue

markdown
Copy code

### Then Adapt Based on Constraints
- Read-heavy traffic → caches, read replicas
- Write-heavy traffic → partitioning, async writes
- Single DB bottleneck → sharding
- Complex joins → denormalization
- Hot keys / skew → partition-aware strategies

### Always Talk in Trade-offs
- “This improves latency but increases write complexity”
- “This is cheaper now but harder to operate later”

### Signal
> “I make informed decisions, not perfect ones.”

---

## 4. Bottleneck-First Thinking

### What they are testing
- Can you identify where the system will break first?

### Approach
- Start with the simplest working system.
- Ask:  
  > “What fails first as traffic grows?”
- Fix one bottleneck at a time.

### Examples
- Single DB → shard
- Synchronous writes → async + queue
- Backend overload → cache or fan-out

### Signal
> “I know how systems fail in the real world.”

---

## 5. Collaborative Engineering Mindset

### What they are testing
They are hiring a teammate, not just a designer.

### Two explicit checks

**a. Are you receptive?**
- Listen to hints.
- Adjust when challenged.
- Say things like:  
  > “Good point, let me rethink that.”

**b. Are you competent?**
- You don’t need hand-holding.
- You can defend your choices logically.

### Signal
> “This person would be easy and effective to work with.”

---

## 6. Depth in Role-Relevant Areas

### What they are testing
- Can you go deep where it actually matters for the role?

### Examples

**Application Engineer**
- API design
- Data modeling
- Caching strategies
- End-to-end request flow

**Infrastructure / Platform Engineer**
- Consistency models
- Failure handling
- Replication, sharding
- Back-pressure, retries, observability

### Rule of thumb

---

## 1. Opening (30–45 seconds): Frame the Problem

> “Before jumping into the design, I’d like to align on the requirements and constraints so I solve the right problem.”

> “I’ll start with a simple baseline design and then evolve it as we identify bottlenecks and scale constraints.”

---

## 2. Requirements Clarification (2–3 minutes)

> “Let me confirm the functional requirements first.”

> “Who are the users of the system, and what core actions do they perform?”

> “Are there latency, availability, or consistency requirements I should optimize for?”

> “What is the expected scale—users, requests per second, and data size?”

> “Any constraints such as cost, compliance, or existing infrastructure?”

---

## 3. High-Level Architecture (3–4 minutes)

> “I’ll begin with a straightforward end-to-end flow.”

> “Clients resolve via DNS, hit a load balancer, then stateless application servers, which talk to a primary datastore.”

> “I’m intentionally keeping this simple first so we can reason clearly about where it breaks.”

> “At this stage, the database and synchronous writes are the most likely bottlenecks.”

---

## 4. Data Model & API Shape (2–3 minutes)

> “Let me briefly outline the core entities and access patterns.”

> “The primary entity is **X**, keyed by **Y**, since most queries are driven by that dimension.”

> “I’m optimizing the schema for the dominant read path, even if that means some denormalization.”

> “Writes flow through the backend; reads come directly from the datastore for now.”

---

## 5. Identify Bottlenecks (Key Transition)

> “Now I’ll walk through how this system behaves as traffic increases.”

> “Given this workload, the first bottleneck is the database due to read amplification.”

> “Latency degradation will appear before throughput saturation, so I’ll address reads first.”

---

## 6. Scaling Strategy (Incremental)

> “To reduce read pressure, I’d introduce a cache for hot keys.”

> “As traffic grows further, I’d shard the database based on **X**, since it distributes load evenly and aligns with query patterns.”

> “Each shard can have read replicas to support read-heavy traffic.”

> “This improves scalability but adds operational complexity and rebalancing overhead.”

---

## 7. Consistency, Reliability, and Failure Handling

> “Strong consistency is required for **X**, but **Y** can tolerate eventual consistency.”

> “If an application instance fails, traffic is rerouted by the load balancer.”

> “Datastore failures are handled via replicas and shard-level failover.”

> “Retries are bounded and idempotent to avoid cascading failures.”

---

## 8. Observability & Operability

> “To operate this system in production, I’d instrument end-to-end latency, error rates, and saturation metrics.”

> “Key dashboards include p95/p99 latency, cache hit ratio, and per-shard database load.”

> “This allows early detection of regressions before users are impacted.”

---

## 9. Closing (Optional – 30 seconds)

> “At this point, the design satisfies the requirements and scales to the expected load.”

> “If we needed to go further, I’d explore async processing, write batching, and regional replication.”

> “Happy to dive deeper into any component.”

---

## Practice Tips

- Practice **out loud**
- Time-box to ~25–30 minutes
- Replace placeholders (**X**, **Y**) with problem-specific entities
- Focus on **clear transitions**, not perfect wording
