#**********************  regularExpressionsAndFiles.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #10
#
# Algorithm:
#   Import regex
#   Open find phone cc file (one for home computer and one for school)
#   Make empty list for email addresses
#   Make empty list for phone numbers
#   Make empty list for credit card numbers
#   Compile phone number regex with a pattern
#   Compile credit card number regex with a pattern
#   Compile email address regex with a pattern
#   For the lines in the findPhoneCC file:
#       search for phone number matches
#       search for credit card matches
#       search for email address matches
#
#       if there's a phone match:
#           append to the phone numbers list
#
#       elif there's a credit card match:
#           append to the credit card list
#
#       elif there's a email address match:
#           append to the email address list
#
#   Write the lists to a new text file
#   Close text file
#
#**********************************************************

import re

#phoneFile=open('C:\\Users\\lankfordm0772\\OneDrive - University of Houston-Clear Lake\\Desktop\\CompSci\\Homework\\LankfordM_CSCI_1470_HW#10\\findPhoneCC.txt')
phoneFile=open('C:\\Users\\micha\\Desktop\\Computer Science\\findPhoneCC.txt')

    #Array declarations
emailAddresses=[]
phoneNumbers=[]
creditCardNumbers=[]

    #Regex declarations
phoneNumRegex=re.compile(r'\d\d\d-\d\d\d-\d\d\d\d')
creditCardNumRegex=re.compile(r'\d\d\d\d-\d\d\d\d-\d\d\d\d-\d\d\d\d')
emailRegex=re.compile(r'\w+@\w+.com')

    #Begin for loop
for line in phoneFile:

        #Search for matches with each regex
    phoneMatch=re.search(phoneNumRegex,line)
    creditCardMatch=re.search(creditCardNumRegex,line)
    emailMatch=re.search(emailRegex,line)
    
    if phoneMatch:
        newLine=phoneMatch.group()
        phoneNumbers.append(newLine)

    elif creditCardMatch:
        newLine=creditCardMatch.group()
        creditCardNumbers.append(newLine)

    elif emailMatch:
        newLine=emailMatch.group()
        emailAddresses.append(newLine)

    #With statement opens text doc and writes to it if there are matches
with open('regularExpressionsAndFilesOutput.txt','w') as data_file:
    data_file.write(f'{emailAddresses}\n {phoneNumbers}\n {creditCardNumbers}')

    #Closes file
phoneFile.close()
