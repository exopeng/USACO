#include <bits/stdc++.h>
using namespace std;
 
int n,m;
const int MAXN = 3000;
vector<int> adj[MAXN];
int cc[MAXN];
bool closed[MAXN];
int reach = 0;
unordered_set<int> open;

void dfs(int curr, int label) {
    if (closed[curr]) {
        return;
    }
    if (cc[curr] == label) {
        return;
    }
    cc[curr] = label;
    reach++;
    for (int i = 0; i < adj[curr].size(); i++) {
        dfs(adj[curr][i], label);
    }
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("closing.in","r",stdin);
    freopen("closing.out","w",stdout);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a,b;
        cin >> a >> b;
        a--;
        b--;
        adj[a].push_back(b);
        adj[b].push_back(a);
        if (open.find(a) == open.end()) {
            open.insert(a);
        }
        if (open.find(b) == open.end()) {
            open.insert(b);
        }
    }
    dfs(0, 1);
    string ans = "NO";
    if (reach == n) {
        ans = "YES";
    }
    cout << ans << "\n";
    for (int i = 0; i < n-1; i++) {
        ans = "NO";
        int close;
        cin >> close;
        close--;
        closed[close] = true;
        open.erase(close);
        reach = 0;
        //have to dfs from something not closed
        dfs(*open.begin(), i+2);
        if (reach == n - i - 1) {
            ans ="YES";
        }
        cout << ans << "\n";
    }
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
