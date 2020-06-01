import java.io.*;
import java.util.*;
import java.util.Collections;

public class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		//make array of ints, with indices representing each cow
		int[] cows = new int[7];
		
		int logs = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < logs; i++) {
			st = new StringTokenizer(f.readLine());
			String cow = st.nextToken();
			int position = whichCow(cow);
			cows[position] += Integer.parseInt(st.nextToken());
		}
		//ArrayPrinter(cows);
		
		//get minimum of cows by copying cows array and sorting it
		int[] cowsSorted = new int[7];
		for (int i = 0; i < cows.length; i++) {
			int temp = cows[i];
			cowsSorted[i] = temp;
		}
		
		Arrays.sort(cowsSorted);
		//ArrayPrinter(cowsSorted);
		int min = cowsSorted[0];
		
		//get second minimum of array by making arrayList and adding values that are not equal to minimum
		ArrayList<Integer> cows2 = new ArrayList<Integer>();
		for (int i = 0; i < cows.length; i++) {
			if (cows[i] != min) {
				cows2.add(cows[i]);
			}
		}
		//arrayListPrinter(cows2);
		
		//edge case if all of them are 0's, then just return tie, as there is no second minimum
		if (cows2.size() == 0) {
			out.println("Tie");
			out.close();
			System.exit(0);
		}
		
		Collections.sort(cows2);
		int min1 = cows2.get(0);
		ArrayList<Integer> cows3 = new ArrayList<Integer>();
		
		//find cows in original array that have that second minimum, if multiple return tie
		for (int i = 0; i < cows.length; i++) {
			if (cows[i] == min1) {
				cows3.add(i);
			}
		}
		
		if (cows3.size() > 1) {
			out.println("Tie");
			out.close();
			System.exit(0);
		}
		
		String cow = "";
		cow = whichIndex(cows3.get(0));
		out.println(cow);
		out.close();
	}
	
	//helper method to determine which index belongs to the cow
	public static void arrayListPrinter(ArrayList<Integer> array ) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i));
		}
		System.out.println();
	}
	public static int whichCow(String name) {
		switch (name) {
			case "Bessie":
				return 0;
			case "Elsie":
				return 1;
			case "Daisy":
				return 2;
			case "Gertie":
				return 3;
			case "Annabelle":
				return 4;
			case "Maggie":
				return 5;
			default:
				return 6;
		
		}
	}
	public static String whichIndex(int index) {
		switch (index) {
		case 0:
			return "Bessie";
		case 1:
			return "Elsie";
		case 2:
			return "Daisy";
		case 3:
			return "Gertie";
		case 4:
			return "Annabelle";
		case 5:
			return "Maggie";
		default:
			return "Henrietta";
	
		}
	}
	public static void ArrayPrinter(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
