#include <bits/stdc++.h>
#define MAXN 100000
using namespace std;
 
long long ans = 1;
int minYUpToCurr[MAXN];
int maxYDownToCurr[MAXN];

int main() {
    freopen("moop.in","r",stdin);
    freopen("moop.out","w",stdout);
    int p;
    cin >> p;
    vector< pair<int,int> > points;
    for (int i = 0; i < p; i++) {
    	int x;
	int y;
        cin >> x >> y;
	points.push_back(make_pair(x,y));
    }
    
    sort(points.begin(),points.end());

    maxYDownToCurr[p - 1] = points[p-1].second;
    for (int i = p - 2; i > -1; i--) {
        	maxYDownToCurr[i] = max(maxYDownToCurr[i + 1], points[i].second);
    }

    minYUpToCurr[0] = points[0].second;
    for (int i = 1; i < p; i++) {
            minYUpToCurr[i] = min(minYUpToCurr[i - 1], points[i].second);
    }

    for (int i = 0; i < p - 1; i++) {
        //if the smallest y in the left component is greater than the largest y in the right component
        //the two can't merge as they tie in x and y
        if (minYUpToCurr[i] > maxYDownToCurr[i + 1]) {
            ans++;
        }
    }
    cout << ans << "\n";
    return 0;
}
