/*
LANG: JAVA
ID: exopeng
PROG: mixmilk
*/
import java.io.*;
import java.util.*;


public class mixmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		int[][] buckets = new int[3][2];
		
		for (int i = 0; i < buckets.length; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			buckets[i][0] = Integer.parseInt(st.nextToken());
			buckets[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 100; i++) {
			int maxReceive = buckets[(i + 1) % 3 ][0] - buckets[(i + 1) % 3 ][1];
			int toGive = buckets[i % 3][1];
			if (toGive > maxReceive) {
				buckets[(i + 1) % 3 ][1] += maxReceive; 
				buckets[i % 3][1] = toGive - maxReceive;
			} else {
				buckets[(i + 1) % 3 ][1] += toGive;
				buckets[i % 3][1] = 0;
			}
			//ArrayPrinter(buckets);
			
		}
		
		for (int i = 0; i < buckets.length; i++) {
			out.println(buckets[i][1]);
		}
		
		
		
		out.close();
	}
	
	public static void ArrayPrinter(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][1] + " ");
			
		}
		System.out.println();
		
	}
}
