
import java.util.*;
import java.io.*;

public class HR_CoinChange {

	private int[] coins;
	private int n;
	private int m;
	private int maxDenom = 0;
	private int minDenom = 0;
	
	private Map<Integer,Integer> hmp = new HashMap<Integer,Integer>(); 
	
	public void readInput() {
		Scanner in = new Scanner(System.in);
		this.n = in.nextInt();
		this.m = in.nextInt();
		
		for(int i=0;i<this.m;i++) {
			this.coins[i] = in.nextInt();
		}
		Arrays.sort(coins);
		this.maxDenom = coins[coins.length - 1];
		this.minDenom = coins[coins.length - 1];
	}
	
	public int findIndex(int n) {
		int insPoint = Arrays.binarySearch(this.coins, n);
		return (insPoint>0 ? insPoint:-insPoint);
	}
	
	public int findNumWays(int n) {
		
		if(hmp.containsKey(n)) {
			return n;
		}
		
		if(n<this.minDenom) {
			return 0;
		}
		
		if(n == this.minDenom) {
			hmp.put(n, 1);
			return hmp.get(n);
		}
		
		int numWays = 0;
		/*if((n>this.minDenom) && (n<this.maxDenom)) {
			int index = findIndex(n);
			if(index>=0) {
				numWays=1;
			}
			for(int i=0;i<index;i++) {
				numWays+= findNumWays(n-coins[i]); 
			}
		} else {
			for(int i=0;i<this.m;i++) {
				numWays+= findNumWays(n-coins[i]);
			}
		}*/
		numWays+= (findIndex(n)>=0) ? 1:0;
		
		for(int i=0;i<this.m;i++) {
			numWays+= findNumWays(n-coins[i]);
		}
		
		hmp.put(n, numWays);
		return hmp.get(n);
	}
	
	public void findWays() {
		System.out.println(findNumWays(this.n));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HR_CoinChange hrcc = new HR_CoinChange();
		hrcc.readInput();
		hrcc.findWays();
	}
}
