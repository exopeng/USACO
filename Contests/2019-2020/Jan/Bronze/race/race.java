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

public class race {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("race.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = 0;
		int distance = Integer.parseInt(s.nextToken());
		int cases = Integer.parseInt(s.nextToken());
		
		int[] endTimes = new int[cases];
		
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(f.readLine());
			endTimes[i] = Integer.parseInt(s.nextToken());
		}
		
		for (int i = 0; i < cases; i++) {
			int finAns = 0;
			int endTime = endTimes[i];
			int currDist = distance;
			int speed = 1;
			//keep subtracting and increasing speed until the distance left is less than speed increase + speed increase - 1
			boolean endTimePast = false;
			//System.out.println("EndTime: " + endTime);
			
			while (i == i) {
				if (currDist < (2 * speed - 1)) {
					break;
				}
				if (speed > endTime && !endTimePast) {
					currDist -= endTime + speed;
					endTimePast = true;
					finAns++;
				} else {
					if (speed > endTime + 1) {
						currDist -= speed + speed - 1;
						finAns++;
					} else {
						currDist -= speed;
					}
				}
				finAns++;
				speed++;
				//System.out.println("Distance left: " + currDist + " CurrSpeed: " + speed + " counter: " + finAns);
				
		
				if (currDist == speed && !endTimePast && speed <= endTime) {
					currDist -= speed;
					finAns++;
					break;
				}
			}
			speed--;
			//System.out.println("ans before decelerating: " + finAns);
			//then start from currSpeed - 1 and keep subtracting
			while (currDist > 0) {
				while (currDist < speed) {
					speed--;
				}
				currDist -= speed;
				finAns++;
				//System.out.println("Distance left: " + currDist + " CurrSpeed: " + speed + " counter: " + finAns);
			}
				
			out.println(finAns);
			
		
			
		}
		out.close();

	}
	
	public static int checker(ArrayList<Integer> distances, int finalDist) {
		for (int i = 0; i < distances.size(); i++) {
			if (distances.get(i) >= finalDist) {
				return i;
			}
		}
		//if it doesn't exceed, your good
		return -1;
	}
	public static ArrayList<Integer> calc(ArrayList<Integer> speed) {
		ArrayList<Integer> distances = new ArrayList<Integer>();
		distances.add(speed.get(0));
		for (int j = 1; j < speed.size(); j++) {
			distances.add(distances.get(j - 1) + speed.get(j));
		}
		return distances;
	}
	public static void ArrayListPrinter(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	
	
	
	
	

}
