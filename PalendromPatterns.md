
Type1 : Valid palindrome or not
====
Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.
Solution: Here, we just need to check, two pointer works , start as one pointer, end as another pointer. Move both when both are equal.

Type2: Largest Palendrom Number
=====
You are given a string num consisting of digits from 0-9. Your task is to return the largest possible palindromic number as a string by using some or all of the digits in num. The resulting palindromic number must not have leading zeros.

Solution: Greedy Approach

We begin by counting digit occurrences. Using digits from 9 down to 0, any digit whose frequency allows pairing (count // 2) contributes to the palindrome’s left and right halves. Single occurrences are candidates for the center; when multiple exist, we retain the highest digit. The final palindrome is formed by combining all pairs with the selected middle digit.
