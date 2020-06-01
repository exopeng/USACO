#include <bits/stdc++.h>
using namespace std;
 
const int MAXL = 1000000;
const int MAXF = 1000000;
const int MAXN = 100000;
const int MAXC = 1000000;
const int MAXB = 1000000;
vector< pair<int,int> > stops;
vector< pair<int,int> > rstops;
int counter = 1;
int l,n;
double rf,rb;
int x[MAXN];

long long ans = 0;
 
int main() {
    freopen("reststops.in","r",stdin);
    freopen("reststops.out","w",stdout);
   	cin >> l >> n >> rf >> rb;
   	//change into meters per second
   	int rorig, borig;
   	rorig = rf;
   	borig = rb;
   	for (int i = 0; i < n; i++) {
   		int x, c;
   		cin >> x >> c;
   		stops.push_back(make_pair(x,c));
   	}
   	//calculate max tastiness up to some point, basically skip only to max tastiness points
   	int maxt[MAXN];
   	maxt[n-1] = stops[n-1].second;
   	rstops.push_back(stops[n-1]);
   	for (int i = n - 2; i > -1; i--) {
   		if (stops[i].second > maxt[i+1]) {
   			rstops.push_back(stops[i]);
   			counter++;
   			maxt[i] = stops[i].second;
   		} else {
   			maxt[i] = maxt[i+1];
   		}
   	}
   	reverse(rstops.begin(), rstops.end());
   	//use arrays when you can ig
   	long long tf = 0;
   	long long bf = 0;
   	long long laststop = 0;
   	for (int i = 0; i < counter; i++) {
   		double currstop = rstops[i].first;
   		//calculate time it takes for both of them to get there
   		tf = (currstop - laststop) * (static_cast<long long>(rorig));
   		bf = (currstop - laststop) * (static_cast<long long>(borig));
   		ans += (tf - bf) * ((long long)(rstops[i].second));
   		//calculate how much time before fpos catches up
   		//floating point error
   		bf = 0;
   		tf = 0;
   		laststop = currstop;
   	}
    cout << ans << "\n";
    return 0;
}
