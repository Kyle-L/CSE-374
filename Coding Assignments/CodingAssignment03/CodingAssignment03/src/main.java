
public class main {

	public static void main(String[] args) {

		int[] test1 = {1, 2, 3, 4};
		int[] test2 = {3, 2, 1, 0, 3};
		int[] test3 = {0, 1, 3, 4};

		Solution jump = new Solution();
		
		System.out.println(jump.canJump(test1));
		System.out.println(jump.canJump(test2));
		System.out.println(jump.canJump(test3));

	}

}
