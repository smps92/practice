
public class PE_26 {

	
	public static int remove2And5(int n) {
	
		int tempn = n;
		while((tempn%2 == 0) && (tempn>1)) {
			tempn/=2;
		}
		while((tempn%5 == 0) && (tempn>1)) {
			//System.out.println(tempn);
			tempn/=5;
		}
		return tempn;
	}
	
	public static int getRepetendLen(int n) {
		
				
		int tempn = remove2And5(n);
		if(tempn == 1) {
			return 0;
		}

		int pow10 = 1;
		int count = 0;
		
		do {
			pow10 = ((pow10 % tempn)*(10 % tempn))%tempn;
			count++;
		} while(pow10!=1);
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maxRepetendLen = 0;
		int argmax = 0;
		//System.out.println(getRepetendLen(7));
		for(int i=2;i<1000;i++) {
			int repetendLen = getRepetendLen(i); 
			if(maxRepetendLen < repetendLen) {
				maxRepetendLen = repetendLen;
				argmax = i;
			}
		}
		System.out.println(""+argmax+"\t"+maxRepetendLen);
	}

}
