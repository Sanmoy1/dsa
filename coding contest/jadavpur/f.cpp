#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MOD = 998244353;

struct Monster {
    int a;
    int s;
};

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    vector<int> h(n);
    for (int i = 0; i < n; i++) cin >> h[i];
    
    vector<Monster> monsters;
    for (int i = 0; i < n; i++) {
        int s = (h[i] + k - 1) / k;
        monsters.push_back({a[i], s});
    }
    
    sort(monsters.begin(), monsters.end(), [](const Monster& m1, const Monster& m2) {
        return (ll)m1.a * m2.s > (ll)m2.a * m1.s;
    });
    
    ll sum_a = 0;
    for (const auto& m : monsters) sum_a += m.a;
    
    ll total_cumulative = 0;
    for (const auto& m : monsters) {
        total_cumulative = (total_cumulative + (ll)m.s * sum_a) % MOD;
        sum_a -= m.a;
    }
    
    cout << (total_cumulative + 1) % MOD << endl;
    return 0;
}