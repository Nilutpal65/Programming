#ifdef _MSC_VER
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
using int64=long long;
using uint64=unsigned long long;
using ipair=pair<int,int>;
using VI=vector<int>;
using VD=vector<double>;

int main()
{
//#ifdef _MSC_VER
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	int t;
	cin>>t;
	while(t--) {
		string s,t;
		cin>>s>>t;
		map<char,int>m;
		sort(s.begin(),s.end());
		for(int i=0;i<s.size();++i) {
			m[s[i]]++;
		}
		if(t=="abc" && m['a'] && m['b'] && m['c']) {
			s="";
			for(int i=0;i<m['a'];++i) s+='a';
			for(int i=0;i<m['c'];++i) s+='c';
			for(int i=0;i<m['b'];++i) s+='b';
			for(char c='d';c<='z';++c) {
				if(m[c]) {
					for(int i=0;i<m[c];++i) s+=c;
				}
			}
		}
		cout<<s<<endl;
	}
	return 0;
}

