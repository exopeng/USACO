#include <bits/stdc++.h>
 
using namespace std;
const int MAXN = 100000;
vector<int> arr;
 
long long ans = 0;
 
int main() {
    freopen("lemonade.in","r",stdin);
    freopen("lemonade.out","w",stdout);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
    	int e;
    	cin >> e;
    	arr.push_back(e);
    }
    ans = n;
    sort(arr.begin(), arr.end());
    reverse(arr.begin(), arr.end());
    int currPos = 0;
    for (int i = 0; i < n; i++) {
    	if (arr[i] < currPos) {
    		ans--;
    	} else {
    		currPos++;
    	}
    }
    cout << ans << "\n";
    return 0;
}
