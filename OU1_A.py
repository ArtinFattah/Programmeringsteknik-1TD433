#!/usr/bin/python3
import turtle

# Funktionen har tre parametrar:
# Paddan t och en position dit paddan skall flyttas
def jump(t, x, y):
    t.penup()    # lyft pennan som ritar paddans spår
    t.goto(x, y) # Flytta paddan till (x,y)
    t.pendown()  # sänk pennan så att den ritar spår

# Funktionen har två parametrar som
# beskriver en position där en padda
# skall skapas. Paddan returneras.
def make_turtle(x, y):
    t = turtle.Turtle() # Skapa en padda
    t.speed(0)          # Sätt hastigheten på paddan till max
    jump(t, x, y)       # Flytta paddan till (x,y)
    return t            # Returnera paddan

# Funktionen ritar en rektangel, fyller den med en färg.
# Nedre vänstra punkt för rektangeln bestäms av (x,y)
# Rektangelns storlek bestäms av parameterna width och height. 
# Färgen bestäms av parametern color.
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
    t.end_fill()           # Definierar slutet för själva fyllandet
    
def tricolore(x, y, h):
    w = h/2  	                     # färgfältens bredd
    rectangle(x, y, w, h, 'blue')    # vänstra fältet
    rectangle(x+w, y, w, h, 'white') # mittersta fältet
    rectangle(x+2*w, y, w, h, 'red') # högra fältet

# Funktionen ritar en pentagram.
# Tre parametrar: En position för övre spetsen
# och längden för varje raksträcka.
def pentagram(x, y, side):
    t = make_turtle(x, y)     # Skapa en padda t i (x,y)
    t.speed(0)                # Sätt hastigheten på paddan till max
    t.hideturtle()            # Gör själva paddan osynlig
    t.fillcolor('yellow')     # Bestäm fyllnadsfärgen för pentagrammet
    t.begin_fill()            # Definierar starten för själva fyllandet
    t.setheading(270 - 36/2)  # Rikta paddans kropp i denna riktning
    # En loop som går fem varv, som ritar en sträcka i varje varv
    for i in range(5):        
        t.forward(side)       # Flytta paddan (rita spåret) sträckan side
        t.left(180-36)        # Rotera paddan 180-36 grader
    t.end_fill()              # Definierar slutet för själva fyllandet

tricolore(-150, -100, 200)
for i in range(5):
    pentagram(-200+i*100, 300, 100)
    pentagram(-200+i*100, -200, 100)
