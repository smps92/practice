#!/usr/bin/python
import re,sys,os



if __name__=="__main__":
	array = []
	s = sys.argv[1]
	for i in xrange(0,len(s)):
		array.append(s[i:])
	suffixArray = sorted(array)
	for i in suffixArray:
		print(i)
