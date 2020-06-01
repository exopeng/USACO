/*
LANG: JAVA
ID: exopeng
PROG: milkorder
*/

//super stupid problem as this is so ambiguous
//a team of two only wins when both characters are present
//and theoretically a team of two could win with just one character, but then that means there would be 25 winning teams
import java.io.*;
import java.util.*;

public class milkorder {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int[] relativeCows = new int[Integer.parseInt(st.nextToken())];
		int[][] definiteCows = new int[Integer.parseInt(st.nextToken())][2];
		ArrayList<Integer> lowCows = new ArrayList<Integer>();
		ArrayList<Integer> definiteCows1 = new ArrayList<Integer>();
		int[] cowPositions = new int[cows];
		boolean[] hasPosition = new boolean[cows];
		
		//fill in relative cows
		if (relativeCows.length != 0) {
			st = new StringTokenizer(f.readLine());
			for (int i = 0; i < relativeCows.length; i++) {
				relativeCows[i] = Integer.parseInt(st.nextToken());
				hasPosition[relativeCows[i] - 1] = true;
			}
		}

		//fill in definite positions
		for (int i = 0; i < definiteCows.length; i++) {
			st = new StringTokenizer(f.readLine());
			int response = Integer.parseInt(st.nextToken());
			definiteCows[i][0] = response;
			definiteCows1.add(response);
			hasPosition[definiteCows[i][0] - 1] = true;
			definiteCows[i][1] = Integer.parseInt(st.nextToken());
			cowPositions[definiteCows[i][1] - 1] = definiteCows[i][0];
		}
		
		//get all the numbers that are not used
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		for (int i = 0; i < cowPositions.length; i++) {
			if (cowPositions[i] != 0) {
				temp1.add(cowPositions[i]);
			}
		}
		
		ArrayList<Integer> available = new ArrayList<Integer>();
		for (int i = 2; i < cows + 1; i++) {
			if (!(temp1.contains(i))) {
				available.add(i);
			}
		}
		
		//get all possible 1 places
		ArrayList<Integer> places = new ArrayList<Integer>();
		for (int i = 0; i < cowPositions.length; i++) {
			if (cowPositions[i] == 0) {
				places.add(i);
			}
		}
		//make an arrayList of the relative Cows position
		ArrayList<Integer> relative = new ArrayList<Integer>();
		for (int i = 0; i < relativeCows.length; i++) {
			if (!definiteCows1.contains(relativeCows[i]) && relativeCows[i] != 1) {
				relative.add(relativeCows[i]);
			}
		}
		
		//start brute forcing, running through all the possible one positions and see if they fulfill it
		for (int i = 0; i < places.size(); i++) {
			int[] tempPositions = new int[cowPositions.length];
			tempPositions = cowPositions.clone();
			ArrayList<Integer> tempAvail = new ArrayList<Integer>();
			tempAvail = (ArrayList<Integer>) relative.clone();
			tempPositions[places.get(i)] = 1;
			for (int j = 0; j < tempPositions.length; j++) {
				if (tempAvail.size() == 0) {
					break;
				}
				if (tempPositions[j] == 0) {
					tempPositions[j] = tempAvail.get(0);
					tempAvail.remove(0);
				}
			}
			ArrayPrinter(tempPositions);
			if (checker(relativeCows, tempPositions)) {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
				out.println(places.get(i) + 1);
				out.close();
				System.exit(0);
			}
			
		}
		
		
		
	}
	public static boolean checker(int[] positions, int[] cowPositions) {
		int[] indices = new int[positions.length];
		for (int i = 0; i < positions.length; i++) {
			//find index of numbers, and if they are all less than each other, it fulfills it
			for (int j = 0; j < cowPositions.length; j++) {
				if (cowPositions[j] == positions[i]) {
					indices[i] = j;
					break;
				}
			}
			
		}
		for (int i = 0; i + 1 < positions.length; i++) {
			if (!(indices[i] < indices[i + 1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void ArrayListPrinter(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
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
	