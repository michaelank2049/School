#**********************  astrosRoster.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #9
#
# Algorithm:
#   Define function
#   Set new list and set average weight/age to zero
#   For loop to print player name and jersey
#   For loop to find and print average weight and averaeg age
#   For llop to append to lists and then find tallest player and person with the team the longest
#   Print tallest player and person on the team the longest
#   Define the main function
#   Call main
#
#**********************************************************

#File to open roster on school computer
#astrosRoster=open('C:\\Users\\lankfordm0772\\OneDrive - University of Houston-Clear Lake\\Desktop\\CompSci\\Homework\\LankfordM_CSCI_1470_HW#9\\AstrosRoster(1).txt')

#File to open roster on laptop
astrosRoster=open('C:\\Users\\micha\\Desktop\\Computer Science\\AstrosRoster(1).txt')

    #Function to find average weight, average age, team veterans, and heigt for the Houston Astros
def astros():
    averageWeight=0
    averageAge=0
    teamVeteran=[]
    height=[]

        #Foor loop moves down each line in text document astrosRoster
    for line in astrosRoster:
        element=line.split(',')
        
            #Prints player and jersey number
        print(element[1], element[2])

            #Calculates average weight
        averageWeight=(averageWeight+int(element[9]))

            #Calculates average age
        averageAge=(averageAge+int(element[5]))
    
            #Finds tallest player
        height.append(element[8][1:])
        height.sort()
        if element[8][1:]==height[-1]:
            print('The tallest player is:',element[1], element[2])

            #Finds players who have been with the team the longest
        teamVeteran.append(element[12][1:-1])
        teamVeteran.sort()
        if element[12][1:-1]=='2001':
            print(element[2],'is a player who has been with the Astros the longest')

        #Print statements
    print('The average weight of the players is:',averageWeight/40)
    print('The average age of the players is:',averageAge/40)

    #Main function calls astros function
def main():
    astros()

    #Calls main function
main()
