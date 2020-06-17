#!/usr/bin/python

import random
min = 1
max = input("Input die maximum value (1 to N):\n> ")

numDie = input("Input number of dice per roll (1 to N):\n> ")

roll_again = "yes"

while roll_again == "yes" or roll_again == "y":
	print "Rolling the dice..."
	print "The values are: "
	
	for i in range(0,numDie):
		print 'Die', i+1, ':', random.randint(min, max)
	
	roll_again = raw_input("Roll the dice again?\n> ")