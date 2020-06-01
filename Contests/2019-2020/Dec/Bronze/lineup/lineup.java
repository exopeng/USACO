import java.io.*;
import java.util.*;
import java.util.Collections;

public class lineup {
	public static ArrayList<String[]> lines = new ArrayList<String[]>();
	public static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
		String[] tempcows = new String[] {"Bessie", "Beatrice", "Sue", "Belinda", "Betsy", "Blue", "Bella", "Buttercup"};
		StringTokenizer st = new StringTokenizer(f.readLine());
		ArrayList<String> cows = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			cows.add(tempcows[i]);
		}
		Collections.sort(cows);
		
		//implement what can be earliest by taking cows off this list
		int conns = Integer.parseInt(st.nextToken());
		
		String[][] connections = new String[conns][2];
		//take in connections
		for (int i = 0; i < conns; i++) {
			st = new StringTokenizer(f.readLine());
			connections[i][0] = st.nextToken();
			
			//get rid of filler words
			String crap = st.nextToken();
			String crap1 = st.nextToken();
			String crap2 = st.nextToken();
			String crap3 = st.nextToken();
			
			connections[i][1] = st.nextToken();
			
		}
		//ArrayPrinter(connections);
		
		//just brute force this by trying all possibilities
		String[] lineup = new String[8];
		lineCreater(lineup, 0, cows, connections);
		
		//alphabetically first should be the earliest element in the arraylist
		
		
	}
	public static boolean checker(String[] lineup, String[][] connections) {
		//check restrictions
		for (int i = 0; i < connections.length; i++) {
			String cow1 = connections[i][0];
			String cow2 = connections[i][1];
			
			//check if cow1 is next to cow2
			int cow1Pos = 0;
			int cow2Pos = 0;
			for (int j = 0; j < lineup.length; j++) {
				if (lineup[j].equals(cow1)) {
					cow1Pos = j;
				}
				if (lineup[j].equals(cow2)) {
					cow2Pos = j;
				}
			}
			if (Math.abs(cow1Pos - cow2Pos) != 1) {
				return false;
			}	
		}
		return true;
	}
	//makes a space in a certain position to place the cow
	public static void lineCreater(String[] lineup, int curr, ArrayList<String> cows, String[][] connections) throws IOException {
		if (curr == 8) {
			if (checker(lineup, connections) == true) {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
				for (int i = 0; i < 8; i++) {
					out.println(lineup[i]);
				}
				out.close();
				System.exit(0);
				
			}
		} else {
			for (int i = 0; i < cows.size(); i++) {
				String temp2 = cows.get(i);
				lineup[curr] = temp2;
				//make a new arraylist to copy the stuff back in
				ArrayList<String> temp = new ArrayList<String>();
				for (int j = 0; j < cows.size(); j++) {
					String temp3 = cows.get(j);
					temp.add(temp3);
				}
				temp.remove(i);
				lineCreater(lineup, curr + 1, temp, connections);
			}
		}
		
	}
	public static void ArrayPrinter(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void ArrayPrinter(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(array[i][j]);
				
			}
			System.out.println();
		}
	}
	public static void ArrayListPrinter(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
}
