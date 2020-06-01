#include <bits/stdc++.h>
long long ans = 0;
using namespace std; 
  
struct Point 
{ 
    int x; 
    int y; 
}; 
  
// Given three colinear points p, q, r, the function checks if 
// point q lies on line segment 'pr' 
bool onSegment(Point p, Point q, Point r) 
{ 
    if (q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) && 
        q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y)) 
       return true; 
  
    return false; 
} 
  
// To find orientation of ordered triplet (p, q, r). 
// The function returns following values 
// 0 --> p, q and r are colinear 
// 1 --> Clockwise 
// 2 --> Counterclockwise 
int orientation(Point p, Point q, Point r) 
{ 
    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
    // for details of below formula. 
    int val = (q.y - p.y) * (r.x - q.x) - 
              (q.x - p.x) * (r.y - q.y); 
  
    if (val == 0) return 0;  // colinear 
  
    return (val > 0)? 1: 2; // clock or counterclock wise 
} 
  
// The main function that returns true if line segment 'p1q1' 
// and 'p2q2' intersect. 
bool doIntersect(Point p1, Point q1, Point p2, Point q2) 
{ 
    // Find the four orientations needed for general and 
    // special cases 
    int o1 = orientation(p1, q1, p2); 
    int o2 = orientation(p1, q1, q2); 
    int o3 = orientation(p2, q2, p1); 
    int o4 = orientation(p2, q2, q1); 
  
    // General case 
    if (o1 != o2 && o3 != o4) 
        return true; 
  
    // Special Cases 
    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
  
    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
  
    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
  
     // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
  
    return false; // Doesn't fall in any of the above cases 
} 
vector< pair< pair<int,int>, pair<int,int> > > segs;
const int MAXN = 100000;
int main() {
    freopen("cowjump.in","r",stdin);
    freopen("cowjump.out","w",stdout);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
     	int x1,y1,x2,y2;
     	cin >> x1 >> y1 >> x2 >> y2;
     	segs.push_back(make_pair(make_pair(x1,y1), make_pair(x2,y2)));
    }
	unordered_set<int> present; 
    vector<int> indices;
    //get the segments that intersect, then try removing those
    //the only segment to remove is the one that appears multiple times, or if only intersects with one other, then one segment,
    for (int j = 0; j < n; j++) {
		for (int f = j + 1; f < n; f++) {
			struct Point p1 = {segs[j].first.first, segs[j].first.second}, q1 = {segs[j].second.first, segs[j].second.second}; 
			struct Point p2 = {segs[f].first.first, segs[f].first.second}, q2 = {segs[f].second.first, segs[f].second.second}; 
			if (doIntersect(p1, q1, p2, q2)) {
				//if this segment hasn't intersected yet, then add to list
				if (present.count(j) == 0) {
					indices.push_back(j);
					present.insert(j);
				} else {
					//if found a segment that already intersected once, then this must be the one to remove
					cout << (j + 1) << "\n";
					return 0;
				}
				if (present.count(f) == 0) {
					indices.push_back(f);
					present.insert(f);
				} else {
					cout << (f + 1) << "\n";
					return 0;
				}
			}
		}
	}
	//if there is only 1 intersection
	sort(indices.begin(), indices.end());
    cout << (indices[0] + 1) << "\n";
    return 0;
}
