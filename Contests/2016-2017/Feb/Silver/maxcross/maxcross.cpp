#include <bits/stdc++.h>
using namespace std;
 

const int MAXN = 100000;
long long ans = 0;
bool cows[MAXN];
int n,k,b;
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("maxcross.in","r",stdin);
    freopen("maxcross.out","w",stdout);
    cin >> n >> k >> b;
    for (int i = 0; i < b; i++) {
        int e;
        cin >> e;
        e--;
        cows[e] = true;
    }
    int maxcount = 0;
    for (int i = 0; i < k; i++) {
        if (cows[i]) {
            maxcount++;
        }
    }
    int start = 0;
    int currct = maxcount;
    for (int i = k; i < n; i++) {
        if (cows[start]) {
            currct--;
        }
        if (cows[i]) {
            currct++;
        }
        maxcount = min(maxcount,currct);
        start++;
    }

    cout << maxcount << "\n";
    return 0;
}
