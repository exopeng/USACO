import java.io.*;
import java.util.*;

//USE BFS

public class wormsort {
	public static ArrayList<Edge>[] holes;
	public static int[] pos;
	public static int[] component;
	public static class Edge {
	    int conn, weight;
	    public Edge(int d, int w) {
	      conn = d;
	      weight = w;
	    }
	}
	
	public static int bsearchFunctChange(int[] arr) {
		//insert helper function to calculate value if true or false
		//returns the first instance of the change in function's output
		
		boolean initial = valid(arr[0]);
		boolean last = valid(arr[arr.length - 1]);
		//edge case, if both initial and last are true, then max value is just last
		if (initial == last) {
			return arr[arr.length - 1];
		}
		
		int start = 0;
		int end = arr.length;
		int index = (start + end) / 2;
		
		boolean works = valid(arr[index]);

		boolean works1 = valid(arr[index - 1]);

		while (!(works == last && works1 == initial)) {
			if (end == start + 1) {
				return -1;
			}
			if (works == last) {
				end = index;
				index = (start + index) / 2;
			} else {
				start = index;
				index = (start + end) / 2;
			}
			works = valid(arr[index]);
			works1 = valid(arr[index - 1]);
		}
		
		
		return arr[index - 1];
	}
	
	public static boolean valid(int width) {
		//fulf keeps track of which cows can reach their destination 
		//floodfill the array, then after each floodfill, see if both of the cows in component are marked as true, which means they are in the same component
		int label = 1;
		component = new int[pos.length];
		for (int i = 0; i < pos.length; i++) {
			//if it hasn't been visited yet
			if (component[i] == 0) {
				bfs(i, label, width);
				label++;
			}
			
		}
		
		//after floodfilling entire array, check to see if all of fulf = true
		for (int i = 0; i < component.length; i++) {
			if (component[i] != component[pos[i]]) {
				return false;
			}
		}
		return true;
	}
	
	public static void bfs(int s, int label, int weight) 
    { 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        component[s] = label;
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            //System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Edge> i = holes[s].listIterator(); 
            while (i.hasNext()) 
            { 
                Edge n = i.next(); 
                if (n.weight >= weight) {
                    if (component[n.conn] != label) 
                    { 
                    	//set this location in the component as reachable
                    	component[n.conn] = label;
                        queue.add(n.conn); 
                        
                    } 
                }
                
            } 
        } 
    } 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
		StringTokenizer s = new StringTokenizer(f.readLine());
		int cows = Integer.parseInt(s.nextToken());
		int h = Integer.parseInt(s.nextToken());
		holes = new ArrayList[h];
		for (int i = 0; i < holes.length; i++) {
			holes[i] = new ArrayList<Edge>();
		}
		
		pos = new int[cows];
		
		component = new int[pos.length];
		
		s = new StringTokenizer(f.readLine());
		for (int i = 0; i < cows; i++) {
			pos[i] = Integer.parseInt(s.nextToken()) - 1;
		}
		
		//check if all cows are already in the right position, then return -1
		for (int i = 0; i < pos.length; i++) {
			if (pos[i] != i) {
				break;
			}
			if (i == pos.length - 1) {
				out.println(-1);
				out.close();
				System.exit(0);
			}
		}
		
		int[] widths = new int[h];
		for (int i = 0; i < h; i++) {
			s = new StringTokenizer(f.readLine());
			int v = Integer.parseInt(s.nextToken()) - 1;
			int v1 = Integer.parseInt(s.nextToken()) - 1;
			int width = Integer.parseInt(s.nextToken());
			widths[i] = width;
			Edge edge1 = new Edge(v1, width);
			Edge edge2 = new Edge(v, width);

			holes[v].add(edge1);
			holes[v1].add(edge2);
		}
		
		//binary search all the widths
		Arrays.sort(widths);
		out.println(bsearchFunctChange(widths));
		out.close();

	}
	
	
	
	// you should actually read the stuff at the bottom
	

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, BASH TEST CASES, MAKE MILLIONS
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */