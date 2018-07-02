#!/usr/bin/python
from __future__ import print_function
import re,sys,os
import pyprimes


if __name__=="__main__":
	count = 0
	for i in xrange(1,int(sys.argv[1])-1):
		PFOfi = [ prime for prime in pyprimes.factorise(i)]
		PFOfiPlus1 = [prime for prime in pyprimes.factorise(i+1)]

		numDivOfi = 1
		for (primefactor,power) in PFOfi:
			numDivOfi*=(power+1)
#		print(i,numDivOfi)

		numDivOfiPlus1 = 1
		for (primefactor,power) in PFOfiPlus1:
			numDivOfiPlus1*= (power+1)
		if(numDivOfiPlus1 == numDivOfi):
#			print(i,i+1,numDivOfi)
			count+=1
	print(count)
		
		
		
