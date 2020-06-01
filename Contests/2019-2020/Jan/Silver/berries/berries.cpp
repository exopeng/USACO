#include <bits/stdc++.h>
using namespace std;
 

 
int ans = 0;
multiset<int, greater<int> > trees;
int n,k;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("berries.in","r",stdin);
    freopen("berries.out","w",stdout);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        trees.insert(a);
    }

    for (int i = 1; i <= *trees.begin(); i++) {
        int ct = 0;
        multiset<int, greater<int> > temp = trees;
        for (int j = 0; j < k; j++) {
            multiset<int, greater<int> >::iterator it = temp.begin();
            if (it == temp.end()) {
                ans = max(ans, ct);
                break;
            } 
            int val = *it;
            temp.erase(it);
            if (val > i) {
                temp.insert(val - i);
                val = i;
            }
            if (j >= k / 2) {
                ct += val;
            } 
        }
        ans = max(ans, ct);
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
