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
int maxn = 100;
int const INF = (int)1e9 + 1e3;
int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	cin.tie(0);
	cout << setprecision(15) << fixed;
	int n;
	int a,b;
	vector<VI> dp(n+1,VI((n * maxn + 1), -INF));
	double sum = 0;
	cin >> n;
	dp[0][0]=0;
	REP(i,n) {
		cin>>a>>b;
		sum += b;
		for(int j=n-1;j>=0;--j) {
			for(int k=i*maxn;k>=0;--k) {
				dp[j+1][k+a]=max(dp[j+1][k+a],dp[j][k] + b);
			}
		}
	}
	for (int i = 1; i <= n; ++i) {
		double ans = 0;
		for (int sa = 0; sa <= i * maxn; ++sa) {
			ans = max(ans, min((double) sa, dp[i][sa] + (sum - dp[i][sa]) / 2.0));
		}
		cout << ans << " ";
	}
	return 0;
}

