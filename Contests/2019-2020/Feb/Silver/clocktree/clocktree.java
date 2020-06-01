import java.io.*;
import java.util.*;


public class clocktree {
	public static ArrayList<Integer>[] adj;
	public static int[] currVisits;
	public static int[] visits;
	public static ArrayList<Integer> added = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("clocktree.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int nodes = Integer.parseInt(s.nextToken());
		int ans = 0;
		adj = new ArrayList[nodes];
		for (int i = 0; i < nodes; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		//no u
		visits = new int[nodes];
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < visits.length; i++) {
			visits[i] = Integer.parseInt(s.nextToken());
		}
		
		for (int i = 0; i < nodes - 1; i++) {
			s = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(s.nextToken()) - 1;
			int dest = Integer.parseInt(s.nextToken()) - 1;
			adj[src].add(dest);
			adj[dest].add(src);
		}
		
		for (int i = 0; i < nodes; i++) {
			currVisits = Arrays.copyOf(visits, visits.length);
			added.clear();
			//if we visited only one branch, you don't need to change the src
			for (int j = 0; j < adj[i].size(); j++) {
				dfs(adj[i].get(j), i, adj[i].get(j) );
			}
			//if i visited more than one branch, then i must have gone through the root at least once, so visiting 2 branches only requires at least one visit on the root
			if (added.size() > 1) {
				currVisits[i]--;
			}
			//after updating everything that needs to be updated, if the root isn't correct, then there is a problem
			if (currVisits[i]%12 == 0) {
				ans++;
			}
		}
		
		out.println(ans);
		out.close();
		
	}
	public static void dfs(int curr, int src, int orig) {
		for (int i = 0; i < adj[curr].size(); i++) {
			int node = adj[curr].get(i);
			if (node != src) {
				dfs(node, curr, orig);
				
			}
			
		}
		//fix upwards
		//if the current node needs to be updated or it has been updated, then the src must also be updated at least once
		if (currVisits[curr] != 12 || currVisits[curr] != visits[curr]) {
			//to handle if we visited more than once branch from the master root node 
			if (added.size() < 2) {
				if (!added.contains(orig)) {
					added.add(orig);
				}
			}
			//if we updated the curr node or one of it's children, then the src node must also be updated as we had to have traversed it unless it is the root node
			if (curr == orig && )
			if (currVisits[curr] != visits[curr]) {
				currVisits[src]++;
			}
			if (currVisits[curr] != 12) {
				currVisits[src] += 12 - currVisits[curr];
				currVisits[curr] = 12;
			}
			
		}
	}
	public static void ArrayListPrinter(ArrayList<Integer>[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].size(); j++) {
				System.out.print(array[i].get(j) + " "); 
			}
			System.out.println();
			
		}
		System.out.println();
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