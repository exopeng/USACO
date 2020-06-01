#include <bits/stdc++.h>
using namespace std;
 
int ans = 0;
pair<int,int> cows[100000];

int main() {
	int counter = 0;
    freopen("pairup.in","r",stdin);
    freopen("pairup.out","w",stdout);
    int types;
    cin >> types;
    for (int i = 0; i < types; i++) {
    	int n; 
    	cin >> n;
    	int element;
    	cin >> element;
    	cows[i] = make_pair(element, n);
    }
    sort(cows, cows + types);
    int i = 0;
    int j = types - 1;
    while (i <= j) {
    	int lowest = cows[i].second;
    	int highest = cows[j].second;
    	ans = max(ans, cows[i].first + cows[j].first);
    	if (lowest == highest) {
    		i++;
    		j--;
    	} else if (lowest < highest) {
    		i++;
    		cows[j].second -= lowest;
    	} else {
    		j--;
    		cows[i].second -= highest;
    	}
    }
    cout << ans << "\n";
    return 0;
}
