#!/usr/bin/python
import math
import fractions
import re,sys,os



if __name__=="__main__":
	n = int(sys.argv[1])
	a = 2
	b = 5
	c = 3
	d = 7
	nextDenominator = 1
	while(nextDenominator<=n):
		nextNumerator = a+c
		nextDenominator = b+d
		hcf = fractions.gcd(nextNumerator,nextDenominator)
		nextNumerator,nextDenominator = nextNumerator/hcf,nextDenominator/hcf
		a,b = nextNumerator,nextDenominator
		print(a,b,c,d)
		
