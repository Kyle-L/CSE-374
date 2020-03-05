/**
 * A solution to Code Assignment 03.
 * @author Kyle Lierer
 *
 */
public class Solution {

	/***
	 * Given an array of non-negative numbers. Each number represents
	 * the max length (or any less) you can pass over the array. You 
	 * begin with the first index (index 0).
	 * This returns whether or not you can reach the last index.
	 * @param arr is an array of non-negative numbers. Each number represents
	 * the max length (or any less) you can pass over the array. You 
	 * begin with the first index (index 0).
	 * @return Whether or not you can reach the last index.
	 */
	public boolean canJump (int[] arr) {
		/* Initialize the highest jump that can be made to the first jump 
		 * length. */
		int highestJumpPossible = arr[0];
		
		/* Iterate through the array trying to reach the end. */
		for (int i = 1; i < arr.length; i++) {
			/* If at any point the highest jump possible is less than the 
			 * index, then you can not jump forward anymore since you could
			 * not jump to the current index. */
			if (highestJumpPossible < i) {
				return false;
			}
			/* Either the highest jump possible is the previous highest jump 
			 * possible or what is at the current index plus the index. */
			highestJumpPossible = Math.max(highestJumpPossible, i + arr[i]);
		}
		/* If you can iterate through the whole array, then you can reach the 
		 * last index. */
		return true;
	}
	
}
