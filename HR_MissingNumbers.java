
import java.util.*;
import java.io.*;

public class HR_MissingNumbers {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		TreeMap<Integer,Integer> listACnts = new TreeMap<Integer,Integer>();
        
        Scanner in = new Scanner(new File("/home/praveen/Downloads/input03.txt"));
        
        int n = Integer.parseInt(in.next());
        
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(in.next());
            if(listACnts.containsKey(num)) {
                int temp = listACnts.get(num) + 1;
                listACnts.put(num,temp);
            } else {
                listACnts.put(num,1);
            }
        }
        
        TreeMap<Integer,Integer> listBCnts = new TreeMap<Integer,Integer>();
        
        int m = Integer.parseInt(in.next());
        for(int i=0;i<m;i++) {
            int num = Integer.parseInt(in.next());
            if(listBCnts.containsKey(num)) {
                int temp = listBCnts.get(num) + 1;
                listBCnts.put(num,temp);
            } else {
                listBCnts.put(num,1);
            }
        }
        
        for(int num: listBCnts.keySet()) {
        	int list1Cnt = listBCnts.get(num);
        	int list2Cnt = listACnts.get(num);
            if(list1Cnt != list2Cnt) {
            	System.out.println(num+" ddsaj"+listBCnts.get(num) +"dadsad "+ listACnts.get(num));
                //System.out.print(num+" ");
            }
        }
	}
}
