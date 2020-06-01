import java.io.*;
import java.math.BigDecimal;
import java.util.*;


public class trianglesON {
	public static int n = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;

		int triangles = Integer.parseInt(s.nextToken());
		Pair[] points = new Pair[triangles];
		for (int i = 0; i < triangles; i++) {
			s = new StringTokenizer(f.readLine());
			long x = Long.parseLong(s.nextToken());
			long y = Long.parseLong(s.nextToken());
			points[i] = new Pair(x,y);
		}

		//find the Y-sum;
		HashMap<Pair, Long> map = new HashMap<Pair, Long>();
		Pair[] temp = Arrays.copyOf(points, points.length);
		Compare obj = new Compare();
		obj.compareByX(temp, temp.length);

		long currX = temp[0].x;
		long currCount = 2;
		long lastSum = findYSum(0, temp);
		
		map.put(temp[0], lastSum % (long)(Math.pow(10, 9) + 7));
		for (int i = 1; i < triangles; i++) {
			if (temp[i].x == currX) {
				lastSum = lastSum + (2 * (currCount - 1) - n) * (Math.abs(temp[i].y - temp[i - 1].y)); 
				map.put(temp[i], lastSum % (long)(Math.pow(10, 9) + 7));
				currCount++;
			} else {
				currX = temp[i].x;
				n = 1;
				lastSum = findYSum(i, temp);
				map.put(temp[i], lastSum % (long)(Math.pow(10, 9) + 7));
				currCount = 2;
			}
		}
		
		HashMap<Pair, Long> map1 = new HashMap<Pair, Long>();
		obj.compareByY(temp, temp.length);
		long currY = temp[0].y;
		currCount = 2;
		n = 1;
		lastSum = findXSum(0, temp);
		map1.put(temp[0], lastSum % (long)(Math.pow(10, 9) + 7));
		for (int i = 1; i < triangles; i++) {
			if (temp[i].y == currY) {
				lastSum = lastSum + (2 * (currCount - 1) - n) * (Math.abs(temp[i].x - temp[i - 1].x)); 
				map1.put(temp[i], lastSum % (long)(Math.pow(10, 9) + 7));
				currCount++;
			} else {
				currY = temp[i].y;
				n = 1;
				lastSum = findXSum(i, temp);
				map1.put(temp[i], lastSum % (long)(Math.pow(10, 9) + 7));
				currCount = 2;
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			ans += (map.get(temp[i]) * map1.get(temp[i]))% (long)(Math.pow(10, 9) + 7);
			ans = (long)((ans) % (Math.pow(10, 9) + 7));
		}
		
		//System.out.println(ans);
		out.println((int)((ans) % (Math.pow(10, 9) + 7)));
		out.close();

	}
	public static long findXSum(int currPos, Pair[] arr) {
		long sum = 0;
		for (int i = currPos + 1; i < arr.length; i++) {
			if (arr[i].y == arr[currPos].y) {
				sum += Math.abs(arr[i].x - arr[currPos].x);
				n++;
			} else {
				break;
			}
		}
		return sum;
	}
	public static long findYSum(int currPos, Pair[] arr) {
		long sum = 0;
		for (int i = currPos + 1; i < arr.length; i++) {
			if (arr[i].x == arr[currPos].x) {
				sum += Math.abs(arr[i].y - arr[currPos].y);
				n++;
			} else {
				break;
			}
		}
		return sum;
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

 static void compareByY(Pair arr[], int n) 
 { 
     // Comparator to sort the pair according to second element 
     Arrays.sort(arr, new Comparator<Pair>() { 
         @Override public int compare(Pair p1, Pair p2) 
         { 
             return (int) (p1.y - p2.y); 
         } 
     }); 
 } 

static void compareByX(Pair arr[], int n) 
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