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

public class cowsignal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int rows = Integer.parseInt(s.nextToken());
		int cols = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		
		char[][] sig = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			s = new StringTokenizer(f.readLine());
			String temp = s.nextToken();
			for (int j = 0; j < cols; j++) {
				sig[i][j] = temp.charAt(j);
			}
			//do the printing
			for (int j = 0; j < k; j++) {
				for (int c = 0; c < cols; c++) {
					for (int b = 0; b < k; b++) {
						out.print(sig[i][c]);
					}
				}
				out.println();
			}
		}
		
		
		//out.println();
		out.close();

	}
	
	
	
	

}
