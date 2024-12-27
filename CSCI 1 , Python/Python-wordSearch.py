#**********************  wordSearch.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #8
#
# Algorithm:
#   Define function to find the row for a search word
#   Go through if and elif statements to find the word and return the value
#   Define function to find the column for a search word's first letter
#   Go through if and elif statements to find the beginning letter and return the value
#   Define function to find the column for the reverse of the search word
#   Go through if and elif statements to find the beginning letter and return the value
#   Define the main function
#   Set up the grid list
#   Ask for user inputs for the grid and search word
#   Print the grid
#   Print where the search word isafter calling functions
#   Flip the search word
#   Print where the reverse search word is after calling functions
#   Call main
#
#**********************************************************


    #Function to return a word in a row
def wordSearchRow(grid,searchWord):
    if searchWord in grid[0]:
        return('row 1')  
    elif searchWord in grid[1]:
        return('row 2')
    elif searchWord in grid[2]:
        return('row 3')        
    elif searchWord in grid[3]:
        return('row 4')    
    elif searchWord in grid[4]:
        return('row 5')
    else:
        return("doesn't exist")

    #Function to return a word in a column
def wordSearchColumn(grid,searchWord):
    if searchWord[0:2] in grid[0][0:2] or searchWord[0:2] in grid[1][0:2] or searchWord[0:2] in grid[2][0:2]:
        return('column 1')
    elif searchWord[0:2] in grid[3][0:2] or searchWord[0:2] in grid[4][0:2]:
        return('column 1')
    elif searchWord[0:2] in grid[0][1:3] or searchWord[0:2] in grid[1][1:3] or searchWord[0:2] in grid[2][1:3]:
        return('column 2')
    elif searchWord[0:2] in grid[3][1:3] or searchWord[0:2] in grid[4][1:3]:
        return('column 2')
    elif searchWord[0:2] in grid[0][2:4] or searchWord[0:2] in grid[1][2:4] or searchWord[0:2] in grid[2][2:4]:
        return('column 3')
    elif searchWord[0:2] in grid[3][2:4] or searchWord[0:2] in grid[4][2:4]:
        return('column 3')
    else:
        return("doesn't exist")

    #Function to return a reverse word in a column
def wordSearchColumnReverse(grid,searchWord):
    if searchWord[0:2] in grid[0][2:4] or searchWord[0:2] in grid[1][2:4] or searchWord[0:2] in grid[2][2:4]:
        return('column 5')
    elif searchWord[0:2] in grid[3][2:4] or searchWord[0:2] in grid[4][2:4]:
        return('column 5')
    elif searchWord[0:2] in grid[0][1:3] or searchWord[0:2] in grid[1][1:3] or searchWord[0:2] in grid[2][1:3]:
        return('column 4')
    elif searchWord[0:2] in grid[3][1:3] or searchWord[0:2] in grid[4][1:3]:
        return('column 4')
    elif searchWord[0:2] in grid[0][0:2] or searchWord[0:2] in grid[1][0:2] or searchWord[0:2] in grid[2][0:2]:
        return('column 3')
    elif searchWord[0:2] in grid[3][0:2] or searchWord[0:2] in grid[4][0:2]:
        return('column 3')
    else:
        return("doesn't exist")

     #Main fucntion 
def main():

        #Creates grid array
    grid=[]

        #For loop that inputs strings into grid
    for i in range(5):
        listInput=input("Input a string for the grid:")
        grid.append(listInput)

        #Print statements
    searchWord=input("Enter a word to search for:")
    print('This is your grid:'+'\n'+grid[0]+'\n'+grid[1]+'\n'+grid[2]+'\n'+grid[3]+'\n'+grid[4])
    print(searchWord,'is in:', wordSearchRow(grid,searchWord),wordSearchColumn(grid,searchWord))
    searchWord=searchWord[::-1]
    print('Reverse',searchWord[::-1],'is in:',wordSearchRow(grid,searchWord),wordSearchColumnReverse(grid,searchWord))
    
    #Call main function
main()





