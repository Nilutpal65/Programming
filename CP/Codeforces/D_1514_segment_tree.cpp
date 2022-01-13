#ifdef ONLINE_JUDGE
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <bits/stdc++.h>

using namespace std;

#define POW2(X) (1<<(X))
#define CKBIT(S,X) (((S)&POW2(X))!=0)
const double pi=acos(-1.0);
const double eps=1e-11;
template<class T> inline void ckmin(T &a,T b){ a=min(a,b); }
template<class T> inline void ckmax(T &a,T b){ a=max(a,b); }
template<class T> inline T sqr(T x){ return x*x; }
#define SIZE(A) ((int)A.size())
#define LENGTH(A) ((int)A.length())
#define MP(A,B) make_pair(A,B)
#define PB(X) push_back(X)
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,a) for(int i=0;i<(a);++i)
#define ALL(A) A.begin(),A.end()
#define ff first
#define ss second
using uint=unsigned int;
using int64=long long int;
using uint64=unsigned long long int;
using ipair=pair<int,int>;
using VI=vector<int>;
using VD=vector<double>;

#ifndef ONLINE_JUDGE
#define debug(x) cerr << #x <<" "; _print(x); cerr << endl;
#else
#define debug(x)
#endif

void _print(int64 t) {cerr << t;}
void _print(int t) {cerr << t;}
void _print(string t) {cerr << t;}
void _print(char t) {cerr << t;}
void _print(double t) {cerr << t;}
void _print(uint64 t) {cerr << t;}

template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T, class V> void _print(pair <T, V> p) {cerr << "{"; _print(p.ff); cerr << ","; _print(p.ss); cerr << "}";}
template <class T> void _print(vector <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(set <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(multiset <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T, class V> void _print(map <T, V> v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}

const int maxn = 3e5 + 5;
int a[maxn];
int tree[3 * maxn];
vector<VI> v(maxn);

int cnt(int l,int r,int c) {
    return upper_bound(v[c].begin(),v[c].end(),r)-lower_bound(v[c].begin(),v[c].end(),l);
}

void build(int v, int L, int R) {
	if (L == R) {
		tree[v]=a[L];
	} else {
		int mid = (L + R) / 2;
		build(2*v,L,mid);
		build(2*v+1,mid+1,R);
		tree[v]=cnt(L,R,tree[2*v]) > cnt(L,R,tree[2*v+1]) ? tree[2*v] : tree[2*v+1];
	}
}

int query(int v,int st, int en, int l, int r) {
	if (en<l || st>r || r<l) {
		return 0;
	}
	if(l<=st && en<=r) {
		return cnt(l,r,tree[v]);
	} else {
		int mid=(st+en)/2;
    	return max(query(2*v,st,mid,l,r),query(2*v+1,mid+1,en,l,r));
	}
}

int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	cin.tie(0);
	int n, q;
	cin >> n >> q;
	FOR(i,1,n+1) {
		cin >> a[i];
		v[a[i]].PB(i);
	}
	build(1,1,n);
	while (q--) {
        int l,r;
        cin >> l >> r;
        printf("%d\n",max(1,2*query(1,1,n,l,r)-(r-l+1)));
    }
	return 0;
}

