Save data to Postgres and emit an event to Kafka.

If you do them sequentially (Code A below), you have a "Dual Write" problem.
```
// Code A: The Trap
db.save(order); // If this succeeds...
kafka.send(order_event); // ...and this fails, your system is corrupted.
````
The network will fail eventually. 
When it does, your database has the order, but your shipping service (listening to Kafka) never heard about it.

The Solution: The Transactional Outbox Pattern 

Instead of publishing directly to the queue, write the event into a temporary "Outbox" table within the same database transaction as your main data entity.

It’s atomic. Either both happen, or neither happens.

Then, a separate process (Debezium, or a simple poller) picks up the outbox event and pushes it to the queue reliably, retrying until it succeeds.
