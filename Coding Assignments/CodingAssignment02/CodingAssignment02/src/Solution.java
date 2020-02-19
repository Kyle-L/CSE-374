/**
 * Finds the nth ugly number given n, a, b, and c.
 * An ugly number is a number such that it is a factor
 * of a, b, or c.
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
		// Sets the starting index of each ugly number.
		long aIndex = 1;
		long bIndex = 1;
		long cIndex = 1;
				
		/* Find the first ugly number.
		 * Note: a, b, and c aren't multiplied by their index
		 * 		 since the starting index is just 1 and thus
		 * 		 multiplying by 1 just results in their identity. */
		long currentUglyNumber = getMin(a, b, c);
	    
		/* Iterates through n number of times finding each ugly number up to 
		 * and including n. */
        for(long i = 1; i <= n; i++) {
        	// Gets the next ugly number.
        	currentUglyNumber = getMin(a * aIndex, b * bIndex, c * cIndex);
            
            /* Determines whether the number comes from a, b, or c 
             * and increments the correct index. 
             * Please note: Each number is checked just in case there
             * 				is an ugly number which that can be created
             * 				by 2 or more a, b, or c multiplied by their 
             * 				index.*/
            if(currentUglyNumber == a * aIndex) { 
            	aIndex++; 
            } 
            if(currentUglyNumber == b * bIndex) { 
            	bIndex++; 
        	} 
            if(currentUglyNumber == c * cIndex) { 
            	cIndex++; 
        	}
        }
        
        // Returns the nth ugly number.
        return currentUglyNumber;
	}
	
	/**
	 * Gets the minimum of 3 long numbers x, y, and z.
	 * @return The minimum of x, y, and z.
	 */
	private long getMin (long x, long y, long z) {
		return Math.min(x, Math.min(y, z));
	}
	
}
