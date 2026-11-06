### Nearest Neighboring City



Problem : Given a number of cities positioned on a Cartesian plane, each city is located at an integer (x, y) coordinate. 

City names and their locations are provided in three arrays: cityName, x, and y, where cityName[i] is the name of the city and (x[i], y[i]) are its coordinates. 

For each queried city, find the name of the nearest city that shares an x or y coordinate. If no other cities share an x or y coordinate, return 'NONE'. 

If multiple cities are equidistant to the queried city, choose the one with the alphabetically lowest name. The distance is calculated using the Manhattan distance, which is the sum of the absolute differences in x and y coordinates.


## First 

**“For one queried city, how would I find the answer by checking every other city?”**

Before optimizing, establish that baseline.

As your interviewer: **What makes another city eligible, and how would you choose the best among eligible cities?**

SMART Goal

1. What must I find?
2. How would I find it by checking every possibility?
3. What makes that approach slow?
4. What question could help me avoid that work?
   
Then test your new question on one small example.
