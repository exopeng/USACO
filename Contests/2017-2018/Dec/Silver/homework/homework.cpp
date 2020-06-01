#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100000;
const int MAXK = 100000;
vector<int> scores;
vector<int> mins;
vector<int> sums;
vector<int> ks;
double maxscore = -1;
int n;
int main() {
    freopen("homework.in","r",stdin);
    freopen("homework.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
    	int element;
    	cin >> element;
    	scores.push_back(element);
    }
    reverse(scores.begin(), scores.end());
    //calc min
    mins.push_back(min(scores[0],scores[1]));
    for (int i = 2; i < n-1; i++) {
    	mins.push_back(min(mins[i - 2], scores[i]));
    }
    sums.push_back(scores[0] + scores[1]);
    for (int i = 2; i < n-1; i++) {
    	sums.push_back(sums[i-2] + scores[i]);
    }
    for (int i = 1; i < n-1; i++) {
    	if ((double)(sums[i-1] - mins[i-1]) / (double)(i) > maxscore) {
    		ks.clear();
    		ks.push_back(n - i - 1);
    		maxscore = (double)(sums[i-1] - mins[i-1]) / (double)(i);
    	} else if ((double)(sums[i-1] - mins[i-1]) / (double)(i) == maxscore) {
    		ks.push_back(n - i - 1);
    	}
    }
    sort(ks.begin(), ks.end());
    for (int i = 0; i < ks.size(); i++) {
    	cout << ks[i] << "\n";
    }

    return 0;
}
