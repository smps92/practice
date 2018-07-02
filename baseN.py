#!/usr/bin/python
import math
import re,sys,os

def getBaseBRep(num,base):
	lst = []
	while(num>=base):
		digitInBaseb = num%base
		num = num/base
		lst.append(digitInBaseb)
	lst.append(num)
	lst.reverse()
	return lst
		

def highestPowerOfPInNFact(n,p):
	sumOfCoeff = sum(getBaseBRep(n,p))
	print(sumOfCoeff)
	return (n-sumOfCoeff)/(p-1)

if __name__=="__main__":
	print(highestPowerOfPInNFact(int(sys.argv[1]),int(sys.argv[2])))
