#include <bits/stdc++.h>
 
using namespace std;
 

 
long long ans = 0;
 
int main() {
    freopen("moobuzz.in","r",stdin);
    freopen("moobuzz.out","w",stdout);
    int x;
    cin >> x;
    ans = (x / 16) * 30;
    int r = x % 16;
    long num = 0;
    for (int i = 0; i < r; i++) {
    	num++;
    	while (num % 3 == 0 || num % 5 == 0) {
    		num++;
    	}
    }
    ans += num;
    cout << ans << '\n';
    return 0;
}
