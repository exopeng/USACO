/*
LANG: JAVA
ID: exopeng1
PROG: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {
	public static void main(String[] args) throws IOException{
		//FileReader e = new FileReader("namenum.in");
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader s = new BufferedReader(new FileReader("dict.txt"));
		StringTokenizer st1;
		StringTokenizer st2 = new StringTokenizer(f.readLine());
		String[] nameList = new String[4617];
		String originalSerialNum = (st2.nextToken());
		
		int counter = 0;
		
		for (int i = 0; i < 4617; i++) {
			st1 = new StringTokenizer(s.readLine());
			String name = st1.nextToken();
			if (name.length() == originalSerialNum.length()) {
				String serialNum = "";
				for (int j = 0; j < name.length(); j++) {
					String letter = name.substring(j,j+1);
					//System.out.println(letter);
					if (letter.equals("A") || letter.equals("B") || letter.equals("C")) {
						serialNum += "2";
					} else if (letter.equals("D") || letter.equals("E") || letter.equals("F")) {
						serialNum += "3";
					} else if (letter.equals("G") || letter.equals("H") || letter.equals("I")) {
						serialNum += "4";
					} else if (letter.equals("J") || letter.equals("K") || letter.equals("L")) {
						serialNum += "5";
					} else if (letter.equals("M") || letter.equals("N") || letter.equals("O")) {
						serialNum += "6";
					} else if (letter.equals("P") || letter.equals("R") || letter.equals("S")) {
						serialNum += "7";
					} else if (letter.equals("T") || letter.equals("U") || letter.equals("V")) {
						serialNum += "8";
					} else {
						serialNum += "9";
					}
					if (!(serialNum.substring(j, j + 1).equals(originalSerialNum.substring(j, j + 1)))) {
						break;
					}
					if (j == name.length() - 1) {
						nameList[counter] = name;
						counter++;
					}
				}
				
			}
		}
		
		if (nameList[0] == null) {
			out.println("NONE");
		}  else {
			for (int i = 0; i < counter; i++) {
				out.println(nameList[i]);
			}
		}
		
		out.close();
		
	}
}
						
						
						
						
						
						