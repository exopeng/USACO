import java.io.*;
import java.util.*;


public class swap {
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static boolean[] finished;
	public static int[] finalCows;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("swap.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		int k = Integer.parseInt(s.nextToken());
		int[][] places = new int[m][2];
		
		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(f.readLine());
			places[i][0] = Integer.parseInt(s.nextToken()) - 1;
			places[i][1] = Integer.parseInt(s.nextToken()) - 1;
		}
		
		int[] cows = new int[n];
		finalCows = new int[n];
		for (int i = 0; i < cows.length; i++) {
			cows[i] = i;
		}
		
		for (int j = 0; j < m; j++) {
			swap(places[j][0], places[j][1], cows);
		}
		
		
		for (int j = 0; j < cows.length; j++ ) {
			map.put(cows[j], j);
			
		}
		System.out.println(map);
		
		for (int i = 0; i < cows.length; i++) {
			cows[i] = i;
		}
		finished = new boolean[n];
		for (int i = 0; i < cows.length; i++) {
			if (!finished[i]) {
				ArrayList<Integer> li = new ArrayList<Integer>();
				int[] swapped = new int[cows.length];
				int counter = 0;
				int curr = i;
				do {
					swapped[map.get(curr)] = i;
					li.add(map.get(curr));
					//System.out.println(Arrays.toString(li.toArray()));
					//error code
					//swapped[curr] = 0;
					curr = map.get(curr);
					counter++;
				} while (swapped[i] != i);
				calcFin(counter, i, k, li);
			}
			
		}
		for (int i = 0; i < n; i++) {
			out.println(finalCows[i] + 1);
		}
		
		out.close();

	}

	public static void calcFin(int cycleLen, int cow, int totalCycles, ArrayList<Integer> li) {
		//System.out.println(Arrays.toString(li.toArray()));
		for (int i = 0; i < li.size(); i++) {
			cow = li.get(i);
			finished[cow] = true;
			finalCows[li.get((i + totalCycles % cycleLen) % cycleLen)] = cow;
		}
	}
	public static void swap(int a1, int a2, int[] arr) {
		int counter = 0;
		for (int j = a1; j <= (a1 + a2) / 2; j++) {
			int temp1 = arr[j];
			int temp2 = arr[a2 - counter];
			arr[j] = temp2;
			arr[a2 - counter] = temp1;
			counter++;
		}
	}
	
	
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, BASH TEST CASES, MAKE MILLIONS
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */