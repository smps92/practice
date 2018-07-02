#!/usr/bin/python
import re,sys,os
import Queue


class Edge:
	
	def __init__(self,node1,node2,weight):
		self.u = node1
		self.v = node2
		self.edgeWeight = weight


class Graph:

	def __init__(self):
		self.edges = []
		self.adjList = {}
		self.nodes = {}
		self.weight = 0

	def addEdge(self,edge,undirected=True):
		self.edges.append(edge)
		self.nodes[edge.u] = 1
		self.nodes[edge.v] = 1
		try:
			self.adjList[edge.u][edge.v] = edge.edgeWeight
		except KeyError:
			self.adjList[edge.u] = {}
			self.adjList[edge.u][edge.v] = edge.edgeWeight
#		self.nodes = self.adjList.keys()

	def createNodeString(self):
		self.nodeString = '_'.join(sorted(self.nodes.keys()))

	def printGraphAdjList(self):
		for node in self.nodes:
			s = node+'\t'
			for adjNode in adjNodes:
				s+=adjNode+':'+str(self.adjList[node][adjNode])+'\t'
			print(s)

	def printGraphAdjMatrix(self):
		sortedNodes = re.split(r'_',self.nodeString)
		print('\t'+'\t'.join(sortedNodes))
		for fromNode in sortedNodes:
			s = fromNode+'\t'
			for toNode in sortedNodes:
				if(toNode in self.adjList[fromNode]):
					s+=str(self.adjList[fromNode][toNode])+'\t'
					self.weight+=self.adjList[fromNode][toNode]
				else:
					s+='-\t'
			print(s)
		print(self.weight)

	def BFS(self):
		nodes = self.nodes.keys()
		startNode = nodes[0]
		numNodes = len(nodes)
		que = Queue.Queue()
		que.put(startNode)
		visited = {}
		while(not que.empty()):
			node = que.get()
			for adjNode in self.adjList[node]:
				if(adjNode not in visited):
					que.put(adjNode)
					visited[adjNode] = 1
		return '_'.join(sorted(visited.keys()))

	def isSpanningTree(self,spTree):
		traversedNodes = spTree.BFS()
		print(traversedNodes)
		if(traversedNodes == self.nodeString):
			return True
		return False 
	
		
	def kruskal(self):
		self.spanningTree = Graph()
		self.spTreeFound = False
		for edge in sorted(self.edges,key=lambda e:e.edgeWeight):
			self.spanningTree.addEdge(edge)
			self.spanningTree.addEdge(Edge(edge.v,edge.u,edge.edgeWeight))
			isConnectedSpTree = self.isSpanningTree(self.spanningTree)
			if(isConnectedSpTree):
				self.spTreeFound = True
				break
		if(self.spTreeFound == False):
			print("graph is disconnected\n no Spanning tree for this graph")
	
	
	def printSpanningTree(self):
		if(self.spTreeFound == True):
			self.spanningTree.createNodeString()
			self.spanningTree.printGraphAdjMatrix()
			print(self.spanningTree.weight)
		else:
			print("no Spanning tree")
#		self.spanningTree.printGraphAdjList()	
#		for edge in self.spanningTree.edges:
#			print(edge.u,edge.v,edge.edgeWeight)
#		print('connected:'+isConnectedSpTree)

		
def readInputCreateGraph(networkFile):
	g = Graph()
	with open(networkFile,'r') as fd:
		fromNode = 'A'
		for line in fd:
			edgeWeights = re.split(r',',line.strip())
			toNode = 'A'
			for edgeWeight in edgeWeights:
				if(edgeWeight != '-'):
					e = Edge(fromNode,toNode,int(edgeWeight))
					g.addEdge(e)
				if(toNode == 'Z'):
					toNode = 'a'
				else:
					toNode = chr(ord(toNode)+1)
			if(fromNode == 'Z'):
				fromNode = 'a'
			else:
				fromNode= chr(ord(fromNode)+1)
			
	g.createNodeString()
	return g
			
	
if __name__=="__main__":
	g = readInputCreateGraph(sys.argv[1])
#	g.printGraphAdjList()
	g.printGraphAdjMatrix()
	g.kruskal()
	g.printSpanningTree()
#	g.printGraphAdjMatrix()
#	g.printGraphAdjList()
#	print(g.isConnectedBFS())
