public class MaxSumSubArray {

	public static void main(String[] args) {

		int[] A = {-2, -3, 4, -1, -2, 1, 5, -3, -4, 8};
		System.out.println(maxSumSubarray(A));
		System.out.println(maxSumSubarray1(A));
	}
	
	static int maxSumSubarray(int[] A){
		int ans = Integer.MIN_VALUE;
		int len = A.length;
		for (int i = 0; i < len; i++){
			int sum = 0;
			for (int j = 0; (i + j) < len; j++){
				sum += A[i + j];
				ans = Math.max(ans, sum);
			}
		}
		return (ans);
	}
	
	static int maxSumSubarray1(int[] A){
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++){
			if (sum + A[i] > 0)
			{
				sum += A[i];
				ans = Math.max(ans, sum);
			}
			else
				sum = 0;
		}
		return (ans);
	}
}
