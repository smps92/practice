#!/usr/bin/python
import math
import os,re,sys

def getConvergent(n):
	tempn = n
	sqrtn = math.sqrt(tempn)
	if(sqrtn == int(math.sqrt(n))):
		return (0,0,0)
	a0 = math.floor(sqrtn)
	mi = 0.0
	di = 1.0

	ai = a0
	hMinus1 = 1
	kMinus1 = 0
	hMinus2 = 0
	kMinus2 = 1
	found = False
#	while(ai!=2*a0):
	while(not found):
		
		hi = ai*hMinus1 + hMinus2
		ki = ai*kMinus1 + kMinus2
		hMinus2 = hMinus1
		kMinus2 = kMinus1
		hMinus1 = hi
		kMinus1 = ki
		if(checkDiophantine(hi,ki,n)):
			found = True
			print(str(n)+','+str(hi)+'/'+str(ki))
			return(hi,ki,n)
		
		miPlus1 = di*ai - mi
		diPlus1 = (n-(miPlus1**2))/di
		aiPlus1 = math.floor((a0+miPlus1)/diPlus1)
		
		di = diPlus1
		ai = aiPlus1
		mi = miPlus1 

def checkDiophantine(x,y,D):
	val = x**2 - D*(y**2)
	if(val == 1):
		return True
	return False
	
if __name__=="__main__":

#	for num in xrange(int(sys.argv[1])):
#		arr = getCFracRep(num)
#		if(len(arr)>0):
#			printCFracRep(arr,num)
#			getConvergents(arr,num)
#	os._exit(0)

	solutionsMap = {}
	for D in xrange(2,int(sys.argv[1])):
		(x,y,D) = getConvergent(D)
		if(x!=0):
			solutionsMap[x] = D
	lst = sorted(solutionsMap.keys())
	print(solutionsMap[lst[len(lst)-1]])
