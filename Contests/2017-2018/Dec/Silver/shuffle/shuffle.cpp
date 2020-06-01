#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100000;
bool dest[MAXN];
long long ans = 0;
int n; 
int adj[MAXN];
bool visited[MAXN];
bool act[MAXN];
void visit(int curr, int start) {
	if (curr == start) {
		return;
	}
	ans++;
	act[curr] = true;
	visit(adj[curr], start);
}

void cycle(int curr) {
	// already visited
	if (act[curr]) {
		return;
	}
	if (visited[curr]) {
		ans++;
		//dont' come back here again
		act[curr] = true;
		visit(adj[curr], curr);
		return;
	}
	visited[curr] = true;
	cycle(adj[curr]);
	visited[curr] = false;
}
int main() {
    freopen("shuffle.in","r",stdin);
    freopen("shuffle.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
    	int element;
    	cin >> element;
    	element--;
    	adj[i] = element;
    }
    //in order for something to be always occupied, it has to lead back to itself
    for (int i = 0; i < n; i++) {
    	cycle(adj[i]);
    	act[adj[i]] = true;
    	//don't need to visit that place again
    	//everything on it's path is also valid
    }
    cout << ans << "\n";
    return 0;
}
