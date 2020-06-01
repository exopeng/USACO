import java.io.*;
import java.util.*;
import java.util.Collections;  
public class cownomics {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		
		//read how many rows for each group
		int rows = Integer.parseInt(st.nextToken());
		
		//read how many columns there are 
		int cols = Integer.parseInt(st.nextToken());
		
		//2D array for each group
		char[][] spotty = new char[rows][cols];
		char[][] regular = new char[rows][cols];
		
		//read the genes
		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(f.readLine());
			String temp = (st.nextToken());
			for (int j = 0; j < cols; j++) {
				
				spotty[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(f.readLine());
			String temp = (st.nextToken());
			for (int j = 0; j < cols; j++) {
				
				regular[i][j] = temp.charAt(j);
			}
		}
		
		int distinct = cols;
		//for each column, make arrayList of distinct characters in each group, then compare
		for (int i = 0; i < cols; i++) {
			
			ArrayList<Character> spots = new ArrayList<Character>();
			for (int j = 0; j < rows; j++) {
				if (!(spots.contains(spotty[j][i]))) {
					spots.add(spotty[j][i]);
				}
			}
			ArrayList<Character> regs = new ArrayList<Character>();
			for (int e = 0; e < rows; e++) {
				if (!(regs.contains(regular[e][i]))) {
					regs.add(regular[e][i]);
				}
			}
			
			//then loop through the array to see if they are any same
			if (regs.contains('A') && spots.contains('A') || regs.contains('T') && spots.contains('T') || regs.contains('G') && spots.contains('G') || regs.contains('C') && spots.contains('C')) {
				distinct--;
			}
		}
		
		out.println(distinct);
		
		
		out.close();

	}
	public static void ArrayPrinter(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}	
	
	
	
	

}
