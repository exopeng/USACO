/*
LANG: JAVA
ID: exopeng
PROG: outofplace
*/
import java.io.*;
import java.util.*;

public class outofplace {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int heights = Integer.parseInt(st.nextToken());
		int[] line = new int[heights];
		int[] comparisonLine = new int[heights];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < heights; i++) {
			st = new StringTokenizer(f.readLine());
			int place = Integer.parseInt(st.nextToken());
			line[i] = place;
			comparisonLine[i] = place;
		}
		
		Arrays.parallelSort(comparisonLine);
		int swaps = -1;
		for (int i = 0; i < heights; i++) {
			if (comparisonLine[i] != line[i]) {
				swaps++;
			}
		}
		swaps = Math.max(0, swaps);
		
		
		
		
		out.println(swaps);
		out.close();

	}
}
