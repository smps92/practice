
import java.io.*;
import java.util.*;

public class HR_PalindromeIndex {

	static boolean isPalindrome(String p) {
        int lengp = p.length();
        
        for(int i=0;i<=lengp/2;i++) {
            if(p.charAt(i) != p.charAt(lengp-i-1)) {
                return false;
            }
        }
        return true;
    }
    
    static int palindromeIndex(String s){
        // Complete this function
        if(isPalindrome(s)) {
            return -1;
        }
        
        int lengs = s.length();
        
        for(int i=0;i<lengs;i++) {
            String delp = s.substring(0,i)+s.substring(i+1);
            if(isPalindrome(delp)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
}
