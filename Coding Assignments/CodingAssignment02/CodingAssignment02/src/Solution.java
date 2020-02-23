/**
 * Finds the nth ugly number given n, a, b, and c.
 * An ugly number is a number such that it is a factor
 * of a, b, or c.
 * 
 * Uses a binary search to find the nth ugly number by 
 * looking at number numbers in unions of A, B, and C where
 * A is set of all ugly numbers of a.
 * B is the set of all ugly numbers of b. 
 * C is the set of all ugly numbers of c.
 * 
 * @author Kyle Lierer
 *
 */
public class Solution {

	/**
	 * Finds the nth ugly number given n, a, b, and c.
	 * An ugly number is a number such that it is a factor
	 * of a, b, or c.
	 * @return The ugly number at n.
	 */
	public long nthUglyNumber (long n, long a, long b, long c) {
		/* If a, b, or c is equal to 1.
		 * then all Integers are an ugly number. */
		if (a == 1 || b == 1 || c == 1) {
			return n;
		}
		
		// The left and right of the binary search.
		int l = 0;
		int r = Integer.MAX_VALUE;
		
		
		int uglyNumber = 0;
		
		/* Uses a binary search to find the nth ugly number. */
		while (l <= r) {
			// Finds the mid of the left and right side.
			int mid = l + (r - l)/2;
			
			// Finds number of numbers that are ugly numbers of a, b, or c at n.
			long numberInUnion = findNumberInUnionSet(mid, a, b, c);
			
			/* If n is less than or equal to the numberUnion.
			 * then ugly number of n is less than the mid or equal to it.*/
			if (numberInUnion >= n) {
				uglyNumber = mid;
				
				/* Sets the right index equal to the mid - 1.
				 * 1 is subtracted since the mid has already been checked.*/
				r = mid - 1;
			} else {
				/* Sets the left index equal to the mid + 1.
				 * 1 is added since the mid has already been checked.*/
				l = mid + 1;
			}
		}
		
		return uglyNumber;
		
	}
	
	/**
	 * Finds number of numbers that are ugly numbers of a, b, or c
	 * less than or equal to n.
	 * 
	 * In others words:
	 * Let A be the set of all ugly numbers of a.
	 * Let B be the set of all ugly numbers of b. 
	 * Let C be the set of all ugly numbers of c.
	 * This returns the |A u B u C| less than or equal to n.
	 * Equation derived from https://www.probabilitycourse.com/chapter1/1_2_2_set_operations.php.
	 */
	private long findNumberInUnionSet (long n, long a, long b, long c) {
		// Finds the least common multiple of a and b.
		long abLCM = findLCM(a, b);
		
		// Finds the least common multiple of b and c.
		long bcLCM = findLCM(b, c);
		
		// Finds the least common multiple of a and c.
		long acLCM = findLCM(a, c);
		
		// Finds the least common multiple of a, b, and c.
		long abcLCM = findLCM(a, bcLCM);
		
		// Finds the number of numbers that are divisible by the sum of a, b, and c.
		long result = n/a + n/b + n/c;
		
		/* Removes all numbers that divisible by a and b, a and c, b and c, and adds back the
		 * the numbers that are divisible by a, b, and c. */
		return result - n/abLCM - n/acLCM - n/bcLCM + n/abcLCM;
	}
	
	/**
	 * Finds the least common multiple using the greatest common factor.
	 */
	private long findLCM (long a, long b) {
		return (a * b)/findGCF(a, b);
	}
	
	/**
	 * Finds the greatest common factor using the Euclidean algorithm.
	 */
	private long findGCF (long a, long b) {
		if (a == 0) {
			return b;
		}
		return findGCF(b % a, a);
	}
	
}
