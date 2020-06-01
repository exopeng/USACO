/*
LANG: JAVA
ID: exopeng1
PROG: combo
*/
import java.io.*;
import java.util.*;


public class combo {
	public static HashMap<Integer, Boolean>[] map = new HashMap[3];
	public static HashMap<Integer, Boolean>[] map1 = new HashMap[3];
	public static void main(String[] args) throws IOException {
		//intialize hashmap array
		for (int i = 0; i < 3; i++) {
			map[i] = new HashMap<Integer,Boolean>();
		}
		for (int i = 0; i < 3; i++) {
			map1[i] = new HashMap<Integer,Boolean>();
		}
		
		//System.out.println((((-1 % 2) + 2) % 2));
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		
		int max = Integer.parseInt(s.nextToken());
		int[] fj = new int[3];
		int[] m = new int[3];
		
		int diff1 = 0;
		int diff2 = 0;
		
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < 3; i++) {
			fj[i] = Integer.parseInt(s.nextToken());
		}
		
		s = new StringTokenizer(f.readLine());;
		for (int i = 0; i < 3; i++) {
			m[i] = Integer.parseInt(s.nextToken());
		}
		
		
		
		
		//then see for each poss if it also exists in the other set
		solve(fj, max);
		solve1(m, max);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(map[i]);
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(map1[i]);
		}
		long ans = 0;
		if (Arrays.equals(fj, m)) {
			System.out.println("Here");
			out.println(map[0].size() * map[1].size() * map[2].size());
			out.close();
			System.exit(0);
		} else {
			ans = map[0].size() * map[1].size() * map[2].size() + map1[0].size() * map1[1].size() * map1[2].size();
		}
		
		
		int[] poss = new int[3];
		for (int i = 0; i < m.length; i++) {
			if (map[i].containsKey(((((m[i] - 1) % max) + max) % max))) {
				poss[i]++;
			}
			if (map[i].containsKey(((((m[i] - 2) % max) + max) % max))) {
				poss[i]++;
			}
			if (map[i].containsKey(((((m[i] - 3) % max) + max) % max))) {
				poss[i]++;
			}
			if (map[i].containsKey(((((m[i]) % max) + max) % max))) {
				poss[i]++;
			}
			if (map[i].containsKey(((((m[i] + 1) % max) + max) % max))) {
				poss[i]++;
			}
		}
		
		int dups = 1;
		
		for (int i = 0; i < 3; i++) {
			dups *= poss[i];
		}
		
		if (dups >= ans) {
			out.println(ans);
		} else {
			out.println(ans - dups);
		}
		out.close();

	}
	
	public static void solve(int[] arr, int max) {
		//count from 0 to max - 1
		for (int i = 0; i < arr.length; i++) {
			(map[i]).put((((arr[i] - 1) % max) + max) % max, true);
			(map[i]).put((((arr[i] - 2) % max) + max) % max, true);
			(map[i]).put((((arr[i] - 3) % max) + max) % max, true);
			(map[i]).put((((arr[i]) % max) + max) % max, true);
			(map[i]).put((((arr[i] + 1) % max) + max) % max, true);
		}
	}
	public static void solve1(int[] arr, int max) {
		//count from 0 to max - 1
		for (int i = 0; i < arr.length; i++) {
			(map1[i]).put((((arr[i] - 1) % max) + max) % max, true);
			(map1[i]).put((((arr[i] - 2) % max) + max) % max, true);
			(map1[i]).put((((arr[i] - 3) % max) + max) % max, true);
			(map1[i]).put((((arr[i]) % max) + max) % max, true);
			(map1[i]).put((((arr[i] + 1) % max) + max) % max, true);
		}
	}
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
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