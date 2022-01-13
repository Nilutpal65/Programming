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

const int N = 5e5+1;
int n,m;
int a[4][N];
int dp3[N][8];
int dp2[N][4];
bool ok3[8][8];
bool ok2[4][4];
 
void fill3(){
	for(int i = 0;i < 8;i++){
		for(int j = 0;j < 8;j++){
			bool bad = 0;
			for(int st = 0;st < 2;st++){
				int bits = (bool)(i&(1<<st))+(bool)(i&(1<<(st+1)));
				bits += (bool)(j&(1<<st))+(bool)(j&(1<<(st+1)));
				if(bits%2 == 0){
					bad = 1;
				}
			}
			if(!bad){
				ok3[i][j] = 1;
			}
		}
	}
}
 

void solve3(){
	for(int i = 1;i <= m;i++){
		int mask = a[1][i]+2*a[2][i]+4*a[3][i];
		for(int cur = 0;cur < 8;cur++){
			dp3[i][cur] = 1e9;
			for(int prev = 0;prev < 8;prev++){
				if(!ok3[prev][cur])continue;
				dp3[i][cur] = min(dp3[i][cur],dp3[i-1][prev]+__builtin_popcount(cur^mask));
			}
		}
	}
	int ans = 1e9;
	for(int i = 0;i < 8;i++)ans = min(ans,dp3[m][i]);
	cout << ans;
}

int main()
{
//#ifdef _MSC_VER
	//freopen("input.txt","r",stdin);
	//freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	//int n,m;
	cin>>n>>m;
	if(n>3 && m>3) {
		cout<<-1<<endl;
	} else {
		if(n==1 || m==1) {
			cout<<0<<endl;
		} else if(n==2) {
			REP(i,n) REP(j,m) {
				char o;cin >> o;
				a[i][j] = o-'0';
			}
			int v1 = 0;
			int v2 = 0;
			for(int i=0;i<m;++i) {
				if (i%2 == 0) {
					if ((a[0][i]+a[1][i]) % 2 == 0) v1++;
				} else {
					if ((a[0][i]+a[1][i]) % 2 == 1) v1++;
				}
			}

			for(int i=0;i<m;++i) {
				if (i%2 == 0) {
					if ((a[0][i]+a[1][i]) % 2 == 1) v2++;
				} else {
					if ((a[0][i]+a[1][i]) % 2 == 0) v2++;
				}
			}

			cout<<min(v1,v2)<<endl;
		} else if(m==2) {
			REP(i,n) REP(j,m) {
				char o;cin >> o;
				a[i][j] = o-'0';
			}
			int v1 = 0;
			int v2 = 0;
			for(int i=0;i<m;++i) {
				if (i%2 == 0) {
					if ((a[0][i]+a[1][i]) % 2 == 0) v1++;
				} else {
					if ((a[0][i]+a[1][i]) % 2 == 1) v1++;
				}
			}

			for(int i=0;i<m;++i) {
				if (i%2 == 0) {
					if ((a[0][i]+a[1][i]) % 2 == 1) v2++;
				} else {
					if ((a[0][i]+a[1][i]) % 2 == 0) v2++;
				}
			}

			cout<<min(v1,v2)<<endl;
		} else {
			fill3();
			FOR(i,1,n+1) FOR(j,1,m+1) {
				char o;cin >> o;
				a[i][j] = o-'0';
			}
			// FOR(i,1,n+1) {
			// 	FOR(j,1,m+1) {
			// 		cout<<a[i][j]<<" ";
			// 	}
			// 	cout<<endl;
			// }
			solve3();
		}
	}
	return 0;
}

