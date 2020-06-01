#include <bits/stdc++.h>
using namespace std;
 

 
char ans;
string code;
long long n;
char rec(long long curr, long long len) {
    //cout << curr << " " << len << "\n";
    if (curr <= code.length()) {
        return code[curr - 1];
    }
    long long next = curr - len / 2 - 1;
    if (next == 0) {
        next = len / 2;
    }
    //make sure len is in the upper half of the new string, not smaller
    len = (long long)code.length() * pow(2,ceil(log2(ceil(next / (double)code.length()))));
    return rec(next, len);
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("cowcode.in","r",stdin);
    freopen("cowcode.out","w",stdout);
    cin >> code;
    cin >> n;
    long long len = (long long)code.length() * pow(2,ceil(log2(ceil(n / (double)code.length()))));
    //out << len;
    ans = rec(n, len);
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
