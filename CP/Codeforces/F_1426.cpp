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
const int64 mod = (int64)1e9 + 7;
int64 modpow(int64 a, int64 b) {
	int64 d = 1;
	while(b > 0) {
		if (b&1) {
			d = d * a;
			d %= mod;
		}
		a = (a * a) % mod;
		b >>= 1;
	}
	return d;
}
int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	cin.tie(0);

	int n; cin >> n;
	string s; cin >> s;
	int64 la = 0,lc = 0,ra = 0,rc = 0,lq = 0, rq = 0;
	int64 ans = 0;
	REP(i,n) {
		ra += s[i] == 'a';
		rc += s[i] == 'c';
		rq += s[i] == '?';
	}
	REP(i,n) {
		ra -= (s[i] == 'a');
		rc -= (s[i] == 'c');
		rq -= (s[i] == '?');
		if (s[i] == 'b' || s[i] == '?') {
			if (la && rc) {
				ans += ((la * rc) % mod) * modpow(3,lq + rq);
			}
			if (la && rq) {
				ans += ((la * rq) % mod) * modpow(3,lq + rq - 1);
			}
			if (lq && rc) {
				ans += ((lq * rc) % mod) * modpow(3,lq + rq - 1);
			}
			if (lq && rq) {
				ans += ((lq * rq) % mod) * modpow(3,lq + rq - 2);
			}
		}
		ans %= mod;
		la += (s[i] == 'a');
		lc += (s[i] == 'c');
		lq += (s[i] == '?');
	}
	cout << ans;
	return 0;
}

