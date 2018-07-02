#!/usr/bin/python

import math
import re,sys,os


def checkDigitCancellingFraction(i,j):

	
	digitsi = {}
	digitsi[i%10] = 1
	digitsi[i/10] = 1

	digitsj = {}
	jdigit0 = j%10
	jdigit1 = j/10

	if((jdigit0 not in digitsi) and (jdigit1 not in digitsi)):
		return False

	if((jdigit0 in digitsi) and (jdigit1 in digitsi)):
		return False

	if((i%10 == 0) or (j%10==0)):
		return False

	digitsj[jdigit0] = 1
	digitsj[jdigit1] = 1
	
	if(jdigit0 in digitsi):
		del digitsi[jdigit0]
		del digitsj[jdigit0]	
	else:
		del digitsi[jdigit1]
		del digitsj[jdigit1]
		
	if((len(digitsi.keys())<1) or (len(digitsj.keys())<1)):
		return False

	fraction = (digitsi.keys()[0]*1.0)/(digitsj.keys()[0]*1.0)
	if(fraction == i*1.0/j):
		return True
	return False


if __name__=="__main__":
#	print(checkDigitCancellingFraction(12,24))
#	os._exit(0)

	for i in xrange(10,100):
		for j in xrange(i+1,100):
		#	print(i,j)
			isNonTrivialDCF = checkDigitCancellingFraction(i,j)
			if(isNonTrivialDCF):
				print(i,j)
	
