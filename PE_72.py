#!/usr/bin/python
import math
import fractions
import re,sys,os
import pyprimes
from itertools import izip


def findEulerTotient(n):
	if(pyprimes.isprime(n)):
		return n-1
	et = n
	for (prime,power) in pyprimes.factorise(n):
		et*=(1-1.0/prime)
	return et
		

if __name__=="__main__":
	found = False
	num = 2
	while(not found):
		eulerTot = findEulerTotient(num)
		val = (eulerTot*1.0)/(num-1)
		if(val<15499.0/94744):
			print(num,(eulerTot*1.0)/(num-1))
			found = True
		num+=1
