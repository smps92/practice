#!/usr/bin/python
import math
import re,sys,os


def countDigits(n):
	return int(math.log(n,10))


def sumOfDigits(n):
	tempn = n
	sumOfDigits = 0
	while(tempn>0):
		digit = tempn%10
		tempn/=10
		sumOfDigits+=digit
	return sumOfDigits

def hDigitsGTkDigits(h,k):
	loghi = int(math.log(h,10)) + 1
	logki = int(math.log(k,10)) + 1
	if(loghi>logki):
		return True
	return False	
	
if __name__=="__main__":
	hiMinus2 = 2
	kiMinus2 = 1
	hiMinus1 = 3
	kiMinus1 = 1
	k = 1;
	for i in xrange(98):
		if(i%3==0):
			num = 2*k
			k+=1
		else:
			num = 1
		hi = num*hiMinus1 + hiMinus2
		ki = num*kiMinus1 + kiMinus2
		hiMinus2 = hiMinus1
		kiMinus2 = kiMinus1
		hiMinus1 = hi
		kiMinus1 = ki
	print(hiMinus1)
	print(kiMinus1)
	print(hiMinus1*1.0/kiMinus1)
	print(sumOfDigits(hiMinus1))
