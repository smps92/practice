#!/usr/bin/python
import re,sys,os



adjMatrix = {}
numNodes = 0
nodes = ''


def readInput(networkFile):
	global numNodes,nodes
	nodename = 0
	with open(networkFile) as fd:
		for line in fd:
			weights = re.split(r',',line.strip())
			for (num,weight) in enumerate(weights):
				if(weight == '-'):
					weight = 1000000
				adjMatrix[str(nodename)+'_'+str(num)]= int(weight)
			nodename+=1
	numNodes = nodename
	nodes = '_'.join([str(i) for i in xrange(numNodes)]) 
			
def printGraph():
	for (key,value) in adjMatrix.iteritems():
		print(str(key)+' '+str(value))

def isConnected(spanningTree):
	nodeList = {}
	for edge in spanningTree.keys():
		(node1,node2) = edge.split('_')
		nodeList[node1] = 1
		nodeList[node2] = 1
	nodeClosure = '_'.join(sorted(nodeList.keys()))
	print(nodeClosure,nodes)
	if(nodeClosure == nodes):
		return True
	return False
		
def kruskal():
	d = {}
	for (key,value) in adjMatrix.iteritems():
		try:
			d[value]+=','+key
		except KeyError:
			d[value] = key
	spanningTree = {}
	for edgeWeight in sorted(d.keys()):
		for edge in re.split(r',',d[edgeWeight]):
			(node1,node2) = edge.split('_')
			if(node1>node2):
				node1,node2 = node2,node1
			key = node1+'_'+node2
			if(key not in spanningTree):
				spanningTree[key] = edgeWeight
			is_connected = isConnected(spanningTree)		
			if(is_connected):
				break
		if(is_connected):
			break
	for (edge,weight) in spanningTree.iteritems():
		print(edge,weight)


def prims():
	d = {}
	for (key,value) in adjMatrix.iteritems():
		(node1,node2) = key.split('_')
		n1 = int(node1)
		n2 = int(node2)
		try:
			d[n1][n2] = value
		except KeyError:
			d[n1] = [100000 for i in xrange(numNodes)]
			d[n1][n2] = value
	for(key,value) in d.iteritems():
		print(key,value)
	

if __name__=="__main__":
	readInput(sys.argv[1])
	kruskal()
#	prims()
