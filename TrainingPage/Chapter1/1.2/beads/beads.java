/*
LANG: JAVA
ID: exopeng1
PROG: beads
*/

import java.io.*;
import java.util.*;

class beads {
    private static boolean ifSame(int necklaceLen, String necklace) {
        String soleColor = "";
        boolean set = false;
        for (int e = 0; e < necklaceLen; e++) {
            if (set == false) {
                if (!(necklace.substring(e, e + 1).equals("w"))) {
                    soleColor = necklace.substring(e, e + 1);
                    set = true;
                }
            }
            if (!(necklace.substring(e, e + 1).equals("w") || necklace.substring(e, e + 1).equals(soleColor))) {
                break;
            }
            if (e == necklaceLen - 1) {
                return true;
            }
        }
        return false;
    }

    private static int ifEndOfNecklace(int necklaceLen, int i) {
        if (i + 1 == necklaceLen) {
            i = 0;
        } else {
            i++;
        }
        return i;
    }
	public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    int necklaceLen = Integer.parseInt(st.nextToken());
						  // Get line, break into tokens
    StringTokenizer st1 = new StringTokenizer(f.readLine());
    String necklace = st1.nextToken();    // first input
    
    //higher number of beads streak
    int maxBeads = 0;

    //test if all elements are the same or with w
    //if finished accounting for all the beads in the necklace
    boolean finished = ifSame(necklaceLen, necklace);
    if (finished) {
        maxBeads = necklaceLen;
    } else {
        //first counted color
        int firstColorInitialPos = 0;
        int secondColorInitialPos = 0;
        int i = 1;
        //firstColor is the first color you count, 
        String firstColor = necklace.substring(firstColorInitialPos, firstColorInitialPos + 1);
        String secondColor = "";
        int counter1;
        maxBeads = 0;
        int localMaxBeads = 0;
        int beadCount = 0;
        //loops through all characters in the string, stops when you get back to the first character of the literal firstColor you counted
        while (finished == false) {
            beadCount = 0;
            //loops until next character isn't white, but still add white to counter
            //System.out.print("First Colors: ");
            if (firstColor.equals("w")) {
                while ((firstColor.equals("w"))) {
                    //System.out.print("w ");
                    firstColor = necklace.substring(i, i + 1);
                    beadCount++;
                    //counter1++;
                    i++;
                    //System.out.print("w" + " ");
                }
                //i--;
                //System.out.print(i + " ");

            }

            //loops through chars until a char doesn't equal it
            while (necklace.substring(i, i + 1).equals(firstColor) || necklace.substring(i, i + 1).equals("w")) {
                //System.out.print(necklace.substring(i, i + 1) + " ");
                //if you reach end of string, go to beginning as its a circular thing
                i = ifEndOfNecklace(necklaceLen, i);
                beadCount++;
                
                
            }
            //System.out.println();

            //noting down the first secondColor intial position, to avoid doubleCounting
            if (localMaxBeads == 0) {
                secondColorInitialPos = i;
                //System.out.println("Second color initial pos: " + secondColorInitialPos);
            }

            //after firstColor is counted, break the necklace there and count the number of second color
            secondColor = necklace.substring(i, i + 1);    
            if ((i == firstColorInitialPos || i == secondColorInitialPos) && (localMaxBeads != 0)) {
                finished = true;
            }

            //System.out.print("Second Colors: ");

            //first loop for second pairs
            while (necklace.substring(i, i + 1).equals(secondColor) || necklace.substring(i, i + 1).equals("w")) {
                //System.out.print(necklace.substring(i, i + 1) + " ");
                i = ifEndOfNecklace(necklaceLen, i);
                beadCount++;
                
            }
            //System.out.println();
            //if counter(number of beads counted) is greater than the all time high of beads, then set maxBeads to that
            if (beadCount > localMaxBeads) {
                localMaxBeads = beadCount;
            }
            if (localMaxBeads == necklaceLen) {
                break;
            }
            //System.out.println("highest number of beads so far is " + localMaxBeads + ", i is: " + i);
            
            //if the last one was a white bead, then find the last non-white beads, as the white beads can be used for the new color's count
            //keeps loopin until not a white bead
            if (i == 0) {
                while (necklace.substring(necklaceLen - 1, necklaceLen).equals("w")) {
                    if (i == 0) {
                        i = necklaceLen - 1;
                    } else {
                        i--;
                    }
                }
            } else {
                while ((necklace.substring(i - 1,i ).equals("w"))) {
                    i--;
                }
            }

            //sets firstColor to that white bead, will find a nonwhite bead in the beginning of loop
            firstColor = necklace.substring(i, i + 1);

            
        }
        maxBeads = localMaxBeads;

        //second loop for second pairs
        //System.out.println("Second attempt, with firstColor and secondColor positions switched");
        finished = false;
        firstColor = necklace.substring(secondColorInitialPos, secondColorInitialPos + 1);
        secondColor = "";
        i = secondColorInitialPos;
        localMaxBeads = 0;
        while (!(finished)) {
            //counter to count how many beads in total
            beadCount = 0;
            //loops until next character isn't white, but still add white to counter
            //System.out.print("First Colors: ");
            if (firstColor.equals("w")) {
                while ((firstColor.equals("w"))) {
                    //System.out.print("w ");
                    beadCount++;
                    i++;
                    firstColor = necklace.substring(i, i + 1);
                }
                //i--;
                //System.out.print(i + " ");

            }

            //loops through chars until a char doesn't equal it
            while (necklace.substring(i, i + 1).equals(firstColor) || necklace.substring(i, i + 1).equals("w")) {
                //System.out.print(necklace.substring(i, i + 1) + " ");
                //if you reach end of string, go to beginning as its a circular thing
                i = ifEndOfNecklace(necklaceLen, i);
                beadCount++;
                
                
            }
            //System.out.println();

            if (localMaxBeads == 0) {
                secondColorInitialPos = i;
                //System.out.println("Second color initial pos: " + secondColorInitialPos);
            }
            //after firstColor is counted, break the necklace there and count the number of second colors
            secondColor = necklace.substring(i, i + 1);
            if ((i == firstColorInitialPos || i == secondColorInitialPos) && (localMaxBeads != 0)) {
                finished = true;
            }

            //System.out.print("Second Colors: ");

            //loop through second colors
            while (necklace.substring(i, i + 1).equals(secondColor) || necklace.substring(i, i + 1).equals("w")) {
                //System.out.print(necklace.substring(i, i + 1) + " ");
                i = ifEndOfNecklace(necklaceLen, i);
                beadCount++;
                

            }
            //System.out.println();

            //if counter(number of beads counted) is greater than the all time high of beads, then set maxBeads to that
            if (beadCount > localMaxBeads) {
                localMaxBeads = beadCount;
            }
            if (localMaxBeads == necklaceLen) {
                break;
            }
            //System.out.println("highest number of beads so far is " + localMaxBeads + ", i is: " + i);

            //finds next spot to check beads
            
            //if the last one was a white bead, then find the last non-white beads, as the white beads can be used for the new color's count
            //keeps loopin until not a white bead
            if (i == 0) {
                while (necklace.substring(necklaceLen - 1, necklaceLen).equals("w")) {
                    if (i == 0) {
                        i = necklaceLen - 1;
                    } else {
                        i--;
                    }
                }
            } else {
                while ((necklace.substring(i - 1,i ).equals("w"))) {
                    i--;
                }
            }

            //sets firstColor to that white bead, will find a nonwhite bead in the beginning of loop
            firstColor = necklace.substring(i, i + 1);

        }
        if (localMaxBeads > maxBeads) {
            maxBeads = localMaxBeads;
        }
    }

    

    out.println(maxBeads);
    out.close();                                  
  }
}