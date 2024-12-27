#**********************  turtlesHW.py  *********************
#
# Name: Michael Lankford
#
# Course: CSCI 1470
#
# Assignment: Homework #2
#
# Algorithm:
#       Setup window and turtle          
#       Draw Pentagon and fill with color
#       Move turtle down and left
#       Draw hexagon and fill with color
#       Move turtle down and left
#       Draw Octagon and fill with color
#       Move turtle down and left
#       Draw star and fill with color
#**********************************************************


import turtle

    #Set window color to blue
window=turtle.Screen()
window.bgcolor("blue")      
max=turtle.Turtle()

    #Make a red circle in middle of screen
max.color("red")                
max.begin_fill()
for i in range(5):
    max.forward(50)
    max.left(72)

max.end_fill()

    #Make a green circle to lower left
max.setpos(-105,-105)           
max.begin_fill()
max.color("green")
for i in range(6):
    max.forward(50)
    max.left(60)

max.end_fill()

    #Make a black circle even lower left
max.setpos(-200,-200)           
max.begin_fill()
max.color("black")
for i in range(8):
    max.forward(50)
    max.left(45)

max.end_fill()

    #Make a yellow star at bottom of page
max.setpos(-300,-300)           
max.begin_fill()
for i in range(5):
    max.color("yellow")
    max.forward(100)
    max.right(144)

max.end_fill()

window.mainloop()
