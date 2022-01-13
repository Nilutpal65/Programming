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
struct st{
	int x,y,z;
	st(int x, int y, int z): x(x),y(y),z(z) { }
};
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
		int n; cin>>n;
		int64 a[n];
		int64 sum=0;
		REP(i,n) {
			cin>>a[i];
			sum+=a[i];
		}
		if(sum%n != 0) {
			cout<<-1<<endl;
			continue;
		}
		vector<st>v;
		FOR(i,1,n) {
			int64 mod=a[i]%(i+1);
			if(mod == 0) {
				v.PB(st(i+1,1,a[i]/(i+1)));
				//cout<<(i+1)<<" "<<1<<" "<<(a[i]/(i+1))<<endl;
			} else {
				int64 diff = i+1-mod;
				//cout<<1<<" "<<(i+1)<<" "<<diff<<endl;
				v.PB(st(1,i+1,diff));
				a[i]+=diff;
				v.PB(st(i+1,1,a[i]/(i+1)));
				//cout<<(i+1)<<" "<<1<<" "<<(a[i]/(i+1))<<endl;
			}
		}
		int64 div = sum / n;
		FOR(i,2,n+1) {
			v.PB(st(1,i,div));
			//cout<<1<<" "<<i<<" "<<div<<endl;
		}
		cout<<v.size()<<endl;
		REP(i,v.size()) {
			cout<<v[i].x<<" "<<v[i].y<<" "<<v[i].z<<endl;
		}
	}
	return 0;
}

