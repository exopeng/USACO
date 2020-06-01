/* Use the slash-star style comments or the system won't see your
   identification information */
/*
LANG: JAVA
ID: exopeng1
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("test.in"));
                                                  // input file name goes above
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int num = Integer.parseInt(st.nextToken());
    int[] firstAnswers = new int[num];
    int[] secondAnswers = new int[num];
    int counter = 0;

    st = new StringTokenizer(f.readLine());
    for (int i = 0; i < num; i++) {
      firstAnswers[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(f.readLine());
    for (int i = 0; i < num; i++) {
      secondAnswers[i] = Integer.parseInt(st.nextToken());
    }
    
    for (int i = 0; i < num; i++) {
      if (firstAnswers[i] == secondAnswers[i]) {
        counter++;
      } 
    }
    System.out.println(counter);
  }
}