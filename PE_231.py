#!/usr/bin/python
import math
import re,sys,os
import pyprimes
import bisect

def getBaseBRep(num,base):
	lst = []
	while(num>=base):
		digitInBaseb = num%base
		num = num/base
		lst.append(digitInBaseb)
	lst.append(num)
	lst.reverse()
	return lst
		

def getHighestPowerOfPInNFact(n,p):
	if(p<2):
		return 0
	sumOfCoeff = sum(getBaseBRep(n,p))
	return (n-sumOfCoeff)/(p-1)

def getPrimeFactOfNcR(n,r):
	primesPowerDict = {}
	primes = [prime for prime in pyprimes.primes_below(n)]
	for prime in primes:
		highestPowerOfPrime = getHighestPowerOfPInNFact(n,prime)
		primesPowerDict[prime] = highestPowerOfPrime
	primesBelowRIndex = bisect.bisect(primes,r)
	primesBelowNMinusRIndex = bisect.bisect(primes,(n-r))
	for i in xrange(primesBelowRIndex):
		hp = getHighestPowerOfPInNFact(r,primes[i])
		primesPowerDict[primes[i]]-= hp
	for i in xrange(primesBelowNMinusRIndex):
		hp = getHighestPowerOfPInNFact(n-r,primes[i])
		primesPowerDict[primes[i]]-= hp
	return primesPowerDict

def getSumOfTerms(primeFact):
	sumOfTerms = 0
	for (prime,power) in primeFact.iteritems():
		sumOfTerms+=prime*power
	return sumOfTerms

def removeZeros(primesPowerd):
	keys = primesPowerd.keys()
	for key in keys:
		value = primesPowerd[key]
		if(value == 0):
			del primesPowerd[key]
	print(getSumOfTerms(primesPowerd))

if __name__=="__main__":
	n = int(sys.argv[1])
	r = int(sys.argv[2])
	primePowerd = getPrimeFactOfNcR(n,r)
	removeZeros(primePowerd)
	
#	for r1 in xrange(r):
#		primePowerd = getPrimeFactOfNcR(n,r1)
#		removeZeros(primePowerd)
#		ncr = math.factorial(n)/(math.factorial(n-r1)*math.factorial(r1))
#		print([(prime,power) for (prime,power) in pyprimes.factorise(ncr)])
#	print(getSumOfTerms(primePowerd))
	
