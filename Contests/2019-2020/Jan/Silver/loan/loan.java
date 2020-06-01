import java.io.*;
import java.util.*;


public class loan {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("loan.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long n = Long.parseLong(s.nextToken());
		long k = Long.parseLong(s.nextToken());
		long m = Long.parseLong(s.nextToken());
		//System.out.println(valid(59537, n ,100000, 1));
		out.println(bsearchFunctChange(n, k, m));
		out.close();
	}
	
	public static boolean valid(long x, long n, long k, long m) {
		//solve the inequality to see when given equals M
//		long finished = (m - n) / (-1 * x);
		long prev = 0;
		long gals = 0;
		long days = 0;
		while (k > 0 && gals < n) {
			prev = (n - gals) / x;
//			if (prev <= m) {
//				gals += m * k;
//				return (gals >= n);
//			}
			if(prev < m) {
		      gals += m * k;
		      break;
			}
			//check if it will repeat
			days = ((n - gals) - prev * x ) / prev + 1;
			if (days > k) {
				days = k;
			}
			prev *= days;
			gals += prev;
			k -= days;
		}
		return (gals >= n);
	}
	public static long bsearchFunctChange(long n, long k, long m) {
		long minW = 0;
	    long maxW = n;
	    while(minW != maxW) {
	      long mid = (minW + maxW + 1) / 2;
	      if(valid(mid, n, k, m)) minW = mid;
	      else maxW = mid-1;
	    }
	    if(minW >= n) minW = -1;
	    return minW;
	}
//	public static long bsearchFunctChange(long n, long k, long m) {
//		//insert helper function to calculate value if true or false
//		//returns the first instance of the change in function's output
//		long start = 1;
//		long end = n;
//		
//		boolean initial = valid(1, n, k, m);
//		boolean last = valid(n, n, k, m);
//		//edge case, if both initial and last are true, then max value is just last
//		if (initial == last) {
//			return n;
//		}
//		long index = (start + end) / 2;
//		
//		boolean works = valid(index, n, k, m);
//
//		boolean works1 = valid(index - 1,  n, k, m);
//
//		while (!(works == last && works1 == initial)) {
//			if (end == start + 1) {
//				return -1;
//			}
//			if (works == last) {
//				end = index;
//				index = (start + index) / 2;
//			} else {
//				start = index;
//				index = (start + end) / 2;
//			}
//			works = valid(index, n, k, m);
//			works1 = valid(index - 1, n, k, m);
//		}
//		return index - 1;
//	}
	
	
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