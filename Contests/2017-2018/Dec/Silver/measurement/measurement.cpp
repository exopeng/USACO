#include <bits/stdc++.h>
using namespace std;
//if it ever drops below or equal to g gallons, then the default is the other cows not mentioned
//key is number of gals, val is number who had that number of gals
map <int,int> galct;
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
    unordered_set <int> ids;
    //default value that unaccounted cows have
    for (int i = 0; i < n; i++) {
    	int day, id, change;
    	cin >> day >> id;
    	id--;
    	if (ids.find(id) == ids.end()) {
    		ids.insert(id);
    	}
    	string element;
    	cin >> element;
    	if (element[0] == '+') {
    		change = stoi(element.substr(1));
    	} else {
    		change = stoi(element);
    	}
    	logs.push_back(make_pair(day, make_pair(id, change)));
    	galct[id] = g;
    }
    mp[g] = ids.size() + 1;
    sort(logs.begin(), logs.end());
    for (int i = 0 ; i < n; i++) {
    	int id = logs[i].second.first;
    	int change = logs[i].second.second;
    	int before = galct[id];
    	galct[id] += change;
    	mp[before]--;
    	//if on the leaderboard before
    	if (before == mp.begin()->first) {
    		//make sure to erase it if it was the only value
    		bool onlyOne = false;
    		if (mp[before] == 0) {
    			mp.erase(before);
    			onlyOne = true;
    		}
    		//if it was the only one on leaderboard
    		if (onlyOne) {
    			//if the new person is greater than or equal to it
    			if (mp.begin()->first >= galct[id]) {
    				ans++;
    			}
    		} else {
    			//there were multiple people on leaderboard
    			ans++;
    		}
    		//not on leaderboard before, now equal to or greater than the top one
    	} else if (galct[id] >= mp.begin()->first) {
    		ans++;
    	}
    	if (mp[before] == 0) {
    		mp.erase(before);
    	}
    	mp[galct[id]]++;
    }
    
    cout << ans << "\n";
    return 0;
}
