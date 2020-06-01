#include <bits/stdc++.h>
 
using namespace std;
const int MAXN = 1000;
int arr[MAXN][MAXN];
//0 reps R, 1 reps L
string ans = "-1";
 
int main() {
    freopen("leftout.in","r",stdin);
    freopen("leftout.out","w",stdout);
    int n = 0;
    cin >> n;

    //cout << n;
    string temp;
    for (int i = 0; i < n; i++) {
    	cin >> temp;
    	for (int j = 0; j < n; j++) {
    		if (temp[j] == 'L') {
    			arr[i][j] = 1;
    		}
    	}
    }

    //make everything 0, handle bottom row, then for every other row, change once if something isn't 0
    for (int i = n - 1; i > -1; i--) {
    	if (arr[n-1][i] != 0) {
    		for (int j = n - 1; j > -1; j--) {
    			if (arr[j][i] == 0) {
   	    			arr[j][i] = 1;
    			} else {
    				arr[j][i] = 0;
    			}
    		}
    	}
    }


    //start at 2nd to last row, going up
    for (int i = n - 2; i > -1; i--) {
    	if (arr[i][n-1] != 0) {
    		for (int j = n - 1; j > -1; j--) {
    			if (arr[i][j] == 0) {
   	    			arr[i][j] = 1;
    			} else {
    				arr[i][j] = 0;
    			}
    		}
    	}
    }
    //add a checker to flip everything by columns if something is there are more 1's than 0's in that column
    for (int i = 0; i < n; i++) {
    	int oct = 0;
    	int zct = 0;
    	for (int j = 0; j < n; j++) {
    		if (arr[j][i] == 1) {
    			oct++;
    		} else {
    			zct++;
    		}
    	}
    	if (oct > zct) {
    		for (int j = 0; j < n; j++) {
	    		if (arr[j][i] == 0) {
	    			arr[j][i] = 1;
	    		} else {
	    			arr[j][i] = 0;
	    		}
    		}
    	}
    } 
    
    //do the same for rows
    for (int i = 0; i < n; i++) {
        int oct = 0;
        int zct = 0;
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == 1) {
                oct++;
            } else {
                zct++;
            }
        }
        if (oct > zct) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
    } 
    

    //find the first non-zero one
    //it might be impossible to fix it, if there are more than 1 cow out of place
    int ipos = 0;
    int jpos = 0;
    int ct = 0;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < n; j++) {
    		if (arr[i][j] != 0) {
                ipos = i;
                jpos = j;
                ct++;
    		}
    	}
    }
    if (ct == 1) {
        ans = to_string(ipos + 1) + " " + to_string(jpos+1);
    } 
    cout << ans << "\n";
    return 0;
}
