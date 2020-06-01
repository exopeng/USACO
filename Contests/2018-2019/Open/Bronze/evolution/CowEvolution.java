import java.io.*;
import java.util.*;
/* REMINDERS
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */

public class CowEvolution {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("evolution.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int pops = Integer.parseInt(st.nextToken());
		ArrayList<String>[] charas = new ArrayList[pops];
		// initializing 
        for (int i = 0; i < pops; i++) { 
            charas[i] = new ArrayList<String>(); 
        }
		
		for (int i = 0; i < pops; i++) {
			st = new StringTokenizer(f.readLine());
			int chars = Integer.parseInt(st.nextToken());
			while (chars > 0) {
				charas[i].add(st.nextToken());
				chars--;
			}
		}
		
		//sort the arrayLists
		for (int i = 0; i < pops; i++) {
			Collections.sort(charas[i]);
		}
		//then loop through every arrayList, by testing if an arrayList has that characteristic
		//does it have all others? If one of them are true, then it is valid for that, else return improper
		for (int i = 0; i < pops; i++) {
			int counter = 0;
			for (int j = 0; j < charas[i].size(); j++) {
				String character = charas[i].get(j);	
				System.out.print(character + " ");
				boolean valid = true;
				//loop through every other to see if it contains that character then it should contain everything else
				//if it does, then its valid for that character, if not, then it isn't and print NO
				for (int c = 0; c < pops; c++) {
					if (charas[c].contains(character)) {
						//see if the arrays are the same 
						for (int d = 0; d < charas[i].size(); d++) {
							if (!charas[c].contains(charas[i].get(d))) {
								valid = false;
								break;
							}
							//if the arrays are the same,
						}
					}
					//if it doesn't fulfill for that character then try for the next one
					if (!valid) {
						break;
						
					}
					//if all arrayLists fulfill that character, then we are finished for that population
					if (c == pops - 1) {
						counter = 1;
					}
				}
				if (counter == 1) {
					break;
				}
				//if there is no character such that every population fulfills it, then print no
				if (j == charas[i].size() - 1) {
					out.println("no");
					out.close();
					System.exit(0);
				}
			}
			System.out.println();
		}
		//if for every cow that has that characteristic has all the others, than it is proper set
		out.println("yes");
		out.close();

	}
	
	
	
	

}
