#!/usr/bin/python3
import turtle
from random import randint

def jump(t, x, y):
    t.penup()    # lyft pennan som ritar paddans spår
    t.goto(x, y) # Flytta paddan till (x,y)
    t.pendown()  # sänk pennan så att den ritar spår

def make_turtle(x, y):
    t = turtle.Turtle() # Skapa en padda
    t.speed(0)          # Sätt hastigheten på paddan till max
    jump(t, x, y)       # Flytta paddan till (x,y)
    return t            # Returnera paddan

def rectangle(x, y, width, height, color):
    t = make_turtle(x, y)  # Skapa en padda t i (x,y)
    t.hideturtle()         # Gör paddan osynlig
    t.speed(0)             # Sätt hastigheten på paddan till max
    t.fillcolor(color)     # Bestäm fyllnadsfärgen för den rektangeln
    t.begin_fill()         # Definierar starten för själva fyllandet
    # En loop som bestäms av innehållet i en lista:
    # Loopen går fyra varv och dist kommer ha följande värden:
    # width, height, width, height (i tur och ordning)
    for dist in [width, height, width, height]:
        t.forward(dist)    # Flytta paddan (och rita dess spår) en sträcka dist
        t.left(90)         # rotera paddan åt vänster 90 grader
    t.end_fill()           # Definierar slutet för själva fyllandet'

#Gör en slumpmässig förflyttning av turtle objectet t
#Kursen ska ändras med med ett slumpmässigt värde i intervallet [-45, 45]
#Om t.ex. paddan har kurs 90 ska kursen sluta i intervallet [45, 135]
#Därefter ska paddan gå framåt. Längden på sträckan som paddan går ska vara ett slumptal i intervallet [0, 25].
def move_random(turtle_object):
    if (abs(turtle_object.xcor()) > 250) or (abs(turtle_object.ycor()) > 250):
        turtle_object.setheading(turtle_object.towards(0, 0))
    turtle_object.left(randint(-45, 45))
    turtle_object.forward(randint(0, 25))

rectangle(-250,-250, 500, 500, 'lightblue')
t1 = make_turtle(randint(-250, 250), randint(-250, 250)) # Skapa en padda'
t2 = make_turtle(randint(-250, 250), randint(-250, 250)) # Skapa en padda'
t1.color('red'), t2.color('green') # Sätt färg på paddorna

for i in range(500):
    move_random(t1)
    if t1.distance(t2) < 50:
        t1.write('Close')
    move_random(t2)
    if t2.distance(t1) < 50:
        t2.write('Close')




