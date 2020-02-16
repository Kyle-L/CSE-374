/**
 * @author Kyle Lierer (liererkt@miamioh.edu)
 * 
 */

import java.util.Stack;

public class Solution {

	public int[][] merge (int[][] A) {
		// Creates a new array of equal size to A.
        int B[][] = new int[A.length][A[0].length]; 
  
        // Copy elements of A to B so that A remains unchanged. 
        for (int i=0; i<A.length; i++) 
            for (int j = 0; j < A[i].length; j++) {
				B[i][j] = A[i][j];
			}
		
        // Create a new stack to use with merging intervals.
		Stack<int[]> stack = new Stack<>();
		
		// Sort the array.
		mergeSort(B, 0, A.length - 1);
		
		// Push the first sorted interval onto the stack.
		stack.push(B[0]);
		
		// Iterate through the rest of the intervals.
		for (int i = 1; i < B.length; i++) {
			int[] top = stack.peek();
			
			// If the intervals are not overlapping, push the current interval to the stack.
			if (top[1] < B[i][0]) {
				stack.push(B[i]);
			// If intervals are overlapping, update the top interval.
			} else if (top[1] <= B[i][1]) {
				top[1] = B[i][1];
				stack.pop();
				stack.push(top);
			}
		}
		
		// Get the size of the stack to create an appropriately sized array.
		int len = stack.size();
		
		// Write over sorted array with new array that is the size of the stack.
		B = new int[len][A[0].length];
		
		// Pop the stack onto the array.
		// Note: This is done backwards to retain the order of the intervals.
		for (int i = len - 1; !stack.isEmpty(); i--) {
			B[i] = stack.pop();
		}
		
		// Return the merged and sorted intervals.
		return B;
	}
	
	/**
	 * Sorts a 2d jagged array using using a merge sort based on the first
	 * element in the 2nd array.
	 * @param array the array being sorted.
	 * @param left the left most index.
	 * @param right the right most index.
	 */
	private void mergeSort (int[][] array, int left, int right) {
		/* Base case: The length is > 1 (in other words the left is
		 * less than the right side). */
		if (left < right) {
			/* Divides the n-element sequence into two by splitting in the 
			 * middle and sorts the two recursively using merge sort.*/			
			int q = (left+right)/2;
			mergeSort(array, left, q);
			mergeSort(array, q + 1, right);
			
			// Merges the two sorted subsequences to produce the sorted answer.
			merge(array, left, q, right);	
		}
	}
	
	/**
	 * Merges two sorted 2d jagged arrays based on the first element of the 2nd array.
	 * @param array the array being merged and sorted.
	 * @param left the left most index.
	 * @param mid the middle index that seperates the two arrays,.
	 * @param right the right most index.
	 */
	private void merge (int[][] array, int left, int mid, int right) {		
		// Declare index counters variables.
		int leftIndex, rightIndex, mainIndex;
		
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		// Create temporary arrays.
		int lArray[][] = new int [n1 + 1][array[0].length];
		int rArray[][] = new int[n2 + 1][array[0].length];
		
		// Copies left side of the array to temp array.
		for (leftIndex = 0; leftIndex < n1; leftIndex++) {
			lArray[leftIndex] = array[left + leftIndex];
		}
		
		// Copies right side of the array to temp array.
		for (rightIndex = 0; rightIndex < n2; rightIndex++) {
			rArray[rightIndex] = array[mid + rightIndex + 1];
		}
		
		// Set the sentinel values for the left and right arrays.
		lArray[n1][0] = Integer.MAX_VALUE;
		rArray[n2][0] = Integer.MAX_VALUE;
		
		// Reset index counters.
		leftIndex = 0;
		rightIndex = 0;
		
		// Merges the temp arrays together into the main array
		for (mainIndex = left; mainIndex <= right; mainIndex++) {
			/* If the left array's first element is smaller than the right's first.
			 * then add the left array's first element to the main array.*/
			if (lArray[leftIndex][0] <= rArray[rightIndex][0]) {
				array[mainIndex] = lArray[leftIndex];
				// Increase the left array's index.
				leftIndex++;
			/* If the left array's first element is bigger than the right's first
			 * or the same size, add the right array's first element to the main 
			 * array. */
			} else {
				array[mainIndex] = rArray[rightIndex];
				// Increase the right array's index.
				rightIndex++;
			}
		}
	}
	
}
