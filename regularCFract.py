#!/usr/bin/python
import math
import re,sys,os



def getRegularCFracRep(n):
	tempn = math.sqrt(n)
	arr = []
	if(tempn == int(tempn)):
		return arr
	a0 = math.floor(tempn)
	arr.append(a0) 
	residual = tempn - arr[0]
	while(not found):
		p = 1.0/residual
		ai = math.floor(p)
		arr.append(ai)
		residual = p - arr[i]
	return arr

def PContMoreDigitsThanQ(p,q):
	logp = int(math.log(p,10))
	logq = int(math.log(q,10))
	if(logp>logq):
		return True
	return False

def printCFracRep(cFracRep,n):
	strRep = ""+str(n)+"-->[";
	for i in xrange(0,len(cFracRep)):
		strRep+= str(cFracRep[i])+','
	strRep = re.sub(r',$','',strRep)+']'
	print(strRep)

if __name__=="__main__":
	num = int(sys.argv[1])
	cFracRep = getRegularCFracRep(num)
	printCFracRep(cFracRep,num)
