import java.io.*;
import java.util.*;


public class planting {
	public static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int fields = Integer.parseInt(s.nextToken());
		adj = new ArrayList[fields];
		for (int i = 0; i < fields; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		long ans = 0;
		for (int i = 0; i < fields - 1; i++) {
			s = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(s.nextToken()) - 1;
			int y = Integer.parseInt(s.nextToken()) - 1;
			adj[x].add(y);
			adj[y].add(x);
		}
		
		for (int i = 0; i < adj.length; i++) {
			ans = Math.max(adj[i].size() + 1, ans);
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