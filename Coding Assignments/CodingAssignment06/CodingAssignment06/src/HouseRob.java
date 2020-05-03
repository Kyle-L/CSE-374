import java.util.*;

/**
 * A solution to Code Assignment 06.
 * @author Kyle Lierer
 */

public class HouseRob {
    	
	/**
	 * Robs a collection of houses.
	 * @param houses - The numbers gained from robbing a house.
	 * @return The max number that can be robbed from all houses.
	 */
	public int rob(int[] houses) {
		return robDynamicTable(houses, 0, houses.length);
	}
	
	/**
	 * Robs the houses using a dynamic programming tabulation approach.
	 * @param houses - The numbers gained from robbing a house.
	 * @param start - The first house in houses to be robbed (inclusive).
	 * @param end - The last house in houses to be robbed (exclusive).
	 * @return The max number that can be robbed from all houses.
	 */
	public int robDynamicTable(int[] houses, int start, int end) {
		/* Create a table to cache sub-problems.
		 * Let tbl[n][0] represent skipping a house and
		 * Let tbl[n][1] represent robbing a house where
		 * n is a value between startIndex and endIndex.*/
		int[][] tbl = new int[end - start + 1][2];
		
		// Iterate through all of the houses within the startIndex and endIndex.
		for (int i = start; i < end; i++) {
			// Set of value of the skip house row equal to the previous max of skipping or robbing.
			tbl[i + 1][0] = Math.max(tbl[i][0], tbl[i][1]);
			// Set the value of robbing equal to the current house + previous value of skipping.
			tbl[i + 1][1] = houses[i] + tbl[i][0];
		}
		// Return the max element in the last column.
		return Math.max(tbl[end][0], tbl[end][1]);
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

    /**
	 * Robs the houses using a dynamic programming memoization approach.
	 * Please note: The only reason this is here is for practice.
	 * @param houses - The numbers gained from robbing a house.
	 * @return The max number that can be robbed from all houses.
     */
	public int robDyanmicMemoization(int[] houses, int start, int end) {
        return robDynamicMemoization(houses, start, end, new HashMap<Integer, Integer>());
    }
    
	/**
	 * Robs the houses using a dynamic programming memoization approach.
	 * Please note: The only reason this is here is for practice.
	 * @param houses - The numbers gained from robbing a house.
	 * @param start - The first house in houses to be robbed (inclusive).
	 * @param end - The last house in houses to be robbed (exclusive).
	 * @param hashMap - Cache the previously computed sub-problems.
	 * @return The max number that can be robbed from all houses.
	 */
    private int robDynamicMemoization(int[] houses, int start, int end, HashMap<Integer, Integer> hashMap) {
    	// Base Case: If the startIndex is greater than the endIndex, there is no houses to be robbed.
    	if (start >= end) {
    		return 0;
		// If the is only one house to rob, return its value.
    	} else if (Math.abs(end-start) == 1) {
    		return houses[start];
		/* Otherwise, return the max of robbing from the first house or robbing from the second house
    	 * plus the remaining houses. */
    	} else {
    		int robCurrent = (hashMap.containsKey(houses[start])) ? hashMap.get(houses[start]) : houses[start] + robRecursive(houses, start + 2, end);
    		int robNext = (hashMap.containsKey(houses[start + 1])) ? hashMap.get(houses[start + 1]) : houses[start + 1] + robRecursive(houses, start + 3, end);
    		return Math.max(robCurrent, robNext);
    	}
    }
}
