#!/usr/bin/python
from __future__ import print_function
import re,sys,os
import pyprimes
import math

sumOfDivs = {}

def findDivisorSum(n):
	divSum = 0
	for div in xrange(2,int(math.sqrt(n))+1):
		if(n%div == 0):
			divSum+=div
			if(div**2 != n):
				divSum+=n/div
	return divSum+1
	
def findDivSums(n):
	for num in xrange(n):
		sumOfDivs[num] = findDivisorSum(num)
		
if __name__=="__main__":
	findDivSums(int(sys.argv[1]))
	for (key,value) in sumOfDivs.iteritems():
		i = 0
		s = str(key)
		tempkey = key
		while(i<20):
			s+="-->"+str(sumOfDivs[tempkey])
			if(tempkey>int(sys.argv[1])):
				break
			tempkey = sumOfDivs[tempkey]
			i+=1
		print(s)
		print("\n")	
