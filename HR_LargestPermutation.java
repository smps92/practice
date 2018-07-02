
import java.io.*;
import java.util.*;

public class HR_LargestPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	       	        
	        if(k>n) {
	        	//Arrays.sort(arr);
	        	for(int i=n;i>0;i--) {
	        		System.out.print((i)+" ");
	        	}
	        } else {
	        	
	        	int[] arr = new int[n];
		        
		        for(int j=0;j<n;j++) {
		            arr[j] = in.nextInt();
		        } 
		        
	        	int i = 0;
	        	int swaps = 0;
	        	while(swaps<k) {
	        		
	        		if(i==n) {
	        			swaps = k;
	        			continue;
	        		}
	            
	        		int maxVal = arr[i];
	        		int maxIndex = i;
	            
	        		for(int j =i+1;j<n;j++) {
	        			if(arr[j] > maxVal) {
	        				maxIndex = j;
	        				maxVal = arr[j];
	        			}
	        		} 
	        		if(arr[i] < arr[maxIndex]) {
	        			int temp = arr[i];
	        			arr[i] = arr[maxIndex];
	        			arr[maxIndex] = temp;
	        			swaps++;
	        		} 
	        		i++;
	        	}
	        
	        	for(int j=0;j<n;j++) {
	        		System.out.print(arr[j]+" ");
	        	}
	        }
	}
}
