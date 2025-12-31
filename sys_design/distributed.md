### Overview
A distributed system is a group of independent nodes that work together to present themselves as a single, logical system.

Examples:
Google Spanner (globally distributed database)
Apache Kafka (distributed log system)

There is often a “leader or a control plane” responsible for managing consistency, replication, and communication between nodes.

### challenge
The primary challenge in distributed coordination lies in balancing consistency, availability, and partition tolerance. When a network failure splits the cluster, the system must decide whether to continue running with possibly outdated data or shut down to ensure full correctness.

#### Consensus and Linearizability
Consensus is protocol used in all nodes agreed on one value despite failure

### In a database replica cluster, why do the nodes need to elect a leader? 
The leader in a database replica cluster is crucial for ensuring consistent writes. It’s worth adding that the leader is the authoritative node for handling writes, ensuring that updates occur in a single, consistent order. This prevents scenarios where two replicas might accept a write for the same record and store different values, leading to inconsistency. 
For instance, in a payment system, without a leader, one replica might record a balance as $100 while another records it as $120. Keep exploring!

### Co-ordinate service
ZooKeeper and etcd simplify implementation, providing robust building blocks for modern System Design.

This lesson introduces the following key concepts for building system resilience:

**Retries**: The simple act of trying a failed operation again.

**Backoff**: A strategy for waiting an increasing amount of time between retries.

**Jitter**: The introduction of randomness to backoff delays to prevent synchronized retries.

**Idempotency**: A property of operations that ensures repeating them produces the same result.

**Checkpointing**: A technique for saving the state of a long-running process to resume after a failure.

### Challenges of concurrency
While powerful, structuring a system for concurrency introduces significant complexity. The non-deterministic nature of task execution can lead to several classic problems, such as:

Race conditions: This issue occurs when multiple tasks access shared data simultaneously, and the final result depends on the unpredictable order of execution, often resulting in inconsistent or corrupted data.

Deadlocks: A situation where two or more tasks are blocked forever, each waiting for a resource held by the other.

Starvation: A task is perpetually denied necessary resources (like CPU time) and never gets to run, often because higher-priority tasks dominate.

Complex debugging: Bugs, such as race conditions, are non-deterministic. They may not appear on every run, making them extremely difficult to reproduce and debug.

Context-switch overhead: The act of switching the CPU from one task to another is not free. This overhead is a fundamental challenge of concurrency.

Of all these challenges, the most fundamental cost that enables concurrency is the overhead of the context switch itself.

### Parallelism in distributed systems
Parallelism is the ideal approach for CPU-bound tasks, where the bottleneck is the computation itself.
A distributed messaging system, such as Apache Kafka, achieves high throughput by splitting a topic into multiple partitions. A consumer group can then have multiple instances reading from these partitions in parallel, allowing for massive data ingestion rates.

### Challenges of parallelism
Data dependency: Tasks may rely on results from others. If Task B cannot start until Task A finishes, true parallel execution is limited.

Load imbalance: Work may not be distributed evenly among all processors. This leads to some cores sitting idle while others are overloaded, resulting in reduced efficiency.

Synchronization cost: Coordinating parallel threads (e.g., ensuring they all complete a step before proceeding to the next) requires synchronization mechanisms, which introduce latency and overhead.

Memory contention: When multiple threads compete to read from and write to the same shared memory location, it can create a new bottleneck, slowing performance.

Scalability limits: The potential speedup is often limited by the serial (non-parallel) portion of the task. Performance gains tend to diminish as more cores are added due to synchronization and communication overhead.


### observability
**Metrics**: Metrics are numerical, aggregated data points collected over time, typically stored as time-series data. 	
Alerting, Dashboards, Trend analysis
**Traces**: A trace represents the end-to-end journey of a single request as it moves through multiple services.
Each step in the journey is a span, which contains timing information and metadata. Traces are essential for pinpointing bottlenecks. They are like a package tracking history, showing every stop a request made. For example, a trace for a checkout request might show a 1200 ms total duration, composed of a 50 ms span in the checkout-service and a 1150 ms child span for a call to the inventory-service.
