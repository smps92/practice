#!/usr/bin/python
import re,sys,os
import math
import bisect

zeckRepCounts = {}
fibonacci = []

def genFibonacciNums(n):
	a = 1
	b = 1
	fibonacci.append(a)
	while(b<n):
		c = a+b
		fibonacci.append(c)
		a = b
		b = c 

def getTermCountInZeckRep(n):
	if(n in zeckRepCounts):
		return zeckRepCounts[n]
	if(n in fibonacci):
		zeckRepCounts[n] = 1
		return zeckRepCounts[n]
	if(n<=0):
		return 0
	temp = n
	zeckRepCount = 0
	insertionPos = bisect.bisect(fibonacci,n)
	fibElement = fibonacci[insertionPos-1]
	temp = temp - fibElement
	zeckRepCount = getTermCountInZeckRep(temp)+1
	zeckRepCounts[n] = zeckRepCount
	return zeckRepCounts[n]

def getZeckRep(n):
	zeckRep = []
	temp = n
	while(temp>0):
		insertionPos = bisect.bisect(fibonacci,temp)
		fibElement = fibonacci[insertionPos - 1]
		temp = temp - fibElement
		zeckRep.append(fibElement)
	return zeckRep	
		

if __name__=="__main__":
	n = int(sys.argv[1])
	genFibonacciNums(n)
	sumOfZeckRep = 0
	for num in xrange(1,int(sys.argv[1])):
		zeckRepCount = getTermCountInZeckRep(num)
		sumOfZeckRep+= zeckRepCount
		print(num,zeckRepCount)
	print(sumOfZeckRep)
		

