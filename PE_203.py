#!/usr/bin/python
import math
import pyprimes
import re,sys,os
import bisect

primes = []

def getBaseBRep(num,base):
	lst = []
	while(num>=base):
		digitInBaseB = num%base
		lst.append(digitInBaseB)
		num = num/base
	lst.append(num)
	lst.reverse()
	return lst

def getPrimes(n):
	global primes
	primes = [prime for prime in  pyprimes.primes_below(n)] 
	
def getPowerOfPInNFact(n,p):
	lst = getBaseBRep(n,p)
	sumOfCoeffs = sum(lst)
	powerOfPInNFact = (n - sumOfCoeffs)/(p-1)
	return powerOfPInNFact

def getPrimePowersInNcR(n,r):
	maxPrimeIndex = bisect.bisect(primes,n)
	primePowerDict = {}
	for i in xrange(maxPrimeIndex):
		primePowerInNFact = getPowerOfPInNFact(n,primes[i])
		primePowerDict[primes[i]] = primePowerInNFact
	primesBelowRIndex = bisect.bisect(primes,r)
	primesBelowNMinusRIndex = bisect.bisect(primes,n-r)
	for i in xrange(primesBelowRIndex):
		primePowerInRFact = getPowerOfPInNFact(r,primes[i])
		primePowerDict[primes[i]]-= primePowerInRFact
	for i in xrange(primesBelowNMinusRIndex):
		primePowerInNMinusRFact = getPowerOfPInNFact(n-r,primes[i])
		primePowerDict[primes[i]]-= primePowerInNMinusRFact
	return primePowerDict

def getNcRIfSquareFree(n,r):
	primePwrDict = getPrimePowersInNcR(n,r)
	ncrVal = 1
	for (prime,power) in primePwrDict.iteritems():
		if((power>=2)):
			return 0
		ncrVal*= prime**power
	return ncrVal

def getSquareFreeInPascal(nRows):
	hmp = {}
	for row in xrange(1,nRows):
		for col in xrange(row+1):
			ncr = getNcRIfSquareFree(row,col)
			hmp[ncr] = 1
	sumOfSquareFree = sum(hmp.keys())
#	for (key,value)	in hmp.iteritems():
#		print(key)
	print(sumOfSquareFree)
			
if __name__=="__main__":
	getPrimes(60)
	getSquareFreeInPascal(int(sys.argv[1]))
