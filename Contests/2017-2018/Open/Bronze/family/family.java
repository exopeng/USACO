import java.io.*;
import java.util.*;  
public class family {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("family.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int relationship = Integer.parseInt(st.nextToken());
		String target = st.nextToken();
		String target1 = st.nextToken();
		String[][] tree = new String[relationship][2];
		
		//fill the tree array
		for (int i = 0; i < relationship; i++) {
			st = new StringTokenizer(f.readLine());
			tree[i][0] = st.nextToken();
			tree[i][1] = st.nextToken();
		}
		//make an arrayList of each person's family tree
		ArrayList<String> targetTreeAbove = findMothers(tree, target);
		ArrayList<String> targetTreeBelow = findDaughters(tree, target);
		targetTreeBelow.add(target);
		
		ArrayList<String> targetTreeAbove1 = findMothers(tree, target1);
		ArrayList<String> targetTreeBelow1 = findDaughters(tree, target1);
		targetTreeBelow1.add(target1);
		
		//add the trees together
		for (int i = 0; i < targetTreeAbove.size(); i++) {
			targetTreeBelow.add(targetTreeAbove.get(i));
		}
		for (int i = 0; i < targetTreeAbove1.size(); i++) {
			targetTreeBelow1.add(targetTreeAbove1.get(i));
		}
		
//		ArrayListPrinter(targetTreeBelow);
//		ArrayListPrinter(targetTreeBelow1);
		String relation = ifMother(targetTreeBelow, targetTreeBelow1, target, target1);
		if ((!relation.equals(""))) {
			out.println(relation);
			out.close();
			System.exit(0);
			
		}
		relation = ifOther(targetTreeBelow, targetTreeBelow1, target, target1);
		if ((!relation.equals(""))) {
			out.println(relation);
			out.close();
			System.exit(0);
			
		}
		out.println("NOT RELATED");
		out.close();

	}
	public static String ifOther(ArrayList<String> targetTreeBelow, ArrayList<String> targetTreeBelow1, String target, String target1) {
		String relation = "";
		//second case, siblings or cousins, or aunts depending on how close is their common mother
		int targetCloseness = -1;
		int target1Closeness = -1;
		int targetPositionNew = 0;
		int target1PositionNew = 0;
		//scan through target's ancestors and check against target1's ancestors
		//get target1's position in his tree
		for (int i = 0; i < targetTreeBelow.size(); i++) {
			if (targetTreeBelow.get(i).equals(target)) {
				targetPositionNew = i;
			}
		}
		//get target1's position in his tree
		for (int i = 0; i < targetTreeBelow1.size(); i++) {
			if (targetTreeBelow1.get(i).equals(target1)) {
				target1PositionNew = i;
			}
		}
		boolean found = false;
		//System.out.println(targetPositionNew + " " + target1PositionNew);
		for (int i = targetPositionNew + 1; i < targetTreeBelow.size(); i++) {
			String ancestor = targetTreeBelow.get(i);
			for (int j = target1PositionNew + 1; j < targetTreeBelow1.size(); j++) {
				if (targetTreeBelow1.get(j).equals(ancestor)) {
					targetCloseness = i - targetPositionNew;
					target1Closeness = j - target1PositionNew;
					found = true;
					break;
				}
				
			}
			if (found) {
				break;
			}
		}
		//System.out.println(targetCloseness + " " + target1Closeness);
		if (targetCloseness == 1 && target1Closeness == 1) {
			return "SIBLINGS";
		}
		//if the distance from the common ancestor is 1 and the other isn't for any of them, then it is an aunt relationship
		if (target1Closeness == 1 && targetCloseness > 1) {
			int diff = targetCloseness - target1Closeness - 1;
			String seniority = "";
			for (int i = 0; i < diff; i++) {
				seniority += "great-";
			}
			return target1 + " is the " + seniority + "aunt of " + target;
		}
		if (targetCloseness == 1 && target1Closeness > 1) {
			int diff = target1Closeness - targetCloseness - 1;
			String seniority = "";
			for (int i = 0; i < diff; i++) {
				seniority += "great-";
			}
			return (target + " is the " + seniority + "aunt of " + target1);
		}
		//if the distance from the common ancestor for both is greater than 1, than they are cousins
		if (target1Closeness > 1 && targetCloseness > 1) {
			return ("COUSINS");
		}
		return "";
	}
	public static String ifMother(ArrayList<String> targetTreeBelow, ArrayList<String> targetTreeBelow1, String target, String target1 ) {
		String relation = "";
		//now find the shared relationship
		//first case, if target shows up in the direct family tree of BB/AA, then it is a grandmother relationship, add greats depending on how many mothers it is away
		int targetPosition = -1;
		int target1Position = -1;
//		if (targetTreeBelow1.size() > targetTreeBelow.size()) {
//			targetTreeBelow = targetTreeBelow1;
//		}
		for (int i = 0; i < targetTreeBelow.size(); i++) {
			//find AA's position and find BB's position
			if (targetTreeBelow.get(i).equals(target)) {
				targetPosition = i;
				
			}
			if (targetTreeBelow.get(i).equals(target1)) {
				target1Position = i;
			}
		}
		if (targetPosition > - 1 && target1Position > - 1) {
			int diff = Math.abs(target1Position - targetPosition);
			String seniority = "";
			for (int i = 1; i < diff; i++) {
				if (i == 1) {
					seniority += "grand-";
				} else {
					seniority = "great-" + seniority;
				}
				
			}
			if (targetPosition > target1Position) {
				relation = target + " is the " + seniority + "mother of " + target1; 
				return relation;
			} else {
				relation = target1 + " is the " + seniority + "mother of " + target; 
				return relation;
			}
			
		}
		targetPosition = -1;
		target1Position = -1;
		for (int i = 0; i < targetTreeBelow1.size(); i++) {
			//find AA's position and find BB's position
			if (targetTreeBelow1.get(i).equals(target)) {
				targetPosition = i;
				
			}
			if (targetTreeBelow1.get(i).equals(target1)) {
				target1Position = i;
			}
		}
		if (targetPosition > - 1 && target1Position > - 1) {
			int diff = Math.abs(target1Position - targetPosition);
			String seniority = "";
			for (int i = 1; i < diff; i++) {
				if (i == 1) {
					seniority += "grand-";
				} else {
					seniority = "great-" + seniority;
				}
				
			}
			if (targetPosition > target1Position) {
				relation = target + " is the " + seniority + "mother of " + target1; 
				return relation;
			} else {
				relation = target1 + " is the " + seniority + "mother of " + target; 
				return relation;
			}
			
		}
		return relation;
	}
	public static void ArrayListPrinter(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
		System.out.println();
	}
	
