#include <iostream>
#include <iomanip>
#define int long long

using namespace std;

inline void io(){cin.tie(0);ios::sync_with_stdio(false);cout.tie(0);cout<<fixed<<setprecision(20);}

signed main(){
    io();
    double res, x, y, dig;
    double sum = 0;
    double l = 1 << 30, r = - (1 << 30);
    double time;
    string msecs;
    for(int i = 0;i < 50;i++){
        cin>>res>>x>>y>>dig;
        cin>>time>>msecs;
        //cout<<res<<endl;
        l = min(l, res);
        r = max(r, res);
        sum += res;
    }
    sum /= 50;
    //cout<<"min = "<<l<<", max = "<<r<<", ave = "<<sum<<endl;
    cout<<l<<endl;
    cout<<r<<endl;
    cout<<sum<<endl;
    return 0;
}
