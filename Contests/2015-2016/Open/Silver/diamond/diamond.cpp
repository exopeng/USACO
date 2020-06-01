#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<int> d; 
vector<int> diff;
unordered_map<int,int> waiting;
int beforeMax = 0;
int ans = 0;
int ct = 0;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("diamond.in","r",stdin);
    freopen("diamond.out","w",stdout);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int e;
        cin >> e;
        d.push_back(e);
    }
    sort(d.begin(), d.end());
    int start = 0;
    for (int i = 0; i < n; i++) {
        if (d[i] - d[start] > k) {
            //cout << "here" << " " << i << "\n";
            ans = max(ans, ct + beforeMax);
            //if first instance of this endpoint, put in waiting
            /*
            if (waiting.find(i-1) == waiting.end()) {
                waiting[i-1] = ct;
            }
            */
            //get the first subsection that ends here
            /*
            if (waiting.find(start) != waiting.end()) {
                beforeMax = max(beforeMax, waiting.find(start)->second);
                //waiting.erase(waiting.find(start));
            }
            */
            beforeMax = max(beforeMax, waiting.find(start)->second);
            start++;
            i--;
            ct--;
        } else {
            ct++;
            if (waiting.find(i) == waiting.end()) {
                waiting[i] = ct;
            }
        }
    }
    //waiting.erase(waiting.find(start));
    beforeMax = max(beforeMax, waiting.find(start - 1)->second);
    ans = max(ans, ct + beforeMax);

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
