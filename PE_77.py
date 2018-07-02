#!/usr/bin/python
import re,sys,os
import pyprimes
import math
import bisect


class PE_77
	def __init__():
		self.numWays = {}
	
	def findPrimes(n):
		self.primes = [prime for prime in pyprimes.primes_below(n)]
	
	def findLargestPrimeLessThanN(n):
		index = bisect.bisect_left(self.primes,n)
		return index
		
	def findNumberOfWays(n):
		if(self.numWays.has_key(n)):
			return self.numWays[n]
		primeIndex = findLargestPrimeLessThanN(n)
		numWays = 0
		for i in xrange(0,primeIndex):
			
			
		
				



if __name__=="__main__":
	found = False
	counter = 2
	while(!found) {
		for prime in pyprimes.primes_belo 

