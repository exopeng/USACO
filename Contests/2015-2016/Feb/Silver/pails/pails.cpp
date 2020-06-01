#include <bits/stdc++.h>
using namespace std;
 

const int MAXX = 100;
int ans = 1000000000;
int visited[MAXX + 1][MAXX + 1][MAXX + 1];
int x,y,k,m;

void dfs(int currx, int curry, int steps) {
    if (visited[currx][curry][steps]) {
        return;
    }
    visited[currx][curry][steps] = true;
    //cout << currx << " " << curry << " " << steps << "\n";
    ans = min(ans, abs(m - (curry + currx)));
    if (steps == k) {
        return;
    }
    //step error
    
    for (int i = 0; i < 6; i++) {
        switch(i) {
            case 0: 
                dfs(0 ,curry, steps + 1);
                break;
            case 1:
                dfs(currx, 0, steps + 1);
                break;
            case 2:
                dfs(x,curry,steps + 1);
                break;
            case 3:
                dfs(currx,y,steps + 1);
                break;
            case 4:
                if (currx < x) {
                    if (curry + currx > x) {
                        dfs(x, curry - (x-currx), steps+1);
                    } else {
                        dfs(currx + curry, 0, steps+1);
                    } 
                }
                break;
            default:
                if (curry < y) {
                    if (curry + currx > y) {
                        dfs(currx - (y-curry), y, steps+1);
                    } else {
                        dfs(0, curry + currx, steps+1);
                    }
                } 
        }
    }

}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("pails.in","r",stdin);
    freopen("pails.out","w",stdout);
    cin >> x >> y >> k >> m;
    ans = min(ans, abs(m));
    dfs(0,0,0);
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
