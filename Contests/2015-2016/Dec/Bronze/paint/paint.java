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

public class paint {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("paint.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		boolean[] fence = new boolean[101];
		int a = Integer.parseInt(s.nextToken());
		int b = Integer.parseInt(s.nextToken());
		for (int i = a; i < b; i++) {
			if (!fence[i]) {
				ans++;
				fence[i] = true;
			}
		}
		s = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(s.nextToken());
		int d = Integer.parseInt(s.nextToken());
		for (int i = c; i < d; i++) {
			if (!fence[i]) {
				ans++;
				fence[i] = true;
			}
		}
		out.println(ans);
		out.close();

	}
	
	
	
	

}
