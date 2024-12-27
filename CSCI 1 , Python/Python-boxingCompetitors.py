#**********************  boxingCompetitors.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #4
#
# Algorithm:
#   Prompt user for boxing competitors weights
#   Get weight
#   if weight is <0
#   Print competitors for welterweight, lightweight, featherweight, bantamweight, tooLow, tooHigh, and quit
#   if weight<51
#   Add to count, to tooLow competitors and tooLowTotal weights, prompt for weights
#   if weight>64
#   Add to count, to tooHigh competitors and tooHighTotal weights, prompt for weights
#   if weight>=61 and <=64
#   Add to count, to welterweight competitors and welterweighTotal weights, prompt for weights
#   if weight>=58 and <=60
#   Add to count, to lightweight competitors and lightweighTotal weights, prompt for weights
#   if weight>=55 and <=57
#   Add to count, to featherweight competitors and featherweighTotal weights, prompt for weights
#   if weight>=51 and <=54
#   Add to count, to bantamweight competitors and bantamweighTotal weights, prompt for weights
#   Add 1 to featherweight if bantamweight=1
#   Add 1 to lightweight if featherweight=1
#   Add 1 to lightweight if welterweight=1
#   Print competitors for welterweight, lightweight, featherweight, bantamweight, tooLow, tooHigh, and averageWeight
#**********************************************************

    #Variable declarations
weight=int(input("Enter a weight in kg of boxing competitors"))
count=0
welterweight=0
lightweight=0
featherweight=0
bantamweight=0
tooLow=0
tooHigh=0
welterweightTotal=0
lightweightTotal=0
featherweightTotal=0
bantamweightTotal=0
tooLowTotal=0
tooHighTotal=0

    #Begin while loop
while weight>0:

        #If weight is <= 0kg then quit program and print competitors
    if weight<=0:
        print(welterweight, "welterweight competitors")
        print(lightweight, "lightweight competitors")
        print(featherweight, "featherweight competitors")
        print(bantamweight, "bantamweight competitors")
        print(tooLow, "too low weight competitors")
        print(tooHigh, "too high weight competitors")
        quit

        #If weight is < 51kg then declare competitor as being underweight
    elif weight<51:
        count=count+1
        tooLowTotal=weight+tooLowTotal
        tooLow=tooLow+1
        weight=int(input("Enter a weight in kg of boxing competitors"))

        #If weight is > 64kg then declare competitor as being overweight 
    elif weight>64:
        count=count+1
        tooHighTotal=weight+tooHighTotal
        tooHigh=tooHigh+1
        weight=int(input("Enter a weight in kg of boxing competitors"))

        #If weight is between 61kg and 64kg then place competitor in welterweight class  
    elif weight>=61 and weight<=64:
        count=count+1
        welterweightTotal=weight+welterweightTotal
        welterweight=welterweight+1
        weight=int(input("Enter a weight in kg of boxing competitors"))

        #If weight is between 58kg and 60kg then place competitor in lightweight class 
    elif weight>=58 and weight<=60:
        count=count+1
        lightweightTotal=weight+lightweightTotal
        lightweight=lightweight+1
        weight=int(input("Enter a weight in kg of boxing competitors"))

        #If weight is between 55kg and 57kg then place competitor in featherweight class
    elif weight>=55 and weight<=57:
        count=count+1
        featherweightTotal=weight+featherweightTotal
        featherweight=featherweight+1
        weight=int(input("Enter a weight in kg of boxing competitors"))

        #If weight is between 51kg and 54kg then place competitor in bantamweight class
    elif weight>=51 and weight<=54:
        count=count+1
        bantamweightTotal=weight+bantamweightTotal
        bantamweight=bantamweight+1
        weight=int(input("Enter a weight in kg of boxing competitors"))
        
#End while loop

        
    #If weight class has 1 person then move competitor up to next class
if bantamweight==1:
    featherweight=featherweight+1
elif featherweight==1:
    lightweight=lightweight+1
elif lightweight==1:
    welterweight=welterweight+1

    #Print weight classes
print(welterweight, "welterweight competitors")
print(lightweight, "lightweight competitors")
print(featherweight, "featherweight competitors")
print(bantamweight, "bantamweight competitors")
print(tooLow, "too low weight competitors")
print(tooHigh, "too high weight competitors")

    #Calculate and print average weight of competitors
averageWeight=(welterweightTotal+lightweightTotal+featherweightTotal+bantamweightTotal+tooLowTotal+tooHighTotal)/count
print(averageWeight,"=average weight of all competitors")        
