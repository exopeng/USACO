#include <bits/stdc++.h>
using namespace std;
 

 
int ans = 0;
int n;
vector<char> games;
int rct[3];
int lct[3];
int findMaxR() {
    int ans = 0;
    for (int i = 0; i < 3; i++) {
        ans = max(ans,rct[i]);
    }
    return ans;
}
int findMaxL() {
    int ans = 0;
    for (int i = 0; i < 3; i++) {
        ans = max(ans,lct[i]);
    }
    return ans;
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("hps.in","r",stdin);
    freopen("hps.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        char element;
        cin >> element;
        games.push_back(element);
        if (games[i] == 'P') {
            rct[0]++;
        } else if (games[i] == 'H') {
            rct[1]++;
        } else {
            rct[2]++;
        }
    }
    for (int i = n-1; i >= 0; i--) {
        if (games[i] == 'P') {
            rct[0]--;
            lct[0]++;
        } else if (games[i] == 'H') {
            rct[1]--;
            lct[1]++;
        } else {
            rct[2]--;
            lct[2]++;
        }
        ans = max(ans, findMaxL() + findMaxR());
    }
    cout << ans << "\n";
    return 0;
}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
 * NAIVE SOL FIRST TO CHECK AGAINST OPTIMIZED SOL
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
