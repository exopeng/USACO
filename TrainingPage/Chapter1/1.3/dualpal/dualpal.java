/*
LANG: JAVA
ID: exopeng1
PROG: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int nums = Integer.parseInt(st.nextToken());
		int startNum = Integer.parseInt(st.nextToken());
		int counter = 0;
		int counter1 = 1;
		char[] charSet = new char[(10)];
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
		while (counter < nums) {
			int num = startNum + counter1;
			int trues = 0;
			for (int i = 2; i < 11; i++) {
				if (isPalindrome(baseConverter(num, i, charSet))) {
					trues++;
				}
				if (trues == 2) {
					out.println(num);
					counter++;
					break;
				}
			}
			counter1++;
			
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
