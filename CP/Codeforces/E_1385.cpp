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

vector<VI>gr;
vector<bool>vis;
VI ord;
VI pos;

void dfs(int v) {
	//cout<<v<<endl;
	vis[v]=true;
	REP(i,gr[v].size()) {
		if(!vis[gr[v][i]]) dfs(gr[v][i]);
	}
	ord.push_back(v);
}

int main()
{
//#ifdef _MSC_VER
	//freopen("input.txt","r",stdin);
	//freopen("output.txt","w",stdout);
//#endif
	std::ios::sync_with_stdio(false);
	int test;
	cin>>test;
	while(test--) {
		int n,m,t,x,y;
		vector<ipair>edge;
		cin>>n>>m;
		gr=vector<VI>(n);
		vis=vector<bool>(n);	
		pos=VI(n);
		ord=VI(n);
		REP(i,m) {
			cin>>t>>x>>y;
			if(t==1) {
				gr[x-1].push_back(y-1);
			}
			edge.push_back({x-1,y-1});
		}
		REP(i,n) {
			if(!vis[i]) dfs(i);
		}
		reverse(ALL(ord));
		REP(i,n) pos[ord[i]]=i;
		bool flag=false;
		REP(i,n) {
			REP(j,SIZE(gr[i])) {
				if (pos[i] > pos[gr[i][j]]) {
					flag=true;
				}
			}
		}
		if (flag) {
			cout<<"NO\n";
		} else {
			cout<<"YES\n";
			REP(i,SIZE(edge)) {
				if (pos[edge[i].first] < pos[edge[i].second]) {
					cout<<edge[i].first+1<<" "<<edge[i].second+1<<endl;
				} else {
					cout<<edge[i].second+1<<" "<<edge[i].first+1<<endl;
				}
			}
		}
	}
	return 0;
}

