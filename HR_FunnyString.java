
import java.util.*;
import java.io.*;

public class HR_FunnyString {
	

	private static Map<String,Integer> hmp = new HashMap<String,Integer>();
	
	static String funnyString(String s){
        // Complete this function
        
			
        for(int i=1,j=s.length()-1;i<s.length();i++,j--) {
            
        	int sdiff = s.charAt(i) - s.charAt(i-1); 
        	int rdiff = s.charAt(j) - s.charAt(j-1);
        	
        	
            sdiff = (sdiff>0) ? sdiff: 0-sdiff;
            rdiff = (rdiff>0) ? rdiff: 0-rdiff;
             
            
            if(sdiff!=rdiff) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
