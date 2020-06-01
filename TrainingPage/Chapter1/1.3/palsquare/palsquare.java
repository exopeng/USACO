/*
LANG: JAVA
ID: exopeng1
PROG: palsquare
*/

import java.io.*;
import java.util.*;

public class palsquare {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int base = Integer.parseInt(st.nextToken());
		char[] charSet = new char[(base)];
		for (int i = 0; i < charSet.length; i++) {
			switch (i) {
				case 10:
					charSet[i] = 'A';
					break;
				case 11:
					charSet[i] = 'B';
					break;
				case 12:
					charSet[i] = 'C';
					break;
				case 13:
					charSet[i] = 'D';
					break;
				case 14:
					charSet[i] = 'E';
					break;
				case 15:
					charSet[i] = 'F';
					break;
				case 16:
					charSet[i] = 'G';
					break;
				case 17:
					charSet[i] = 'H';
					break;
				case 18:
					charSet[i] = 'I';
					break;
				case 19:
					charSet[i] = 'J';
					break;
				default:
					charSet[i] = (char)(i + '0');
					
			}
					
		}
		int b = 1;
		while (b < 301) {
			int currNumber = b;
			int squareNumber = currNumber * currNumber;
			String squareBaseRepresentation = baseConverter(squareNumber, base, charSet);
			if (isPalindrome(squareBaseRepresentation)) {
				out.println(baseConverter(currNumber, base, charSet) + " " + squareBaseRepresentation);
			}
			b++;
			
		}
		
		
		
		out.close();
	}
	
	public static String baseConverter(int number, int base, char[] charSet) {
		int power = 0;
		String baseRepresentation = "";
		boolean greater = true;
		while (greater) {
			power++;
			if (!(number >= Math.pow(base, power))) {
				power--;
				greater = false;
			}
		}
		
		
		while (power != -1) {
			int counter = 0;
			while (number >= Math.pow(base, power)) {
				number -= Math.pow(base, power);
				counter++;
			}
			baseRepresentation += String.valueOf(charSet[counter]);
			power--;
		
		}
		return baseRepresentation;
	}
	
	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (!(str.charAt(i) == str.charAt(str.length() - 1 - i))) {
				return false;
			}
		}
		return true;
	}
}
