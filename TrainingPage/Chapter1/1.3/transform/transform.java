/*
LANG: JAVA
ID: exopeng1
PROG: transform
*/

import java.io.*;
import java.util.*;

class transform {
    

	public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());

        int dimension = Integer.parseInt(st.nextToken());
        //System.out.println(dimension);
        String[][] original = new String[dimension][dimension];

        String[][] transformed = new String[dimension][dimension];

        //gets original image
        for (int i = 0; i < dimension; i++) {
            st = new StringTokenizer(f.readLine());
            String line = st.nextToken();
            for (int j = 0; j < dimension; j++) {
                original[i][j] = line.substring(j, j + 1);        
            }
        }

        //gets second image
        for (int i = 0; i < dimension; i++) {
            st = new StringTokenizer(f.readLine());
            String line = st.nextToken();
            for (int j = 0; j < dimension; j++) {
                transformed[i][j] = line.substring(j, j + 1);        
            }
        }

        //arrayPrinter(original);

        //arrayPrinter(transformed);


        //arrayPrinter(rotate90(original));
        //arrayPrinter(rotate180(original));
        //arrayPrinter(rotate270(original));
        //arrayPrinter(reflection(original));

       
        if (sameArray(transformed, rotate90(original))) {
            //System.out.println(1);
            out.println(1);
        } else if (sameArray(transformed, rotate180(original))) {
            //System.out.println(2);
            out.println(2);
        } else if (sameArray(transformed, rotate270(original))) {
            //System.out.println(3);
            out.println(3);
        } else if (sameArray(transformed, reflection(original))) {
            //System.out.println(4);
            out.println(4);
        } else if (combination(original, transformed)) {
            //System.out.println(5);
            out.println(5);
        } else if (sameArray(original, transformed)) {
            //System.out.println(6);
            out.println(6);
        } else {
            //System.out.println(7);
            out.println(7);
        }   


        out.close();                                  
    }

    private static void arrayPrinter(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String[][] rotate90(String[][] array) {
        String[][] newArray = new String[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            String[] tempArray = new String[array.length];
            for (int j = 0; j < array.length; j++) {
                tempArray[j] = array[i][j];
            }
            for (int j = 0; j < array.length; j++) {
                newArray[j][(newArray.length - 1) - i] = tempArray[j];
            }
        }
        return newArray;
    }

    private static String[][] rotate180(String[][] array) {
        array = rotate90(array);
        array = rotate90(array);
        return array;
    }

    private static String[][] rotate270(String[][] array) {
        array = rotate90(array);
        array = rotate90(array);
        array = rotate90(array);
        return array;
    }

    private static String[][] reflection(String[][] array) {
        String[][] newArray = new String[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                newArray[i][j] = array[i][array.length - 1 - j];
            }
        }

        return newArray;
    }

    private static boolean combination(String[][] original, String[][] transformed) {
        if (sameArray(transformed, rotate90(reflection(original)))) {
            return true;
        }
        if (sameArray(transformed, rotate180(reflection(original)))) {
            return true;
        }

        if (sameArray(transformed, rotate270(reflection(original)))) {
            return true;
        }

        return false;


    }


    private static boolean sameArray(String[][] original, String[][] transformed) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                if (!original[i][j].equals(transformed[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}