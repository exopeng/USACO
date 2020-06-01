#include <bits/stdc++.h> 
using namespace std;

const int MAXN = 5000;
const int MAXQ = 5000;
int n, q;
//first is the node connected to, second is relevance
vector < pair<int,int> > adj[MAXN];

 
long long ans = 0;

void dfs(int curr, int last, int minr, int k) {
	if (minr >= k) {
		ans++;
		for (int i = 0; i < adj[curr].size(); i++) {
			if (adj[curr][i].first != last) {
				dfs(adj[curr][i].first, curr, min(minr, adj[curr][i].second), k);
			}
		}
	}
	//else there is no hope for all the other nodes as they are guaranteed to 
	//have a relevance less than k
	
}
int main() {
    freopen("mootube.in","r",stdin);
    freopen("mootube.out","w",stdout);
    cin >> n >> q;
    for (int i = 0; i < n - 1; i++) {
    	int x, y, z;
    	cin >> x >> y >> z;
    	x--;
    	y--;
    	adj[x].push_back(make_pair(y,z));
    	adj[y].push_back(make_pair(x,z));
    }
    for (int i = 0; i < q; i++) {
    	ans = 0;
    	int k, v;
    	cin >> k >> v;
    	v--;
    	for (int j = 0; j < adj[v].size(); j++) {
    		dfs(adj[v][j].first, v, adj[v][j].second, k);
    	}
    	cout << ans << "\n";
    }
    return 0;
}
