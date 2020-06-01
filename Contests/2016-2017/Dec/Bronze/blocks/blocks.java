import java.io.*;
import java.util.*;
/* REMINDERS
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */

public class blocks {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int blocks = Integer.parseInt(s.nextToken());
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 97; i < 123; i++) {
			map.put((char)i, 0);
		}
		
		for (int i = 0; i < blocks; i++) {
			s = new StringTokenizer(f.readLine());
			
			String word1 = s.nextToken();
			String word2 = s.nextToken();
			
			//count occurences of each letter in each word, and then take the max of it out of the 2 words
			HashMap<Character, Integer> currMap = new HashMap<Character, Integer>();
			for (int j = 97; j < 123; j++) {
				currMap.put((char)j, 0);
			}
			for (int j = 0; j < word1.length(); j++) {
				currMap.put(word1.charAt(j), currMap.get(word1.charAt(j)) + 1);
			}
			
			
			
			HashMap<Character, Integer> currMap1 = new HashMap<Character, Integer>();
			for (int j = 97; j < 123; j++) {
				currMap1.put((char)j, 0);
			}
			for (int j = 0; j < word2.length(); j++) {
				currMap1.put(word2.charAt(j), currMap1.get(word2.charAt(j)) + 1);
			}
			
			for (int j = 97; j < 123; j++) {
				map.put((char)j, map.get((char)j) + Math.max(currMap.get((char)j), currMap1.get((char)j)));
			}
		}
		
		for (int i = 97; i < 123; i++) {
			out.println(map.get((char)i));
		}
		out.close();

	}
	
	
	
	
	

}
