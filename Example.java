
import java.io.*;
import java.util.*;

public class Solution {

	private int numEmployees;
	private String firstEmployee;
	private String secondEmployee;
	private String CEO;
	private Map<String,String> relations = new HashMap<String,String>();
	
	public void readInput() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = "";
			numEmployees = Integer.parseInt(br.readLine());
			firstEmployee = br.readLine().trim();
			secondEmployee = br.readLine().trim();
		
			boolean flag = false;
			
			while((s=br.readLine())!= null) {
				if(s.equalsIgnoreCase(" ")) {
					break;
				}
				String[] relation = s.split(" ");
				relations.put(relation[1].trim(),relation[0].trim());
				if(flag == false) {
					relations.put(relation[0].trim()," ");
					flag = true;
					CEO = relation[0];
				}
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		getHierarchy(firstEmployee);
		getHierarchy(secondEmployee);
	}
	
	public ArrayList<String> getHierarchy(String employee) {
		
		ArrayList<String> hierarchy = new ArrayList<String>();
		String manager = employee;
		while(manager!= " ") {
			//System.out.print(manager+ " ");
			
			hierarchy.add(relations.get(manager));
			manager = relations.get(manager);
			
		} 
		return hierarchy;	
	}
	
	public String commonManager() {
		
		ArrayList<String> firstEHierarchy = getHierarchy(firstEmployee);
		ArrayList<String> secondEHierarchy = getHierarchy(secondEmployee);

		if(relations.get(firstEmployee).equalsIgnoreCase(secondEmployee)) {
			return secondEmployee;
		}
		
		if(relations.get(secondEmployee).equalsIgnoreCase(firstEmployee)) {
			return firstEmployee;
		}
		
		Map<String,Integer> hmp = new HashMap<String,Integer>();
		for(String manager: firstEHierarchy) {
			hmp.put(manager, 1);
		}
	
		for(String manager: secondEHierarchy) {
			if(hmp.containsKey(manager)) {
				return manager;
			}
		}
		return CEO;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		s.readInput();
		s.commonManager();
	}
}