#**********************  mathQuiz.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #6
#
# Algorithm:
#   Import Randomizer
#   Set the count to 0
#   Print out 2 addition problem with random numbers 
#   User inputs answer( if correct add 1 to count)
#   Print out 2 subtraction problem with random numbers 
#   User inputs answer( if correct add 1 to count)
#   Print out 2 multiplication problem with random numbers 
#   User inputs answer( if correct add 1 to count)
#   Print out 2 division problem with random numbers 
#   User inputs answer( if correct add 1 to count)
#   Print out 2 modulus problem with random numbers 
#   User inputs answer( if correct add 1 to count)
#   Print total count/10
#   Ask user if they want to take another quiz
#   If answer is yes then repeat code
#   If answer is no then quit program
#   
#**********************************************************

import random
count=0

        #Generate addition questions
def additionQuestion():
        randomNum1= random.randint(1,20)
        randomNum2= random.randint(1,20)
        global count
        userAnswer=int(input("What is "+str(randomNum1)+'+'+str(randomNum2)+'?'))
        
        answer=randomNum1+randomNum2
        if userAnswer==answer:
            count=count+1
            print('Correct')
        else:
            count
            print('Wrong')
        return count

        #Generate subtraction questions
def subtractionQuestion():
        randomNum1= random.randint(1,20)
        randomNum2= random.randint(1,20)
        global count
        userAnswer=int(input("What is "+str(randomNum1)+'-'+str(randomNum2)+'?'))

        answer=randomNum1-randomNum2
        if userAnswer==answer:
            count=count+1
            print('Correct')
        else:
            count
            print('Wrong')
        return count

        #Generate multiplication questions
def multiplicationQuestion():
        randomNum1= random.randint(1,20)
        randomNum2= random.randint(1,20)
        global count
        userAnswer=int(input("What is "+str(randomNum1)+'*'+str(randomNum2)+'?'))

        answer=randomNum1*randomNum2
        if userAnswer==answer:
            count=count+1
            print('Correct')
        else:
            count
            print('Wrong')
        return count

        #Generate divison questions
def divisionQuestion():
        randomNum1= random.randint(1,20)
        randomNum2= random.randint(1,20)
        global count
        userAnswer=int(input("What is "+str(randomNum1)+'//'+str(randomNum2)+'?'))

        answer=randomNum1//randomNum2
        if userAnswer==answer:
            count=count+1
            print('Correct')
        else:
            count
            print('Wrong')
        return count

        #Generate modulus questions
def modulusQuestion():
        randomNum1= random.randint(1,20)
        randomNum2= random.randint(1,20)
        global count
        userAnswer=int(input("What is "+str(randomNum1)+'%'+str(randomNum2)+'?'))

        answer=randomNum1%randomNum2
        if userAnswer==answer:
            count=count+1
            print('Correct')
        else:
            count
            print('Wrong')
        return count

        #Function to print number of questions gotten right
def main():
        userAnswer=additionQuestion()
        userAnswer=additionQuestion()
        userAnswer=subtractionQuestion()
        userAnswer=subtractionQuestion()
        userAnswer=multiplicationQuestion()
        userAnswer=multiplicationQuestion()
        userAnswer=divisionQuestion()
        userAnswer=divisionQuestion()
        userAnswer=modulusQuestion()
        userAnswer=modulusQuestion()
        print(count,'/10')
        askUser=input('Do you want to take another quiz?')
        if askUser=='no':
                quit
        else:
                main()

