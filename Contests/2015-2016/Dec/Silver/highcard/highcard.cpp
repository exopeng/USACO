#include <bits/stdc++.h>
using namespace std;
 

const int MAXN = 50000;
long long ans = 0;
int n;
vector<int> elsie;
bool cards[MAXN * 2];
set<int> bessie;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("highcard.in","r",stdin);
    freopen("highcard.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int e;
        cin >> e;
        e--;
        elsie.push_back(e);
        cards[e] = true;
    }
    for (int i = 0; i < 2*n; i++) {
        if (!cards[i]) {
            bessie.insert(i);
            //cout << i << "\n";
        }
    }
    sort(elsie.begin(),elsie.end());
    for (int i = 0; i < n; i++) {
        set<int>::iterator get = bessie.lower_bound(elsie[i]);
        if (get != bessie.end()) {
            ans++;
            //cout << *get << "\n";
            bessie.erase(get);
        }
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
