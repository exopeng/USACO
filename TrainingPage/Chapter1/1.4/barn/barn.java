

/*
LANG: JAVA
ID: exopeng1
PROG: barn1
*/
import java.io.*;
import java.util.*;
import java.util.Arrays;

public class barn {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int boards = Integer.parseInt(st.nextToken());
		
		int stalls = Integer.parseInt(st.nextToken());
		
		int cows = Integer.parseInt(st.nextToken());
		
		int[] stallNumbers = new int[cows];
		
		int stallsCovered = cows;
		
		int currBoards = cows;
		
		for (int i = 0; i < cows; i++) {
			st = new StringTokenizer(f.readLine());
			stallNumbers[i] = Integer.parseInt(st.nextToken());
			
		}
	
		Arrays.sort(stallNumbers);
		
		int[] diffList = new int[stallNumbers.length - 1];
		
		for (int i = 1; i < stallNumbers.length; i++) {
			int diff = stallNumbers[i] - stallNumbers[i - 1];
			diffList[i - 1] = diff;
		}
		Arrays.sort(diffList);
		
		for (int i = 0; i < diffList.length; i++) {
			System.out.print(diffList[i] + " ");
		}
		
		for (int i = 0; i < diffList.length; i++) {
			currBoards--;
			if (!(diffList[i] == 1)) {
				stallsCovered += diffList[i] - 1;
			}
			
			if (currBoards == 4) {
				break;
			}
		}
		
		out.println(stallsCovered);
		
		out.close();
		
		
		
	}
}

