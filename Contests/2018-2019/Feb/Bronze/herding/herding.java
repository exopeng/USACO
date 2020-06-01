/*
LANG: JAVA
ID: exopeng
PROG: blist
*/
import java.io.*;
import java.util.*;
public class herding {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("herding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		//get locations of cows
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int min = 0;
		//sort into array, easier to index
		int[] cows = new int[] {a, b, c};
		Arrays.sort(cows);
		
		//get distances of cows
		int ab = Math.abs(cows[1] - cows[0]) - 1;
		int bc = Math.abs(cows[2] - cows[1]) - 1;
		
		//System.out.println(ab + " " + bc);
		
		//calculate minimum
		if (ab == 0 && bc == 0) {
			out.println(min);
			out.println(max);
			out.close();
			System.exit(0);
		}
		
		if (ab == 1 || bc == 1) {
			min = 1;
		} else {
//			if (ab == 0 && bc > 1 || bc == 0 && ab > 1 || ab > 1 && bc > 1) {
//				min = 2;
//			} else {
//				min = 2;
//			}
			min = 2;
			
			
		}
		
		//calculate maximum
		//handled sorted cows
		
		max = Math.max(ab, bc);
		
		
		out.println(min);
		out.println(max);
		out.close();
	
	}
	public static void ArrayPrinter(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
