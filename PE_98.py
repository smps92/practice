#!/usr/bin/python
from __future__ import print_function
import re,sys,os
import math

anagrams = {}

def getSignature(s):
	signature = ''
	for letter in sorted(s):
		signature+=letter
	return signature
	

if __name__=="__main__":
	with open(sys.argv[1],"r") as fd:
		for line in fd:
			word = line.strip()
			signature = getSignature(word)
			try:
				anagrams[signature] = 
			except KeyError:
				anagrams[signature] = word
			
			
