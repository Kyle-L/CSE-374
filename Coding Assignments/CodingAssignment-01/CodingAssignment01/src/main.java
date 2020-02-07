import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		int[][] arr = {{1, 3}, {2, 6}, {15, 18}, {8, 10}};
		
		System.out.println(Arrays.deepToString(arr));
		
		Solution s = new Solution();
				
		int[][] arr2 = s.merge(arr);
		
		System.out.println(Arrays.deepToString(arr2));
	}

}
