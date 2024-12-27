#**********************  monthlyExpenses.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #1
#
# Algorithm:
#   Prompt user for Name,Salary,Rent,Grocery,Mobie,Miscellaneous
#   Get Name,Salary,Rent,Grocery,Mobie,Miscellaneous
#   Calculate totalExpenses and balanceRemaining
#   Display Name,Salary,totalExpenses,balanceRemaining
#**********************************************************

    #Variable inputs
name=input("Type your name")
salary=int(input("Type your salary"))
rent=int(input("Type your rent"))
grocery=int(input("Type your grocery"))
mobile=int(input("Type your mobile"))
miscellaneous=int(input("Type your miscellaeous"))

    #Calculations for total expenses and balance remaining
totalExpenses=rent+grocery+mobile+miscellaneous
balanceRemaining=salary-totalExpenses

    #Print values
print(name,salary,totalExpenses,balanceRemaining)
