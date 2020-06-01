import java.io.*;
import java.util.*;


public class cereal {
	public static int[] cereal;
	public static int[][] p;
	public static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		cereal = new int[m];
		for (int i = 0; i < m; i++) {
			cereal[i] = -1;
		}
		p = new int[n][2];
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(s.nextToken()) - 1;
			int y = Integer.parseInt(s.nextToken()) - 1;
			p[i][0] = x;
			p[i][1] = y;
		}
		int[] cows = new int[n];
		ans = 0;
		int[] fin = new int[n];
		for (int i = cows.length - 1; i > -1; i--) {
			//get first choice
			ans++;
			int fc = p[i][0];
			//check who has it, if any
			if (cereal[fc] != -1) {
				rec(cereal[fc], fc);
			} 
			cereal[fc] = i;
			fin[i] = ans;
		}
		for (int i = 0; i < fin.length; i++) {
			out.println(fin[i]);
		}
		out.close();
	}
	public static void rec(int cow, int takenCereal) {
		if (takenCereal == p[cow][0]) {
			//if it's first choice was taken, then get it's second choice if the cow holding is is after it or no one holds it
			int sec = p[cow][1];
			//it can only gain it's second cereal if no one has taken it or the cow who took it is later in line
			if (cereal[sec] == -1 || cereal[sec] > cow) {
				//ans++;
				if (cereal[sec] > cow) {
					int temp = cereal[sec];
					cereal[sec] = cow;
					//recurse further for the cow whose cereal was taken by the current cow
					rec(temp, sec);
				} else {
					cereal[sec] = cow;
				}
			} else {
				//if the cow who has it is earlier in line, than there is no way to gain that cereal
				ans--;
			}
		} else {
			//if not first choice, then there is no recourse
			ans--;
		}
	}
	
	
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