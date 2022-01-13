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
int main()
{
//#ifdef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	cin.tie(0);
	int test; cin >> test;
	int ii = 0;
	while(ii++ < test) {
		int n,m;
		cin >> n >> m;
		vector<string>s(n);
		REP(i,n) cin >> s[i];
		//if (true) {
		// if (ii == 129 && n == 3) {
		// 	cout << "YES" << endl;
		// 	int res = 0;
		// 	int cc = 5;
		// 	REP(i,n) REP(j,n) {
		// 		if (s[i][j] == '*') continue;
		// 		if (s[i][j] == 'a') res = res + (1<<cc);
		// 		cc--; 
		// 	}
		// 	cout << res << endl;
		// 	if (res == 38) {
		// 		REP(i,n) cout<<s[i]<<endl;
		// 	}
		// 	continue; 
		// }
		bool flag = 0, flag1 = 0;
		pair<int,int>res = {0,1};
		vector<int>res1;
		vector<set<int>>v1(n);
		vector<set<int>>v2(n);
		REP(i,n) {
			REP(j,n) {
				if (i == j) {
					continue;
				}
				if (s[i][j] == s[j][i]) {
					flag = 1;
					res = {i,j};
					break;
				}
				if (s[i][j] == 'a') {
					if ((v1[i].size()==1 && *v1[i].begin()!=j) || (v1[i].size() > 1)) {
						for(auto e:v1[i]) {
							if (e == j) continue;
							res1.PB(e+1); res1.PB(i+1); res1.PB(j+1);
							break;
						}
						flag1 =  1;
						break;
					}
					v1[j].insert(i);
				} else {
					if ((v2[i].size()==1 && *v2[i].begin()!=j) || (v2[i].size() > 1)) {
						for(auto e:v2[i]) {
							if (e == j) continue;
							res1.PB(e+1); res1.PB(i+1); res1.PB(j+1);
							break;
						}
						flag1 =  1;
						break;
					}
					v2[j].insert(i);
				}
			}
		if (flag || flag1) break;
		}
		if (!flag && !flag1) {
			REP(i,1) {
				REP(j,n) {
					if (i == j) continue;
					if (s[i][j] == 'a') {
						if ((v1[i].size()==1 && *v1[i].begin()!=j) || (v1[i].size() > 1)) {
							for(auto e:v1[i]) {
								if (e == j) continue;
								res1.PB(e+1); res1.PB(i+1); res1.PB(j+1);
								break;
							}
							flag1 =  1;
							break;
						}
						v1[j].insert(i);
					} else {
						if ((v2[i].size()==1 && *v2[i].begin()!=j) || (v2[i].size() > 1)) {
							for(auto e:v2[i]) {
								if (e == j) continue;
								res1.PB(e+1); res1.PB(i+1); res1.PB(j+1);
								break;
							}
							flag1 =  1;
							break;
						}
						v2[j].insert(i);
					}
				}
			if (flag || flag1) break;
			}
		}
		vector<int>vs;
		int prev=-1;
		if(flag || (m&1)) {
			//cout << "Y\n";
			REP(i,m+1) {
				if(i&1) {
					if ((res.ff + 1) == prev) {
						vs.clear(); break;
					}
					vs.PB(res.ff + 1);
					prev = res.ff + 1; 
					//cout << (res.ff + 1) << " ";
				} else {
					if ((res.ss + 1) == prev) {
						vs.clear(); break;
					}
					vs.PB(res.ss + 1);
					prev = res.ss + 1; 
					//cout << (res.ss + 1) << " ";
				}
			}
		} else {
			if (flag1) {
				//cout << "Y\n";
				res1.PB(res1[1]);
				if (m % 4 == 0) {
					reverse(res1.begin(), res1.end());
				}
				debug(res1);
				REP(i,m+1) {
					if ((res1[i%4]) == prev) {
						vs.clear(); break;
					} 
					vs.PB(res1[i%4]);
				}
			} else {
				//cout << "NO";
			}
		}

		if (vs.size()) {
			cout << "YES\n";
			for(auto e:vs) {
				cout << e << " ";
			}
		} else {
			cout << "NO";
		}
		cout << "\n";
	}
	return 0;
}

/*

1
3 4
*ab
b*a
ab*

*/