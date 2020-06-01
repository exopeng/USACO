#include <bits/stdc++.h>
using namespace std;
 
int tallies[4];
int ans = 1000000;
int n;
vector< pair<int,int> > cows;
vector<int> y;
vector<int> x;
void check() {
    int maxct = 0;
    for (int f = 0; f < 4; f++) {
        //cout << tallies[f] << " ";
        maxct = max(maxct, tallies[f]);
    }
    //cout << "\n";
    ans = min(maxct,ans);    
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("balancing.in","r",stdin);
    freopen("balancing.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a,b;
        cin >> a >> b;
        cows.push_back(make_pair(a,b));
        y.push_back(b);
        x.push_back(a);
    }
    sort(cows.begin(), cows.end());
    sort(y.begin(),y.end());
    sort(x.begin(), x.end());
    for (int i = 0; i < n; i++) {
        if (y[i] != n - 1 && y[i] == y[i+1]) {
            continue;
        }
        //keep going until you reach one y that isn't the same
        tallies[0] = 0;
        tallies[1] = n - (i + 1);
        tallies[2] = i + 1;
        tallies[3] = 0;
        check();
        int lastpos = -1;
        for (int j = 0; j < n; j++) {
            lastpos = j;
            while (j != n - 1 && cows[j].first == cows[j+1].first) {
                j++;
            }
            //cout << i << " " << j << " ";
            for (int e = lastpos; e <= j; e++) {
                if (cows[e].second > y[i] + 1) {
                    tallies[0]++;
                    tallies[1]--;
                } else {
                    tallies[3]++;
                    tallies[2]--;
                }
            }

            check();  
        }
    }

    //cout << x1 << " " << x2 << " " << y1 << " " << y2 << "\n";

    

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
