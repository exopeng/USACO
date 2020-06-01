import java.io.*;
import java.util.*;


public class perimeter {
	public static char[][] arr;
	public static boolean[][] visited; 
	public static long area = 0;
	public static long perimeter = 0;
	public static long ansArea = 0;
	public static long ansPerim = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int dim = Integer.parseInt(s.nextToken());
		arr = new char[dim][dim];
		visited = new boolean[dim][dim];
		for (int i = 0; i < dim; i++) {
			s = new StringTokenizer(f.readLine());
			String temp = s.nextToken();
			for (int j = 0; j < dim; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		floodfill();
		out.println(ansArea + " " + ansPerim);
		out.close();
	}
	public static void floodfill() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				area = 0;
				perimeter = 0;
				if (!visited[i][j] && arr[i][j] == '#') {
					dfs(i,j);
					if (area >= ansArea) {
						//ansArea = Math.max(ansArea, area);
						//ansPerim = Math.max(ansPerim, perimeter);
						  if (area == ansArea && perimeter < ansPerim) { 
							  ansPerim = perimeter; 
						  } 
						  if (area > ansArea) { 
							  ansArea = area; 
							  ansPerim = perimeter; 
						  }
						 
					}
				}
			}
		}
	}
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		char initial = arr[i][j];
		area++;
		if (j - 1 == -1 || arr[i][j - 1] == '.' ) {
			perimeter++;
		}
		if (j + 1 == arr[0].length || arr[i][j + 1] == '.' ) {
			perimeter++;
		}
		if (i + 1 == arr.length || arr[i + 1][j] == '.') {
			perimeter++;

		}
		if (i - 1 == -1 || arr[i-1][j] == '.') {
			perimeter++;

		}
		if (j + 1 != arr[0].length && arr[i][j + 1] == initial && !visited[i][j + 1]) {
			dfs(i, j + 1);
		} 
		if (j - 1 != -1 && arr[i][j - 1] == initial && !visited[i][j - 1]) {
			dfs(i, j - 1);
		} 
		if (i + 1 != arr.length && arr[i + 1][j] == initial && !visited[i + 1][j]) {
			dfs(i + 1, j);
		}
		if (i - 1 != -1 && arr[i - 1][j] == initial && !visited[i - 1][j]) {
			dfs(i - 1, j);
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