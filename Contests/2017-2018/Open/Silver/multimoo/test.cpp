#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1000000;
int arr[MAXN][MAXN];
int adj[MAXN][MAXN];
bool visited[MAXN][MAXN];
int n = 0;
int currct = 0;
int ct[MAXN + 1];

void refill(int x,int y) {
	if (adj[x][y] == -1) {
		adj[x][y] = currct;
	} else {
		return;
	}
	if (x + 1 < n) {
		refill(x+1,y);
	}
	if (x - 1 > -1) {
		refill(x - 1,y);
	}
	if (y + 1 < n) {
		refill(x,y+1);
	}
	if (y - 1 > -1) {
		refill(x,y-1);
	}
}
void dfs(int x, int y, int last) {
	if (!visited[x][y]) {
		if (arr[x][y] == last) {
			visited[x][y] = true;
			currct++;
			ct[last] = max(currct, ct[last]);
			if (x + 1 < n) {
				dfs(x+1,y,last);
			}
			if (x - 1 > -1) {
				dfs(x - 1,y, last);
			}
			if (y + 1 < n) {
				dfs(x,y+1, last);
			}
			if (y - 1 > -1) {
				dfs(x,y-1, last);
			}
			adj[x][y] = -1;
			//refill later on
		} 
	}
}
int main() {
	freopen("multimoo.in","r",stdin);
    freopen("multimoo.out","w",stdout);
   	cin >> n;
   	for (int i = 0; i < n; i++) {
   		for (int j = 0; j < n; j++) {
   			cin >> arr[i][j];
   		}
   	}
}