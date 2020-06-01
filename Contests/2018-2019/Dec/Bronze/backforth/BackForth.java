/*
LANG: JAVA
ID: exopeng
PROG: backforth
*/
import java.io.*;
import java.util.*;


public class BackForth {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] barn1 = new int[10];
		int[] barn2 = new int[10];
		int[] barn1Pure = new int[10];
		int[] barn2Pure = new int[10];
		
		for (int i = 0; i < 10; i++) {
			int val = Integer.parseInt(st.nextToken());
			barn1[i] = val;
			barn1Pure[i] = val;
		}
		
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < 10; i++) {
			int val = Integer.parseInt(st.nextToken());
			barn2[i] = val;
			barn2Pure[i] = val;
		}
		
		
		int[] sum = new int[1];
		sum[0] = 1000;
		
		//barn1 to barn2
		for (int i = 0; i < barn1.length; i++) {	
			
			//barn2 to barn1
			for (int j = 0; j < barn2.length; j++) {
				for (int d = 0; d < barn1Pure.length; d++) {
					int toStore = barn1Pure[d];
					int toStore1 = barn2Pure[d];
					barn1[d] = toStore;
					barn2[d] = toStore1;
				}
				int total = 1000;
				if (barn1[i] != barn2[j]) {
					int trade1 = barn1[i];
					int trade2 = barn2[j];
					total += barn2[j];
					total -= barn1[i];
					barn1[i] = trade2;
					barn2[j] = trade1;
					//if in total not already in list, add
					if (!(inTotal(sum, total))) {
						int[] temp = sum;
						sum = new int[temp.length + 1];
						sum[0] = total;
						for (int e = 0; e < temp.length; e++) {
							sum[e + 1] = temp[e];
						}
//						System.out.println("total possible measuring " + sum.length);
//						System.out.println(trade1 + " in Barn1 was replaced with " + trade2);
//						System.out.println(trade2 + " in Barn2 was replaced with " + trade1);
//						System.out.print("Barn1 values: ");
//						ArrayPrinter(barn1);
//						System.out.print("Barn2 values: ");
//						ArrayPrinter(barn2);
//						System.out.println("Total milk:" + total);
//						System.out.println();
					}
					
					
					//barn1 to barn2
					for (int p = 0; p < barn1.length; p++) {
						
						
						//barn2 to barn1
						for (int c = 0; c < barn2.length; c++) {
							int[] barn1New = new int[10];
							int[] barn2New = new int[10];
							for (int d = 0; d < barn1.length; d++) {
								int toStore = barn1[d];
								int toStore1 = barn2[d];
								barn1New[d] = toStore;
								barn2New[d] = toStore1;
							}
							int total2 = total;
							if (barn1New[p] != barn2New[c] && barn1New[p] != trade2 && barn2New[c] != trade1) {
								int trade1New = barn1New[p];
								int trade2New = barn2New[c];
								total2 -= barn1New[p];
								total2 += barn2New[c];
								barn1New[p] = trade2New;
								barn2New[c] = trade1New;
								
								//if total not already in list, add
								if (!(inTotal(sum, total2))) {
									int[] temp = sum;
									sum = new int[temp.length + 1];
									sum[0] = total2;
									for (int e = 0; e < temp.length; e++) {
										sum[e + 1] = temp[e];
									}
									
//									System.out.println("total possible measuring " + sum.length);
//									System.out.println(trade1 + " in Barn1 was replaced with " + trade2New);
//									System.out.println(trade2 + " in Barn2 was replaced with " + trade1New);
//									System.out.print("Barn1 values: ");
//									ArrayPrinter(barn1New);
//									System.out.print("Barn2 values: ");
//									ArrayPrinter(barn2New);
//									System.out.println("Total milk:" + total);
//									System.out.println();
								}
							}
						}
					}
				}
			}
		}
//		ArrayPrinter(sum);
		out.println(sum.length);
//		ArrayPrinter(barn1Pure);
//		ArrayPrinter(barn2Pure);
		out.close();
	}
	
	public static void ArrayPrinter(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
	}
	public static boolean inTotal(int[] totals, int total) {
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] == total) {
				return true;
			}
			if (i == totals.length - 1) {
				return false;
			}
		}
		return true;
	}
}
