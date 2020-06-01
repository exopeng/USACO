#include <bits/stdc++.h>
using namespace std;
 
const int MAXN = 100;
const int MAXK = 100;
long long ans = 0;
int cc[MAXN][MAXN];
int arr[MAXN][MAXN];
bool adj[MAXN * MAXN][MAXN * MAXN];
vector< pair<int,int> > cows;
int n,k,r;

void dfs(int i, int j, int lasti, int lastj, int label) {
    //if road between the two
    if (i == n || i < 0 || j == n || j < 0) {
        return;
    }
    if (cc[i][j]) {
        return;
    }
    //if there is a road in between
    int id = arr[i][j];
    int endid = arr[lasti][lastj];
    if (adj[id][endid]) {
        return;
    }
    cc[i][j] = label;
    dfs(i+1,j,i,j,label);
    dfs(i-1,j,i,j,label);
    dfs(i,j+1,i,j,label);
    dfs(i,j-1,i,j,label);
}

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("countcross.in","r",stdin);
    freopen("countcross.out","w",stdout);
    cin >> n >> k >> r;
    //make id
    int counter = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = counter;
            counter++;
        }
    }
    for (int i = 0; i < r; i++) {
        int starti, startj, endi, endj;
        cin >> starti >> startj >> endi >> endj;
        starti--;
        startj--;
        endi--;
        endj--;
        adj[arr[starti][startj]][arr[endi][endj]] = true;
        adj[arr[endi][endj]][arr[starti][startj]] = true;
    }
    for (int i = 0; i < k; i++) {
        int e, j;
        cin >> e >> j;
        e--;
        j--;
        cows.push_back(make_pair(e,j));
    }
    int label = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dfs(i,j,i,j, label);
            label++;
        }
    }
    for (int i = 0; i < k; i++) {
        pair <int,int> start = cows[i];
        for (int j = i + 1; j < k; j++) {
            pair <int,int> end = cows[j];
            if (cc[start.first][start.second] != cc[end.first][end.second]) {
                ans++;
            }
        }
    }

    cout << ans << "\n";
    return 0;
}
