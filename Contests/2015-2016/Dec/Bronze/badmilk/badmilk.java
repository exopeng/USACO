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

public class badmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		long ans = Integer.MIN_VALUE;
		int people = Integer.parseInt(s.nextToken());
		int milks = Integer.parseInt(s.nextToken());
		int drinks = Integer.parseInt(s.nextToken());
		int sicks = Integer.parseInt(s.nextToken());
		
		//sick log
		int[][] sickLog = new int[sicks][2];
		//index 0 stores the person, index 1 stores the time
		
		
		//drink logs
		int[][] drinkLog = new int[drinks][3];
		//index 0 stores the person, index 1 stores the milk, and index 2 stores the time
		
		for (int i = 0; i < drinks; i++) {
			s = new StringTokenizer(f.readLine());
			drinkLog[i][0] = Integer.parseInt(s.nextToken());
			drinkLog[i][1] = Integer.parseInt(s.nextToken());
			drinkLog[i][2] = Integer.parseInt(s.nextToken());
		}
		
		for (int i = 0; i < sicks; i++) {
			s = new StringTokenizer(f.readLine());
			sickLog[i][0] = Integer.parseInt(s.nextToken());
			sickLog[i][1] = Integer.parseInt(s.nextToken());
		}
		
 		for (int i = 1; i < milks + 1; i++) {
 			int meds = 0;
 			int[] drinkers = new int[people + 1];
 			//indices represent the drinker
 			//value represents the time
 			//max the size of array, and when you reach 0 stop
 			
 			for (int j = 0; j < drinks; j++) {
 				if (drinkLog[j][1] == i) {
 					//remember to take the earliest time someone drank the milk
 					int person = drinkLog[j][0];
 					int time = drinkLog[j][2];
 					if (drinkers[person] != 0) {
 						drinkers[person] = Math.min(drinkers[person], time);
 					} else {
 						drinkers[person] = time;
 						meds++;
 					}
 					
 					
 				}
 			}
 			
 			for (int j = 0; j < sicks; j++) {
 				int sickPerson = sickLog[j][0];
 				int sickTime = sickLog[j][1];
 				//first condition for not being a bad milk is if a person who got sick didn't drink it
 				//second condition for not being a bad milk is if a person got sick before drinking it
 				if (drinkers[sickPerson] == 0 || drinkers[sickPerson] > sickTime) {
 					break;
 				}
 
 				//when reach the end of sicklog, tally up the people
 				if (j == sicks - 1) {
 					ans = Math.max(ans, meds);
 				}
 				
 			}
 			//System.out.println(meds);
 			
 			
 		}
 		
 		//another edge case, is if everybody drinks that milk but they get sick in the end
 		//edge case, if somebody gets sick but before he drinks any milk, print 1
// 		if (ans < 0) {
// 			out.println(1);
// 		}
 		
		out.println(ans);
		
		out.close();

	}
	
	
	
	

}
