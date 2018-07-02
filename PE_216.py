#!/usr/bin/python
import re,sys,os
import pyprimes


if __name__=="__main__":
	count = 0
	for num in xrange(1,int(sys.argv[1])):
		if(pyprimes.isprime(2*num*num -1)):
			count+=1
	print(count)
	
