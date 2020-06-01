#include <bits/stdc++.h>
using namespace std;
 

const int MAXN = 100000;
const int MAXNM = 100000;
vector<int> adj[MAXN];
vector< pair<int,int> > cows;
int cc[MAXN];
int n,m;
int minx, maxx, miny, maxy;
int ans = 1000000000;

void dfs(int curr, int label) {
	if (!cc[curr]) {
		cc[curr] = label;
		minx = min(cows[curr].first, minx);
		maxx = max(cows[curr].first, maxx);
		miny = min(cows[curr].second, miny);
		maxy = max(cows[curr].second, maxy);
		for (int i = 0; i < adj[curr].size(); i++) {
			dfs(adj[curr][i], label);
		}
	}
}

int main() {
    freopen("fenceplan.in","r",stdin);
    freopen("fenceplan.out","w",stdout);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
    	int x,y;
    	cin >> x >> y;
    	cows.push_back(make_pair(x,y));
    }
    for (int i = 0; i < m; i++) {
    	int x,y;
    	cin >> x >> y;
    	x--;
    	y--;
    	adj[x].push_back(y);
     	adj[y].push_back(x);
    }

    for (int i = 0; i < n; i++) {
    	if (!cc[i]) {
    		minx = 100000001;
	    	maxx = -1;
	 		miny = 100000001;
	    	maxy = -1;   
	    	dfs(i, i+1);
	    	ans = min(2*(maxx-minx) + 2*(maxy-miny), ans);	
    	}
    }

    cout << ans << "\n";
    return 0;
}
