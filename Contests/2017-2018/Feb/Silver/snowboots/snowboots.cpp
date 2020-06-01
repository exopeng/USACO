#include <bits/stdc++.h>
 
using namespace std;
const int MAXB = 250;
const int MAXN = 250;
int arr[MAXN];
vector< pair<int,int> > boots;
int n, b;
int visited[MAXN][MAXB];
int ans = 10000;
//don't iterate on bootsleft, just on pos and bpos, otherwise repetition
void search(int pos, int bpos) {
	visited[pos][bpos] = 1;
	if (pos == n - 1) {
		ans = min(bpos, ans);
		return;
	}
	for (int i = bpos; i < b; i++) {
		//choose to switch boots
		if (boots[i].first >= arr[pos]) {
			//look at all possible jumps
			for (int j = pos + 1; j <= pos + boots[i].second && j < n; j++) {
				if (!visited[j][i]) {
					//if able to step there
					if (boots[i].first >= arr[j]) {
						search(j, i);
					}
				}
				
			}
		}
	}
	//if (bootsleft == 0) {
	//	return false;
	//}
	return;
}
int main() {
    freopen("snowboots.in","r",stdin);
    freopen("snowboots.out","w",stdout);
    cin >> n >> b;
    for (int i = 0; i < n; i++) {
    	cin >> arr[i];
    }
    for (int i = 0; i < b; i++) {
    	int s, d;
    	cin >> s >> d;
    	boots.push_back(make_pair(s,d));
    }
    //why do i need to repeatedly do this?
    //boolean part terminates early, not seeing all other possibilities, looping makes it go forward once, so it visits all possibilities
    for (int i = 0; i < b; i++) {
    	search(0, 0);
    	//cout << ans << "/n";
    }
    cout << ans << "\n";
    return 0;
}
