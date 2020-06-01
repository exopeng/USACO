/*
LANG: JAVA
ID: exopeng
PROG: taming
*/
import java.io.*;
import java.util.*;

public class taming {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("taming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[] log = new int[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < log.length; i++) {
			log[i] = Integer.parseInt(st.nextToken());
		}
		
		//check for the contradiction of day not being 0 or -1
		if (log[0] != -1 && log[0] != 0) {
			out.println(-1);
			out.close();
			System.exit(0);
		}
		log[0] = 0;
		//check for "bad" logs
		for (int i = 1; i < log.length; i++) {
			if (log[i - 1] == 0 ) {
				if (log[i] != 0 && log[i] != 1 && log[i] != -1) {
					out.println(-1);
					out.close();
					System.exit(0);
				}
			}
		}
		
		
		//go through the array to fill out what we know based on logs, if a breakout occured on that day, then log is 0
		
		int minBreakouts = 0;
		
		for (int i = 1; i < log.length; i++) {
			if (log[i] != -1 && log[i] != 0) {
				int days = log[i];
				for (int j = 1; j < days + 1; j++) {
					if (log[i - j] != days - j && log[i - j] != -1) {
						out.println(-1);
						out.close();
						System.exit(0);
					} else {
						log[i - j] = days - j;
					}
					
				}
			}
		}
		
		//get all 0' s which mean breakouts
		for (int i = 0; i < log.length; i++) {
			if (log[i] == 0) {
				minBreakouts++;
			}
		}
		
		ArrayPrinter(log);
		int maxBreakouts = minBreakouts;
		//if a log entry is -1, then see what was before it, if it was 0, then that entry is uncertain as it may be 0 or 1, depending on if a breakout occured that day
		for (int i = 1; i < log.length; i++) {
			if (log[i] == -1) {
				//see how many before it is -1
				maxBreakouts++;
//				int before = log[i-1];
//				if (before == 0 || before == -1) {
//					maxBreakouts++;
//				}
			}
		}
		out.println(minBreakouts + " " + maxBreakouts);
		
		out.close();

	}
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}	
	
}
	