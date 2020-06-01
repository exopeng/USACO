#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 0;
int n,k;
const int MAXN = 1000;
int arrstart[MAXN + 1][MAXN + 1];
int arrstop[MAXN + 1][MAXN + 1];
 
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("paintbarn.in","r",stdin);
    freopen("paintbarn.out","w",stdout);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int a,b,c,d;
        cin >> a >> b >> c >> d;
        for (int j = b; j < d; j++) {
            arrstart[j][a]++;
            arrstop[j][c]++;
        }
    }

    for (int i = 0; i < MAXN + 1; i++) {
        int paintbuckets = 0;
        for (int j = 0; j < MAXN + 1; j++) {
            if (arrstart[i][j]) {
                paintbuckets += arrstart[i][j];
            }
            
            if (arrstop[i][j]) {
                paintbuckets -= arrstop[i][j];
            }
            if (paintbuckets == k) {
                ans++;
            }
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
