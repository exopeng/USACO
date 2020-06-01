import java.io.*;
import java.util.*;
import java.util.Collections;  
public class lostcow {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int farmerLocation = Integer.parseInt(st.nextToken());
		int cowLocation = Integer.parseInt(st.nextToken());
		boolean cowGreater = false;
		
		if (farmerLocation < cowLocation) {
			cowGreater = true;
		}
		
		ArrayList<Integer> journeys = new ArrayList<Integer>();
		journeys.add(farmerLocation);
		//add to journeys list and calculate distance each time a new thing is added
		//check if that is greater/less than bessie's position, if not, then add to list
		//if greater, take diff between that and bessies pos and then sum up the array sum
		boolean isFound = false;
		boolean add = true;
		int i = 0;
		int newPosition = 0;
		int distance = 0;
		int extra = 0;
		while (!isFound) {
			if (add) {
				newPosition = farmerLocation + (int)Math.pow(2, i); 
				add = false;
			} else {
				newPosition = farmerLocation - (int)Math.pow(2, i); 
				add = true;
			}
			
			distance += Math.abs(journeys.get(journeys.size() - 1) - newPosition);
			journeys.add(newPosition);
			
			//check if greater or less than cow
			if (cowGreater) {
				if (newPosition >= cowLocation) {
					isFound = true;
					extra = Math.abs(newPosition - cowLocation);
				}
			} else {
				if (newPosition <= cowLocation) {
					isFound = true;
					extra = Math.abs(newPosition - cowLocation);
				}
			}
			i++;
			
		}
		
		distance -= extra;
		out.println(distance);
		
		
		out.close();

	}
	public static void ArrayPrinter(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}	
	
	
	
	

}
