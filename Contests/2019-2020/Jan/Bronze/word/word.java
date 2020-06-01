
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

public class word {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("word.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		ArrayList<String> words = new ArrayList<>();
		int wordCount = Integer.parseInt(s.nextToken());
		int chars = Integer.parseInt(s.nextToken());
		
		
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < wordCount; i++) {
			words.add(s.nextToken());
		}
		
		//ArrayListPrinterString(words);
		while (words.size() > 0) {
			int limit = chars;
			String currLine = "";
			currLine += words.get(0);
			limit -= words.get(0).length();
			words.remove(0);
			
			while (limit > 0) {
				if (words.size() <= 0 || limit - words.get(0).length() < 0) {
					break;
				}
				currLine += " " + words.get(0);
				limit -= words.get(0).length();
				words.remove(0);
			}
			out.println(currLine);
		}
		out.close();

	}
	public static void ArrayListPrinterString(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	
	

}
