#!/usr/bin/python
import math
import fractions
import re,sys,os


def generateFarey(a,b,c,d,n):
	nextNumerator = 0
	nextDenominator = 1
	while((nextDenominator<=n) and (nextNumerator*1.0/nextDenominator <= 3.0/7)):
		term = math.floor((n+b)*1.0/d)
		nextNumerator = term*c - a
		nextDenominator = term*d - b
		a,b,c,d = c,d,nextNumerator,nextDenominator
		print(a,b,c,d)
		if((nextNumerator==3.0) and (nextDenominator==7.0)):
			print(a,b,c,d)
#			os._exit(0)

if __name__=="__main__":
	n = int(sys.argv[1])
	generateFarey(3,8,2,5,n)
