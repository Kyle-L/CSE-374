import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		int s[] =  {1, 3, 0, 5, 8, 5}; 
	    int f[] =  {2, 4, 6, 7, 9, 9}; 
	    ActivitySelection as = new ActivitySelection();
	    System.out.println(Arrays.toString(as.findMaxActivities(s, f))); 
	}

}
