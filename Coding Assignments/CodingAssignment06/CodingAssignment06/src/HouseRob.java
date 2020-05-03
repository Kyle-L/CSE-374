/**
 * A solution to Code Assignment 06.
 * @author Kyle Lierer
 *
 */

public class HouseRob {
    
	/**
	 * Robs a collection of houses.
	 * @param houses - The numbers gained from robbing a house.
	 * @return The max number that can be robbed from all houses.
	 */
	public int rob(int[] houses) {
		return robDynamic(houses, 0, houses.length);
	}
	
	/**
	 * Robs the houses using a dynamic programming approach.
	 * @param houses - The numbers gained from robbing a house.
	 * @param start - The first house in houses to be robbed (inclusive).
	 * @param end - The last house in houses to be robbed (exclusive).
	 * @return The max number that can be robbed from all houses.
	 */
	public int robDynamic(int[] houses, int start, int end) {
		/* Create a memoization table to cache sub-problems.
		 * Let memoizationTbl[n][0] represent skipping a house and
		 * Let memoizationTbl[n][1] represent robbing a house where
		 * n is a value between startIndex and endIndex.*/
		int[][] memoizationTbl = new int[end - start + 1][2];
		
		// Iterate through all of the houses within the startIndex and endIndex.
		for (int i = start; i < end; i++) {
			// Set of value of the skip house row equal to the previous max of skipping or robbing.
			memoizationTbl[i + 1][0] = Math.max(memoizationTbl[i][0], memoizationTbl[i][1]);
			// Set the value of robbing equal to the current house + previous value of skipping.
			memoizationTbl[i + 1][1] = houses[i] + memoizationTbl[i][0];
		}
		// Return the max element in the last column.
		return Math.max(memoizationTbl[end][0], memoizationTbl[end][1]);
	}
	
	/**
	 * Robs the houses using a recursive approach.
	 * Note: 	The only reason this is here is because I used it to establish a recurrence relation 
	 * 			to derive the DP solution from.
	 * @param houses - The numbers gained from robbing a house.
	 * @param startIndex - The first house in houses to be robbed (inclusive).
	 * @param endIndex - The last house in houses to be robbed (exclusive).
	 * @return The max number that can be robbed from all houses.
	 */
	public int robRecursive(int[] houses) {
        return robRecursive(houses, 0, houses.length);
    }
    
	/**
	 * 
	 * @param houses - The numbers gained from robbing a house.
	 * @param start - The first house in houses to be robbed (inclusive).
	 * @param end - The last house in houses to be robbed (exclusive).
	 * @return The max number that can be robbed from all houses.
	 */
    private int robRecursive(int[] houses, int start, int end) {
    	// Base Case: If the startIndex is greater than the endIndex, there is no houses to be robbed.
    	if (start >= end) {
    		return 0;
		// If the is only one house to rob, return its value.
    	} else if (Math.abs(end-start) == 1) {
    		return houses[start];
		/* Otherwise, return the max of robbing from the first house or robbing from the second house
    	 * plus the remaining houses. */
    	} else {
    		int robCurrent = houses[start] + robRecursive(houses, start + 2, end);
    		int robNext = houses[start + 1] + robRecursive(houses, start + 3, end);
    		return Math.max(robCurrent, robNext);
    	}
    }
}
