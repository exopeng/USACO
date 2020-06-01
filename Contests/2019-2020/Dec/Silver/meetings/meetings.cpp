#include <bits/stdc++.h>
using namespace std;
const int MAXN = 50000;
vector < pair <double, pair<int, double> > > cowLine;

long double maxWeight;
long long ans = 0;
int barnpos1 = 0;
int barnpos2;
int n;
long long currWeight = 0;
bool finished[MAXN];

int main() {
    freopen("meetings.in","r",stdin);
    freopen("meetings.out","w",stdout);

    cin >> n >> barnpos2;
 	
 	for (int i = 0; i < n; i++) {
 		int w, x, v;
 		cin >> w >> x >> v;
 		cowLine.push_back(make_pair(x, make_pair(w, v)));
 		maxWeight += w;
 	}
 	//sort by x position
 	sort(cowLine.begin(), cowLine.end());
 	//for (int i = 0; i < n; i++) {
 	//		cout << cowLine[i].first << " ";
 	//}
 	//cout << "\n";
 	//start simulating every half second
 	while (1) {
 		for (int i = 0; i < n; i++) {
 			if (!finished[i]) {
 				 cowLine[i].first += (cowLine[i].second.second / 2);
 			}
 		}
 		//check for meetings with barns and other cows
 		for (int i = 0; i < n; i++) {
 			if (!finished[i]) {
 				if (cowLine[i].first == barnpos1 || cowLine[i].first == barnpos2) {
 					currWeight += cowLine[i].second.first;
 					finished[i] = true;
 				}
 				//overcount by 2
 				if (i != n - 1) {
 					if (cowLine[i].first == cowLine[i + 1].first) {
 						cowLine[i].second.second *= -1;
 						cowLine[i + 1].second.second *= -1;
 						ans++;
	 				}
 				}
 			}
 		}
 		
 		if (currWeight >= maxWeight / 2) {
    		cout << ans << "\n";
    		return 0;
 		}

 	}
    return 0;
}
