#********************** cybersecurity.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #11
#
# Algorithm:
#   Import regex
#   Open DOB file
#
# checkDates function
#       compile data regex
#       for line in cybersecurity:
#           dateMatch= search lines in dateRegex
#           name= split line at comma
#           name= strip name
#           if dateMatch doesn't equal none:
#               match= dateMatch group
#               if integer(match [element 0]) doesn't equal 0:
#                   month= integer(match [element 0 to 1])
#                   call checkMonthRange function
#               else:
#                   month= integer(match [element 1])
#                   call checkMonthRange function
#
# checkMonthRange function
#       if month in days dictionary:
#           days= integer(match element 3 to 4)
#           if month=2 and day=29:
#               days[element 2]= ('February', 29)
#           else:
#               days[element 2]= ('Febraury', 28)
#               call checkdayRange function
#
# checkDayRange function
#       if day greater than 0 and less than days[month] element 1:
#           year= integer(match [element 6 to end])
#           leapYear= checkLeapYear function(year)
#           call checkYearRange function
#
# checkYearRange function
#       if year greater than or equal to 1900 and less than or equal to 2020:
#           if leapYear= 'This is a leap year':
#               print name month day, year 'This is a leap year'
#           else:
#               print name month day, year
#
# checkLeapYear function
#       if year is divisible by 4 and doesn't equal 0:
#           return 'Not a leap year'
#       elif year is divisible by 100 and doesn't equal 0:
#           return 'Is a leap year'
#       elif year is divisble by 400 and doesn't equal 0:
#           return 'Not a leap year'
#       else:
#           return 'Is a leap year'
#
# main function
#       call checkDates function
#
# call main function
#
#**********************************************************

import re

    #Create dictionary and keys for months
days={ 1:('January', 31), 2:('February', 28), 3:('March', 31),4:('April', 30), 5:('May', 31), 6:('June', 30), 7:('July', 31),
8:('August', 31), 9:('September', 30), 10:('October', 31),11:('November', 30), 12:('December', 31) }

    #Open file
cybersecurity = open('DOB.txt')

    #Date checker function
def checkDates():
    dateRegex=re.compile(r'\d{2}/\d{2}/\d{4}')

        #For loop goes down each line in file
    for line in cybersecurity:
        dateMatch=re.search(dateRegex, line)
        name=line.split(",")[1]
        name=name.strip()
        if dateMatch!=None:
            match=dateMatch.group()
            if int(match[0])!=0:
                month=int(match[0:2])

                    #Calls checkMonthRange function
                checkMonthRange(month, match, name)
            else:
                month=int(match[1])

                    #Calls checkMonthRange function
                checkMonthRange(month, match, name)   

    #Month range checker function
def checkMonthRange(month, match, name):
    if month in days.keys():
        day=int(match[3:5])
        if month==2 and day==29:
            days[2]=('February', 29)
        else:
            days[2]=('February', 28)

                #Calls checkDayRange function
            checkDayRange(month, day, match, days, name)

    #Date range checker fucntion
def checkDayRange(month, day, match, days, name):         
    if day>0 and day<=days[month][1]:
        year=int(match[6:])

            #Calls checkLeapYear function
        leapYear=checkLeapYear(year)

            #Calls checkYearRange function
        checkYearRange(month, day, match, days, name, year, leapYear)

    #Leap year checker function
def checkLeapYear(year):
    if year%4!=0:
        return('Not a leap year')
    elif year%100!=0:
        return('This is a leap year')
    elif year%400!=0:
        return('Not a leap year')
    else:
        return('This is a leap year')

    #Year range checker function
def checkYearRange(month, day, match, days, name, year, leapYear):

        #If statement will print a statement
    if year>=1900 and year<=2020:
        if leapYear=='This is a leap year':
            print(f"{name} {month} {day},{year} This year is a leap year")
        else:
            print(f"{name} {month} {day},{year}")

    #Main function calls checkDates function
def main():
    checkDates()
    
main()

cybersecurity.close()
