
import java.io.*;
import java.util.*;
public class traffic {
	
	public static ArrayList<Integer> poss = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int segs = Integer.parseInt(st.nextToken());
		int[][] flows = new int[segs][3];
		
		for (int i = 0; i < segs; i++) {
			st = new StringTokenizer(f.readLine());
			String type = st.nextToken();
			
			//mark main highway as 0, on ramp as 1, off ramp as 2
			if (type.equals("none")) {
				flows[i][0] = 0;
			} 
			if (type.equals("on")) {
				flows[i][0] = 1;
			} 
			if (type.equals("off")) {
				flows[i][0] = 2;
			} 
			flows[i][1] = Integer.parseInt(st.nextToken());
			flows[i][2] = Integer.parseInt(st.nextToken());
		}
		//get range of flow before mile 1
		int min1 = 0;
		int max1 = 0;
		boolean found1 = false;
		for (int i = segs - 1; i > -1; i--) {
			//if found a main highway, keep going until you reach a ramp on or off
			if (found1) {
				if (flows[i][0] == 1) {
					//dont wan't flows to be negative
					if (min1 - flows[i][2] < 0) {
						min1 = 0;
					} else {
						min1 -= flows[i][2];
					}
					if (max1 - flows[i][1] < 0) {
						max1 = 0;
					} else {
						max1 -= flows[i][1];
					}
				}
				if (flows[i][0] == 2) {
					min1 +=  flows[i][1];
					max1 += flows[i][2];
				}
				if (flows[i][0] == 0) {
					min1 = Math.max(flows[i][1], min1);
					max1 = Math.min(flows[i][2], max1);	
				}
			} else {
				if (flows[i][0] == 0) {
					min1 = flows[i][1];
					max1 = flows[i][2];
					found1 = true;
				}
				
			}
			
		}
		out.println(min1 + " " + max1);
		
		//get range of flow after mile N
		int min = 0;
		int max = 0;
		boolean found = false;
		for (int i = 0; i < segs; i++) {
			//if found a main highway, keep going until you reach a ramp on or off
			if (found) {
				if (flows[i][0] == 1) {
					min += flows[i][1];
					max += flows[i][2];
				}
				if (flows[i][0] == 2) {
					//dont wan't flows to be negative
					if (min - flows[i][2] < 0) {
						min = 0;
					} else {
						min -= flows[i][2];
					}
					if (max - flows[i][1] < 0) {
						max = 0;
					} else {
						max -= flows[i][1];
					}
				}
				if (flows[i][0] == 0) {
					min = Math.max(flows[i][1], min);
					max = Math.min(flows[i][2], max);	
				}
			} else {
				if (flows[i][0] == 0) {
					min = flows[i][1];
					max = flows[i][2];
					found = true;
				}
				
			}
			
		}
		
		
		out.println(min + " " + max);
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
