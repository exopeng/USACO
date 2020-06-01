/*
LANG: JAVA
ID: exopeng
PROG: hoofball
*/
import java.io.*;
import java.util.*;

public class hoofball {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numOfCows = Integer.parseInt(st.nextToken());
		int[] cows = new int[numOfCows];
		st = new StringTokenizer(f.readLine());
		int[][] adjacency = new int[numOfCows][numOfCows];
		for (int i = 0; i < numOfCows; i++) {
			int response = Integer.parseInt(st.nextToken());
			cows[i] = response;
		}
		Arrays.sort(cows);
		
		//see what cows are reached when each cow gets a ball
		for (int i = 0; i < numOfCows; i++) {
			int closestCow = 0;
			if (i != 0 && i != numOfCows - 1) {
				if (Math.abs(cows[i] - cows[i - 1]) == Math.abs(cows[i] - cows[i + 1])) {
					closestCow = cows[i - 1];
					adjacency[i][i - 1] = 1;
				} else {
					if (Math.abs(cows[i] - cows[i - 1]) < Math.abs(cows[i] - cows[i + 1])) {
						closestCow = cows[i - 1];
						adjacency[i][i - 1] = 1;
					} else {
						closestCow = cows[i + 1];
						adjacency[i][i + 1] = 1;
					}
				}
			} else {
				if (i == 0) {
					closestCow = cows[i + 1];
					adjacency[i][i + 1] = 1;
				} else {
					closestCow = cows[i - 1];
					adjacency[i][i - 1] = 1;
				}
			}
		}
		//see how many cows are never passed a ball
		ArrayPrinter(adjacency);
		int currentBalls = 0;
		for (int i = 0; i < adjacency.length; i++) {
			for (int j = 0; j < adjacency.length; j++) {
				if (adjacency[j][i] == 1) {
					System.out.println("Ball at " + j + " has a passer at " + i);
					break;
				}
				if (j == adjacency.length - 1) {
					currentBalls++;
					System.out.println("Ball " + i + " is a source, current balls is " + currentBalls );
				}
			}
		}
		
		//check pairs that only pass to each other
		for (int i = 0; i < adjacency.length - 1; i++) {
			int pairs1 = 0;
			int pairs2 = 0;
			int pairs2pos = 0;
			for (int j = 0; j < adjacency.length; j++) {
				if (adjacency[j][i] == 1) {
					pairs1++;
				}
				if (j == adjacency.length - 1) {
					if (pairs1 == 1) {
						for (int e = 0; e < adjacency.length; e++) {
							if (adjacency[e][i + 1] == 1) {
								pairs2++;
								pairs2pos = e;
							}
							if (e == adjacency.length - 1 && pairs2 == 1 && pairs2pos == i) {
								currentBalls++;
								System.out.println("ball " + i + " & ball " + (i + 1) + " are pairs" + " current balls " + currentBalls);
								i++;
							}
						}
					}
					
				}
			}
			
			
		}
		
		System.out.println(currentBalls);
		
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
	
	
}
	