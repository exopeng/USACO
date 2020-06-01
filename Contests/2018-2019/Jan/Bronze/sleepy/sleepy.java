import java.io.*;
import java.util.*;
import java.util.Collections;

public class sleepy {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int[] line = new int[cows];
		
		//get input
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < cows;i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		int deep = 0;
		//find how deep in the line is a mismatched pair, like {1,4,2,3}, where 4 and 2 are the mismatched pair, everything before it is irrelevant
		for (int i = 0; i < cows - 1; i++) {
			if (line[i] > line[i + 1]) {
				deep = i + 1;
			}
		}
		
		
		out.println(deep);
		out.close();
	}
	
	
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
