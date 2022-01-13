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

vector<VI>gr;
VI parent;
VI path;
map<int,int>ign;
map<int,int>vis;
vector<int64> sz;
//int it=0;
void dfs(int v, int pa) {
	//cout << v << " "<<pa<<endl;
	if (vis[v]) {
		parent[v]=pa;
		pa=parent[v];
		while(pa!=v) {
			path.PB(pa);
			pa=parent[pa];
		}
	} else {
		parent[v]=pa;
		vis[v]=1;
		for(auto e:gr[v]) {
			if (e==pa) continue;
			dfs(e,v);
		}
	}
}

int64 dfs2(int v, int pa) {
	if(vis[v]) return 0;
	sz[v]=1L;
	vis[v]=1;
	for(auto e:gr[v]) {
		if ((e==pa) || ign[e]) continue;
		sz[v]+=dfs2(e,v);
	}
	return sz[v];
}
int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	int test;
	cin>>test;
	while(test--) {
		//debug(1);
		int n;
		cin>>n;
		gr=vector<VI>(n+1);
		sz=vector<int64>(n+1);
		parent=VI(n+1);
		path.clear();
		ign.clear();
		vis.clear();
		
		REP(i,n) {
			int u,v;
			cin>>u>>v;
			gr[u].PB(v);
			gr[v].PB(u);
		}
		
		dfs(1,-1);
		//debug(parent);

		for(auto e:path) {
			ign[e]=1;
		}
		
		vis.clear();
		//debug(path);
		//debug(ign);
		int64 N=n;
		int64 ans=(N*(N-1)*1LL);
		for(auto e:path) {
			if(vis[e]) continue;
			sz[e]=dfs2(e,-1);
			ans -= (sz[e]*(sz[e]-1)*1LL)/2LL;
			//debug(sz[e]);
		}
		printf("%lld\n", ans);
	}
	return 0;
}


/**
 * 
 * 1
10
2 6
5 9
2 4
8 4
1 10
2 8
2 1
1 3
7 4
5 4

**/
