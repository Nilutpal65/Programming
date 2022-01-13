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
struct cmp
{
	bool operator()(const pair<int64, int>& o1, const pair<int64, int>& o2) {
		return o1.first < o2.first; // ascending order
	}
};
int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	cin.tie(0);
	int n1,n2,n3,n4; int64 x;
	cin >> n1 >> n2 >> n3 >> n4;
	pair<int64, int> a1[n1],a2[n2],a3[n3],a4[n4];
	REP(i,n1) {
		cin >> x;
		a1[i] = {x,i};
	}
	REP(i,n2) {
		cin >> x;
		a2[i] = {x,i};
	}
	REP(i,n3) {
		cin >> x;
		a3[i] = {x,i};
	}
	REP(i,n4) {
		cin >> x;
		a4[i] = {x,i};
	}
	sort(a2,a2+n2,cmp());
	sort(a3,a3+n3,cmp());
	sort(a4,a4+n4,cmp());
	vector<set<int>>v1(n1),v2(n2),v3(n3);
	int q1,q2,q3,u1,u2;
	cin>>q1;
	REP(i,q1) {
		cin>>u1>>u2;
		--u1; --u2;
		v1[u1].insert(u2);
	}

	cin>>q2;
	REP(i,q2) {
		cin>>u1>>u2;
		--u1; --u2;
		v2[u1].insert(u2);
	}

	cin>>q3;
	REP(i,q3) {
		cin>>u1>>u2;
		--u1; --u2;
		v3[u1].insert(u2);
	}

	vector<ipair>vp1,vp2,vp3;
	REP(i, n3) {
		bool found = 0;
		REP(j,n4) {
			if (v3[ a3[i].second ].find( a4[j].second ) == v3[ a3[i].second ].end()) {
				found = 1;
				a3[i].first += a4[j].first;
				break;
			}
		}
		if (!found) {
			a3[i].first = LLONG_MAX;
		}
	}

	sort(a3,a3+n3,cmp());

	REP(i, n2) {
		bool found = 0;
		REP(j,n3) {
			if (a3[j].first == LLONG_MAX) break;
			if (v2[ a2[i].second ].find( a3[j].second ) == v2[ a2[i].second ].end()) {
				found = 1;
				a2[i].first += a3[j].first;
				break;
			}
		}
		if (!found) {
			a2[i].first = LLONG_MAX;
		}
	}
	sort(a2,a2+n2,cmp());
	int64 ans = LLONG_MAX;
	REP(i, n1) {
		bool found = 0;
		REP(j,n2) {
			if (a2[j].first == LLONG_MAX) break;
			if (v1[ a1[i].second ].find( a2[j].second ) == v1[ a1[i].second ].end()) {
				found = 1;
				a1[i].first += a2[j].first;
				break;
			}
		}
		if (found) {
			ans=min(ans, a1[i].first);
		}
	}

	if (ans == LLONG_MAX) ans = -1;

	cout << ans << "\n";

	return 0;
}

