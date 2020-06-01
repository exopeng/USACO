#include <bits/stdc++.h>
using namespace std;

long long ans = 0;
long long n,m,r;
vector <long long> gals;
//second is number of gallons, first is price per gallon
vector < pair<long long,long long> > sell;
vector <long long> rent;
int sellInd = 0;
//bool cmp(const pair<int,int> &a, const pair<int,int> &b) { 
//    return (a.second < b.second); 
//} 
long long simulateRent(long long curr, long long prevVal) {
    if (curr > r - 1) {
        return prevVal;
    }
    return rent[curr] + prevVal;
}
long long simulateSell(long long gal, long long prevVal) {
	long long curr = 0;
	for (int i = sellInd; i < sell.size(); i++) {
		if (gal < sell[i].second) {
			curr += gal * sell[i].first;
            sell[i].second -= gal;
            sellInd = i;
			break;
		} else {
			gal -= sell[i].second;
            curr += sell[i].first * sell[i].second;
            sell[i].second = 0;
		}
	}
	return curr + prevVal;
}
int main() {
    freopen("rental.in","r",stdin);
    freopen("rental.out","w",stdout);
    cin >> n >> m >> r;
    for (int i = 0; i < n; i++) {
    	long long e;
    	cin >> e;
    	gals.push_back(e);
    }

    for (int i = 0; i < m; i++) {
    	long long x,y;
    	cin >> y >> x;
    	sell.push_back(make_pair(x,y));
    }

    for (int i = 0; i < r; i++) {
    	long long f;
    	cin >> f;
    	rent.push_back(f);
    }

    sort(gals.begin(), gals.end());
    sort(sell.begin(), sell.end());
    sort(rent.begin(), rent.end());
    reverse(gals.begin(), gals.end());
    reverse(sell.begin(), sell.end());
    reverse(rent.begin(), rent.end());

    vector <long long> rented;
    rented.push_back(0);
    //cout << rented[0] << " ";
    for (long long i = 1; i <= n; i++) {
        rented.push_back(simulateRent(i - 1, rented[i-1]));
        //cout << rented[i] << " ";
    }
    //cout << "\n";
    vector<long long> sold;
    sold.push_back(0);
    //cout << sold[0] << " ";
    for (long long i = 1; i <= n; i++) {
        sold.push_back(simulateSell(gals[i-1], sold[i-1]));
        //cout << sold[i] << " ";
    }
    for (long long i = 0; i <= n; i++) {
        ans = max(ans, sold[i] + rented[n-i]);
    }
    cout << ans << "\n";
    return 0;
}
