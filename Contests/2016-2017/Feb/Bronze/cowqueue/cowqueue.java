import java.io.*;
import java.util.*;
/* REMINDERS
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */

public class cowqueue {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int cows = Integer.parseInt(s.nextToken());
		int[] entries = new int[cows];
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < cows; i++) {
			s = new StringTokenizer(f.readLine());
			int entry = Integer.parseInt(s.nextToken());
			map.put(entry, Integer.parseInt(s.nextToken()));
			entries[i] = entry;
		}
		
		//sort the array by increasing time of entry
		int[][] times  = sorter(entries, map);
		//ArrayPrinter(times);
		//then process first cow, and then add to time
		//check then with new time, if any cows entered before or at the new time, if there was, add to new time
		//after reaching a cow that entered after the new time, set new time to that and then add the wait, repeat
		long newTime = times[0][0] + times[0][1];
		for (int i = 1; i < times.length; i++) {
			if (times[i][0] <= newTime) {
				newTime += times[i][1];
			} else {
				newTime = times[i][0] + times[i][1];
			}
			
		}
		
		out.println(newTime);
		out.close();

	}
	
	public static int[][] sorter(int[] entries, HashMap<Integer, Integer> map) {
		int[][] times = new int[entries.length][2];
		Arrays.sort(entries);
		for (int i = 0; i < entries.length; i++) {
			times[i][0] = entries[i];
			times[i][1] = map.get(entries[i]);
		}
		
		return times;
	}
	public static void ArrayPrinter(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	

}
