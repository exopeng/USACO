import java.io.*;
import java.util.*;
import java.util.Collections;

public class speeding {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] rules = new int[n][2];
		int[][] bessie = new int[m][2];
		
		//get intervals and speed limits of the road
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			rules[i][0] = Integer.parseInt(st.nextToken());
			
			//add last distance, so you have increasing distances and markers
			if (i != 0) {
				rules[i][0] += rules[i - 1][0];
			}
			rules[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//get intervals and speed limits of Bessie
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(f.readLine());
			bessie[i][0] = Integer.parseInt(st.nextToken());
			if (i != 0) {
				bessie[i][0] += bessie[i - 1][0];
			}
			bessie[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		//now compare every point in miles 1-100, and see if there are any violations on Bessie's behalf, if there is take speed limit diff and max
		for (int i = 1; i <= 100; i++) {
			//find interval in rules that contains it, and get the speed limit
			int ruleSpeed = 0;
			
			for (int j = 0; j < n; j++) {
				if (i <= rules[j][0]) {
					ruleSpeed = rules[j][1];
					break;
				}
			}
			
			int bessieSpeed = 0;
			//find interval in bessie that contains it, and get speed limit
			
			for (int e = 0; e < m; e++) {
				if (i <= bessie[e][0]) {
					bessieSpeed = bessie[e][1];
					break;
				}
			}
			
			int diff = bessieSpeed - ruleSpeed;
			
			max = Math.max(diff, max);
		}
		
		
		out.println(max);
		out.close();
	}
	
	
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
