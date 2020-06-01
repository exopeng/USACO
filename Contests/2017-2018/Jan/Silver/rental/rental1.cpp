#include <bits/stdc++.h>
using namespace std;

long long ans = 0;
const int MAXN = 100000;
const int MAXM = 100000;
const int MAXR = 100000;
int n,m,r;
vector <int> gals;
//second is number of gallons, first is price per gallon
vector < pair<int,int> > sell;
vector <int> rent;

//bool cmp(const pair<int,int> &a, const pair<int,int> &b) { 
//    return (a.second < b.second); 
//} 

long long simulate(int toSell, int toRent) {
	long long curr = 0;
	long long gal = 0;
	for (int i = 0; i < toSell; i++) {
		gal += gals[i];
	}
	for (int i = 0; i < sell.size(); i++) {
		if (gal < sell[i].second) {
			curr += gal * sell[i].first;
			break;
		} else {
			gal -= sell[i].second;
			curr += sell[i].first * sell[i].second;
		}
	}
	for (int i = 0; i < toRent && i < rent.size(); i++) {
		curr += rent[i];
	}
	return curr;
}
int main() {
    freopen("rental.in","r",stdin);
    freopen("rental.out","w",stdout);
    cin >> n >> m >> r;
    for (int i = 0; i < n; i++) {
    	int e;
    	cin >> e;
    	gals.push_back(e);
    }

    for (int i = 0; i < m; i++) {
    	int x,y;
    	cin >> y >> x;
    	sell.push_back(make_pair(x,y));
    }

    for (int i = 0; i < r; i++) {
    	int f;
    	cin >> f;
    	rent.push_back(f);
    }

    sort(gals.begin(), gals.end());
    sort(sell.begin(), sell.end());
    sort(rent.begin(), rent.end());
    reverse(gals.begin(), gals.end());
    reverse(sell.begin(), sell.end());
    reverse(rent.begin(), rent.end());

    ans = max(ans, simulate(0,n));
    ans = max(ans, simulate(n, 0));

    int low = 0;
    int high = n;
    int mid = 0;
    //special case n = 2
    if (n == 2) {
    	cout << ans << "\n";
    	return 0;
    }
    //increasing then decrease
    while (low < high) {
    	mid = (low + high) / 2;
    	if (simulate(mid, n - mid) > simulate(mid - 1, n - mid - 1) && simulate(mid + 1, n - mid + 1) < simulate(mid, n - mid)) {
    		ans = max(ans,simulate(mid, n - mid));
    		break;
    	} else if (simulate(mid - 1, n - mid - 1) < simulate(mid,n - mid)) {
    		low = mid;
    	} else {
    		high = mid;
    	}
    }
    cout << ans << "\n";
    return 0;
}
