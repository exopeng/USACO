/*
LANG: JAVA
ID: exopeng1
PROG: milk
*/

import java.io.*;
import java.util.*;
public class milk {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int units = Integer.parseInt(st.nextToken());
		int farmers = Integer.parseInt(st.nextToken());
		int[][] priceAndUnits = new int[farmers][2];
		int[] price = new int[farmers];
		for (int i = 0; i < farmers; i++) {
			st = new StringTokenizer(f.readLine());
			priceAndUnits[i][0] = Integer.parseInt(st.nextToken());
			priceAndUnits[i][1] = Integer.parseInt(st.nextToken());
			price[i] = priceAndUnits[i][0];
		}
		
		
		sortbyColumn(priceAndUnits, 0);
		
		int cost = 0;
		
		for (int i = 0; i < farmers; i++) {
			int supply = priceAndUnits[i][1];
			int costPerUnit = priceAndUnits[i][0];
			int toBuy = 0;
			if (units < supply) {
				toBuy = units;
			} else {
				toBuy = supply;
			}
			cost += toBuy * costPerUnit;
			units -= toBuy;
			if (units == 0) {
				break;
			}
		}
		
		out.println(cost);
		
		out.close();
		
		
	
		
	}
	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
}
