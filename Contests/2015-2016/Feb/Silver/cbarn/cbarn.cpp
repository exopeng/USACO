#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 1000000000000;
int n;
const int MAXN = 1000;
int arr[MAXN];

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("cbarn.in","r",stdin);
    freopen("cbarn.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < n; i++) {
        int temp[MAXN];
        copy(begin(arr),end(arr),begin(temp));
        int stopPoint = i;
        int toFill = (i - 1 + n) % n;
        int toTake = (i - 2 + n) % n;
        long long count = 0;
        while (toFill != (stopPoint)) {
            if (temp[toFill] > 1) {
                count = 1000000000001;
                break;
            } else if (temp[toFill] == 1) {
                toFill = (toFill - 1 + n)  % n;
                if (toFill == toTake) {
                    toTake = (toTake-1 + n) % n;
                }
                continue;
            }
            if (temp[toTake] >= 1) {
                count += pow((toFill - toTake + n) % n, 2);
                temp[toTake]--;
                temp[toFill] = 1;
                continue;
            } else {
                toTake = (toTake - 1 + n)  % n;
            }
        }
        ans = min(ans, count);
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
