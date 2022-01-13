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
string s;
struct cmp {
	bool operator()(const int& i, const int& j) {
		return s[i]>s[j];
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
	int test; cin >> test;
	while(test--) {
		map<char,int>co,count;
		map<int,int> used;
		cin >> s;
		int n=s.length();
		vector<char>ss,ans,temp;
		int ii =0 ;
		while(ii<n) {
			char cc= s[ii];
			ss.PB(cc);
			while(ii<n && cc==s[ii]) { ii++; }
		}
		s=string(ss.begin(),ss.end());
		n=s.length();
		for(auto e:s) co[e]++;
		int i = 0;
		while(i<n) {
			VI ind;
			ind.clear();
			temp.clear();
			while(i<n && (co[s[i]] > 1)) {
				temp[s[i]]++;
				ind.PB(i++);
			}
			if(ind.size() > 0) {
				char extra='0';
				while(i<n && co[s[i]]==0) ++i;
				if (i<n) {
					extra=s[i];
					ind.PB(i);
				}
				sort(ind.begin(), ind.end(), cmp());
				
				used[ind[0]] = 1;
				co[s[ind[0]]]= 0;
				ans.PB(s[ind[0]]);

				FOR(j,1,ind.size()) {
					int e=ind[j];
					if (extra != '0' && ((s[e] > extra) && (e > ind[0])) && co[s[e]]>0) {
						ans.PB(s[e]);
						co[s[e]]=0;
						used[e]=1;
						continue;
					}
					if (co[s[e]] == temp[s[e]]) {
						ans.PB(s[e]);
						used[e]=1;
						co[s[e]]=0;
						continue;
					}
					if (i<n && e==i) continue;
					if(co[s[e]])
					co[s[e]]--;
				}
			} else {
				if(co[s[i]] == 1) {
					ans.PB(s[i]);
					used[i] = 1;
				}
				++i;
			}
		}
	}
	return 0;
}