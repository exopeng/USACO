/*
LANG: JAVA
ID: exopeng
PROG: teleport
*/
import java.io.*;
import java.util.*;

public class teleport {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numOfCows = Integer.parseInt(st.nextToken());
		int[] cows = new int[numOfCows];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numOfCows; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer>[] loops = new ArrayList[numOfCows];
		
		Arrays.parallelSort(cows);
		//see what cows are reached when each cow gets a ball
		for (int i = 0; i < numOfCows; i++) {
			int closestCow = 0;
			if (i != 0 && i != numOfCows - 1) {
				if (Math.abs(cows[i] - cows[i - 1]) == Math.abs(cows[i] - cows[i + 1])) {
					closestCow = cows[i - 1];
				}
			} else {
				if (Math.abs(cows[i] - cows[i - 1]) < Math.abs(cows[i] - cows[i + 1])) {
					closestCow = cows[i - 1];
				} else {
					closestCow = cows[i + 1];
				}
			}
			
			ArrayList<Integer> currLoop = new ArrayList<Integer>();
			currLoop.add(cows[i], closestCow);
			ArrayList<Integer> loop = passBall(cows, currLoop, i);
			for (int e = 0; e < loop.size(); e++) {
				loops[i].add(loop.get(e));
			}
			
		}
		
		out.println();
		out.close();

	}
	
	public static ArrayList<Integer> passBall(int[] cows, ArrayList<Integer> loop, int i) {
		//find the last cow which the ball was passed to
		int lastCow = loop.get(loop.size() - 2);
		int cow = loop.get(loop.size() - 1);
		int closestCow = 0;
		
		if (i != 0 && i != cows.length - 1) {
			//if there are two cows equal lengths from the current cow
			if (Math.abs(cows[i] - cows[i - 1]) == Math.abs(cows[i] - cows[i + 1])) {
				closestCow = cows[i - 1];
				i--;
			}
		} else {
			//find which cow is closer to the current cow
			if (Math.abs(cow - cows[i - 1]) < Math.abs(cows[i] - cows[i + 1])) {
				closestCow = cows[i - 1];
				i--;
			} else {
				closestCow = cows[i + 1];
				i++;
			}
		}
		
		loop.add(closestCow);
		if (!(closestCow == lastCow)) {
			passBall(cows, loop, i);
		} 
		
		return loop; 
	}
	
}