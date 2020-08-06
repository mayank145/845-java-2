import java.util.*;
public class Bug_Fixing3 {
	//check if the array contains every number from 1 to K atleast once
	public boolean solution(int[] A, int K) {
		int n = A.length;
		for (int i = 0; i <(n-1); i++) {
			if (A[i] + 1 < A[i + 1])
				return false;
		}
		if (A[0] != 1 && A[n-1] != K)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 1, 2, 2, 3};
		int K = 3;
		Bug_Fixing3 b=new Bug_Fixing3();
		System.out.println(b.solution(A, K));
	}


}
