# Denomination

Programming challenge description:
The goal of this question is to design a cash register program. Your register currently has the following notes/coins within it:

One Pence: .01
Two Pence: .02
Five Pence: .05
Ten Pence: .10
Twenty Pence: .20
Fifty Pence: .50
One Pound: 1
Two Pounds: 2
Five Pounds: 5
Ten Pounds: 10
Twenty Pounds: 20
Fifty Pounds: 50
The aim of the program is to calculate the change that has to be returned to the customer with the least number of coins/notes. Note that the expectation is to have an object-oriented solution - think about creating classes for better reusability.

Input:
Your program should read lines of text from standard input (this is already part of the initial template). Each line contains two numbers which are separated by a semicolon. The first is the Purchase price (PP) and the second is the cash(CH) given by the customer.

Output:
For each line of input print a single line to standard output which is the change to be returned to the customer. If CH == PP, print out Zero. If CH > PP, print the amount that needs to be returned (in terms of the currency values). Any other case where the result is an error, the output should be ERROR.

The output should the change from highest to lowest denomination.
