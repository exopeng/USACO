import java.io.*;
import java.util.*;
import java.util.Collections;

public class shell {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("shell.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		char[] shell = new char[3];
		String test = "abc";
		for (int i = 0; i < 3; i++) {
			shell[i] = test.charAt(i);
		}
		
		
		
		
		int swaps = Integer.parseInt(st.nextToken());
		
		int[][] swapMoves = new int[swaps][3];
		//get swaps
		for (int i = 0; i < swaps; i++) {
			st = new StringTokenizer(f.readLine());
			swapMoves[i][0] = Integer.parseInt(st.nextToken()) - 1;
			swapMoves[i][1] = Integer.parseInt(st.nextToken()) - 1;
			swapMoves[i][2] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		int score = 0;
		//watch out for segfaults!!!
		//then for each pebble location, do the swaps
		for (int i = 0; i < 3; i++) {
			
			//constructing array so no segfaults...
			char[] testChar = new char[3];
			for (int c = 0; c < testChar.length; c++) {
				testChar[c] = shell[c];
			}
			
			char pebble = shell[i];
			int counter = 0;
			//start doing the swaps
			for (int j = 0; j < swaps; j++) {
				//swap the shells
				char toSwap1 = testChar[swapMoves[j][0]];
				char toSwap2 = testChar[swapMoves[j][1]];
				
				testChar[swapMoves[j][0]] = toSwap2;
				testChar[swapMoves[j][1]] = toSwap1;
				
				int guess = swapMoves[j][2];
				
				//if guess is right according to bepple location, then add to counter
				if (testChar[guess] == pebble) {
					counter++;
				}
				
			}
			
			score = Math.max(counter, score);
			
		}
		
		out.println(score);
		out.close();
	}
	
	
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
