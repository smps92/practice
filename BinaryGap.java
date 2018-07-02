import java.io.*;
import java.util.*;



public class BinaryGap {

    private String getBinRep(int n) {
        StringBuilder binrep = new StringBuilder("");
        
        int temp = n;
        int count = 0;
        
        while(temp>0) {
            int digit = temp%2;
            temp=temp/2;
           binrep.append(digit);
        }
        return binrep.reverse().toString();
    }
    
    public int solution(int N) {
        // write your code in Java SE 8
    	
        String brep = getBinRep(N);
        int curPos = 0;
        int prevPos = 0;
        int maxLen = 0;
        
        while((curPos>=0) && (curPos<brep.length())) {
            prevPos = curPos;
            curPos = brep.indexOf("1",curPos+1);
            int len = curPos - prevPos - 1;
            //System.out.println(curPos);
            if(len>maxLen) {
                maxLen = len;
            }
        
        }               
        return maxLen;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryGap bg = new BinaryGap();
		/*for(int i=0;i<20;i++) {
			System.out.println(bg.getBinRep(i));
		}*/
		int n = 328;
		System.out.println(bg.getBinRep(n));
		System.out.println(bg.solution(n));
	}
}
