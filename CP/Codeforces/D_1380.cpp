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
	//printf("%s\n", "hello world");
	int n,m;
	cin >> n >> m;
	int x,k,y;
	cinn>>x>>k>>y;
	int a[n],b[m];
	REP(i,n) cin>>a[i];
	REP(i,m) cin>>b[i];
	if (m>n) {
		cout<<-1<<endl;
		return 0;
	}
	int ans=0;
	int j=0;
	for(int i=0;i<m;++i) {

	}
	return 0;
}

