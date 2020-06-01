/*
LANG: JAVA
ID: exopeng1
PROG: ride
*/

import java.io.*;
import java.util.*;

class ride {
	public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    StringTokenizer st1 = new StringTokenizer(f.readLine());
    String comet = st.nextToken();    // first input
    String groupName = st1.nextToken();    // second input
    int cometSum = 1;
    int groupNameSum = 1;
    for (int i = 0; i < comet.length(); i++) {
    	cometSum *= (int)(comet.charAt(i)) - 64;
    }
    for (int i = 0; i < groupName.length(); i++) {
    	groupNameSum *= (int)(groupName.charAt(i)) - 64;
    }
    if (groupNameSum % 47 == cometSum % 47) {
    	out.println("GO");  
    } else {
    	out.println("STAY");
    }
                         
    out.close();                                  
  }
}