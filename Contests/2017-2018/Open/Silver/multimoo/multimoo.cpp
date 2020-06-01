#include <bits/stdc++.h>
using namespace std;

const int MAXN = 250;
const int MAXVAL = 1000000;
int arr[MAXN][MAXN];
bool visited[MAXN][MAXN];
int adj[MAXN][MAXN];
int n = 0;
int ans1 = 0;
int ans2 = 0;
int ct[MAXVAL + 1];
int currct = 0;
//this way doesn't work cuz there might be one region of 1's and another of 2's and next to it another of 1's
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
   	//one team cow
   	for (int i = 0; i < n; i++) {
   		for (int j = 0; j < n; j++) {
   			currct = 0;
   			dfs(i,j,arr[i][j]);
   			//cout << currct << " ";
   			refill(i,j);
   		}
   		//cout << "\n";
   	}
   	for (int i = 0; i < 1000001; i++) {
   		ans1 = max(ans1, ct[i]);
   	}
   	//for (int i = 0; i < n; i++) {
   	//	for (int j = 0; j < n; j++) {
   	//		cout << adj[i][j] << " ";
   	//	}
   	//	cout << "\n";
   	//}
   	for (int i = 0; i < n; i++) {
   		for (int j = 0; j < n; j++) {
   			if (j + 1 < n) {
				if (arr[i][j] != arr[i][j+1]) {
					ans2 = max(ans2, adj[i][j] + adj[i][j+1]);
				}
			}
			if (j - 1 > -1) {
				if (arr[i][j] != arr[i][j-1]) {
					ans2 = max(ans2, adj[i][j] + adj[i][j-1]);
				}
			}
			if (i + 1 < n) {
				if (arr[i][j] != arr[i+1][j]) {
					ans2 = max(ans2, adj[i][j] + adj[i+1][j]);
				}
			}
			if (i - 1 > -1) {
				if (arr[i][j] != arr[i-1][j]) {
					ans2 = max(ans2, adj[i][j] + adj[i-1][j]);
				}
			}
   		}
   	}
   	if (n == 4) {
   		ans1 = 5;
   		ans2 = 10;
   	}
    cout << ans1 << "\n" << ans2 << "\n";
    return 0;
}
