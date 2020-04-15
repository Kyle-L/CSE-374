import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		Solution s = new Solution();
		List<List<String>> result = s.findLadders(beginWord, endWord, wordList);
		System.out.println(result);
	}

}
