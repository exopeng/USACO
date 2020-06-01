/*
LANG: JAVA
ID: exopeng
PROG: blist
*/
import java.io.*;
import java.util.*;
public class revegetate {
	
	public static ArrayList<Integer> poss = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		//get number of pastures
		int pastures = Integer.parseInt(st.nextToken());
		//get number of cows
		int cows = Integer.parseInt(st.nextToken());
		
		int[][] restraints = new int[cows][2];
		//get restraints
		for (int i = 0; i < cows; i++) {
			st = new StringTokenizer(f.readLine());
			restraints[i][0] = Integer.parseInt(st.nextToken());
			restraints[i][1] = Integer.parseInt(st.nextToken());
			//System.out.println(restraints[i][0] + " " + restraints[i][1]);
		}
		
		//ArrayPrinter(restraints);
		
		//make array of array for each pasture, with who it can share a seed with, false if it can, true if it can't
		boolean[][] restrictions = new boolean[pastures][pastures];
		
		for (int i = 0; i < restraints.length; i++) {
			restrictions[restraints[i][0] - 1][restraints[i][1] - 1] = true;
			restrictions[restraints[i][1] - 1][restraints[i][0] - 1] = true;
		}
		
		//make array of array for each pasture, to know what seeds are available
		boolean[][] seeds = new boolean[pastures][4];
		//if a seed is taken as another pasture is shared with it, make it true
		
		String pasture = "";
		
		//go through all the pastures
		for (int d = 0; d < pastures; d++) {
			//go through all the seeds
			for (int i = 1; i < 5; i++) {
				//only use the seed if it is available, ie not restricted
				if (!seeds[d][i - 1]) {
					pasture += "" + i;
					//go through restrictions to see which cannot share a seed with pasture i, and mark that seed off
					for (int j = 0; j < restrictions.length; j++) {
						if (restrictions[j][d]) {
							//go through it's array of potential seeds to cross out that seed
							seeds[j][i - 1] = true;
						}
					}
					break;
				}
				
				
			}
		}
		
		
		out.println(pasture);
		out.close();
	
	}
	
	
	public static void ArrayPrinter(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
