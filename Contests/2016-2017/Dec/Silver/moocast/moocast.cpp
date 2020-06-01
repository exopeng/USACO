#include <bits/stdc++.h>
using namespace std;
 

 
int ans = 0;
const int MAXN = 200;
vector<int> adj[MAXN];
vector< pair< pair<int,int>, int> > cows;
bool visited[MAXN];
bool currvisited[MAXN];
int n;
int counter = 0;
void reset() {
    for (int i = 0; i < n; i++) {
        currvisited[i] = false;
    }
    counter = 0;
}
void dfs(int curr) {
    if (!currvisited[curr]) {
        currvisited[curr] = true;
        visited[curr] = true;
    } else {
        return;
    }
    counter++;
    for (int i = 0; i < adj[curr].size(); i++) {
        dfs(adj[curr][i]);
    }
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("moocast.in","r",stdin);
    freopen("moocast.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int x,y,p;
        cin >> x >> y >> p;
        cows.push_back(make_pair(make_pair(x,y), p));
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j != i) {
                double distance = pow((double)pow(cows[i].first.first - cows[j].first.first, 2) + (double)pow(cows[i].first.second - cows[j].first.second, 2), 0.5);
                //cout << distance << "\n";
                if (distance <= cows[i].second) {
                    adj[i].push_back(j);
                }
            }
           
        }
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            reset();
            dfs(i);
            ans = max(ans, counter);
        }
    }
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
