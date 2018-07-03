package projectEuler;

import java.io.*;
import java.util.*;



class Node {

	private int element;
	private ArrayList<Node> ancestors = new ArrayList<Node>();
	private ArrayList<Node> children = new ArrayList<Node>();
	private Node parent  = null;
	
	public static Map<Integer,Integer> nodesGenerated = new HashMap<Integer,Integer>();
	public static Node sentinal = new Node(0,null);
	
	public Node(int element,Node parent) {
		this.element = element;
		this.parent = parent;
	}

	public int getElement() {
		
		return this.element;
	}
	
	public ArrayList<Node> getChildren() {
		
		return this.children;
	}
		
	
	public void genChildren() {
		
		for(Node anc: this.ancestors) {
			if(!(nodesGenerated.containsKey(this.element+anc.element))) {
				
				Node child = new Node(this.element+anc.element,this);
				children.add(child);
				child.updateAncestors();
				nodesGenerated.put(child.getElement(), 1);
			}
		}
	}
	
	
	public void updateAncestors() {
		
		if(this.parent == null) {
			ancestors.add(this);
			return;
		}
		
		ArrayList<Node> nodeAncestors = this.parent.ancestors;
		int ancLen = nodeAncestors.size();
		for(int i = 0;i< ancLen;i++) {
			ancestors.add(nodeAncestors.get(i));
		}
		ancestors.add(this);
	}
}

public class PE_122 {

	
	
	
	public void generatePowerTree() {
		
		
		
		Node powerTreeRoot = new Node(1,null);
		powerTreeRoot.updateAncestors();
		
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(powerTreeRoot);
		queue.add(Node.sentinal);
		Node.nodesGenerated.put(powerTreeRoot.getElement(),1);
		
		int count = 0;
		while(count<=2) {
			
			ArrayList<Node> newQueue = new ArrayList<Node>();
			boolean sentinalFound = false;
			while(!sentinalFound) {
				
				Node crnt = newQueue.remove(0);
				if(crnt == Node.sentinal) {
					newQueue.add(Node.sentinal);
					sentinalFound = true;
					continue;
				}
				
				crnt.genChildren();
				for(Node child: crnt.getChildren()) {
					if(!Node.nodesGenerated.containsKey(child.getElement())) {	
						newQueue.add(child);
					}
				}
			}
			for(Node n: newQueue) {
				System.out.print(n.getElement());
			}
			System.out.println();
			queue = newQueue;
			count++;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE_122 p122 = new PE_122();
		
		
	}

}
