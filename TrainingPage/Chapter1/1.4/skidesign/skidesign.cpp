
/*
ID: exopeng1
TASK: skidesign
LANG: C++                 
*/

#include <bits/stdc++.h>
using namespace std;
 

 
int ans = 1000000000;
int n;
vector<int> hills; 

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("skidesign.in","r",stdin);
    freopen("skidesign.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int e;
        cin >> e;
        hills.push_back(e);
    }

    for (int i = 0; i <= 100; i++) {
        int max = i;
        int temp = 0;
        for (int j = 0; j < n; j++) {
            if (hills[j] > max || max - hills[j] > 17) {
                if (hills[j] > max) {
                    temp += pow(hills[j] - max,2);
                } else {
                    temp += pow((max-hills[j]) - 17,2);
                }
            }
        }
        ans = min(ans,temp);
    }
    cout << ans << "\n";
    return 0;
}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
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
