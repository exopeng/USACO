import java.io.*;
import java.util.*;
import java.util.Collections;

public class whereami {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int characters = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		String boxes = st.nextToken();
		
		//start with length 1, then keep increasing if the ones before it doesnt work
		for (int i = 1; i <= characters; i++) {
			String toCheck = boxes.substring(0, i);
			//System.out.println("What we are checking " + toCheck);
			//then go down the array until the last character of the checking is the last character of the boxes
			int start = 1;
			int end = start + i;
			ArrayList<String> dict = new ArrayList<String>();
			dict.add(toCheck);
			while (end <= characters) {
				String comp = boxes.substring(start, end);
				//System.out.println(comp);
				if (dict.contains(comp)) {
					break;
				} else {
					dict.add(comp);
				}
					
				//System.out.println("Start: " + start + " End: " + end);
				
				if (end == characters) {
					out.println(i);
					out.close();
					System.exit(0);
				}
				start++;
				end++;
			}
		}
		out.println(characters);
		out.close();
		
		
		
		
	}
	
	
	
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
