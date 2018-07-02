
import java.util.*;
import java.io.*;

public class PE_31 {

	private final int[] denoms;
	private final int minDenom;
	private final int maxDenom;
	private final Map<Integer,Integer> hmp;
	private final Map<String,Integer> visitedMap;
	private final int sum;
	
	public PE_31(int[] ar,int s) {
		hmp = new HashMap<Integer,Integer>();
		visitedMap = new HashMap<String,Integer>();
		denoms = new int[ar.length];
		sum = s;
		int min = 1000000;
		int max = -1;
		for(int i=0;i<ar.length;i++) {
			denoms[i] = ar[i];
			if(denoms[i]<min) {
				min = denoms[i];
			}
			if(denoms[i]>max) {
				max = denoms[i];
			}
		}
		minDenom = min;
		maxDenom = max;
	}
	
	public int getNumWays(int sm) {
		
		
		if(hmp.containsKey(sm)) {
			return hmp.get(sm);
		}
		
		if(sm<this.minDenom) {
			return 0;
		}
		if(sm == this.minDenom) {
			hmp.put(sm, 1);
			return hmp.get(sm);
		}
		
		int nWays = 0;
		for(int i = 0;i<denoms.length;i++) {
			if(denoms[i]<sm) {
				nWays+=getNumWays(sm -denoms[i]);
			}
		}
		int pos = Arrays.binarySearch(denoms,sm);
		if(pos>=0) {
			nWays+=1;
		}
		
		hmp.put(sm, nWays);
		return hmp.get(sm);
	}
	
	
	public void printMap() {
		System.out.println(hmp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int numDenoms = in.nextInt();
		int[] ar = new int[numDenoms];
		for(int i=0;i<numDenoms;i++) {
			ar[i] = in.nextInt();
		}
		int sum = in.nextInt();
		PE_31 p31 = new PE_31(ar,sum);
		System.out.println(p31.getNumWays(sum));
		p31.printMap();
	}
}
