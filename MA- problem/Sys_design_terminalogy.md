CAP
============
When NoSQL databases prioritize scalability, performance, and availability, they often trade off strong data consistency, which is a consequence of the CAP and PACELC theorems.

For example, re-entering the same dataset in NoSQL databases might be accepted without an error being thrown, but relational databases prevent duplicate rows from being added via integrity checks.

Most NoSQL solutions trade off strong consistency for high availability under network partitions (CAP theorem). Some applications’ classes are hard to develop using loose consistency guarantees, for example, eventual consistency. The following use cases where strong consistency and high availability are the requirements of the applications:

Financial services: Regulatory constraints and high client expectations make this industry particularly challenging. There must be constant, error-free communication between banks, fintech companies, and government agencies. 
Applications like payment gateways and online banking have the added pressure of processing hundreds of millions of transactions reliably while also applying complex anti-fraud and settlement measures. 
Coping with this constant influx of data requires meticulous re-architecturing of legacy systems. NoSQL cannot provide strong consistency with high availability, which is why using a relational database is a better choice.

Webhook
=======

In BT payment processing, we send notifications to merchant on any transaction status changes, subscription lifecycle events.

HMAC-SHA1 signatures for payload verification

gRPC
=======
gRPC is used for high-performance inter-service communication with Protocol Buffers.
