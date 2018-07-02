#!/usr/bin/python
import re,sys,os
import math


if __name__=="__main__":
	matrix = []
	with open(sys.argv[1],'r') as fd:
		for line in fd:
			numbers = [int(num) for num in re.split(r',',line.strip())]
			matrix.append(numbers)
	for i in xrange(len(matrix)):
		s = ''
		for j in xrange(len(matrix[1])):
			s+=str(matrix[i][j])+','
		print(s)
		print('\n')
