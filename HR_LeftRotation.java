
import java.util.*;
import java.io.*;

public class HR_LeftRotation {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        
        int[] arr = new int[d];
        for(int i=0;i<d;i++) {
            arr[i] = in.nextInt();
        }
        
        for(int i=0;i<n-d;i++) {
            System.out.print(in.nextInt()+" ");
        }
        
        for(int i=0;i<d;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
