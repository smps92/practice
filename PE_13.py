#!/usr/bin/python
import math
import re,sys,os


if __name__=="__main__":
	sumOf50DigitNos = 0
	with open(sys.argv[1],'r') as fd:
		for line in fd:
			sumOf50DigitNos+= long(line[:12])
	print(sumOf50DigitNos)
