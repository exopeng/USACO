#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 0;
vector<int> arr;
int first[7];
int last[7];

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("div7.in","r",stdin);
    freopen("div7.out","w",stdout);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int e;
        cin >> e;
        arr.push_back(e);
    }
    long long sum = 0;
    for (int i = 0; i < 7; i++) {
        first[i] = 10000000;
    }
    //keep track of the first time you see that modulo and the last one
    //if it repeats, that means the interval in between is a multiple of 7
    //that's the only way to get the same modulo 
    for (int i = 1; i <=n; i++) {
        sum += arr[i-1];
        sum %= 7;
        first[sum] = min(first[sum], i);
        last[sum] = i;
    }
    for (int i = 0; i < 7; i++) {
        if (first[i] < n) {
            if (last[i] - first[i] + 1 > ans) {
                ans = last[i] - first[i];
            }
        }
        
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
