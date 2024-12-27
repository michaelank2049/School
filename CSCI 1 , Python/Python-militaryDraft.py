#**********************  militaryDraft.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Project Code
#
# Algorithm:
#   Import random
#
#       If age input greater than 20 and less than 44:
#           return ('y')
#       Else:
#           return ('n')
#
#       If weight input greater than 90 and less than 250:
#           return ('y')
#       Else:
#           return ('n')
#
#       If height input greater than 54 and less than 80:
#           return ('y')
#       Else:
#           return ("n')
#
#       Set enlistees to global variable
#       Set answer to yes
#       Set count to 0
#       Set average weight to 0
#       Set average age to 0
#       Set average height to 0
#       Create list of armed forces
#       While answer=='yes':
#           Create enlistees list
#           Create checked enlistees list
#           For loop runs 4 times:
#               User input
#               Append input to enlistees list
#           Append name(element[0]) to checked enlistees
#           Append checked age to checked enlistees
#           Append checked weight to checked enlistees
#           Append checked height to checked enlistees
#           If checked age=='y' and checked weight=='y' and checked height=='y':
#               Print(name, 'has been assigned to', a random armed force)
#               Add 1 to count
#               Calculate average age
#               Calculate average weight
#               Calculate average height
#           Else:
#               Print(name, 'isn't eligible for service')
#       User input to continue while loop
#   Print average age
#   Print average weight
#   Print average height
#
#**********************************************************

import random

    #Check age range function
def age():
    if int(enlistees[1])>18 and int(enlistees[1])<44:
        return('y')
    else:
        return('n')

    #Check weight range function
def weight():
    if int(enlistees[2])>90 and int(enlistees[2])<250:
        return('y')
    else:
        return('n')

    #Check height range function
def height():
    if int(enlistees[3])>54 and int(enlistees[3])<80:
        return('y')
    else:
        return('n')

    #Main function
def main():
    global enlistees

        #Variable and array declarations
    answer='yes'
    count=0
    averageWeight=0
    averageAge=0
    averageHeight=0
    armedForces=['Army','Navy','Marine Corps','Air Force','Coast Guard']

        #Begin while loop
    while answer=='yes':

            #Array declarations
        enlistees=[]
        checkedEnlistees=[]

            #For loop for user input
        for i in range(4):
            
                #For this enter the name press enter, enter the age press enter, etc.
            askUser=input("Enter a person's name, age, weight, and height in inches:")
            enlistees.append(askUser)

            #Append inputs to array and call functions
        checkedEnlistees.append(enlistees[0])
        checkedEnlistees.append(age())
        checkedEnlistees.append(weight())
        checkedEnlistees.append(height())

            #Check if user input person if viable for draft
        if checkedEnlistees[1]=='y' and checkedEnlistees[2]=='y' and checkedEnlistees[3]=='y':
            print(enlistees[0],'has been assigned to the',random.choice(armedForces))
            count=count+1
            averageWeight=(int(enlistees[2])+averageWeight)
            averageAge=(int(enlistees[1])+averageAge)
            averageHeight=(int(enlistees[3])+averageHeight)
        else:
            print(enlistees[0],'is not fit for service')

            #User input to continue entering inputs
        answer=input("Do you want to continue?")

        #Print statements
    print(count)
    print('The average age of the eligible recruits is:',(averageAge/count),'years.')
    print('The average weight of the eligible recruits is:',(averageWeight/count),'pounds.')
    print('The average height of the eligible recruits is:',(averageHeight/count),'inches.')

    #Call main
main()
                               
    
