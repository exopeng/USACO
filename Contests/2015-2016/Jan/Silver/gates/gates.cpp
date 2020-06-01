#include <bits/stdc++.h>
using namespace std;
 

struct pair_hash
{
	template <class T1, class T2>
	std::size_t operator() (const std::pair<T1, T2> &pair) const
	{
		return std::hash<T1>()(pair.first) ^ std::hash<T2>()(pair.second);
	}
};

long long ans = 0;

//vector< pair< pair<int,int>, pair<int,int> > > segs;
set< pair< pair<int,int>, pair<int,int> > > segs;

unordered_set< pair<int,int> , pair_hash > points;
//0 for start, 1 for end
int n;

//small enough to brute force check if segment exists
bool present(pair< pair<int,int>, pair<int,int> > seg) {
	if (segs.find(seg) != segs.end() || segs.find(make_pair(make_pair(seg.second.first, seg.second.second), make_pair(seg.first.first, seg.first.second))) != segs.end()) {
		return true;
	}
	//for (int i = 0; i < segs.size(); i++) {
	//	if ((segs[i].first == seg.first && segs[i].second == seg.second) || (segs[i].second == seg.first && segs[i].first == seg.second)) {
	//		return true;
	//	}
	//}
	return false;
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("gates.in","r",stdin);
    freopen("gates.out","w",stdout);
    cin >> n;
    string instruct;
    cin >> instruct;
    int currx = 0;
    int curry = 0;
    points.insert(make_pair(currx,curry));

    for (int i = 0; i < n; i++) {
    	int endx = currx;
    	int endy = curry;
    	if (instruct[i] == 'N') {
    		endy++;
    	} else if (instruct[i] == 'S') {
    		endy--;
    	} else if (instruct[i] == 'W') {
    		endx--;
    	} else {
    		endx++;
    	}

    	//check if a segment occupies both the start and end pos or vice versa, then ignore
    	if (present(make_pair(make_pair(currx,curry), make_pair(endx, endy)))) {
    		currx = endx;
    		curry = endy;
    		continue;
    	}
    	
    	//see if the point already exists
    	if (points.find(make_pair(endx,endy)) != points.end()) {
    		ans++;
    	}
    	//establish a fence
    	//segs.push_back(make_pair(make_pair(currx,curry), make_pair(endx, endy)));
    	segs.insert(make_pair(make_pair(currx,curry), make_pair(endx, endy)));
    	points.insert(make_pair(endx,endy));
    	currx = endx;
    	curry = endy;
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
