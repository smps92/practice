
import java.io.*;
import java.util.*;

public class HR_SherlockAndArray {
	
	static String solve(int[] a){
		
		//if(a.length<=2) {
		//	return "NO";
		//}
		
        int[] lSums = new int[a.length];
        int lsum = 0;
        
        for(int i=0;i<a.length;i++) {
            lsum+=a[i];
            lSums[i] = lsum;
        }
        //System.out.println(lSums.toString());
        
        int[] rSums = new int[a.length];
        int rsum = 0;
        
        for(int i=a.length-1;i>=0;i--) {
            rsum+=a[i];
            rSums[i] = rsum;
        }
        
        for(int i=0;i<a.length;i++) {
        	
            int lSumMinusi = lSums[i] - a[i];
            int rSumMinusi = rSums[i] - a[i];
            
            if(lSumMinusi == rSumMinusi) {
                return "YES";
            }
        }
        
        return "NO";
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }



}
