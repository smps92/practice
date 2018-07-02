#!/usr/bin/python
import math
import re,sys,os


def getCFracRep(n):
	tempn = n
	sqrtn = math.sqrt(tempn)
	if(int(sqrtn) == sqrtn):
		return []
	a0 = math.floor(math.sqrt(tempn))
	residual = sqrtn - a0
	ai = a0
	cFracRep = []
	cFracRep.append(ai)
	while(ai!=2*a0):
		p = 1.0/residual
		print(p,residual,ai)
		ai = int(math.floor(p))
		residual = p - ai
		cFracRep.append(ai)
	return cFracRep

def getPeriod(ar):
	if(len(ar) ==0):
		return 0
	return (len(ar)-1)

def printcFracRep(ar,n,pd):
	if(len(ar)!=0):
		s = ''+str(n)+'['
		for ai in ar:
			s+=str(ai)+','
		s = re.sub(r',$',']',s)
		s+= str(pd)
		print(s)
		
if __name__=="__main__":
	n = int(sys.argv[1])
	array = getCFracRep(int(sys.argv[1]))
	pd = getPeriod(array)
#	printcFracRep(array,n,pd)
	os._exit(0)

	count1 = 0
	n = int(sys.argv[1])
	for num in xrange(2,n): 
		cFracRep = getCFracRep(num)
		period = getPeriod(cFracRep)
		if(period%2 == 1):
			count1 = count1+1
			print(num,period)
	print(count1)
