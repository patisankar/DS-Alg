### lessons
I need to improve reframe problem rather than speed.

Strip the problem to what actually matters, identify state, transistion come from rules.

Step1: Strip the Problem to What Survives
============
Ask only:

After all operations are done, what information do I actually care about?

Examples:

Last digit → modulo arithmetic

Max value → comparisons only

Valid/invalid → boolean state

Count → accumulation

If something does not affect the final answer, it must be discarded.

Rule:
If you are tracking more than the output requires, you are over-modeling. 

For DP,
=========
At step i, I know STATE, and I can choose DECISION, which changes STATE into NEW_STATE.
