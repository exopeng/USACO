#include <bits/stdc++.h>
using namespace std;
 

const int MAXN = 500;
const int MAXM = 50;
long long ans = 0;
int n, m;
char spots[MAXN][MAXM];
char plain[MAXN][MAXM];
unordered_set<string> taken;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("cownomics.in","r",stdin);
    freopen("cownomics.out","w",stdout);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> spots[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> plain[i][j];
        }
    }
    string temp;
    temp.resize(3);
    for (int i = 0; i < m; i++) {
        for (int j = i +1; j < m; j++) {
            for (int e = j + 1; e < m; e++) {
                //add all the ones in spots
                taken.clear();
                for (int y = 0; y < n; y++) {
                    temp[0] = spots[y][i];
                    temp[1] = spots[y][j];
                    temp[2] = spots[y][e];
                    taken.insert(temp);
                }
                //see if any of the plain ones contain, it
                for (int y = 0; y < n; y++) {
                    temp[0] = plain[y][i];
                    temp[1] = plain[y][j];
                    temp[2] = plain[y][e];
                    if (taken.find(temp) != taken.end()) {
                        break;
                    }
                    if (y == n-1) {
                        ans++;
                    }
                }
            }
        }
    }
    cout << ans << "\n";
    return 0;
}
