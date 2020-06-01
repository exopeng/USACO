import java.io.*;
import java.util.*;
import java.util.Collections;

public class gymnastics {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int sessions = Integer.parseInt(st.nextToken());
		int cows = Integer.parseInt(st.nextToken());
		
		int[][] rankings = new int[sessions][cows];
		//get rankings into a 2D array
		for (int i = 0; i < sessions; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < cows; j ++) {
				rankings[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//for each cow, compare to all the other cows
		int consecutivePairs = 0;
		
		for (int i = 0; i < cows; i++) {
			int cow = i + 1;
			//only need to check against the cows after it
			for (int j = i + 1; j < cows; j++) {
				int toCheck = j + 1;
				boolean valid = true;
				//see if the cow needs to be first or the other needs to be first, setting initial condition
				boolean first = true;
				for (int c = 0; c < rankings[0].length; c++) {
					if (rankings[0][c] == toCheck) {
						first = false;
						break;
					}
					if (rankings[0][c] == cow) {
						break;
					}
				}
				
				//then go through rankings to see if the rest fulfill the condition
				for (int c = 0; c < sessions; c++) {
					for (int e = 0; e < cows; e++) {
						if (first) {
							//if you get to the cow first, then your good, you can stop checking, else if you get to toCheck first, then its not a valid pair
							if (rankings[c][e] == cow) {
								break;
							}
							if (rankings[c][e] == toCheck) {
								valid = false;
								break;
							}
						} 
						if (!first) {
							//if you get to the toCheck first, then your good, you can stop checking, else if you get to cow first, then its not a valid pair
							if (rankings[c][e] == toCheck) {
								break;
							}
							if (rankings[c][e] == cow) {
								valid = false;
								break;
							}
						}
							
						
					}
					//if one of these don't follow the initial condition, then the pair of cows isn't a consistent pair
					if (!valid) {
						break;
					}
					//if it makes it past all the sessions and the initial condition holds, then add one to consecutive pairs
					if (c == sessions - 1) {
						consecutivePairs++;
					}
					
				}
				
			}
		}
		
		
		out.println(consecutivePairs);
		out.close();
	}
	
	
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
