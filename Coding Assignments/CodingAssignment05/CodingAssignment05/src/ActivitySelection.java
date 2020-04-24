import java.util.*;

/**
 * A solution to Code Assignment 05.
 * @author Kyle Lierer
 *
 */
public class ActivitySelection {

	/**
	 * Selects the maximum number of activities that can be performed by a single person, 
	 * assuming that a person can only work on a single activity at a time.
	 * Precondition: finishTime is in sorted ascending order.
	 * @param startTime The array which includes all start times.
	 * @param finishTime The array which includes all finish times in ascending order.
	 */
    int[] findMaxActivities(int[] startTime, int[] finishTime) { 	
        List<Integer> results = new ArrayList<Integer>();
    	
    	// Initialize variables.
    	int prevActivity = 0;
        int curActivity = 0;
        
        // The first activity is always chosen, so add that.
        results.add(curActivity);
        
        /* Iterate through the remaining activities.
         * Because finishTime is sorted in ascending order, we can just iterate through finishTime
         * and check the corresponding startTime to determine if it the condition for our
         * greedy choice is true.*/
        for (curActivity = 1; curActivity < finishTime.length; curActivity++) {
        	/* Make the greedy choice.
        	 * "Pick the next activity whose time is more than or equal to the finish time 
        	 * of previously selected activity."
        	 * This is equivalent to: If the startTime at the current index is greater
        	 * than the finishTime at the previous index.*/
        	if (startTime[curActivity] >= finishTime[prevActivity]) {
        		// Add the current activity.
        		results.add(curActivity);
        		// Set the previous activity to the current activity.
        		prevActivity = curActivity;
        	}
        }
        
        // Convert the list to a primitive array.
        return results.stream().mapToInt(i -> i).toArray();
    }
}
