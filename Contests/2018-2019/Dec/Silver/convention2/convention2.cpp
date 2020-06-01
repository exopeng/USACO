#include <bits/stdc++.h>
 
using namespace std;
 
int ans = 0;
int n;
bool cmp(const pair<int, pair<int,int> > &a, 
              const pair<int, pair<int,int> > &b) 
{ 
    if (a.first == b.first) {
        return (a.second.second > b.second.second);
    }
    return (a.first < b.first); 
} 

struct CustomCompare
{
    bool operator()(const pair<int, pair<int,int> >& lhs, const pair<int, pair<int,int> >& rhs)
    {
        return lhs.second.second < rhs.second.second;
    }
};


int main() {
    freopen("convention2.in","r",stdin);
    freopen("convention2.out","w",stdout);
    cin >> n;
    vector < pair <int,int> > cows;
    list < pair <int, pair <int,int> > > cowsSorted;
    priority_queue < pair<int, pair<int,int> >,  vector<pair<int, pair<int,int> > >, CustomCompare > p;

    for (int i = 0; i < n; i++) {
    	int a;
    	int t;
    	cin >> a >> t;
    	cows.push_back(make_pair(a, t));
    	cowsSorted.push_back(make_pair(a, make_pair(t,n - i)));
    }

    //if have same time, further sorted by priority
    cowsSorted.sort();
    int currTime = 0;
   

    while (true) {
        pair<int, pair<int,int> > cow;
        if (!p.empty()) {
            cow = p.top();
            p.pop();
            ans = max(ans, currTime - cow.first);
            currTime += cow.second.first;
        } else {
            if (cowsSorted.empty()) {
                break;
            }
            cow = *cowsSorted.begin();
            cowsSorted.pop_front();
            currTime = cow.first + cow.second.first;
        }
        //cout << cow.first << " " << cow.second.first << " " << cow.second.second << "\n";       

        //see if any have this time, or less
        for (list<pair<int, pair<int,int> > >::iterator j = cowsSorted.begin(); j != cowsSorted.end(); j++) {
            if (j->first <= currTime) {
                p.push(*j);
                //cout << j->first << " " << j->second.first << " " << j->second.second << "\n";       
                cowsSorted.erase(j);
                j--;
            } else {
                break;
            } 
        }

    }

    
    cout << ans << "\n";
    return 0;
}
