#include <bits/stdc++.h>
using namespace std;

const int MAXN = 10000;
int arr[MAXN];
long long ans = 0;
int n,t;

bool valid(int k) {
    priority_queue<long long, vector<long long>, greater<long long> > pq;
    for (int i = 0; i < k && i < n; i++) {
        pq.push(arr[i]);
    }
    int ct = 0;
    long long time = 0;
    do {
        time = (long long)pq.top();
        pq.pop();
        if (ct + k < n) {
            pq.push(arr[ct + k] + time);
        }
        ct++;
    } while (ct < n);
    return (time <= t);
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("cowdance.in","r",stdin);
    freopen("cowdance.out","w",stdout);
    cin >> n >> t;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int lo = 1;
    int hi = n;
    int best = 0;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (valid(mid)) {
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
