作者：T-yy空荡荡
链接：https://www.nowcoder.com/discuss/226329?type=0&order=0&pos=25&page=1
来源：牛客网

一 字符串压缩解压
字符串压缩时格式 AB[2|ABC]

解压后格式 ABABCABC

#include<bits/stdc++.h>

using namespace std;

int main(){
    string x;
    while(cin>>x){
        stack<char> q;
        for(int i(0);i<x.size();i++){
            if(x[i]!=']')q.push(x[i]);
            else{
                string tmp;
                while(q.top()!='|'){
                    tmp+=q.top();
                    q.pop();
                }
                q.pop();
                int bt(0);
                for(int i(1);q.top()!='[';i*=10){
                    bt+=(q.top()-'0')*i;
                    q.pop();
                }
                q.pop();
                for(int i(0);i<bt;i++){
                    for(int j(tmp.size()-1);j>=0;j--){
                        q.push(tmp[j]);
                    }
                }
            }
        }
        string ans(q.size(),' ');
        for(int i(ans.size()-1);i>=0;i--){
            ans[i]=q.top();
            q.pop();
        }
        cout<<ans<<endl;
    }
    return 0;
}
二 n次翻转求逆序对的数量
 不会做，但是目测如果特别了解求逆序对的二分过程，通过记录过程然后映射到答案应该是可行的。

 据说暴力有60分 后悔没写。

三 河道针眼覆盖问题
 简单区间覆盖问题

#include<bits/stdc++.h>

using namespace std;

int main(){
    int n,l;
    cin>>n>>l;
    vector<pair<int, int> >all(n);
    for(int i(0);i<n;i++){
        cin>>all[i].first>>all[i].second;
    }
    auto cmp = [](pair<int, int>a,pair<int, int>b) -> bool{return a.first==b.first?a.second>b.second:a.first<b.first;};
    sort(all.begin(),all.end(),cmp);
    bool flag(1);
    int tmp(0),i(0),ans(0);
    for(int i(0);tmp<l&&i<n;){
        ans++;
        int s=tmp;
        for(;all[i].first<=s&&i<n;i++){
            tmp=max(all[i].second,tmp);
        }
        if(tmp==s&&tmp<l)break;
    }
    if(tmp>=l)cout<<ans<<endl;
    else cout<<-1<<endl;
    return 0;
}
四 最多能看到的楼数
 了解最长上升子序列即可做这道题。

#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int>x(n);
    vector<int>dp1(n,0);
    vector<int>dp2(n,0);
    for(int i(0);i<n;i++)cin>>x[i];
    vector<int>dp3(n,0);
    int tmp(0);
    for(int i(0);i<n;i++){
        int pos = lower_bound(dp3.begin(),dp3.begin()+tmp+1,x[i],greater<int>())-dp3.begin();
        if(pos>tmp)tmp++;
        else tmp=pos;
        dp3[pos]=x[i];
        dp1[i]=pos+1;
    }
    dp3.clear();
    dp3.resize(n,0);
    tmp=0;
    for(int i(n-1);i>=0;i--){
        int pos = lower_bound(dp3.begin(),dp3.begin()+tmp+1,x[i],greater<int>())-dp3.begin();
        if(pos>tmp)tmp++;
        else tmp=pos;
        dp3[pos]=x[i];
        dp2[i]=pos+1;
    }
    for(int i(0);i<n;i++){
        int ct=1+(i==0?0:dp1[i-1])+(i==n-1?0:dp2[i+1]);
        cout<<ct<<" ";
    }
    cout<<endl;
    return 0;
}
五 最多能休息的天数
 dp

#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int>x(n);
    vector<int>y(n);
    for(int i(0);i<n;i++)cin>>x[i];
    for(int i(0);i<n;i++)cin>>y[i];
    vector<vector<int> >dp(n+1,vector<int>(3,0));
    for(int i(1);i<=n;i++){
        dp[i][0]=min(dp[i-1][1]+1,min(dp[i-1][2]+1, dp[i-1][0]+1));
        if(x[i-1]==1)dp[i][1]=min(dp[i-1][0],dp[i-1][2]);
        else dp[i][1]=n;
        if(y[i-1]==1)dp[i][2]=min(dp[i-1][0],dp[i-1][1]);
        else dp[i][2]=n;
    }
    cout<<min(dp[n][0],min(dp[n][1],dp[n][2]))<<endl;
    return 0;
}    