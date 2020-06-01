import java.io.*;
import java.util.*;
/* REMINDERS
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */

public class diamond {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		
		long ans = 0;
		
		int dis = Integer.parseInt(s.nextToken());
		int diff = Integer.parseInt(s.nextToken());
		int[] diamonds = new int[dis];
		for (int i = 0; i < dis; i++) {
			s = new StringTokenizer(f.readLine());
			diamonds[i] = Integer.parseInt(s.nextToken());
		}
		
		Arrays.sort(diamonds);
		
		for (int i = dis - 1; i > 0; i--) {
			//iterate through all the possible one
			int start = 0;
			for (int end = 0 + i; end < diamonds.length; end++) {
				int maxDiff = diamonds[end] - diamonds[start];
				if (maxDiff <= diff) {
					out.println(i + 1);
					out.close();
					System.exit(0);
				}
				start++;
				
			}
				
			
			
		}
		
		out.println(1);
		out.close();

	}
	
	
	
	

}
