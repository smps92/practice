
import java.io.*;
import java.util.*; 
public class HR_MinAbsDiff {

	static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        TreeMap<Integer,Integer> tmap = new TreeMap<Integer,Integer>();
        for(int i=0;i<n;i++) {
            
            if(tmap.containsKey(ar[i])) {
                int temp = tmap.get(ar[i]) + 1;
                tmap.put(ar[i],temp);
            } else {
                tmap.put(ar[i],1);
            }
        }
        int argmax = tmap.lastKey();
        int val = tmap.get(argmax);
        return val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
