import java.io.*;
import java.util.*;


class Node {
	
	private int element;
	private Node parent;
	public long msum = 0;
	
	public static Node root = null;
	
	public Node(int element) {
		this.element = element;
	}
	
	public long getElement() {
		return this.element;
	}
	
	public void setParent(Node p) {
		this.parent = p;
	}
}

public class PE_18 {
			
	public static void readInputAsGraph(String inFile) {
		
		ArrayList<Node> parentQueue = new ArrayList<Node>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			
			String s = "";
			Node root = new Node(Integer.parseInt(br.readLine()));
			root.setParent(null);
			Node.root = root;
			
			parentQueue.add(root);
			root.msum = root.getElement();
						
			while((s=br.readLine()) != null) {
				
				ArrayList<Node> childQueue = new ArrayList<Node>();
				String[] parts = s.split(" ");
				for (String child:parts) {
					
					Node c = new Node(Integer.parseInt(child));
					childQueue.add(c);
				}
				for(int i=0,j=0;i<parentQueue.size();i++,j++) {
					
					Node parent = parentQueue.get(i);
					Node child1 = childQueue.get(j);
					Node child2 = childQueue.get(j+1);
					
					child1.setParent(parent);
					
					if(child1.msum < parent.msum + child1.getElement()) { 
						child1.msum = parent.msum + child1.getElement();
					}
					
					child2.setParent(parent);
					
					if(child2.msum < parent.msum + child2.getElement()) {
						child2.msum = parent.msum + child2.getElement();
					}
					
					/*for(Node n: childQueue) {
						System.out.print("\t"+n.msum);
					}*/
					//System.out.println();
				}
				parentQueue = childQueue;
			}
		} catch(IOException  ie) {
			ie.printStackTrace();
		}
		
		long maxSum = 0;
		for(Node n: parentQueue) {
			if(maxSum < n.msum) {
				maxSum = n.msum;
			}
		}
		System.out.println(maxSum);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readInputAsGraph("/home/praveen/eclipse-workspace/ProjectEuler/src/PE67_Input");
	}

}
