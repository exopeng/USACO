#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 0;
int n,k;
vector<int> b;

bool fill(int r) {
    int ct = k - 1;
    int d = b[0] + 2*r;
    for (int i = 0; i < n; i++) {
        //out of range
        if (b[i] > d) {
            if (ct == 0) {
                //no more bombs
                return false;
            }
            ct--;
            d = b[i] + 2*r;
        } 
    }
    return true;
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("angry.in","r",stdin);
    freopen("angry.out","w",stdout);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int e;
        cin >> e;
        b.push_back(e);
    }
    sort(b.begin(),b.end());

    int lo = 0;
    int hi = ceil(((double)b[n - 1] - b[0]) / 2);
    while (lo != hi) {
        int mid = (lo + hi) / 2;
        //cout << mid << "\n";
        if (fill(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    cout << lo << "\n";
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
