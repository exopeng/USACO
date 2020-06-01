#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 0;
int n,q;
const int MAXLOC = 1000000000;
vector<int> loc;
vector< pair<int,int> > queries;
//to find something that tends towards the right(the more right, the better), add one to mid(good, good, good, bad,bad)
//to find something that tends towards the left(the more left, the better), do nothing(bad,bad,good,good,good)

int bsearchHigh(int high) {
    int lo = 0;
    int hi = n-1;
    while (lo != hi) {
        int mid = (lo + hi + 1) / 2;
        if (high >= loc[mid]) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
}
int bsearchLo(int low) {
    int lo = 0;
    int hi = n - 1;
    while (lo != hi) {
        //int mid = (lo + hi - 1) / 2;
        int mid = (lo + hi) / 2;
        if (low <= loc[mid]) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return hi;
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("haybales.in","r",stdin);
    freopen("haybales.out","w",stdout);
    cin >> n >> q;
    for (int i = 0; i < n; i++) {
        int element;
        cin >> element;
        loc.push_back(element);
    }
    sort(loc.begin(), loc.end());
    for (int i = 0; i < q; i++) {
        int a,b;
        cin >> a >> b;
        if (a > loc[n-1]|| b < loc[0]) {
            ans = 0;
        } else {
             int hi = bsearchHigh(b);
             int lo = bsearchLo(a);
             ans = hi - lo + 1;
        }
        cout << ans << "\n";
    }
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
