#!/usr/bin/python
import re,sys,os
import math

def getCFracRep(n):
	tempn = n
	sqrtn = math.sqrt(n)
	if(sqrtn == int(sqrtn)):
		return []
	a0 = math.floor(math.sqrt(n))
	mi = 0.0
	di = 1.0
	ai = a0
	cFracRep = []
	cFracRep.append(ai)
	while(ai!=2*a0):
		miPlus1 = di*ai - mi
		diPlus1 = (n-(miPlus1**2))/di
		aiPlus1 = math.floor((a0+miPlus1)/diPlus1)
		
		di = diPlus1
		ai = aiPlus1
		mi = miPlus1 
		cFracRep.append(ai)
	return cFracRep

def getPeriod(arr):
	if(len(arr)<1):
		return 0
	return (len(arr)-1)
	
def printCFracRep(arr,n):
	if(len(arr)<1):
		print(str(n)+'[]')
		return
	s = str(n)+'['
	for num in arr:
		s+=str(num)+','
	s = re.sub(r',$',']',s)
	print(s)

def getConvergents(arr,n):
	hMinus1 = 1
	kMinus1 = 0
	hMinus2 = 0
	kMinus2 = 1
	
	


if __name__=="__main__":
	n = int(sys.argv[1])
	count = 0
	for num in xrange(2,n):
		cFracRep = getCFracRep(num)
		if(getPeriod(cFracRep)%2 == 1):
			printCFracRep(cFracRep,num)
			count+=1
	print(count)
		
	
