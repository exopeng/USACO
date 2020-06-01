import java.io.*;
import java.util.*;


public class socdist {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		Pair[] li = new Pair[m];
		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(f.readLine());
			long x = Integer.parseInt(s.nextToken());
			long y = Integer.parseInt(s.nextToken());
			li[i] = new Pair(x,y);
		}
		Compare obj = new Compare();
		obj.compareByX(li, li.length);
		out.println(bsearchFunctChange(li, n));
		out.close();
	}
	public static long bsearchFunctChange(Pair[] intervals, int cows) {
		long minW = -1;
	    long maxW = intervals[intervals.length - 1].y;
	    while(minW != maxW) {
	      long mid = (minW + maxW + 1) / 2;
	      if(works(intervals, mid, cows)) minW = mid;
	      else maxW = mid - 1;
	    }
	    return minW;
	}
	public static boolean works(Pair[] intervals, long dist, int cows) {
		long lastPoint = intervals[0].x - dist;
		long currPoint = 0;
		for (int i = 0; i < intervals.length; i++) {
			while (currPoint <= intervals[i].y) {
				currPoint = lastPoint + dist;
				if (currPoint < intervals[i].x) {
					currPoint = intervals[i].x;
				}
				if (cows == 0) {
					return true;
				}
				if (currPoint > intervals[i].y) {
					break;
				}
				cows--;
				lastPoint = currPoint;
			}
		}
		return (cows == 0);
	}
	
	
	// you should actually read the stuff at the bottom
	
}
class Pair {
	long x;
	long y;
	
	public Pair(long first, long second) {
		this.x = first;
		this.y = second;
	}
	public String toString() {
		return (x + "," + y);
	}
	
}
//class to define user defined conparator 
class Compare { 

 void compareByY(Pair arr[], int n) 
 { 
     // Comparator to sort the pair according to second element 
     Arrays.sort(arr, new Comparator<Pair>() { 
         @Override public int compare(Pair p1, Pair p2) 
         { 
             return (int) (p1.y - p2.y); 
         } 
     }); 
 } 

 void compareByX(Pair arr[], int n) 
{ 
    // Comparator to sort the pair according to second element 
    Arrays.sort(arr, new Comparator<Pair>() { 
        @Override public int compare(Pair p1, Pair p2) 
        { 
            return (int) (p1.x - p2.x); 
        } 
    }); 
} 
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