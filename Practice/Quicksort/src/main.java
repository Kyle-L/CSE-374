import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		System.out.println("<== Tests QuickSort on a Integer array ==>");
		
		// Creates a integer array of random order.
		Integer[] integers = {1, 5, 2, 6, 7, 0, 3};
		
		// Output the unsorted array.
		System.out.println("The unsorted array: " + Arrays.toString(integers));
		
		// Creates integer quick sort object
		Quicksort<Integer> integerQuickSort = new Quicksort<Integer>();
		
		// Sort the integer array.
		integerQuickSort.sort(integers);
		
		// Output the result.
		System.out.println("The sorted array: " + Arrays.toString(integers));
		
		System.out.println("\n\n<== Tests QuickSort on a String array ==>");
		
		String[] strings = {"a", "c", "z", "b", "e"};
		Quicksort<String> stringQuickSort = new Quicksort<String>();
		
		// Output the unsorted array.
		System.out.println("The unsorted array: " + Arrays.toString(strings));
		
		stringQuickSort.sort(strings);
		
		// Output the result.
		System.out.println("The sorted array: " + Arrays.toString(strings));	
	}

}