	public static ArrayList<String> findMothers(String[][] tree, String target) {
		//find all mothers of the target
		ArrayList<String> targetTreeAbove = new ArrayList<String>();
		for (int i = 0; i < tree.length; i++) {
			if (tree[i][1].equals(target)) {
				target = tree[i][0];
				targetTreeAbove.add(target);
				for (int j = 0; j < tree.length; j++) {
					if (tree[j][1].equals(target)) {
						target = tree[j][0];
						targetTreeAbove.add(target);
						j = -1;
					}
				}
				
				break;
			}
		}
		//ArrayListPrinter(targetTreeAbove);
		return targetTreeAbove;
	}
	
	public static ArrayList<String> findDaughters(String[][] tree, String target) {
		ArrayList<String> targetTreeBelow = new ArrayList<String>();
		for (int i = 0; i < tree.length; i++) {
			if (tree[i][0].equals(target)) {
				target = tree[i][1];
				targetTreeBelow.add(tree[i][1]);
				for (int j = 0; j < tree.length; j++) {
					if (tree[j][0].equals(target)) {
						target = tree[j][1];
						targetTreeBelow.add(tree[j][1]);
						j = -1;
					}
				}
				
				break;
			}
		}
		//reverse the order, so it goes from youngest to oldest
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = targetTreeBelow.size() - 1; i > -1; i--) {
			temp.add(targetTreeBelow.get(i));
		}
		return temp;
	}
	public static void ArrayPrinter(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}	
	public static void ArrayPrinter(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0;j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	

}
