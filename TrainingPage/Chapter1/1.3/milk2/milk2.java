/* Use the slash-star style comments or the system won't see your
   identification information */
/*
LANG: JAVA
ID: exopeng1
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int farmers = Integer.parseInt(st.nextToken());
    int[] startTimes = new int[farmers];
    int[] endTimes = new int[farmers];
    int start;
    int end;

    for (int i = 0; i < farmers; i++) {
      st = new StringTokenizer(f.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      startTimes[i] = start;
      endTimes[i] = end;
    }

    //sorting times
    for (int i = 0; i < startTimes.length; i++) {
      for (int j = 0; j < startTimes.length - 1; j++) {
        if (startTimes[j] > startTimes[j + 1]) {
          int temp = startTimes[j];
          startTimes[j] = startTimes[j + 1];
          startTimes[j + 1] = temp;
          int temp1 = endTimes[j];
          endTimes[j] = endTimes[j + 1];
          endTimes[j + 1] = temp1;
        }
      }
    }

    for (int i = 0; i < farmers; i++) {
      //System.out.print(startTimes[i] + " ");
    }
    //System.out.println();

    for (int i = 0; i < farmers; i++) {
      //System.out.print(endTimes[i] + " ");
    }
    //System.out.println();

    int currentTime = 0;
    int maxEmptyTime = 0;
    int maxContinuousTime = endTimes[0] - startTimes[0];


    while (currentTime < startTimes.length - 1) {
      boolean isEmptyTime = false;
      int initialTime = startTimes[currentTime];
      int emptyTime = 0;
      int continousTime = 0;
      int localEndTime = endTimes[currentTime];
      while (isEmptyTime == false && currentTime < startTimes.length - 1) {
        if (endTimes[currentTime] > localEndTime) {
          localEndTime = endTimes[currentTime];
        }
        
        int localStartTime = startTimes[currentTime + 1];
        if (localStartTime > localEndTime) {
          emptyTime = localStartTime - localEndTime;
          continousTime = localEndTime - initialTime;
          isEmptyTime = true;
        }
        currentTime++;
      }

      if (emptyTime > maxEmptyTime) {
        maxEmptyTime = emptyTime;
      }

      if (continousTime > maxContinuousTime) {
        maxContinuousTime = continousTime;
      }

    }

    //System.out.println(maxContinuousTime);
    //System.out.println(maxEmptyTime);
    out.println(maxContinuousTime + " " + maxEmptyTime);
    out.close();                                  // close the output file
  }
}