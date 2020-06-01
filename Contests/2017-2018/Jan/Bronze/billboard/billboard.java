/*
LANG: JAVA
ID: exopeng
PROG: billboard
*/
import java.io.*;
import java.util.*;

public class billboard {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lawnXLower = Integer.parseInt(st.nextToken());
		int lawnYLower = Integer.parseInt(st.nextToken());
		int lawnXUpper = Integer.parseInt(st.nextToken());
		int lawnYUpper = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(f.readLine());
		int feedXLower = Integer.parseInt(st.nextToken());
		int feedYLower = Integer.parseInt(st.nextToken());
		int feedXUpper = Integer.parseInt(st.nextToken());
		int feedYUpper = Integer.parseInt(st.nextToken());
		
		int area = 0;
		int lawnArea = (lawnXUpper - lawnXLower) * (lawnYUpper - lawnYLower);
		
		//case 1, all four corners of the lawn is covered
		if (feedXUpper >= lawnXUpper && feedYUpper >= lawnYUpper && feedXLower <= lawnXLower && feedYLower <= lawnYLower ) {
			area = 0;
		} else {
			//case 2, two corners are covered, so only have to get remaining portion
			if (feedYLower < lawnYUpper && feedYUpper >= lawnYUpper && feedXLower <= lawnXLower && feedXUpper >= lawnXUpper) {
				//System.out.println("I got here");
				area = (feedYLower - lawnYLower) * (lawnXUpper - lawnXLower);
			} else {
				if (feedYUpper > lawnYLower && feedYLower <= lawnYLower && feedXLower <= lawnXLower && feedXUpper >= lawnXUpper) {
					area = (lawnXUpper - lawnXLower) * (feedYUpper - lawnYLower);
				} else {
					if (feedXUpper > lawnXLower && feedXLower <= lawnXLower && feedYUpper >= lawnYUpper && feedYLower <= lawnYLower) {
						area = (lawnXUpper - feedXUpper) * (lawnYUpper - lawnYLower);
					} else {
						if (feedXLower < lawnXUpper && feedXUpper >= lawnXUpper && feedYUpper >= lawnYUpper && feedYLower <= lawnYLower) {
							area = (lawnXUpper - feedXLower) * (feedYUpper - feedYLower);
						} else {
							//case 3, partially covered but only one corner
							area = lawnArea;
						}
					}
				}
			}
			
		}
		
		System.out.println(area);
		out.close();

	}
}
