#**********************  tresureHunt.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #7
#
# Algorithm:
#   Import Randomizer and turtle
#   Randomly place turtle and treasure box
#   Assign movement to input box
#   If the turtles x and y coordinates are inside the box's x and y coordinates then write you win
#
#**********************************************************

import turtle
import random

    #Set screen items
window = turtle.Screen()
window.bgcolor("blue")
bepo = turtle.Turtle()
treasure= turtle.Turtle()
treasure.color("yellow")
treasure.shape("square")

    #Set random integer baoundaries
turtleX=random.randint(-300,300)
turtleY=random.randint(-300,300)
treasureX=random.randint(-300,300)
treasureY=random.randint(-300,300)


    #Set turtle to a random position
bepo.penup()
bepo.setpos(turtleX,turtleY)
bepo.pendown()


    #Set treasure to a random position
treasure.penup()
treasure.setpos(treasureX,treasureY)
treasure.pendown()
treasure.hideturtle()

    #Set movement to an input box
start = True

    #Begin while loop
while start:
    MoveType = int(turtle.numinput("Player Movement", "Do you want to move forward or turn? 0 = forward, 1 = turn left, 2 = turn right", default=0, minval = 0, maxval = 2))
    if MoveType == 0:
        movement = int(turtle.numinput("Player Movement", "How far do you want to go: 200 is max distance", default=0, minval = 0, maxval = 200))
        bepo.forward(movement)
    elif MoveType == 1:
        movement = int(turtle.numinput("Player Movement", "How far do you want to turn? 90 is a full left turn, 180 turns you around.", default=0, minval = 0, maxval = 180))
        bepo.left(movement)
    elif MoveType == 2:
        movement = int(turtle.numinput("Player Movement", "How far do you want to turn? 90 is a full right turn, 180 turns you around.", default=0, minval = 0, maxval = 180))
        bepo.right(movement)
        
        #Checks to see if the coordinates of the turtle match up with the box
    if bepo.xcor() >= treasureX - 15 and bepo.xcor() <= treasureX + 15 and bepo.ycor() >= treasureY - 15 and bepo.ycor() <= treasureY + 15:
        bepo.write("You win")

#End while loop

    #Close window
window.mainloop()

