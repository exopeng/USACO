import java.io.*;
import java.util.*;


public class revegetate {
	public static int[] cc;
	public static boolean[] visited;
	public static boolean imp = false;
	public static int[] graph;
	public static ArrayList<Edge> [] li;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(s.nextToken());
		int n = Integer.parseInt(s.nextToken());
		long ans = 0;
		cc = new int[m];
		visited = new boolean[m];
		li = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			li[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(f.readLine());
			String same = s.nextToken();
			int x = Integer.parseInt(s.nextToken()) - 1;
			int y = Integer.parseInt(s.nextToken()) - 1;
			//1 stands for same grass, 2 stands for different
			if (same.equals("S")) {
				//check for conflict
				li[x].add(new Edge(y,1));
				li[y].add(new Edge(x,1));
			} else {
				li[x].add(new Edge(y,2));
				li[y].add(new Edge(x,2));
			}
		}
		//label the pastures with the appropriate seeds, check for conflicts
		graph = new int[m];
		
		//count the number of components
		for (int i = 0; i < m; i++) {
			if (!visited[i]) {
				dfs(i, 1);
				ans++;
			}
		}
		//guaranteed power of 2
		if (imp) {
			out.println(0);
		} else {
			out.print(1);
			for (int i = 0; i < ans ; i++) {
				out.print(0);
			}
		out.println();
		}
		out.close();
	}
	public static void dfs(int curr, int label) {
		graph[curr] = label;
		visited[curr] = true;
		for (int i = 0; i < li[curr].size(); i++) {
			int x = curr;
			int y = li[curr].get(i).d;
			int w = li[curr].get(i).w;
			if (w == 1) {
				//if the two are opposite when it is supposed to be identical seed
				if (graph[y] == 3-label) {
					imp = true;
				}
				//if you haven't labeled it yet
				if (graph[y] == 0) {
					dfs(y, label);
				}
			} else {
				//if the two are identical when it is supposed to be opposite seed
				if (graph[y] == graph[x]) {
					imp = true;
				}
				//if you haven't labeled it yet
				if (graph[y] == 0) {
					dfs(y, 3 - label);
				}
			}
			
		}
	}
	public static class Edge {
	    int d, w;
	    public Edge(int d, int w) {
	      this.d = d;
	      this.w = w;
	    }
	 }
	public static String baseConverter(long number, int base) {
		char[] charSet = new char[base];
		for (int i = 0; i < charSet.length; i++) {
			switch (i) {
				case 10:
					charSet[i] = 'A';
					break;
				case 11:
					charSet[i] = 'B';
					break;
				case 12:
					charSet[i] = 'C';
					break;
				case 13:
					charSet[i] = 'D';
					break;
				case 14:
					charSet[i] = 'E';
					break;
				case 15:
					charSet[i] = 'F';
					break;
				case 16:
					charSet[i] = 'G';
					break;
				case 17:
					charSet[i] = 'H';
					break;
				case 18:
					charSet[i] = 'I';
					break;
				case 19:
					charSet[i] = 'J';
					break;
				default:
					charSet[i] = (char)(i + '0');
					
			}
		}
		int power = 0;
		String baseRepresentation = "";
		boolean greater = true;
		while (greater) {
			power++;
			if (!(number >= Math.pow(base, power))) {
				power--;
				greater = false;
			}
		}
		while (power != -1) {
			int counter = 0;
			while (number >= Math.pow(base, power)) {
				number -= Math.pow(base, power);
				counter++;
			}
			baseRepresentation += String.valueOf(charSet[counter]);
			power--;
		
		}
		return baseRepresentation;
	}
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
 * NAIVE SOL FIRST TO CHECK AGAINST OPTIMIZED SOL
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */