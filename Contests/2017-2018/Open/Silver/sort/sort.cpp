#include <bits/stdc++.h>
 
using namespace std;
const int MAXN = 100000;
vector<int> orig;
vector<int> sorted;

 
int ans = 0;
 
int main() {
    freopen("sort.in","r",stdin);
    freopen("sort.out","w",stdout);
    int n; 
    cin >> n;
    for (int i = 0; i < n; i++) {
    	int element;
    	cin >> element;
    	orig.push_back(element);
    	sorted.push_back(element);
    }
    sort(sorted.begin(), sorted.end());
    unordered_map<int, int> map;
    //map<int, int> map;

    for (int i = 0; i < n; i++) {
    	map[sorted[i]] = i;
    }
    for (int i = 0; i < n; i++) {
    	ans = max(ans, i - map[orig[i]]);
    }

    cout << (ans+1) << "\n";
    return 0;
}
