
import java.io.*;
import java.util.*;

public class PE_82 {

	private final int rows;
	private final int columns;
	private final int[][] matrix;
	private final String matrixFile;
	
	private Map<String,Long> mSumMap = new HashMap<String,Long>();
	
	public PE_82(String inFile,int r,int c) {
		this.rows = r;
		this.columns = c;
		this.matrixFile = inFile;
		this.matrix = new int[this.rows][this.columns];
	}
	
	public void readInput1() throws IOException {
		
		try {
			Scanner in = new Scanner(new File(this.matrixFile));
			int i = 0;
			int j = 0;
			while(in.hasNextInt()) {
				matrix[i][j] = in.nextInt();
				if(j==79) {
					j=0;
					i++;
				}
			}
			in.close();
		} catch(FileNotFoundException fnfe) {
			throw new IOException(fnfe);
		}
	}
	
	public void readInput() throws IOException {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.matrixFile));
			String s = "";
			int i = 0;
			while((s=br.readLine())!=null) {
				String[] prts = s.split(" ",-1);
				int j = 0;
				for(String prt:prts) {
					matrix[i][j] = Integer.parseInt(prt);
					j++;
				}
				i++;
			}
		}catch(FileNotFoundException fnfe) {
			throw new IOException(fnfe);
		}
	}
	
	public void printMatrix() {
		
		for(int i=0;i<this.rows;i++) {
			for(int j=0;j<this.rows;j++) {
				System.out.print(""+matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public long getMSum(int i,int j) {
		
		String key = ""+i+"_"+j;
		if(mSumMap.containsKey(key)) {
			return mSumMap.get(key);
		}
		
		
		//if((i==0) && (j==0)) {
		//	mSumMap.put(key, new Long(matrix[i][j]));
		//	return mSumMap.get(key);
		//}
		
		if(j==0) {
			mSumMap.put(key, new Long(matrix[i][j]));
			return mSumMap.get(key);
		}
		
		
		long mSum = 0;
		if(i==0) {
			long leftSum = getMSum(i,j-1);
			long downSum = getMSum(i+1,j);
			
			mSum = (leftSum>downSum)? downSum: leftSum;
			mSumMap.put(key, mSum);
			return mSumMap.get(key);
		}
		
		if(i==this.rows-1) {
			long leftSum = getMSum(i,j-1);
			mSumMap.put(key, mSum);
			return mSumMap.get(key);
		}
			
		long leftSum = getMSum(i,j-1);
		long downSum = getMSum(i,j+1);
		long upSum = getMSum(i-1,j);
		
		mSum = (leftSum>downSum)?
						(downSum>upSum)?upSum: downSum : 
							(leftSum>upSum) ? upSum:leftSum;
		mSum+=matrix[i][j];
		mSumMap.put(key, mSum);
		return mSumMap.get(key);	
	}
	
	public long getMinSum() {
		
		TreeMap<Long,Integer> tmap = new TreeMap<Long,Integer>();
		for(int rowNum=0; rowNum<this.rows;rowNum++) {
			tmap.put(getMSum(rowNum,this.columns-1),1);
		}
		return tmap.firstKey();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//PE_82 p82 = new PE_82("/home/praveen/eclipse-workspace/ProjectEuler/src/p082_matrix.txt",80,80);
		PE_82 p82 = new PE_82("/home/praveen/eclipse-workspace/ProjectEuler/src/p081_testMatrix",5,5);
		p82.readInput();
		p82.printMatrix();
		p82.getMinSum();
	}
}
