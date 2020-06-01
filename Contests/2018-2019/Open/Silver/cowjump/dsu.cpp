#include <bits/stdc++.h>
using namespace std; 


//maintain a parent array, each index corresponds to a node, and the value is the immediate parent
//size is the size of the set it is in
void make_set(int v) {
    parent[v] = v;
    size[v] = 1;
}

//merges the smaller of the two sets to the larger
void union_sets(int a, int b) {
    a = find_set(a);
    b = find_set(b);
    if (a != b) {
        if (size[a] < size[b])
            swap(a, b);
        parent[b] = a;
        size[a] += size[b];
    }
}

//uses path compression, so every node in the set points to the root node(parent)
int find_set(int v) {
    if (v == parent[v])
        return v;
    return parent[v] = find_set(parent[v]);
}