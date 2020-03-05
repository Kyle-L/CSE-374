import java.util.Arrays;

/**
 * An implementation of QuickSort following the algorithm provided in
 * "Introduction to Algorithms" by Thomas Cormen. 
 * ISBN-10: 9780262033848 
 *  
 * @author Kyle Lierer
 *
 * @param <T> The type of the array being sorted.
 */

public class Quicksort<T>{

	/**
	 * Sorts an array of comparable objects.
	 * @param array The comparable array.
	 */
	public void sort (Comparable<T>[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	/**
	 * Sorts an array of comparable objects using quick sort.
	 * @param array The comparable array.
	 * @param left
	 * @param right
	 */
	private void quickSort (Comparable<T>[] array, int left, int right) {
		// Divide and conquer until the the left is greater than the right.
		if (left < right) {
			// Determines the paritioning index.
			int pivot = partition(array, left, right);
			
			// Sort the left sub-array up until the pivot.
			quickSort(array, left, pivot - 1);
			
			// Sorts the right sub-array up until the pivot.
			quickSort(array, pivot + 1, right);
		}
	}
	 /**
	  * Partitions the comparable array.
	  * @param array The comparable array.
	  * @param left
	  * @param right
	  * @return
	  */
	private int partition (Comparable<T>[] array, int left, int right) {
		// The right most element is chosen as the pivot object.
		Comparable<T> pivotObject = array[right];
		
		// The index of the smaller element being compared.
		int i = left - 1;
		
		// The for
		for (int j = left; j < right; j++) {			
			// If current element is smaller than or equal to the pivot
			if (array[j].compareTo((T) pivotObject) <= 0) {
				// Increments the smaller index of the smaller element.
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, right);
		
		// Returns the partitioning index.
		return i + 1;
	}
	
	/**
	 * Swaps two elements in a comparable array.
	 * @param array The comparable array.
	 * @param index1 The index of the first element being swapped.
	 * @param index2 The index of the second element being swapped.
	 */
	private void swap (Comparable<T>[] array, int index1, int index2) {
		Comparable<T> temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}
	
}
