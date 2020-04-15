/**
 * A solution to Code Assignment 04.
 * @author Kyle Lierer
 *
 */

import java.util.*;

/*
 * Algorithm Pseudo Code:
 * 			1. Create a path P1 that begins at beginWord.
 * 			2. Let V be all visited strings.
 * 			3. Let F be all final paths.
 * 			4. Q be a queue of paths (stack gives the wrong return order), does not matter.
 * 			5. Q <- P1
 * 			6. While Q is not empty.
 * 			7.		Let V1 be an set of strings.
 * 			8.			Poll Q for path P2.
 * 			9.			Let s be the last string in P2.
 * 			10.			Let S be all single transform variations of s.
 * 			11.				For t in S
 * 			12.					If t is end, add P2 + t to F.
 * 			13.					If t is not end and not in V, add P2 + t to Q.
 * 			14.						Add t to V1
 * 			15.			Add everything in V1 to V.
 * 			16.	Return F
 * 
 */
class Solution {
	
	final char START_CHAR = 'a';
	final char END_CHAR = 'z';
	
	/**
	 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest 
	 * transformation sequence(s) from beginWord to endWord, such that:
	 * 		1. Only one letter can be changed at a time
	 * 		2. Each transformed word must exist in the word list. 
	 * Note that beginWord is not a transformed word.
	 * Pre-conditions: wordList contains endWord.
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {		
        List<List<String>> finalTransformPaths = new ArrayList<>();
        
        // Copy the wordList into a set so the wordList is not modified.
        Set<String> wordSet = new HashSet<>(wordList);
        
        // Pre-conditions.
        if (!wordSet.contains(endWord) || beginWord == "" || endWord == "") {
        	return finalTransformPaths;
        }
        
        // A set to keep track of all visited words.
        Set<String> visitedStrings = new HashSet<>();
        
        // Add beginWord to the set since that is the starting string.
        visitedStrings.add(beginWord);
        
        // A queue to keep track of all in-progress transform paths.
        Queue<List<String>> queue = new LinkedList<>();
        
        // Create a path of only beginWord as a starting path.
        List<String> startTransformPath = new ArrayList<String>();
        startTransformPath.add(beginWord);
        queue.add(startTransformPath);

        // Whether all paths at a particular depth have been found.
        boolean shortestPathsFound = false;
        
        /* Continue polling paths from the queue until the queue is empty
         * and all paths at the shortest depth are found. */
        while (!queue.isEmpty() && !shortestPathsFound) {
        	/* All of the strings visited during this iteration.
        	 * Updated at the end of an iteration so branching paths
        	 * do not get skipped. */
            Set<String> tempVisited = new HashSet<>();
            
            /* Iterate through backwards since the size of the queue can 
             * change when elements are added and by doing it backwards we
             * can avoid modifying wordIndex to accommodate the changing size
             * the queue. */
            for (int wordIndex = queue.size(); wordIndex > 0; wordIndex--) {
            	// An unfinished transform path.
                List<String> curTempTransformPath = queue.poll();
                
                // Get the last string in the transform path.
                String curStr = curTempTransformPath.get(curTempTransformPath.size() - 1);
                
                // Iterate through each character in the string.
                for (int charIndex = 0; charIndex < curStr.length(); charIndex++) {
                    char[] charArr = curStr.toCharArray();
                    
                    // Change each character in the charArr one at a time.
                    for (char c = START_CHAR; c <= END_CHAR; c++) {
                    	// Set the 
                        charArr[charIndex] = c;
                        
                        // Convert the char array into a new string.
                        String newStr = new String(charArr);
                        
                        // If the newString is the endWord, we have found a final transform path.
                        if (newStr.equals(endWord)) {
                        	/* Add newStr to curTempTransformPath
                        	 * Note: 	Not copying curTempTransform since the loop is ended when
                        	 * 			since a final path has been found. */
                        	curTempTransformPath.add(newStr);
                        	finalTransformPaths.add(curTempTransformPath);
                        	
                        	/* Since a path at this depth has been found, quit once
                        	 * once we are done at this depth. */
                        	shortestPathsFound = true;
                    	
                    	/* If the newString is not the current string and not visited, add to the 
                    	 * tempTransformPath and add that back into the queue. */
                        } else if (wordSet.contains(newStr) && !visitedStrings.contains(newStr)) {
                        	// Copy the curTempTransformPath to a new list so the original is not updated.
                            List<String> tempTransformCopy = new ArrayList<String>(curTempTransformPath);
                        	tempTransformCopy.add(newStr);
                        	// Add back to the queue.
                        	queue.add(tempTransformCopy);
                        	// Mark the string as visited at the end of this iteration.
                            tempVisited.add(newStr);
                        }
                    }
                }
            }
            // Mark all strings visited during this iteration as visited.
            visitedStrings.addAll(tempVisited); 
        }
        
        // Return the final transform paths.
        return finalTransformPaths;
    }

}