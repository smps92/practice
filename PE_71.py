#!/usr/bin/python
import math
import fractions
import pyprimes
from collections import OrderedDict
import re,sys,os

rFractions = {}

def checkDivisibleAny(n,pfactors):
	for pf in pfactors:
		if(n%pf ==0):
			return True
	return False;

def findCoPrimeNos(n):
	if(pyprimes.isprime(n)):
		coPrimeNos = [num for num in xrange(1,n)]
		return coPrimeNos
		
	primeFactors = pyprimes.factors(n)
	coPrimeNos = [num for num in xrange(1,n) if(not checkDivisibleAny(num,primeFactors))]
	return coPrimeNos

def printFractions():
	for key in sorted(rFractions.keys()):
		print(rFractions[key])

def countFractions(n):
	return len(findCoPrimeNos(n))
	
def genFractions(n):
	for coPrimeNum in findCoPrimeNos(n):
		fractVal = coPrimeNum*1.0/n
		if((fractVal<=3.0/7) and (fractVal>=2.0/5)):
			rFractions[coPrimeNum*1.0/n] = ''+str(coPrimeNum)+'/'+str(n)

def findRFraction():
	prevKey = 0
	prevValue = 0
	for key in sorted(rFractions.keys()):
		value = rFractions[key]
		if(value == 3.0/7):
			print(prevkey,prevValue)
			return
		prevKey = key
		prevValue = value

if __name__=="__main__":
	n = int(sys.argv[1])
	for num in xrange(1,n+1):
		genFractions(num)
	printFractions()
	findRFraction()
