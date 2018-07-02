
import java.io.*;
import java.util.*;

public class PE_81 {

	private final String matrixFile;
	private final int[][] matrix;
	private final int rows;
	private final int columns;
	
	private Map<String,Long> mSumMap = new HashMap<String,Long>();
	 
	public PE_81(String mfile,int rows,int columns) {
		matrixFile = mfile;
		this.rows = rows;
		this.columns = columns;
		matrix = new int[this.rows][this.columns];
	}
	
	public void readInput() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(matrixFile));
			String line = "";
			int i = 0;
			while((line = br.readLine())!=null) {
				int j = 0;
				String[] numsStr = line.split(",");
				for(String n: numsStr) {
					matrix[i][j] = Integer.parseInt(n);
				//	System.out.print(n);
					j++;
				}
				i++;
				//System.out.println();
			}
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public long minSum(int i, int j) {
		
		String key = ""+i+"_"+j;
		if(mSumMap.containsKey(key)) {
			return mSumMap.get(key);
		}
		
		if((j==0) && (i==0)) {
			mSumMap.put(key, new Long(matrix[0][0]));
			//System.out.println(matrix[0][0]);	
			return mSumMap.get(key);
		}
		
		long mSum = 0;
		if(j==0) {
			mSum = minSum(i-1,j) + matrix[i][j];
			mSumMap.put(key, mSum);
			return mSumMap.get(key);
		}
		if(i==0) {
			mSum = minSum(i,j-1) + matrix[i][j];
			mSumMap.put(key, mSum);
			return mSumMap.get(key);
		}
		
		long leftSum = minSum(i,j-1);
		long upSum = minSum(i-1,j);
		long downSum = minSum(i+1,j);
		
		mSum = (leftSum<upSum)?  
				(leftSum<downSum)? leftSum:downSum: 
					(downSum<upSum?downSum:upSum);
		
		mSumMap.put(key,mSum + matrix[i][j]);
		return mSumMap.get(key);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE_81 p81 = new PE_81("/home/praveen/eclipse-workspace/ProjectEuler/src/p081_matrix.txt",80,80);
		//PE_81 p81 = new PE_81("/home/praveen/eclipse-workspace/ProjectEuler/src/p081_testMatrix",5,5);
		p81.readInput();
		System.out.println(p81.minSum(79,79));
	}
}
