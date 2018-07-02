#!/usr/bin/python
import re,sys,os


def generateAllPartitions(n,m):
	a = [0]*(m+1)
	a[0] = n - m +1
	for j in range(1,m+1):
		a[j] = 1
	a[m] = -1
	done = False
	j = m
	s = 0
	while(not done):
		print(a)
		if(a[1] >= a[0] -1):
			j = 2
			s = a[0] + a[1] -1
			while(a[j] >= a[0] - 1):
				if(a[j] >= a[1] -1):
					s = s+a[j]
					j = j+1
			x = 0
			if(j>m-1):
				done = True
			else:
				x = a[j]+1
				a[j] = x
				j = j-1
			while(j>0):
				a[j] = x
				s = s-x
				j = j-1
			a[0] = s
		else:
			a[0] = a[0] - 1
			a[1] = a[1] + 1

if __name__=="__main__":
	n = int(sys.argv[1])
	m = int(sys.argv[2])
	for numParts in xrange(2,m+1):
		generateAllPartitions(n,numParts)	
