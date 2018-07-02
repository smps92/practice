import java.util.*;
import java.io.*;

public class PE_62 {

	private static Map<String,String> countmap = new HashMap<String,String>();
	
	
	public static String getSignature(long p) {
	
		StringBuilder s = new StringBuilder("");
		ArrayList<Long> arr = new ArrayList<Long>();
		
		long tempn = p;
		while(tempn>0) {
			long digit = tempn%10;
			tempn/=10;
			arr.add(digit);
		}
		Long[] sortedDigits = arr.toArray(new Long[1]);
		Arrays.sort(arr.toArray(sortedDigits));
		
		for(Long l: sortedDigits) {
			s.append(l);
		}
		return s.toString();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
		boolean found = false;
		long counter = 1;
		
		while(!found) {
			long cube = counter*counter*counter;
			String sign = getSignature(cube);
			
			if(countmap.containsKey(sign)) {
				String temp = countmap.get(sign)+","+cube;
				countmap.put(sign,temp);
				int count = temp.split(",").length;
				if(count == 5) {
					//found = true;
					System.out.println(sign+" "+temp);
					Thread.sleep(1800);
				}
			} else {
				countmap.put(sign, ""+cube);
			}
			counter++;
		}
	}
}
