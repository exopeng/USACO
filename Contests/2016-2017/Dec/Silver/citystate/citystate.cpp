#include <bits/stdc++.h>
using namespace std;
 
long long ans = 0;
int n; 
struct pair_hash
{
    template <class T1, class T2>
    std::size_t operator () (std::pair<T1, T2> const &pair) const
    {
        std::size_t h1 = std::hash<T1>()(pair.first);
        std::size_t h2 = std::hash<T2>()(pair.second);

        return h1 ^ h2;
    }
};
unordered_map<pair<string, string>, int, pair_hash > mp; 
vector< pair<string,string> > citystates;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("citystate.in","r",stdin);
    freopen("citystate.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        string a,b;
        cin >> a >> b;
        pair<string,string> p = make_pair(a.substr(0,2),b);
        if (mp.find(p) != mp.end()) {
            mp[p]++;
            //cout << mp[p] << " ";
        } else {
            mp[p] = 1;    
            //cout << mp[p] << " ";       
        }
        citystates.push_back(p);
    }
    for (int i = 0; i < citystates.size(); i++) {
        pair<string,string> rev = make_pair(citystates[i].second,citystates[i].first);
        if (mp.find(rev) != mp.end() && citystates[i].second != rev.second) {
            //cout << citystates[i].first << " " << citystates[i].second << " " << mp[rev] << " " << mp[citystates[i]] << "\n";
            ans += mp[rev] * mp[citystates[i]];
            mp.erase(citystates[i]);
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
