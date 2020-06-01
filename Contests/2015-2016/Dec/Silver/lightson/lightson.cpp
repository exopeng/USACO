#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 1;
const int MAXN = 100;
bool visited[MAXN][MAXN];
int n, m;
vector< pair<int,int> > adj[MAXN][MAXN];
bool lightson[MAXN][MAXN];

void dfs(int curri, int currj) {
	if (curri < 0 || curri >= n || currj < 0 || currj >= n) {
		return;
	}
	//light might be turned on later by another thing
	if (!lightson[curri][currj]) {
		return;
	}
	if (visited[curri][currj]) {
		return;
	}
	visited[curri][currj] = true;

	for (int i = 0; i < adj[curri][currj].size(); i++) {
		int b = adj[curri][currj][i].first;
		int a = adj[curri][currj][i].second;
		if (!lightson[b][a]) {
			lightson[b][a] = true;
			//if now accessible, see if any of the adjacent ones were visited, and visit
			if (b - 1 > -1 && visited[b-1][a]) {
				dfs(b,a);
			} else if (b + 1 < n && visited[b+1][a]) {
				dfs(b,a);
			} else if (a + 1 < n && visited[b][a+1]) {
				dfs(b,a);
			} else if (a - 1 > -1 && visited[b][a-1]) {
				dfs(b,a);
			}
			ans++;
		}
	}
	dfs(curri + 1, currj);
	dfs(curri - 1, currj);
	dfs(curri, currj + 1);
	dfs(curri, currj-1);
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("lightson.in","r",stdin);
    freopen("lightson.out","w",stdout);
    cin >> n >> m;
    lightson[0][0] = true;
    for (int i = 0; i < m; i++) {
    	int a,b,c,d;
    	cin >> a >> b >> c >> d;
    	a--,b--,c--,d--;
    	adj[b][a].push_back(make_pair(d,c));
    }
    dfs(0,0);
    cout << ans << "\n";
    return 0;
}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * IF CAN'T FIGURE ANYTHING OUT, MAKE TEN TEST CASES TO EVALUATE ALL TYPES OF SCENARIOS, THEN CONSTRUCT SOLUTION TO FIT IT
 * NAIVE SOL FIRST TO CHECK AGAINST OPTIMIZED SOL
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
