#include <bits/stdc++.h>
 
using namespace std;
const int MAXN = 100000;
vector < pair<int, int> > p;
int arr[MAXN];
int n;
int mind = 1000001;
long long ans = 0;
int main() {
    freopen("lifeguards.in","r",stdin);
    freopen("lifeguards.out","w",stdout);
   	cin >> n;
   	for (int i = 0; i < n; i++) {
   		int x, y;
   		cin >> x >> y;
   		p.push_back(make_pair(x,i));
   		p.push_back(make_pair(y,i));
   	}
   	sort(p.begin(), p.end());
   	int endpoint = -1;
   	unordered_set<int> curr;
   	int last = 0;
   	for (int i = 0; i < n*2; i++) {
   		//if it interrupted something, that former thing's alone time is that
   		if (curr.size() == 1) {
   			arr[last] = p[i].first - endpoint;
   		}
   		//if some lifeguard is working, add to total time working
   		if (curr.size() > 0) {
   			ans += p[i].first - endpoint;
   		}
   		//if already present, remove from set, shift's over
   		if (curr.find(p[i].second) != curr.end()) {
   			curr.erase(p[i].second);
   		} else {
   			curr.insert(p[i].second);
   			last = p[i].second;
   		}
   		//set last time working
   		endpoint = p[i].first;
   	}
   	for (int i = 0; i < n; i++) {
   		//cout << arr[i] << " ";
   	}
   	for (int i = 0; i < n; i++) {
   		mind = min(arr[i],mind);
   	}
    cout << ans - mind << "\n";
    return 0;
}
