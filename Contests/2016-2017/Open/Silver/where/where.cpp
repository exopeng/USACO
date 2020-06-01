#include <bits/stdc++.h>
using namespace std;

const int MAXN = 20;
char arr[MAXN][MAXN];
bool visited[MAXN][MAXN];
long long ans = 0;
int n;
char fchar;
char schar;
int fct = 0;
int sct = 0;
vector< pair<pair<int,int>, pair<int,int> > > pcl;

void dfs(int x1, int y1, int x2, int y2, int curri, int currj, char last) {
    if (curri < y1 || curri > y2 || currj < x1 || currj > x2) {
        return;
    }
    if (visited[curri][currj]) {
        return;
    }
    //make sure it is the same as the last one
    if (arr[curri][currj] != last) {
        return;
    }
    visited[curri][currj] = true;
    dfs(x1,y1,x2,y2,curri, currj+1, last);
    dfs(x1,y1,x2,y2,curri, currj-1, last);
    dfs(x1,y1,x2,y2,curri + 1, currj, last);
    dfs(x1,y1,x2,y2,curri-1, currj, last);
}
bool check(int x1, int y1, int x2, int y2) {
    unordered_set<char> taken;
    for (int i = y1; i <= y2; i++) {
        for (int j = x1; j <= x2; j++) {
            if (taken.size() == 2) {
                if (taken.find(arr[i][j]) == taken.end()) {
                    return false;
                }
            } else {
                if (taken.find(arr[i][j]) == taken.end()) {
                    taken.insert(arr[i][j]);
                    if (taken.size() == 1) {
                        fchar = arr[i][j];
                    } else {
                        schar = arr[i][j];
                    }
                }
            }
        }
    }
    for (int i = 0; i < pcl.size(); i++) {
        int cx1 = pcl[i].first.first;
        int cy1 = pcl[i].first.second;
        int cx2 = pcl[i].second.first;
        int cy2 = pcl[i].second.second;
            //include lower bound
        //not inside of one
        if (x1 >= cx1 && x1 <= cx2 && y1 >= cy1 && y1 <= cy2 
            && x2 >= cx1 && x2 <= cx2 && y2 >= cy1 && y2 <= cy2) {
            return false;
        }
        //not encompassing one
       if (cx1 >= x1 && cx1 <= x2 && cy1 >= y1 && cy1 <= y2 
            && cx2 >= x1 && cx2 <= x2 && cy2 >= y1 && cy2 <= y2) {
            return false;
        }
    }
    if (taken.size() < 2) {
        return false;
    }
    return true;
}
void reset() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            visited[i][j] = false;
        }
    }
}
void cc(int j, int i, int e, int f) {
    for (int m = i; m <= f; m++) {
        for (int n = j; n <= e; n++) {
            if (!visited[m][n]) {
                if (arr[m][n] == fchar) {
                    fct++;
                } else {
                    sct++;
                }
                dfs(j,i,e,f, m, n, arr[m][n]);  
            }
        }
    }
    //cout << fct << " " << sct << "\n";
    if ((fct == 1 && sct > 1) || (fct > 1 && sct == 1) ) {
        ans++;
        //cout << "here " << i << " " << j << " " << f << " " << e << "\n";
        pcl.push_back(make_pair(make_pair(j,i), make_pair(e,f)));
    }
}
int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);
    freopen("where.in","r",stdin);
    freopen("where.out","w",stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int f = n-1; f >= i; f--) {
                for (int e = n-1; e >= j; e--) {
                    fct = 0;
                    sct = 0;
                    fchar = '1';
                    schar = '1';
                    if (check(j,i,e,f)) {
                        //cout << i << " " << j << " " << f << " " << e << " " << fchar << " " << schar << "\n";
                        reset();
                        cc(j,i,e,f);
                    }
                }
            }
        }
    }

    cout << ans << "\n";
    return 0;
}
