#include <bits/stdc++.h>
using namespace std;

long long ans = 0;
vector< pair <int,int> > cows;
multiset<int> chickens;
int c,n;

bool cmp(const pair<int,int> &a, 
              const pair<int,int> &b) {
    if (a.second == b.second) {
        return a.first < b.first;
    }
    return a.second < b.second;

}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("helpcross.in","r",stdin);
    freopen("helpcross.out","w",stdout);
    cin >> c >> n;
    for (int i = 0; i < c; i++) {
        int e;
        cin >> e;
        chickens.insert(e);
    }
    for (int i = 0; i < n; i++) {
        int s, e;
        cin >> s >> e;
        cows.push_back(make_pair(s,e));
    }
    sort(cows.begin(), cows.end(), cmp);

    for (int i = 0; i < n; i++) {
        //find earliest chicken that can fit it's schedule
        multiset<int>::iterator chicken = chickens.lower_bound(cows[i].first);
        if (chicken != chickens.end() && *chicken <= cows[i].second) {
            ans++;
            chickens.erase(chicken);
        }
    }
    cout << ans << "\n";
    return 0;
}
