#include <bits/stdc++.h>
using namespace std;
 

 
int maxans = 0;
int minans = 0;
int n;
vector<int> cows;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("herding.in","r",stdin);
    freopen("herding.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        cows.push_back(a);
    }
    sort(cows.begin(), cows.end());

    //find max
    maxans += max(cows[1] - cows[0] - 1, cows[n -1 ] - cows[n-2] - 1);
    for (int i = 1; i < n - 2; i++) {
        maxans += (cows[i+1] - cows[i] - 1);
    }

    int start = 0;
    int consec = 1;

    //beware of not checking when loop terminates
    for (int i = 1; i < n; i++) {
        if (!(cows[i] <= cows[start] + n - 1)) {
            //fix only if they are all in a row
            if (consec == n - 1) {
                minans = max(minans, i - start - 1);
            } else {
                minans = max(minans, i - start);
            }
            if (cows[start+1] - cows[start] == 1) {
                consec--;
            }
            start++;
            i--;
        } else {
            if (cows[i] - cows[i-1] == 1) {
                consec++;
            }
            if (i == n-1) {
                if (consec == n - 1) {
                    minans = max(minans, i - start);
                } else {
                    minans = max(minans, i - start + 1);
                }
            }
            
        }
    }

    cout << n - minans << "\n" << maxans << "\n";
    return 0;
}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
 * NAIVE SOL FIRST TO CHECK AGAINST OPTIMIZED SOL
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * MAINTAIN TEST CASE LIST, TO TEST NEW SOLS
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
