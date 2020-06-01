#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 0;
int n,q;
const int MAXN = 100000;
int arr1[MAXN];
int arr2[MAXN];
int arr3[MAXN];
int garr[MAXN]; 

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("bcount.in","r",stdin);
    freopen("bcount.out","w",stdout);
    cin >> n >> q;
    for (int i = 0; i < n; i++) {
        cin >> garr[i];
    }
    if (garr[0] == 1) {
        arr1[0] = 1;
    }
    if (garr[0] == 2) {
        arr2[0] = 1;
    }
    if (garr[0] == 3) {
        arr3[0] = 1;
    }
    for (int i = 1; i < n; i++) {
        arr1[i] = arr1[i-1];
        arr2[i] = arr2[i-1];
        arr3[i] = arr3[i-1];
        if (garr[i] == 1) {
            arr1[i]++;
        } 
        if (garr[i] == 2) {
            arr2[i]++;
        } 
        if (garr[i] == 3) {
            arr3[i]++;
        } 
    }
    for (int i = 0; i < q; i++) {
        int a,b;
        cin >> a >> b;
        a--,b--;
        int x,y,z;
        x = arr1[b];
        y = arr2[b];
        z = arr3[b];
        if (a != 0) {
            x -= arr1[a-1];
            y -= arr2[a-1];
            z -= arr3[a-1];
        } 
        cout << x << " " << y << " " << z << "\n";
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
