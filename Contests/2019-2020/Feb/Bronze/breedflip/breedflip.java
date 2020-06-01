import java.io.*;
import java.util.*;


public class breedflip {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int n = Integer.parseInt(s.nextToken());
		s = new StringTokenizer(f.readLine());
		String a = s.nextToken();
		s = new StringTokenizer(f.readLine());
		String b = s.nextToken();
		
		boolean notMatching = false;
		for (int i = 0; i < b.length(); i++) {
			if (notMatching) {
				if (b.charAt(i) == a.charAt(i)) {
					notMatching = false;
				}
			} else {
				if (b.charAt(i) != a.charAt(i)) {
					notMatching = true;
					ans++;
				}
			}
			
		}
		
		out.println(ans);
		out.close();

	}
	
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, BASH TEST CASES, MAKE MILLIONS
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */