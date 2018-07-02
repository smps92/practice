
import java.io.*;
import java.util.*;

public class MaxPalindromicSubstring {

	
	private String input = "";
	private Map<String,Integer> hmp1 = new HashMap<String,Integer>();
	private Map<String,Integer> hmp = new HashMap<String,Integer>();
	
	private MaxPalindromicSubstring(String s) {
		input = s;
	}
	
	private int maxPalinLength(int i,int j) {
	
		String key = ""+i+"_"+j;
		//System.out.println(key);
		
		
		if(hmp.containsKey(key)) {
			return hmp.get(key);
		}
		
		if(i==j) {
			hmp.put(key,1);
			hmp1.put(key, 1);
			return hmp.get(key);
		}
		
		if(i+1==j) {
			if(input.charAt(i) == input.charAt(j)) {
				hmp.put(key, 2);
				hmp1.put(key, 1);
				return hmp.get(key);
			} else {
				hmp1.put(""+i+"_"+i,1);
				hmp1.put(""+j+"_"+j,1);
				hmp.put(key, 1);
				return hmp.get(key);
			}
		}
		
		int len1 = maxPalinLength(i+1,j-1);
		String subKey = ""+(i+1)+"_"+(j-1);
		
		if(hmp1.containsKey(subKey)) {
			if(input.charAt(i) == input.charAt(j)) {
				len1+=2;
				hmp1.put(key,1);
			}
		}
		
		int len2 = maxPalinLength(i,j-1);
		int len3 = maxPalinLength(i+1,j);
		
		
		int maxLen = (len1>len2) ? (len1>len3)? len1:len3 : (len2 >len3)?len2:len3; 
		hmp.put(key, maxLen);  
		return hmp.get(key);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		MaxPalindromicSubstring mps = new MaxPalindromicSubstring(s);
		System.out.println(mps.maxPalinLength(0,s.length()-1));
	}
}
