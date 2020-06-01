import java.io.*;
import java.util.*;


public class mooyomooyo {
	public static int[][] arr;
	public static boolean[][] visited; 
	public static int counter = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		arr = new int[n][10];
		visited = new boolean[n][10];
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(f.readLine());
			String temp = s.nextToken();
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
			}
		}
		
		floodfill(k);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				out.print(arr[i][j]);
			}
			out.println();
		}
		out.close();

	}
	public static void gravity() {
		for (int i = arr.length - 1; i > -1; i--) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 0) {
					bringDown(i, j);
				}
			}
		}
	}
	public static void bringDown(int i, int j) {
		for (int e = i - 1; e > - 1; e--) {
			if (arr[e][j] != 0) {
				int temp = arr[e][j];
				arr[i][j] = temp;
				arr[e][j] = 0;
				break;
			}
		}
	}
	public static void floodfill(int k) {
		int[][] temp = new int[arr.length][10];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = Arrays.copyOf(arr[i], 10);
		}
		visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				counter = 0;
				dfs(i,j, k);
			}
		}
		boolean finished = true;
		for (int i = 0; i < arr.length; i++) {
			if (!Arrays.equals(temp[i], arr[i])) { 
				  finished = false;
			 }
		}
		if (!finished) {
			/*
			 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[0].length;
			 * j++) { System.out.print(arr[i][j]); } System.out.println(); }
			 * System.out.println();
			 */
			gravity(); 
			/*
			 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[0].length;
			 * j++) { System.out.print(arr[i][j]); } System.out.println(); }
			 * System.out.println();
			 */
			floodfill(k); 
		}
	  
		 
	}
	public static void dfs(int i, int j, int k) {
		int initial = arr[i][j];
		visited[i][j] = true;
		if (initial != 0) {
			counter++;
			if (j + 1 != arr[0].length && arr[i][j + 1] == initial && !visited[i][j + 1]) {
				dfs(i, j + 1, k);
			}
			if (j - 1 != -1 && arr[i][j - 1] == initial && !visited[i][j - 1]) {
				dfs(i, j - 1, k);

			}
			if (i + 1 != arr.length && arr[i + 1][j] == initial && !visited[i + 1][j]) {
				dfs(i + 1, j, k);

			}
			if (i - 1 != -1 && arr[i - 1][j] == initial && !visited[i - 1][j]) {
				dfs(i - 1, j, k);

			}
			if (counter >= k) {
				if (arr[i][j] != 0) {
					dfs2(i, j, arr[i][j]);
					//go back and make all of the same color 0
				}
				
			}
		}
		
	}
	public static void dfs2(int i, int j, int initial) {
		arr[i][j] = 0;
		if (j + 1 != arr[0].length && arr[i][j + 1] == initial) {
			dfs2(i, j + 1, initial);
		}
		if (j - 1 != -1 && arr[i][j - 1] == initial) {
			dfs2(i, j - 1, initial);

		}
		if (i + 1 != arr.length && arr[i + 1][j] == initial ) {
			dfs2(i + 1, j, initial);

		}
		if (i - 1 != -1 && arr[i - 1][j] == initial ) {
			dfs2(i - 1, j, initial);

		}
		
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