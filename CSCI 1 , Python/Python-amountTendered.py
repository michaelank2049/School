#**********************  makingChange.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #3
#
# Algorithm:
#   Prompt user for itemCost and amountTendered
#   Calculate change
#   Check operators
#   Calculate dollars, quarters, dimes, nickels, pennies
#   Print dollars, quarters, dimes, nickels, pennies
#**********************************************************


    #Variable declarations
itemCost=float(input("Enter the item cost? To stop enter a cost>amount tendered"))
amountTendered=float(input("Enter the amount tendered? To stop enter a cost>amount tendered"))
change=100*(amountTendered-itemCost)
count=0
answer=input("Do you want to continue?")

    #While loop to check for bills larger than 500 and invalid count
while amountTendered<500 and count<1:

        #If item cost is larger than bills given
    if itemCost>amountTendered:
        print("Error, cost is greater than amount tendered")
        itemCost=float(input("Enter the item cost? To stop enter a cost>amount tendered"))
        amountTendered=float(input("Enter the amount tendered? To stop enter a cost>amount tendered"))

        #If want to stop program
    elif answer=='no':
        stop()

        #Print change and ask to continue
    else:
        count=count+1
        dollar=change//100
        quarter=(change%100)//25
        dime=((change%100)%25)//10
        nickel=(((change%100)%25)%10)//5
        penny=change%5
        print(dollar, "dollars")
        print(quarter, "quarters")
        print(dime, "dimes")
        print(nickel, "nickels")
        print(penny, "pennies")
        answer=input("Do you want to continue?")

