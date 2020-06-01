/*
LANG: JAVA
ID: exopeng1
PROG: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
	public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());

    //gets number of people
    int np = Integer.parseInt(st.nextToken());

    //initializes the balances of every account
	int[] accountBalances = new int[np]; 			

    //initializes every accountholder name
    String[] accounts = new String[np];

    //gets the name of everybody, stores to accounts
    for (int i = 0 ; i < np; i++) {
        st = new StringTokenizer(f.readLine());
        accounts[i] = st.nextToken();
        accountBalances[i] = 0;
    }

    //reads the accountName
    //st = new StringTokenizer(f.readLine());

    //int currLine = np + 2;

    int currAccount = 0;
    String line;

        
    while ((line = f.readLine()) != null) {//while (!(st.nextToken().equals(""))) {
        //if (currAccount != 0) {
        //    st = new StringTokenizer(f.readLine());
        //}

        //reads the amount given and number of people to give to
        st = new StringTokenizer(line);
        String presentAccount = st.nextToken();
        //System.out.println("Current Account: " + presentAccount);


        st = new StringTokenizer(f.readLine());
        //sets the amount to give
        int givenAmount = Integer.parseInt(st.nextToken());
        //System.out.println("givenAmount: " + givenAmount);

        //how many to give to
        int numOfPeople = Integer.parseInt(st.nextToken());
        //System.out.println("numOfPeople: " + numOfPeople);

        //sets balance for the current account
        int remainingBalance = 0;
        
        

        //saves it to the accountBalances array
        //finds the account to set the amount to
        for (int j = 0; j < accounts.length; j++) {
            if (accounts[j].equals(presentAccount)) {
                //accountBalances[j] = accountBalances[j] + (givenAmount / numOfPeople);
                remainingBalance = accountBalances[j] - givenAmount;
                if (givenAmount != 0) {
                    remainingBalance = remainingBalance + (givenAmount % numOfPeople);
                }
                accountBalances[j] = remainingBalance;
                break;
            }
        }
        

        //finds every receiver
        for (int i = 0; i < numOfPeople; i++) {

            //reads the next line, which says who to give it to
            st = new StringTokenizer(f.readLine());

            //gets name
            String receiver = st.nextToken();

            //finds the account to give to
            for (int j = 0; j < accounts.length; j++) {
                if (accounts[j].equals(receiver)) {
                    accountBalances[j] = accountBalances[j] + (givenAmount / numOfPeople);
                    break;
                }
            }

            //currLine++;
        }

        //currLine += 2;

        //reads the accountName
        

        //goes to next account
        currAccount++;

    }

    //prints the output
    for (int i = 0; i < accounts.length; i++) {
        out.println(accounts[i] + " " + accountBalances[i]);
    }
       
    out.close();                                  
  }
}