/*
LANG: JAVA
ID: exopeng
PROG: mixmilk
*/
import java.io.*;
import java.util.*;


public class factory {
	public static boolean[][] destinations = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("factory.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int stations = Integer.parseInt(st.nextToken());
		
		//indices represent which station has a conveyor belt, indices represent start, value represents if there is a conveyor belt
		boolean[][] conveyors = new boolean[stations][stations];
		for (int i = 0; i < stations - 1; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			conveyors[a - 1][b - 1] = true;
			
		}
		//after we have all the direct destinations, mark all the indirect destinations
		for (int i = 0; i < stations; i++) {
			//look at each walkway it has, and then go to that walkway, see it's walkways, and add them to the station, keep going until no more walkways
			//but first set itself to visited
			destinations[i][i] = true;
			for (int j = 0; j < stations; j++) {
				if (conveyors[i][j]) {
					pathFinders(j, i, conveyors);
				}
			}
		}
		
		ArrayPrinter(destinations);
		int station = -1;
		//check through boolean array to find smallest value that has an all true column
		//if none, print -1
		for (int i = 0; i < stations; i++) {
			for (int j = 0; j < stations; j++) {
				if (!destinations[j][i]) {
					break;
				}
				if (j == stations - 1) {
					station = i + 1;
					out.println(station);
					out.close();
					System.exit(0);
				}
			}
		}
		out.println(station);
		out.close();
	}
	public static void pathFinders(int destination, int start, boolean[][] conveyors) {
		if (!destinations[start][destination]) {
			destinations[start][destination] = true;
			for (int i = 0; i < conveyors[destination].length; i++) {
				if (conveyors[destination][i]) {
					pathFinders(i, start, conveyors);
				}
			}
		}
		//when to stop, when something set is already true;
		
	}
	
	public static void ArrayPrinter(boolean[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
}
