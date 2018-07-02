import java.io.*;
import java.util.*;

public class HR_Anagram {

	 static int anagram(String s){
	        // Complete this function
	        int length = s.length();
	        String s1 = new String(s.substring(0,length/2));
	        System.out.println(s1);
	        String s2 = new String(s.substring(length/2));
	        System.out.println(s2);
	        
	        if(s1.length()!=s2.length()) {
	        	 return -1;
	        }
	        
	        Map<String,Integer> hmap = new HashMap<String,Integer>();
	        
	        for(char c: s1.toCharArray()) {
	        	String temp = ""+c;
	        	if(hmap.containsKey(temp)) {
	        		int tempCnt = hmap.get(temp) + 1;
	        		hmap.put(temp,tempCnt);
	        	}else {
	        		hmap.put(temp, 1);
	        	}
	        }
	        
	        
	        int changeCount = 0;
	        
	        for(char c: s2.toCharArray()) {
	        	
	        	String temp = ""+c;
	        	if(hmap.containsKey(temp)) {
	        
	        		if(hmap.get(temp) == 0) {
	        			changeCount++;
	        		} else {
	        			System.out.println("contains"+temp+hmap.get(temp));
	        			int tempCnt = hmap.get(temp) - 1;
	        			hmap.put(temp, tempCnt);
	        		}
	        	} else {
	        		changeCount++;
	        	}
	        return changeCount;
	    }

	    public static void main(String[] args) {
	    	
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            String s = in.next();
	            int result = anagram(s);
	            System.out.println(result);
	        }
	    }
}
