import java.io.*;
import java.util.*;


public class mountains {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int mts = Integer.parseInt(s.nextToken());
		Pair[] peaks = new Pair[mts];
		Pair[] sides = new Pair[mts * 2];
		int counter = 0;
		for (int i = 0; i < mts; i++) {
			s = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			peaks[i] = new Pair(x,y);
			
		}
		Compare obj = new Compare();
		//obj.compareByX(peaks, peaks.length);
		obj.compareByX(peaks, peaks.length);

		//System.out.println(Arrays.toString(peaks));

		for (int i = peaks.length - 1; i > -1; i--) {
			//sides[counter] = new Pair(peaks[i].x + peaks[i].y, peaks.length - 1 - i);
			//sides[counter + 1] = new Pair(peaks[i].x - peaks[i].y, peaks.length - 1 - i);
			sides[counter] = new Pair(peaks[i].x + peaks[i].y, i);
			sides[counter + 1] = new Pair(peaks[i].x - peaks[i].y, i);
			counter += 2;
		}
		
		long ans = mts;
		
		obj.compareByX(sides, sides.length);	
		//System.out.println(Arrays.toString(sides));
		
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>(); 
		
		int boss = sides[0].y;
		map.put(boss, true);
		for (int i = 1; i < sides.length; i++) {
			if (map.containsKey(sides[i].y)) {
				if (sides[i].y != boss) {
					mts--;
					map.put(sides[i].y, false);
				} else {
					if (!queue.isEmpty()) {
						do {
							if (queue.isEmpty()) {
								//if all bosses are exhausted but the sweep isn't finished yet, there still needs to be another boss
								if (i != sides.length - 1) {
									boss = sides[i + 1].y;
									map.put(boss, true);
									i++;

								}
								break;
							}
							boss = queue.poll();
						} while (map.get(boss) == false);
					}
				}
			} else {
				queue.add(sides[i].y);
				map.put(sides[i].y, true);
			}
		}
		out.println(mts);
		out.close();
		
	}
	
	
	// you should actually read the stuff at the bottom
	
	
}
class Pair {
	int x;
	int y;
	
	public Pair(int first, int second) {
		x = first;
		y = second;
	}
	public String toString() {
		return x + "," + y;
	}
	
	
}
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