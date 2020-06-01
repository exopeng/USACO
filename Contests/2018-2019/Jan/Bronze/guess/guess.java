import java.io.*;
import java.util.*;
import java.util.Collections;

public class guess {
	public static void main(String[] args) throws IOException {
		//compare every two pairs and see what the max number of similar traits is, then the max yeses is max + 1
		//solution below only gets 5 test cases...
		
		BufferedReader f = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int animals = Integer.parseInt(st.nextToken());
		String[][] animalChars = new String[animals][100];
		for (int i = 0; i < animals; i++) {
			st = new StringTokenizer(f.readLine());
			animalChars[i][0] = st.nextToken();
			int chars = Integer.parseInt(st.nextToken());
			//get characteristics
			for (int j = 1; j <= chars; j++) {
				animalChars[i][j] = st.nextToken();
			}
			
		}
		
		//find animal with most characteristics
		int maxChars = 0;
		int maxAnimal = 0;
		for (int i = 0; i < animals; i++) {
			int chars = 0;
			for (int j = 1; j < 100; j++) {
				//break when you reach null
				if (animalChars[i][j] == null) {
					break;
				}
				chars++;
			}
			if (chars > maxChars) {
				maxChars = chars;
				maxAnimal = i;
			}
		}
		
		
		//get the animal and its characterstics array
		String[] animal = new String[maxChars];
		
		
		for (int i = 0; i < maxChars; i++) {
			 animal[i] = animalChars[maxAnimal][i + 1];
		}
		
		ArrayPrinter(animal);
		int maxShared = 0;
		
		//get animal that shares the most characteristics with the max animal
		for (int i = 0; i < animals; i++) {
			int shared = 0;
			
			//make sure not to check against itself
			if (i != maxAnimal) {
				for (int j = 1; j < 100; j++) {
					//break when you reach null
					if (animalChars[i][j] == null) {
						break;
					}
					String chars = animalChars[i][j];
					
					//loop through the maxAnimal's characteristics to see if its equals any of them
					for (int e = 0; e < animal.length; e++) {
						if (chars.equals(animal[e])) {
							shared++;
							break;
						}
					}
				}
				maxShared = Math.max(shared, maxShared);
			}
			
		}
		
		
		System.out.println(maxShared + 1);
		out.close();
	}
	
	
	
	public static void ArrayPrinter(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void ArrayPrinter(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.println(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
