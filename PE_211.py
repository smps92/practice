#!/usr/bin/python
import math
import re,sys,os
import pyprimes


def getSumOfSquares(n):
	sumOfDivisorSquares = 1
	if(pyprimes.isprime(n)):
		sumOfDivisorSquares = 1 + n*n
		return sumOfDivisorSquares
	for (prime,power) in pyprimes.factorise(n):
		sumOfDivisorSquares*=(prime**(2*power+2) - 1)/(prime**2 - 1)
	return sumOfDivisorSquares

if __name__=="__main__":
	for num in xrange(2,int(sys.argv[1])):
		getSumOfSquares(num)
	os._exit(0)
	rSum = 0
	for num in xrange(int(sys.argv[1])):
		divisorSquareSum = getSumOfSquares(num)
		root = math.sqrt(divisorSquareSum)
		if(long(root) == root):
			rSum+=num
	print(rSum)
			
		
			
