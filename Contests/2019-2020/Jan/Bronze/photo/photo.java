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

public class photo {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int aNums = Integer.parseInt(s.nextToken());
		int[] bs = new int[aNums - 1];
		
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < bs.length; i++) {
			bs[i] = Integer.parseInt(s.nextToken());
		}
		
		//start from a1 = 1, then check if it is a permutation, meaning each number cannot appear more than once, keep hashmap to check if something has appeared
		for (int i = 1; i < bs[0]; i++) {
			HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>();
			int[] as = new int[aNums];
			as[0] = i;
			hmap.put(as[0], true);
			for (int j = 1; j < aNums; j++) {
				as[j] = bs[j - 1] - as[j - 1];
				//make sure to limit so that all elements in the permutation fall in the range 1...N
				if (hmap.containsKey(as[j]) || as[j] > aNums ) {
					break;
				}
				hmap.put(as[j], true);
				if (j == aNums - 1) {
					for (int c = 0; c < as.length; c++) {
						if (c == as.length - 1) {
							out.println(as[c]);
						} else {
							out.print(as[c] + " ");
						}
						
						
					}
					out.close();
					System.exit(0);
				}
			}
			ArrayPrinter(as);
			
			
			
		}

	}
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	

}