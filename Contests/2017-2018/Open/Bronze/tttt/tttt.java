/*
LANG: JAVA
ID: exopeng
PROG: tttt
*/

//super stupid problem as this is so ambiguous
//a team of two only wins when both characters are present
//and theoretically a team of two could win with just one character, but then that means there would be 25 winning teams
import java.io.*;
import java.util.*;

public class tttt {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		
		StringTokenizer st;
		char[][] tile = new char[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(f.readLine());
			String line = st.nextToken();
			for (int j = 0; j < 3; j++) {
				tile[i][j] = line.charAt(j);
			}
		}
		
		int oneTeamVictories = 0;
		ArrayList<Character> oneVictoryTeams= new ArrayList<Character>();
		int twoTeamVictories = 0;
		ArrayList<String> twoVictoryTeams= new ArrayList<String>();
		//ArrayPrinter(tile);
		
		//figure out how many one team victories are there
		//if a character has already claimed victory, then it can't be used again
		//don't even bother checking characters of teams that claimed victory
		//figure out horizontal
		for (int i = 0; i < 3; i++) {
			char marker = tile[i][0];
			//if character is already by a single cow that has won, don't check
			if (!(oneVictoryTeams.contains(marker))) {
				for (int j = 1; j < 3; j++) {
					if (!(tile[i][j] == marker)) {
						break;
					}
					if (j == 2) {
						oneTeamVictories++;
						oneVictoryTeams.add(marker);
					}
				}
			}
			
		}
		//figure out vertical
		for (int i = 0; i < 3; i++) {
			char marker = tile[0][i];
			//if character is already by a single cow that has won, don't check
			if ((!oneVictoryTeams.contains(marker))) {
				for (int j = 1; j < 3; j++) {
					if (!(tile[j][i] == marker)) {
						break;
					}
					if (j == 2) {
						oneTeamVictories++;
						oneVictoryTeams.add(marker);
					}
				}
			}
			
		}
		
		//figure out diagonal
		//check left to right
		char marker = tile[0][0];
		//don't want to check victory by teams that already have them
		if (!(oneVictoryTeams.contains(marker))) {
			for (int i = 1; i < 3; i++) {
				if ((tile[i][i] != marker)) {
					break;
				}
				if (i == 2) {
					oneTeamVictories++;
					oneVictoryTeams.add(marker);
				}
			}
		} 
		
		//check right to left
		char marker1 = tile[0][2];
		//don't want to check victory by teams that already have them
		if (!(oneVictoryTeams.contains(marker1))) {
			for (int i = 1; i > -1; i--) {
				if ((tile[2 - i][i] != marker1)) {
					break;
				}
				if (i == 0) {
					oneTeamVictories++;
					oneVictoryTeams.add(marker1);
				}
			}
			
		} 
		
		//check two team victories
		
		//check horizontal
		for (int i = 0; i < 3; i++) {
			char marker2 = tile[i][0];
			char marker3 = tile[i][2];
			//find first different marker, if there isn't, then it isn't a two team win
			if (marker3 == marker2) {
				marker3 = tile[i][1];
			} if (!(marker3 == marker2)) {
				String team = ("" + marker2) + marker3;
				String team1 = ("" + marker3) + marker2;
				//if character is already by a cow team that has won, don't check
				if (!(twoVictoryTeams.contains(team) || twoVictoryTeams.contains(team1))) {
					for (int j = 1; j < 3; j++) {
						if ((tile[i][j] != marker2 && tile[i][j] != marker3)) {
							break;
						}
						if (j == 2) {
							twoTeamVictories++;
							twoVictoryTeams.add(team);
							twoVictoryTeams.add(team1);
						}
					}
				}
			}
			
			
			
		}
		//figure out vertical
		for (int i = 0; i < 3; i++) {
			char marker2 = tile[0][i];
			char marker3 = tile[1][i];
			//find first different marker, if there isn't then there isn't a two team win
			if (marker3 == marker2) {
				marker3 = tile[2][i];
			} if (!(marker3 == marker2)) {
				String team = ("" + marker2) + marker3;
				String team1 = ("" + marker3) + marker2;
				//if character is already by a single cow that has won, don't check
				if (!(twoVictoryTeams.contains(team) || twoVictoryTeams.contains(team1))) {
					for (int j = 1; j < 3; j++) {
						if ((tile[j][i] != marker2 && tile[j][i] != marker3)) {
							break;
						}
						if (j == 2) {
							twoTeamVictories++;
							twoVictoryTeams.add(team);
							twoVictoryTeams.add(team1);
						}
					}
				}
			}
			
			
		}
		
		//figure out diagonal
		//check right to left
		char marker2 = tile[0][2];
		char marker3 = tile[1][1];
		//find first different marker
		if (marker3 == marker2) {
			marker3 = tile[2][0];
		} if (marker3 != marker2) {
			String team = ("" + marker2) + marker3;
			String team1 = ("" + marker3) + marker2;
			//don't want to check victory by teams that already have them
			if (!(twoVictoryTeams.contains(team) || twoVictoryTeams.contains(team1))) {
				for (int i = 1; i > -1; i--) {
					if ((tile[2 - i][i] != marker2 && tile[2 - i][i] != marker3)) {
						break;
					}
					if (i == 0) {
						twoTeamVictories++;
						twoVictoryTeams.add(team);
						twoVictoryTeams.add(team1);
					}
				}
			} 
		}
		
		
		//check left to right
		char marker4 = tile[0][0];
		char marker5 = tile[1][1];
		//find first different marker
		if (marker5 == marker4) {
			marker5 = tile[2][2];
		} if (!(marker5 == marker4)) {
			String team2 = ("" + marker4) + marker5;
			String team3 = ("" + marker5) + marker4;
			//don't want to check victory by teams that already have them
			if (!(twoVictoryTeams.contains(team2) || twoVictoryTeams.contains(team3))) {
				for (int i = 1; i < 3; i++) {
					if ((tile[i][i] != marker4) && tile[i][i] != marker5 ) {
						break;
					}
					if (i == 2) {
						twoTeamVictories++;
						twoVictoryTeams.add(team2);
						twoVictoryTeams.add(team3);
					}
				}
				
			} 
		}
		
		
		
		
		
		
		//ArrayListPrinter(oneVictoryTeams);
		//ArrayListPrinterString(twoVictoryTeams);
		out.println(oneTeamVictories);
		out.println(twoTeamVictories);
		out.close();

	}
	public static void ArrayListPrinter(ArrayList<Character> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	public static void ArrayPrinter(char[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
	public static void ArrayListPrinterString(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	
}
	