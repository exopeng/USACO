#include <bits/stdc++.h>
using namespace std;
 

 
long long ans = 1000000000000;
multiset< pair<int,int> > x;
multiset< pair<int,int> > y;
vector< pair<int,int> > cows;
int n;
void process(int steps) {
    if (steps == 3) {
        //calc the area
        //cout << "Max x: " << (x.rbegin())->first << " min x: " << x.begin()->first << " max y: " << (y.rbegin())->first << " min y: " << y.begin()->first << "\n";
        ans = min(ans, (long long)((x.rbegin())->first - x.begin()->first) * ((y.rbegin())->first - y.begin()->first));
        return;
    }
    multiset< pair<int,int> >::iterator remove = x.begin();
    multiset< pair<int,int> >::reverse_iterator remove1 = x.rbegin();
    multiset< pair<int,int> >::iterator remove2 = y.begin();
    multiset< pair<int,int> >::reverse_iterator remove3 = y.rbegin();
    pair<int,int> p = make_pair(1,1);
    pair<int,int> p1 = make_pair(1,1);
    for (int j = 0; j < 4; j++) {
        //put back what they removed
        switch (j) {
            ///remove minx    
            case 0:
                p = make_pair(remove->first, remove->second);
                x.erase(p);
                //remove the pair plus the index
                p1 = make_pair(cows[remove->second].second, remove->second);
                y.erase(p1);
                break;
            //remove maxx
            case 1:
                p = make_pair(remove1->first, remove1->second);
                x.erase(p);
                p1 = make_pair(cows[remove1->second].second, remove1->second);
                y.erase(p1);
                break;
            //remove miny
            case 2:
                p = make_pair(remove2->first, remove2->second);
                y.erase(p);
                p1 = make_pair(cows[remove2->second].first, remove2->second);
                x.erase(p1);
                break;
            //remove maxy
            default:
                p = make_pair(remove3->first, remove3->second);
                y.erase(p);
                p1 = make_pair(cows[remove3->second].first, remove3->second);
                x.erase(p1);
        }
        process(steps + 1);
        //add back what they removed
        if (j < 2) {
            x.insert(p);
            y.insert(p1);
        } else {
            y.insert(p);
            x.insert(p1);
        }
    }
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("reduce.in","r",stdin);
    freopen("reduce.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a,b;
        cin >> a >> b;
        pair<int,int> point = make_pair(a,b);
        x.insert(make_pair(a,i));
        y.insert(make_pair(b,i));
        cows.push_back(point);
    }
    process(0);
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
