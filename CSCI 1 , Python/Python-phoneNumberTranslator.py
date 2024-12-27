#**********************  phoneNumberTranslator.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #5
#
# Algorithm:
#   Prompt user for a phone number
#   If number==-1, quit program
#   Else, translate any letters in phone number to a corresponding number
#   Place original numbers in new phone number
#   Place new numbers following original numbers
#   Print new phone number
#   Prompt user for phone number
#
#**********************************************************

        #Variable eclaration
phoneNumber=input("Enter telephone number, -1 to stop:")
count=0

        #Begin while loop
while count>=0:

                #Quit program if phone number = -1
        if phoneNumber=='-1':
                quit

                #Else translate number
        else:

                        #Assigns letters to the appropriate number
                def translate(char):
                        if char.upper()=='A' or char.upper()=='B' or char.upper()=='C':
                            number='2'
                        elif char.upper()=='D' or char.upper()=='E' or char.upper()=='F':
                            number='3'
                        elif char.upper()=='G' or char.upper()=='H' or char.upper()=='I':
                            number='4'
                        elif char.upper()=='J' or char.upper()=='K' or char.upper()=='L':
                            number='5'
                        elif char.upper()=='M' or char.upper()=='N' or char.upper()=='O':
                            number='6'
                        elif char.upper()=='P' or char.upper()=='Q' or char.upper()=='R' or char.upper()=='S':
                            number='7'
                        elif char.upper()=='T' or char.upper()=='U' or char.upper()=='V':
                            number='8'
                        elif char.upper()=='W' or char.upper()=='X' or char.upper()=='Y' or char.upper()=='Z':
                            number='9'
                        return number

                        #Puts nunber in place of letters
                def translateNumber(phoneNumber):

                                #Array declaration
                        result=''

                                #Puts numbers into array
                        for char in phoneNumber:
                                if char in ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']:
                                        result= result + translate(char)
                                else:
                                    result= result + char
                        return result

                     #Prints phone number   
                print(translateNumber(phoneNumber))
                phoneNumber=input("Enter telephone number, -1 to stop:")


#End while loop
