#include <bits/stdc++.h>
 
using namespace std;
const int MAXN = 100000;
const int MAXM = 100000;
long long ans = 0;
vector<int> adj[MAXN];
int milk[MAXN];
//1 represents H, 2 represents G

int comp[MAXN];

void dfs(int curr, int label) {
	if (!comp[curr]) {
		comp[curr] = label;
		for (int i = 0; i < adj[curr].size(); i++) {
			if (milk[adj[curr][i]] == milk[curr]) {
				dfs(adj[curr][i], label);
			}
		}
	}
}
int main() {
    freopen("milkvisits.in","r",stdin);
    freopen("milkvisits.out","w",stdout);
    int n;
    int m;
    cin >> n >> m;
    string milks;
    cin >> milks;
    for (int i = 0; i < n; i++) {
    	if (milks[i] == 'H') {
    		milk[i] = 1;
    	} else {
    		milk[i] = 2;
    	}
    }
 	for (int i = 0; i < n - 1; i++) {
 		int x,y;
 		cin >> x >> y;
 		x--;
 		y--;
 		adj[x].push_back(y);
 		adj[y].push_back(x);
 	}
 	for (int i = 0; i < n; i++) {
 		dfs(i, i + 1);
 	}
 	for (int i = 0; i < m; i++) {
 		int x, y, p;
 		char temp;
 		cin >> x >> y >> temp;
 		x--;
 		y--;
 		if (temp == 'H') {
    		p = 1;
    	} else {
    		p = 2;
    	}
    	if (comp[x] != comp[y] || milk[x] == p) {
    		ans = 1;
    	} else {
    		ans = 0;
    	}
    	cout << ans;
 	}
    return 0;
}
