#include <bits/stdc++.h>
using namespace std;
const int cows = 1000000000;
//if it ever drops below or equal to g gallons, then the default is the other cows not mentioned
//key is number of gals, val is number who had that number of gals
int galct[cows];
vector< pair< int, pair<int,int> > > logs;
map<int, int, greater<int> > mp;

//first is day, first of second is id, second of second is change
int n,g;
long long ans = 0;
 
int main() {
	//use sorted map to navigate this, it will automatically sort to give highest value, not p queue, ds problem
    freopen("measurement.in","r",stdin);
    freopen("measurement.out","w",stdout);
    cin >> n >> g;
    cout << ans << "\n";
    return 0;
}
