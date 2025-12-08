## Mock interivew
AI: imagine you’re tasked with designing a Pub-Sub system from scratch. How would you approach this, and what initial requirements or goals would you want to clarify before starting the design?
Mine: if we want to pub-sub system, first we need to see how many users are intent to use this one. Let suppose producer send message to multiple subscribers. They can subscribe to particular topic. functional requirement, published message should deliver to subscribers without lost. There should be reliable system. Non-functional, message deliver can be eventual-consistency, it should be scallable for as subscribers goes up.
AI: You’ve highlighted reliability, scalability, and eventual consistency as key requirements, and you want to understand the user base size. Let’s make that more concrete: what kind of scale do you envision for this system—are we talking thousands, millions, or even more users? And do you see this as being more read-heavy, write-heavy, or balanced?
Mine: I’m thinking we will go with million users, and write and ready heavy.
AI: So, we’re targeting a system with millions of users and significant read and write traffic. Besides reliable message delivery and scalability, are there any other functional or non-functional requirements you’d want to consider—like message ordering, security, latency expectations, or durability? Or do you feel what you’ve listed covers the core needs for now?
Mine: Yes, we are expecting messaging ordering, securly deliver message, latency is not main concern. And we do need durability.
AI: Message ordering, secure delivery, and durability are now also part of your requirements, with latency being less of a concern.

Let’s move to the high-level design. Can you walk me through the main components you’d include in your Pub-Sub architecture and briefly describe how they’d interact to meet these requirements? If you can, please sketch the architecture in the diagram tool.

Mine: I see you’ve included publishers, a topic manager, and multiple subscribers. Can you walk me through the flow of a message—starting from when a publisher sends it, all the way to delivery at the subscriber? How does your design ensure messages aren’t lost along the way?
